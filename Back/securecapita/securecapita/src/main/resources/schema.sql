-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema securecapita
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema securecapita
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `securecapita` DEFAULT CHARACTER SET utf8 ;
USE `securecapita` ;

-- -----------------------------------------------------
-- Table `securecapita`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `securecapita`.`Users` (
  `idUsers` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsers`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `securecapita`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `securecapita`.`Roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `permission` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `securecapita`.`UserRoles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `securecapita`.`UserRoles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Users_idUsers` INT NOT NULL,
  `Roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_UserRoles_Users_idx` (`Users_idUsers` ASC) VISIBLE,
  INDEX `fk_UserRoles_Roles1_idx` (`Roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_UserRoles_Users`
    FOREIGN KEY (`Users_idUsers`)
    REFERENCES `securecapita`.`Users` (`idUsers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_UserRoles_Roles1`
    FOREIGN KEY (`Roles_id`)
    REFERENCES `securecapita`.`Roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
