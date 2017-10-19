<?php
require_once(dirname(__FILE__) . "/system.php");

class ChangeNote
{
    protected $_userID = 0;
    protected $_actionIDs;
    protected $_actionObjectTypeIDs;
    protected $_pathway;
    protected $_pathwayID = 0;
    protected $_pathwayElement;
    protected $_pathwayElementID = 0;
    protected $_pathwayElementTypeID;

    public function __construct($xmlChangeNote)
    {
        $this->_userID = $xmlChangeNote['made_by_user'];
        $this->_actionIDs = explode(" ", $xmlChangeNote->actions);
        $this->_actionObjectTypeIDs = explode(" ", $xmlChangeNote->object_types);
        $this->_pathway = $xmlChangeNote->pathway;
        $this->_pathwayID = $xmlChangeNote->pathway['id'];
        $this->_pathwayElement = $xmlChangeNote->pathway_element;
        $this->_pathwayElementID = $xmlChangeNote->pathway_element['id'];
        $this->_pathwayElementTypeID = $xmlChangeNote->pathway_element['type'];
    }

    function getUserID()
    {
        return (int)$this->_userID;
    }

    function getActionIDs()
    {
        return $this->_actionIDs;
    }

    function getActionObjectTypeIDs()
    {
        return $this->_actionObjectTypeIDs;
    }

    function getPathway()
    {
        return $this->_pathway;
    }

    function getPathwayID()
    {
        return (int)$this->_pathwayID;
    }

    function getPathwayElement()
    {
        return $this->_pathwayElement;
    }

    function getPathwayElementID()
    {
        return (int)$this->_pathwayElementID;
    }

    function getPathwayElementTypeID()
    {
        return $this->_pathwayElementTypeID;
    }

}

class DiscussionNote extends ChangeNote
{
    protected $_subject;
    protected $_posting;

    public function __construct($xmlDiscussionNote)
    {
        parent::__construct($xmlDiscussionNote);
        $this->_subject = $xmlDiscussionNote->subject;
        $this->_posting = $xmlDiscussionNote->posting;
    }

    function getSubject()
    {
        return $this->_subject;
    }

    function getPosting()
    {
        return $this->_posting;
    }
}


class Notification
{
    const TEXT_NEWLINE = "\n";
    const HTML_NEWLINE = "<br>";
    const USER_COLOR = "#3CB371";
    const NAME_COLOR = "#1E90FF";

    protected $_notifyUser;
    private $_changeNotes = array();
    private $_discussionNotes = array();
    private $_message;

    public function __construct($xmlNotification)
    {
        $userID = $xmlNotification['notify_user'];
        $this->_notifyUser = Users::getUser((int)$userID);
        //echo "<br>new Notification<br>";
        //var_dump($xmlNotification);
        //var_dump($xmlNotification->cnage_notes->change);
        foreach ($xmlNotification->cnage_notes->change as $change) {
            $changeNote = new ChangeNote($change);
            // var_dump($changeNote);
            if (!array_key_exists($changeNote->getPathwayID(), $this->_changeNotes))
                $this->_changeNotes[$changeNote->getPathwayID()] = array();
            $this->_changeNotes[$changeNote->getPathwayID()][$changeNote->getPathwayElementID()] = $changeNote;
        }
        foreach ($xmlNotification->discussion as $discussion) {
            $discussionNote = new DiscussionNote($discussion);
            if (!array_key_exists($discussionNote->getPathwayID(), $this->_discussionNotesNotes))
                $this->_discussionNotesNotes[$discussionNote->getPathwayID()] = array();
            $this->_discussionNotesNotes[$discussionNote->getPathwayID()][$discussionNote->getPathwayElementID()] = $discussionNote;
        }
    }

    public function getUser()
    {
        return $this->_notifyUser;
    }

    private function highlight($text, $color)
    {
        return "<span style='color:$color'>" . $text . "</span>";
    }

    public function build()
    {
        $at = ActionTypes::getInstance();
        $tc = TraceableClasss::getInstance();
        $nl = self::HTML_NEWLINE;
        $name = $this->_notifyUser->getFirstName() . " " . $this->_notifyUser->getLastName();
        if ($name == " ")
            $name = $this->_notifyUser->getDisplayName();
        $this->_message = "Dear " . $name . ",$nl";
        $this->_message .= "You receive this message in agreemnet with your Effectopedia user profile settings. If you would like to change these settings please login into your account. To do so, please use the upper right corner link 'sign in' in Effectopedia application. After sucessfull login next to your display name a profile link is available. Follow this link to load the user profile page and change your settings.)$nl";

        foreach ($this->_changeNotes as $changes) {
            $changeNote = $changes[key($changes)];
            $user = Users::getUser($changeNote->getUserID());
            $this->_message .= $nl . "During her/his last seession the user " . $this->highlight($user->getDisplayName(), self::USER_COLOR) . " modified the " . $this->highlight($changeNote->getPathway(), self::NAME_COLOR) . " pathway.";
            if (count($changes) == 1)
                $this->_message .= "The modification was related to the " . $tc->getTraceableClassDescription($changeNote->getPathwayElementTypeID()) . " entitled " . $this->highlight($changeNote->getPathwayElement(), self::NAME_COLOR);
            else {
                $this->_message .= "The following pathway elements were created and /or modified:$nl";
                $this->_message .= "The " . $tc->getTraceableClassDescription($changeNote->getPathwayElementTypeID());
                if ($changeNote->getPathwayElement())
                    $this->_message .= " entitled " . $this->highlight($changeNote->getPathwayElement(), self::NAME_COLOR) . " was ";

                $actionIDs = $changeNote->getActionIDs();
                $actionObjectTypeIDs = $changeNote->getActionObjectTypeIDs();
                $cnt = count($actionIDs);
                echo $cnt . " " . count($actionObjectTypeIDs);
                if ($cnt == count($actionObjectTypeIDs)) {
                    $grouped = array();
                    for ($i = 0; $i < $cnt; $i++) {
                        $grp = $at->getActionTypeGroupID($actionIDs[$i]);
                        if (($actionObjectTypeIDs[$i] == $changeNote->getPathwayElementTypeID()) && ($actionIDs[$i] != 5))
                            if (array_key_exists($grp, $grouped))
                                $grouped[$grp] .= ", " . $at->getActionTypeDescription($actionIDs[$i]);
                            else
                                $grouped[$grp] = $at->getActionTypeDescription($actionIDs[$i]);
                    }
                    $sentence = "";
                    foreach ($grouped as $key => $val) {
                        if ($key == 1)
                            $sentence = "created";
                        else if ($sentence != "")
                            $sentence .= " and " . $val . " were " . $at->getActionTypeGroupIDDescription($key);
                        echo $at->getActionTypeGroupIDDescription($key);
                    }
                    $this->_message .= $sentence . $nl;
                }
            }
        }
    }

    public function send()
    {
        echo "<br><br>";
        echo $this->_message;
        $to = $this->_notifyUser->getEmail();
        $to = "aladjov@qsari.org";//$this->_notifyUser->getEmail();
        $subject = '=?UTF-8?B?' . base64_encode("Effectopedia update") . '?=';
        $headers = "From: Effectopedia.org <system@effectopedia.org>\r\n" .
            "MIME-Version: 1.0" . "\r\n" .
            "Content-type: text/plain; charset=UTF-8 \r\n";

// if (mail($to, $subject, $this->_message, $headers)) 
//   echo "<p>Message successfully sent!</p>";
//    else 
//   echo "<p>Message delivery failed...</p>";
    }
}

class Notifications
{
    private $_fileName;
    private $_notifications = array();

    public function __construct($fileName)
    {
        $this->_fileName = $fileName;
        echo "loading...";

        $this->load();
        $this->build();
    }

    private function load()
    {
        echo $this->_fileName;
        $zip = zip_open($this->_fileName);
        if (!is_resource($zip))
            echo "zip:" . $zip . "\n";
        if ((file_exists($this->_fileName)) && (is_resource($zip)))
            if (file_exists($this->_fileName)) {
                echo " - file exists";
                $zip_entry = zip_read($zip);
                zip_entry_open($zip, $zip_entry);
                echo "zip entry=" . $zip_entry;
                if ($zip_entry) {
                    echo '<br>Name: ' . zip_entry_name($zip_entry) . '<br>';
                    echo 'File size:' . zip_entry_filesize($zip_entry) . '<br><br>';
                    $contents = zip_entry_read($zip_entry, (int)zip_entry_filesize($zip_entry));
//	  echo htmlspecialchars($contents, ENT_QUOTES);
                    $xml = simplexml_load_string($contents);
                    zip_entry_close($zip_entry);
                    foreach ($xml->notification as $notification) {
                        $notification = new Notification($notification);
                        //var_dump($notification->getUser()->getUserID());
                        $this->_notifications[$notification->getUser()->getUserID()] = $notification;
                    }
                } else {
                    echo 'Error loading entry:';
                    exit('Error.');
                }
            } else {
                echo 'Error loading notifications file: ' . $this->_fileName;
                exit("\nError.");
            }
    }

    private function build()
    {
        echo "<br><br>Building " . count($this->_notifications) . " notifications<br>";
        foreach ($this->_notifications as $notification)
            $notification->build();
    }

    public function send()
    {
        echo "sending...";
        foreach ($this->_notifications as $notification)
            $notification->send();
    }

}
