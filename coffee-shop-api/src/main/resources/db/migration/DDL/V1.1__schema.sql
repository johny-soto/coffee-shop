CREATE TABLE `order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gross_price` INT NOT NULL,
  `discount` DOUBLE NOT NULL,
  `charges` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `date` DATE NOT NULL,
  `status` BIT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
