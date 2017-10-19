<?php

class AuthenticationUser {
    static $excludedUpdatePropertyNames = array("id", "sso_id", "created_at", "options");

    static $claimNamesByPropertyName = array(
        "first_name" => "given_name",
        "last_name" => "family_name",
    );

    static $excludedEffectopediaPropertyNames = array("sso_id", "created_at");

    static $effectopediaPropertyNamesByPropertyName = array(
        "email" => "e-mail",
        "first_name" => "firstName",
        "last_name" => "lastName",
        "display_name" => "displayName"
    );

    public $id;
    public $email;
    public $sso_id;
    public $first_name;
    public $last_name;
    public $display_name;
    public $fax;
    public $telephone;
    public $affiliation;
    public $country;
    public $city;
    public $street;
    public $zip_code;
    public $options = 3;
    public $created_at;

    public function fillFromClaims($ssoId, array $userClaims) {
        $this->sso_id = $ssoId;
        $this->created_at = $this->created_at ?? date("Y-m-d H:i:s");

        foreach (self::getPropertyNames() as $propertyName) {
            if (in_array($propertyName, self::$excludedUpdatePropertyNames)) {
                continue;
            }

            $claimName = self::$claimNamesByPropertyName[$propertyName] ?? $propertyName;
            $this->{$propertyName} = $userClaims[$claimName] ?? "";
        }

        if (!$this->display_name && $this->first_name) {
            $this->display_name = "{$this->first_name} {$this->last_name}";
        }
    }

    public function toEffectopediaProfileArray() {
        $effectopediaProfile = array();
        foreach (self::getPropertyNames() as $propertyName) {
            if (in_array($propertyName, self::$excludedEffectopediaPropertyNames)) {
                continue;
            }

            $arrayKey = self::$effectopediaPropertyNamesByPropertyName[$propertyName] ?? $propertyName;
            $propertyValue = $this->{$propertyName};
            // Workaround broken parsing (cannot handle empty values).
            if ($propertyValue === "") {
                $propertyValue = " ";
            }
            $effectopediaProfile[] = "{$arrayKey}={$propertyValue}";
        }
        return $effectopediaProfile;
    }

    public static function getDatabasePropertyNames() {
        return array("id", "email", "sso_id", "options", "created_at");
    }

    static function getPropertyNames() {
        return array_keys(get_object_vars(new self()));
    }
}
