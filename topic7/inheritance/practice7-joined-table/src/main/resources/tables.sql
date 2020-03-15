CREATE TABLE `animals`
(
    `id`          INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name`        VARCHAR(250) NOT NULL,
    `cage_number` VARCHAR(100) NOT NULL
);

CREATE TABLE `giraffe`
(
    `id`     INT(11) PRIMARY KEY,
    `height` DECIMAL(4, 2) NOT NULL,
    CONSTRAINT `fk_giraffe_animals` FOREIGN KEY (`id`) REFERENCES `animals` (`id`)
);

CREATE TABLE `wolfs`
(
    `id`          INT(11) PRIMARY KEY,
    `live_region` VARCHAR(250) NOT NULL,
    CONSTRAINT `fk_wolfs_animals` FOREIGN KEY (`id`) REFERENCES `animals` (`id`)
);