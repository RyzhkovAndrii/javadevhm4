DROP SCHEMA IF EXISTS `javadevhm4`;
CREATE SCHEMA `javadevhm4`;
USE `javadevhm4`;

DROP TABLE IF EXISTS `products`;
DROP TABLE IF EXISTS `manufacturers`;

CREATE TABLE `manufacturers` (
  `id` BINARY(16) NOT NULL UNIQUE,
  `name` VARCHAR(50) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = Utf8;

CREATE TABLE `products` (
  `id` BINARY(16) NOT NULL UNIQUE,
  `name` VARCHAR(50) NOT NULL,
  `price` DECIMAL,
  `manufacturer_id` BINARY(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `products_name_manufacturer_id_uindex`(`name`, `manufacturer_id`),
  CONSTRAINT `fk_manufacturer_id`
  FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET = Utf8;