ALTER TABLE `action_types`
  CHANGE `description` `description` VARCHAR(192) NOT NULL,
  ENGINE = INNODB,
  CHARSET = utf8mb4;

ALTER TABLE `data_sources`
  CHANGE `name` `name` VARCHAR(128) NOT NULL,
  ENGINE = INNODB,
  CHARSET = utf8mb4;

ALTER TABLE `notifications`
  CHANGE `file_name` `file_name` VARCHAR(192) NOT NULL,
  CHANGE `doc_sha` `doc_sha` VARCHAR(256) NOT NULL,
  ENGINE = INNODB,
  CHARSET = utf8mb4;

ALTER TABLE `object_types`
  CHANGE `class_name` `class_name` VARCHAR(255) NOT NULL,
  CHANGE `description` `description` VARCHAR(192) NOT NULL,
  ENGINE = INNODB,
  CHARSET = utf8mb4;

ALTER TABLE `users`
  CHANGE `email` `email` VARCHAR(200) NOT NULL,
  CHANGE `password` `password` VARCHAR(200) NOT NULL,
  CHANGE `first_name` `first_name` VARCHAR(200) NOT NULL,
  CHANGE `last_name` `last_name` VARCHAR(200) NOT NULL,
  CHANGE `disp_name` `disp_name` VARCHAR(192) NOT NULL,
  CHANGE `fax` `fax` VARCHAR(32) NOT NULL,
  CHANGE `telephone` `telephone` VARCHAR(32) NOT NULL,
  CHANGE `web` `web` VARCHAR(255) NOT NULL,
  CHANGE `affiliation` `affiliation` VARCHAR(255) NOT NULL,
  CHANGE `country` `country` VARCHAR(128) NOT NULL,
  CHANGE `city` `city` VARCHAR(192) NOT NULL,
  CHANGE `street` `street` VARCHAR(255) NOT NULL,
  CHANGE `zip` `zip` VARCHAR(16) NOT NULL,
  CHARSET = utf8mb4;

ALTER TABLE `users`
  CHANGE `password` `sso_id` VARCHAR(64) CHARSET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  ADD INDEX `sso_id` (`sso_id`),
  ADD INDEX `email` (`email`);

ALTER TABLE `xmldump` ENGINE=INNODB, CHARSET=utf8mb4;

DROP TABLE `authentications`;
