CREATE TABLE `giraffe`
(
    `id`          INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name`        VARCHAR(250)  NOT NULL,
    `cage_number` VARCHAR(100)  NOT NULL,
    `height`      DECIMAL(4, 2) NOT NULL
);

CREATE TABLE `wolfs`
(
    `id`          INT(11) PRIMARY KEY AUTO_INCREMENT,
    `name`        VARCHAR(250) NOT NULL,
    `cage_number` VARCHAR(100) NOT NULL,
    `live_region` VARCHAR(250) NOT NULL
);