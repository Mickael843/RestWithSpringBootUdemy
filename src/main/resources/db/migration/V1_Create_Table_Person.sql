CREATE TABLE IF NOT EXISTS `person` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`address` varchar(250),
	`first_name` varchar(250) NOT NULL,
	`gender` varchar(250),
	`last_name` varchar(250),
	PRIMARY KEY (`id`)
)