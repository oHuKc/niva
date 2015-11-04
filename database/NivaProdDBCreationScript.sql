SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `niva_production` DEFAULT CHARACTER SET utf8 ;
USE `niva_production`;

#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.TV_HomeTheater;
CREATE TABLE niva_production.TV_HomeTheater
         (
         id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
         TV_TYPE CHAR(40) NOT NULL,
         TV_SCREEN_SIZE CHAR(40) NOT NULL,
         BRAND CHAR(40) NOT NULL,
         PRICE CHAR(40) NOT NULL,
         RESOLUTION CHAR(40) NOT NULL,
         DESCRIPTION CHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;

#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.cell_phone;
CREATE TABLE niva_production.cell_phone
         (
         id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
         DEVICE_BRAND CHAR(40) NOT NULL,
         MODEL_FAMILY CHAR(40) NOT NULL,
         PRICE CHAR(40) NOT NULL,
         OPERATING_SYSTEM CHAR(40) NOT NULL,
         DESCRIPTION CHAR(40) NOT NULL
         )ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;

#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.computers_tablets;
CREATE TABLE niva_production.computers_tablets
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  PROCESSOR_MODEL CHAR(40) NOT NULL,
  RAM CHAR(40) NOT NULL,
  BRAND CHAR(40) NOT NULL,
  OPERATING_SYSTEM CHAR(40) NOT NULL,
  HARD_DRIVE_SIZE CHAR(40) NOT NULL,
  HARD_DRIVE_TYPE CHAR(40) NOT NULL,
  SCREEN_SIZE CHAR(40) NOT NULL,
  COLOR CHAR(40) NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;
#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.audio;
CREATE TABLE niva_production.audio
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  DEVICE_TYPE CHAR(40) NOT NULL,
  BRAND CHAR(40) NOT NULL,
  COLOR CHAR(40) NOT NULL,
  NUMBER_OF_SPEAKERS INT NOT NULL,
  NUMBER_OF_CHANNELS INT NOT NULL,
  STORAGE_CAPACITY INT NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;


#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.car_electronics_gps;
CREATE TABLE niva_production.car_electronics_gps
(
  id INT NOT NULL,
  DEVICE_TYPE CHAR(40) NOT NULL,
  BRAND CHAR(40) NOT NULL,
  NUMBERS_OF_CHANNELS INT NOT NULL,
  AMPLIFIER_CLASS CHAR(40) NOT NULL,
  SCREEN_SIZE CHAR(40) NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;

#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.cameras_camcorders;
CREATE TABLE niva_production.cameras_camcorders
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  BRAND CHAR(40) NOT NULL,
  COLOR CHAR(40) NOT NULL,
  OPTICAL_ZOOM CHAR(40) NOT NULL,
  MEGAPIXELS CHAR(40) NOT NULL,
  SCREEN_TYPE CHAR(40) NOT NULL,
  SENSOR_TYPE CHAR(40) NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;
#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.video_games_movies_music;
CREATE TABLE niva_production.video_games_movies_music
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  DEVICE_TYPE CHAR(40) NOT NULL,
  FORMAT CHAR(40) NOT NULL,
  GENRE CHAR(40) NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;
#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.health_fitness_beauty;
CREATE TABLE niva_production.health_fitness_beauty
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  TYPE CHAR(40) NOT NULL,
  BRAND CHAR(40) NOT NULL,
  COLOR CHAR(40) NOT NULL,
  STYLE CHAR(40) NOT NULL,
  MEASURES CHAR(40) NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;
#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.toys_games;
CREATE TABLE niva_production.toys_games
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  TYPE CHAR(40) NOT NULL,
  BRAND CHAR(40) NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;

#------------------------------------------------------------------------------
DROP TABLE IF EXISTS  niva_production.wearable_technology;
CREATE TABLE niva_production.wearable_technology
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  BRAND CHAR(40) NOT NULL,
  TYPE CHAR(40) NOT NULL,
  COLOR CHAR(40) NOT NULL,
  OS_COMPATIBILITY CHAR(40) NOT NULL,
  STYLE CHAR(40) NOT NULL,
  MEASURES CHAR(40) NOT NULL,
  PRICE CHAR(40) NOT NULL,
  DESCRIPTION CHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 0;
#------------------------------------------------------------------------------
# INSERTING DATA IN TO niva_production.TV_HomeTheater
#------------------------------------------------------------------------------
DELETE FROM niva_productiontv_hometheater;

INSERT INTO INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','40" - 45"','Samsung','$788.66','2160p (4K)','2160p resolution.Motion Rate 120.Smart TV, apps, Web browser included');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','40" - 45"','Samsung','$1,099.98','2160p (4K)','2160p resolution.Clear Motion Rate 240.Smart TV, Samsung Smart Hub, Web browser included.3D TV');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','40" - 45"','Samsung','$788.66','2160p (4K)','2160p resolution.Motion Rate 120.Smart TV, apps, Web browser included');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','46" - 49"','LG','$899.98','2160p (4K)','2160p resolution.TruMotion 120Hz refresh rate.Smart TV, LG Content Store, Web browser included');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','46" - 49"','LG','$749.99','2160p (4K)','2160p resolution.Ultra Clarity Index 1080.LG Smart TV, Premium VOD Services');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','50" - 54"','Westinghouse','$699.99','2160p (4K)','2160p resolution.60Hz refresh rate.Smart TV');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$999.99','2160p (4K)','2160p resolution.Smart TV');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$1,399.99','2160p (4K)','2160p resolution.Motionflow XR 960.Smart Android TV with Google Play and Google Cast built-in.3D TV');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$1,999.98','2160p (4K)','2160p resolution.Motionflow XR 960.Smart Android TV with Google Play and Google Cast built-in.3D TV');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$1,098.00','2160p (4K)','2160p resolution.Motionflow XR 240.Smart TV');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','60" - 64"','VIZIO','$1,199.99','2160p (4K)','2160p resolution.Clear Action 720.Smart TV, VIZIO Internet Apps Plus');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','65" - 69"','Sharp','$1,221.76','2160p (4K)','2160p resolution.AquoMotion 240.Smart TV, SmartCentral, Web browser included');
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','70" or More','Samsung','$19,999.98','2160p (4K)','2160p resolution.Motion Rate 240.Smart TV, Samsung Smart Hub, Web browser included.3D TV');