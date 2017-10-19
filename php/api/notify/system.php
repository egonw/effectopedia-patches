<?php

class User
{
    protected $_userID = 0;
    protected $_email;
    protected $_firstName;
    protected $_lastName;
    protected $_createdAt;
    protected $_displayName;
    protected $_options;

    function __construct($profile)
    {
        // id=0  email=1  password=2  first_name=3  last_name=4 created_at=5  disp_name=6 fax=7 telephone=8 
        // web=9  affiliation=10  country=11  city =12 street=13  zip=14  options=15 
        $this->_userID = $profile[0];
        $this->_email = $profile[1];
        $this->_firstName = $profile[3];
        $this->_lastName = $profile[4];
        $this->_createdAt = $profile[5];
        $this->_displayName = $profile[6];
        $this->_options = $profile[15];
    }

    function getUserID()
    {
        return (int)$this->_userID;
    }

    function getEmail()
    {
        return $this->_email;
    }

    function getFirstName()
    {
        return $this->_firstName;
    }

    function getLastName()
    {
        return $this->_lastName;
    }

    function getCreatedAt()
    {
        return $this->_createdAt;
    }

    function getDisplayName()
    {
        return $this->_displayName;
    }

    function getOptions()
    {
        return $this->_options;
    }
}

class Users
{
    private static $_profiles = array();
    private static $_users;

    private function __construct()
    {

    }

    static public function getInstance()
    {
        if (!self::$_users) {
            self::$_users = new Users();
        }
        return self::$_users;
    }

    static public function getUser($userID)
    {
        if (!array_key_exists($userID, self::$_profiles)) {
            $sql = "SELECT * FROM `users` WHERE `id`=" . $userID;
            $result = mysql_query($sql);
            self::$_profiles[$userID] = new user(mysql_fetch_row($result));
        }
        return self::$_profiles[$userID];
    }
}

class ActionType
{
    protected $_actionTypeID = 0;
    protected $_description;
    protected $_groupID;

    function __construct($actionType)
    {
        // type_id=0  description=1  group_id=2  
        $this->_actionTypeID = (int)($actionType[0] - 1);
        $this->_description = $actionType[1];
        $this->_groupID = $actionType[2];
        //echo "action type ".$this->_actionTypeID." is ".$this->_description." and in group ".$this->_groupID."<br><br>";
    }

    function getActionTypeID()
    {
        return (int)$this->_actionTypeID;
    }

    function getDescription()
    {
        return $this->_description;
    }

    function getGroupID()
    {
        return $this->_groupID;
    }
}

class ActionTypes
{
    private static $_types = array();
    private static $_registered;
    private static $_groups = array("created", "added", "removed", "cleared", "set", "updated");

    private function __construct()
    {
        $sql = "SELECT * FROM `action_types`";
        $result = mysql_query($sql);
        while ($row = mysql_fetch_row($result)) {
            $at = new ActionType($row);
            $this->_types[$at->getActionTypeID()] = $at;
        }
    }

    static public function getInstance()
    {
        if (!self::$_registered) {
            self::$_registered = new ActionTypes();
        }
        return self::$_registered;
    }

    public function getActionType($actionTypeID)
    {
        return $this->_types[$actionTypeID];
    }

    public function getActionTypeGroupID($actionTypeID)
    {
        $actionType = $this->_types[$actionTypeID];
        if ($actionType)
            return $actionType->getGroupID();
        else
            return 0;
    }

    public function getActionTypeGroupIDDescription($groupID)
    {
        if (($groupID > 0) && ($groupID <= 6))
            return self::$_groups[$groupID - 1];
        else
            return "";
    }

    public function getActionTypeDescription($actionTypeID)
    {
        $actionType = $this->_types[$actionTypeID];
        if ($actionType)
            return $actionType->getDescription();
        else
            return "";
    }
}


class TraceableClass
{
    protected $_traceableClassID = 0;
    protected $_className;
    protected $_description;

    function __construct($TraceableClass)
    {
        // type_id=0  class_name=1  description=2  
        $this->_traceableClassID = (int)($TraceableClass[0] - 1);
        $this->_className = $TraceableClass[1];
        $this->_description = $TraceableClass[2];
        // echo "traceable calss  ".$this->_traceableClassID." with name ".$this->_className." and description ".$this->_description."<br><br>";

    }

    function getTraceableClassID()
    {
        return (int)$this->_traceableClassID;
    }

    function getDescription()
    {
        return $this->_description;
    }

    function getClassNameID()
    {
        return $this->_className;
    }
}

class TraceableClasss
{
    private static $_classes = array();
    private static $_registered;

    private function __construct()
    {
        $sql = "SELECT * FROM `object_types`";
        $result = mysql_query($sql);
        while ($row = mysql_fetch_row($result)) {
            $tc = new TraceableClass($row);
            $this->_classes[$tc->getTraceableClassID()] = $tc;
        }
    }

    static public function getInstance()
    {
        if (!self::$_registered) {
            self::$_registered = new TraceableClasss();
        }
        return self::$_registered;
    }

    public function getTraceableClass($TraceableClassID)
    {
        return $this->_classes[$TraceableClassID];
    }

    public function getTraceableClassDescription($TraceableClassID)
    {
        $traceableClass = $this->_classes[(int)$TraceableClassID];
        if ($traceableClass)
            return $traceableClass->getDescription();
        else
            return "object";
    }

}
