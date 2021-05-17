CREATE TABLE category (
  id int NOT NULL,
  description varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE coffee (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  category_id int NOT NULL,
  price int NOT NULL,
  units int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES category (id)
);

insert into category(id,description) values(1,'Clasico');
insert into category(id,description) values(2,'Especialidad');

CREATE TABLE `order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gross_price` INT NOT NULL,
  `discount` DOUBLE NOT NULL,
  `charges` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `date` DATE NOT NULL,
  `status` BIT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));