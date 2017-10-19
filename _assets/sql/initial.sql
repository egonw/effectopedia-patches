/*Table structure for table `action_types` */

CREATE TABLE `action_types` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(192) COLLATE latin1_german2_ci NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;

/*Table structure for table `authentications` */

CREATE TABLE `authentications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT 'refer to users.id',
  `provider` varchar(100) NOT NULL,
  `provider_uid` varchar(255) NOT NULL,
  `email` varchar(200) NOT NULL,
  `display_name` varchar(150) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `profile_url` varchar(300) NOT NULL,
  `website_url` varchar(300) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `provider_uid` (`provider_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `data_sources` */

CREATE TABLE `data_sources` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE latin1_german2_ci NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;

/*Table structure for table `notifications` */

CREATE TABLE `notifications` (
  `notification` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `file_name` varchar(192) COLLATE latin1_german2_ci NOT NULL,
  `status` smallint(6) NOT NULL DEFAULT '0',
  `doc_sha` varchar(256) COLLATE latin1_german2_ci NOT NULL,
  `revision` int(11) NOT NULL,
  PRIMARY KEY (`notification`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;

/*Table structure for table `object_types` */

CREATE TABLE `object_types` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) COLLATE latin1_german2_ci NOT NULL,
  `description` varchar(192) COLLATE latin1_german2_ci NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;

/*Table structure for table `teams` */

CREATE TABLE `teams` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;

/*Table structure for table `users` */

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `created_at` datetime NOT NULL,
  `disp_name` varchar(192) NOT NULL,
  `fax` varchar(32) NOT NULL,
  `telephone` varchar(32) NOT NULL,
  `web` varchar(255) NOT NULL,
  `affiliation` varchar(255) NOT NULL,
  `country` varchar(128) NOT NULL,
  `city` varchar(192) NOT NULL,
  `street` varchar(255) NOT NULL,
  `zip` varchar(16) NOT NULL,
  `options` int(10) unsigned NOT NULL DEFAULT '3',
  PRIMARY KEY (`id`),
  KEY `disp_name` (`disp_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `xmldump` */

CREATE TABLE `xmldump` (
  `revision` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `committed` tinyint(4) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`revision`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci;
