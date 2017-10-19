ALTER TABLE `users`
  DROP COLUMN `first_name`,
  DROP COLUMN `last_name`,
  DROP COLUMN `disp_name`,
  DROP COLUMN `fax`,
  DROP COLUMN `telephone`,
  DROP COLUMN `web`,
  DROP COLUMN `affiliation`,
  DROP COLUMN `country`,
  DROP COLUMN `city`,
  DROP COLUMN `street`,
  DROP COLUMN `zip`,
  CHANGE `created_at` `created_at` DATETIME NOT NULL
  AFTER `options`,
  DROP INDEX `disp_name`,
  DROP INDEX `email`,
  ADD INDEX `email` (`email`);
