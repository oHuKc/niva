SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `niva_testdb` DEFAULT CHARACTER SET utf8 ;
USE `niva_testdb` ;

-- -----------------------------------------------------
-- Table `niva_testdb`.`administrators' create
-- -----------------------------------------------------

DROP TABLE IF EXISTS `niva_testdb`.`administrators` ;

CREATE TABLE niva_testdb.administrators
(
  Id INT(10) NOT NULL AUTO_INCREMENT,
  Login CHAR(40) NOT NULL,
  Password CHAR(40) NOT NULL,
  FirstName CHAR(40) NOT NULL,
  LastName CHAR(40) NOT NULL,
  Contacts CHAR(80) NOT NULL,
  PRIMARY KEY (Id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 0;

-- -----------------------------------------------------
-- Table `niva_testdb`.`goods_type' create
-- -----------------------------------------------------
DROP TABLE IF EXISTS `niva_testdb`.`goods_type`;

CREATE TABLE niva_testdb.goods_type
(
  ItemId INT(10) NOT NULL AUTO_INCREMENT,
  ItemModel CHAR(40) NOT NULL,
  ItemDescription CHAR(80) NOT NULL,
  ItemType CHAR(40) NOT NULL,
  PRIMARY KEY (ItemId)
)
  ENGINE  = InnoDB
  AUTO_INCREMENT = 1000;

-- -----------------------------------------------------
-- Table `niva_testdb`.`goods_type' create
-- -----------------------------------------------------
DROP TABLE IF EXISTS `niva_testdb`.`goods`;

CREATE TABLE niva_testdb.goods
(
  GoodsId INT(10) NOT NULL AUTO_INCREMENT,
  GoodsType CHAR(40) NOT NULL,
  GoodsName CHAR(40) NOT NULL,
  GoodsPrice CHAR(40) NOT NULL,
  Description CHAR(40) NOT NULL,
  PRIMARY KEY (GoodsId)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;
-- -----------------------------------------------------
-- Table `niva_testdb`.`goods_availability' create
-- -----------------------------------------------------
DROP TABLE  IF EXISTS `niva_testdb`.`goods_availability`;

CREATE TABLE niva_testdb.goods_availability
(
  Name CHAR(40) NOT NULL ,
  Count INT(10) NOT NULL,
  Status CHAR(40) NOT NULL,
  Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT
)
  ENGINE = InnoDb
  CHAR SET = utf8
  AUTO_INCREMENT = 1;
-- -----------------------------------------------------
-- Table `niva_testdb`.`orders' create
-- -----------------------------------------------------
DROP TABLE IF EXISTS `niva_testdb`.`orders`;

CREATE TABLE niva_testdb.orders
(
  OrderId INT(10) NOT NULL AUTO_INCREMENT,
  OderderDate DATE NOT NULL ,
  CustomerId VARCHAR(40) NOT NULL,
  PRIMARY KEY (OrderId)
)
  ENGINE = InnoDb
  CHAR SET = utf8
  AUTO_INCREMENT = 1;
-- -----------------------------------------------------
-- Table `niva_testdb`.`customers' create
-- -----------------------------------------------------
DROP TABLE IF EXISTS `niva_testdb`.`customers`;

CREATE TABLE niva_testdb.customers
(
  CustomerID INT(10) NOT NULL  AUTO_INCREMENT,
  FirstName CHAR(40) NOT NULL ,
  LastName CHAR(40) NOT NULL ,
  PhoneNr CHAR(20) NOT NULL,
  Email CHAR(40) NOT NULL,
  PRIMARY KEY (CustomerID)
)
  ENGINE = InnoDB
  CHAR SET = utf8
  AUTO_INCREMENT = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


#delete from niva_testdb.customers;

#select count(1) from niva_testdb.customers;