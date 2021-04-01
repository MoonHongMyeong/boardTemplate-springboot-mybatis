CREATE TABLE `user` (
	`id`	BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name`	VARCHAR(20)	NOT NULL,
	`email`	VARCHAR(50)	NOT NULL,
	`password`	VARCHAR(100) NOT NULL,
	`phone`	VARCHAR(15)	NOT NULL,
	`picture`	VARCHAR(50)	NOT NULL,
	`created_date`	DATETIME	NULL,
	`modifed_date`	DATETIME	NULL,
	`role`	VARCHAR(10)	NOT NULL
);

CREATE TABLE `category`(
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `created_date` DATETIME NULL,
    `modified_date` DATETIME NULL
);

CREATE TABLE `post`(
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(50) NOT NULL,
    `content` TEXT NOT NULL,
    `image` VARCHAR(100) NOT NULL,
    `created_date` DATETIME NULL,
    `modified_date` DATETIME NULL,
    `removed` VARCHAR(5) NOT NULL,
    `temp` VARCHAR(5) NOT NULL,
    `user_id` BIGINT NOT NULL,
    `category_id` BIGINT NOT NULL,
    FOREIGN KEY(`user_id`) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY(`category_id`) REFERENCES CATEGORY(id) ON DELETE CASCADE
);

CREATE TABLE `comment`(
	`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `content` TEXT NOT NULL,
    `parent_id` BIGINT NULL,
    `created_date` DATETIME NULL,
    `modified_date` DATETIME NULL,
    `removed` VARCHAR(5) NOT NULL,
    `user_id` BIGINT NOT NULL,
    `post_id` BIGINT NOT NULL,
    FOREIGN KEY(`user_id`) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY(`post_id`) REFERENCES POST(id) ON DELETE CASCADE
);