-- MySQL Script generated by MySQL Workbench
-- Mon May 15 10:27:51 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`orders` ;

CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
  `id_orders` INT NOT NULL AUTO_INCREMENT,
  `orders_address` VARCHAR(45) NULL,
  `orders_manager` VARCHAR(45) NULL,
  `menus_id_menus` INT NOT NULL,
  PRIMARY KEY (`id_orders`, `menus_id_menus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`users` ;

CREATE TABLE IF NOT EXISTS `mydb`.`users` (
  `id_users` INT NOT NULL AUTO_INCREMENT,
  `users_name` VARCHAR(45) NULL,
  `users_pass` VARCHAR(45) NULL,
  `users_email` VARCHAR(45) NULL,
  `orders_id_orders` INT NOT NULL,
  `orders_menus_id_menus` INT NOT NULL,
  PRIMARY KEY (`id_users`),
  INDEX `fk_users_orders1_idx` (`orders_id_orders` ASC, `orders_menus_id_menus` ASC),
  CONSTRAINT `fk_users_orders1`
    FOREIGN KEY (`orders_id_orders` , `orders_menus_id_menus`)
    REFERENCES `mydb`.`orders` (`id_orders` , `menus_id_menus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`foods`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`foods` ;

CREATE TABLE IF NOT EXISTS `mydb`.`foods` (
  `id_foods` INT NOT NULL AUTO_INCREMENT,
  `foods_name` VARCHAR(45) NULL,
  `foods_ stock` INT NULL,
  `foods_price` INT NULL,
  PRIMARY KEY (`id_foods`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`dates` ;

CREATE TABLE IF NOT EXISTS `mydb`.`dates` (
  `id_dates` INT NOT NULL AUTO_INCREMENT,
  `dates_date` TIMESTAMP NULL,
  PRIMARY KEY (`id_dates`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`deliverys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`deliverys` ;

CREATE TABLE IF NOT EXISTS `mydb`.`deliverys` (
  `id_deliverys` INT NOT NULL AUTO_INCREMENT,
  `deliverys_hour` INT NULL,
  `deliverys_available` TINYINT NULL,
  PRIMARY KEY (`id_deliverys`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`deliverys_has_dates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`deliverys_has_dates` ;

CREATE TABLE IF NOT EXISTS `mydb`.`deliverys_has_dates` (
  `deliverys_id_deliverys` INT NOT NULL,
  `dates_id_dates` INT NOT NULL,
  PRIMARY KEY (`deliverys_id_deliverys`, `dates_id_dates`),
  INDEX `fk_deliverys_has_dates_dates1_idx` (`dates_id_dates` ASC),
  INDEX `fk_deliverys_has_dates_deliverys_idx` (`deliverys_id_deliverys` ASC),
  CONSTRAINT `fk_deliverys_has_dates_deliverys`
    FOREIGN KEY (`deliverys_id_deliverys`)
    REFERENCES `mydb`.`deliverys` (`id_deliverys`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deliverys_has_dates_dates1`
    FOREIGN KEY (`dates_id_dates`)
    REFERENCES `mydb`.`dates` (`id_dates`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users_has_dates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`users_has_dates` ;

CREATE TABLE IF NOT EXISTS `mydb`.`users_has_dates` (
  `users_id_users` INT NOT NULL,
  `dates_id_dates` INT NOT NULL,
  PRIMARY KEY (`users_id_users`, `dates_id_dates`),
  INDEX `fk_users_has_dates_dates1_idx` (`dates_id_dates` ASC),
  INDEX `fk_users_has_dates_users1_idx` (`users_id_users` ASC),
  CONSTRAINT `fk_users_has_dates_users1`
    FOREIGN KEY (`users_id_users`)
    REFERENCES `mydb`.`users` (`id_users`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_dates_dates1`
    FOREIGN KEY (`dates_id_dates`)
    REFERENCES `mydb`.`dates` (`id_dates`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders_has_foods`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`orders_has_foods` ;

CREATE TABLE IF NOT EXISTS `mydb`.`orders_has_foods` (
  `orders_id_orders` INT NOT NULL,
  `orders_menus_id_menus` INT NOT NULL,
  `foods_id_foods` INT NOT NULL,
  PRIMARY KEY (`orders_id_orders`, `orders_menus_id_menus`, `foods_id_foods`),
  INDEX `fk_orders_has_foods_foods1_idx` (`foods_id_foods` ASC),
  INDEX `fk_orders_has_foods_orders1_idx` (`orders_id_orders` ASC, `orders_menus_id_menus` ASC),
  CONSTRAINT `fk_orders_has_foods_orders1`
    FOREIGN KEY (`orders_id_orders` , `orders_menus_id_menus`)
    REFERENCES `mydb`.`orders` (`id_orders` , `menus_id_menus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_foods_foods1`
    FOREIGN KEY (`foods_id_foods`)
    REFERENCES `mydb`.`foods` (`id_foods`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;