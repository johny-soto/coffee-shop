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