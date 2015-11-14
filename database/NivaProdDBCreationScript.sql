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
         DESCRIPTION CHAR(100) NOT NULL,
         SCREEN_TYPE_ID INT(10) NOT NULL,
         IMAGE longblob NOT NULL
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
#--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# INSERTING DATA IN TO niva_production.TV_HomeTheater
#--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','40" - 45"','Samsung','$788.66','2160p (4K)','2160p resolution.Motion Rate 120.Smart TV, apps, Web browser included','1',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Samsung4045_788.jpg'));
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','40" - 45"','Samsung','$1,099.98','2160p (4K)','2160p resolution.Clear Motion Rate 240.Smart TV, Samsung Smart Hub, Web browser included.3D TV','1',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Samsung4045_789.jpg'));
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','40" - 45"','Samsung','$788.66','2160p (4K)','2160p resolution.Motion Rate 120.Smart TV, apps, Web browser included','1',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Samsung4045_1099.jpg'));
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','46" - 49"','LG','$899.98','2160p (4K)','2160p resolution.TruMotion 120Hz refresh rate.Smart TV, LG Content Store, Web browser included','2',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/LG4649_899.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','46" - 49"','LG','$749.99','2160p (4K)','2160p resolution.Ultra Clarity Index 1080.LG Smart TV, Premium VOD Services','2',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/LG4649_749.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','50" - 54"','Westinghouse','$699.99','2160p (4K)','2160p resolution.60Hz refresh rate.Smart TV','3',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Westinghouse5054_699.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$999.99','2160p (4K)','2160p resolution.Smart TV','4',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$1,399.99','2160p (4K)','2160p resolution.Motionflow XR 960.Smart Android TV with Google Play and Google Cast built-in.3D TV','4',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1399.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$1,999.98','2160p (4K)','2160p resolution.Motionflow XR 960.Smart Android TV with Google Play and Google Cast built-in.3D TV','4',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','55" - 59"','Sony','$1,098.00','2160p (4K)','2160p resolution.Motionflow XR 240.Smart TV','4',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','60" - 64"','VIZIO','$1,199.99','2160p (4K)','2160p resolution.Clear Action 720.Smart TV, VIZIO Internet Apps Plus','5',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Vizio6064_1199.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','65" - 69"','Sharp','$1,221.76','2160p (4K)','2160p resolution.AquoMotion 240.Smart TV, SmartCentral, Web browser included','6',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sharp6569_1221.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'4K UHD','70" or More','Samsung','$19,999.98','2160p (4K)','2160p resolution.Motion Rate 240.Smart TV, Samsung Smart Hub, Web browser included.3D TV','7',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/SamsungMore70_19999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','27 and Under','Insignia','$99.99','720p','Insignia- 19" Class (18.5" Diag.) LED 720p HDTVBlack','10' ,LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','27 and Under','Insignia','$129.99','1080p','Insignia - 24" Class (23.8" Diag.) LED 1080p HDTV Black','10' ,LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1399.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','27 and Under','Insignia','$89.99','720p','Insignia - 19" Class (18-1/2" Diag.) LED 720p HDTVBlack 60Hz refresh rate ENERGY STAR Certified','10',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','28" - 32"','SunBrite TV','1,499.99','1080p','SunBrite TV - Signature Series - 32" Class (32" Diag.) LED Outdoor 1080p 60Hz HDTV Silver','11',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','28" - 32"','SunBrite TV','$4,595.98','1080p','SunBrite TV - Pro Series - 32" Class (31.5" Diag.) LED Outdoor Touch Screen 1080p Display Silver','11',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Vizio6064_1199.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','28" - 32"','SunBrite TV','$5,195.98','1080p','SunBrite TV Pro Series 32" Class (31.5" Diag.) LED Outdoor Touch Screen 1080p Display Silver','11',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','28" - 32"','SunBrite TV','$3,295.98','1080p','SunBrite TV - Pro Series - 32" Class (32" Diag.)  LED  Outdoor Touch Screen 1080p Display Silver','11',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1399.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','28" - 32"','SunBrite TV','$5,195.98','1080p','SunBrite TV - Pro Series - 32" Class (32" Diag.) LED OutdoorTouch Screen 1080p Display Black','11',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','33" - 39"','Insignia','$199.99','720p','Insignia - 39" Class (38.5" Diag.) - LED - 720p - HDTV - Black','12',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','40" - 45"','Toshiba','$249.99','1080p ','Toshiba - 40" Class (39.5" Diag.) - LED - 1080p - HDTV - Black','13',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Vizio6064_1199.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','40" - 45"','Toshiba','$279.99','1080p ','Toshiba - 43" Class (42.5" Diag.) - LED - 1080p - HDTV - Black','13',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','40" - 45"','Toshiba','$364.64','1080p ','Toshiba - 40" Class (40" Diag.) - LED-LCD TV - 1080p - Gunmetal','13',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1399.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','46" - 49"','LG','$749.99','2160p','LG - 49" Class (48.5" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Black','14',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','46" - 49"','LG','$479.99','1080p','LG - 49" Class (48.5" Diag.) - LED - 1080p - HDTV - Black','14',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','46" - 49"','LG','$899.98','2160p','LG - 49" Class (48.5" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Black','14',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Vizio6064_1199.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','46" - 49"','LG','$749.99','2160p','LG - UB8200 Series - 49" Class (48-1/2" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Black','14',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','46" - 49"','LG','$786.99','1080p','LG - 47" Class (46-9/10" Diag.) - LED - 1080p - 240Hz - Smart - 3D - HDTV','14',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sharp6569_1221.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','46" - 49"','LG','$697.99','1080p','LG - 49" Class (48.5" Diag.) - LED - 1080p - Smart - HDTV - Black','14',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/LG4649_899.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','50" - 54"','Sharp','$429.99','1080p','Sharp - 50" Class (49.7" Diag.) - LED - 1080p - HDTV - Black','15',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Samsung4045_788.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','50" - 54"','Sharp','$499.99','1080p','Sharp - 50" Class (49.7" Diag.) - LED - 1080p - Smart HDTV Roku TV Black','15',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','50" - 54"','Sharp','$899.99','1080p','Sharp - AQUOS - 50" Class (49.6" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Black','15',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1399.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','55" - 59"','Sony','$999.99','2160p','Sony - 55" Class (54.6" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Black','16',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','55" - 59"','Sony','$1,399.99','2160p','Sony - 55" Class (54.6" Diag.) - LED - 2160p - Smart - 3D - 4K Ultra HD TV - Black','16',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','55" - 59"','Sony','$799.99','1080p','Sony - 55" Class (54.6" Diag.) - LED - 1080p - Smart - 3D - HDTV - Black','16',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Vizio6064_1199.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','55" - 59"','Sony','$1,799.98','2160p','Sony - 55" Class (54-1/2" Diag.) - LED - 2160p - Smart - 3D - 4K Ultra HD TV - Black','16',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sharp6569_1221.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','55" - 59"','Sony','$1,098.00','2160p','Sony - 55" Class (54.6" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Silver','16',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/LG4649_899.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','55" - 59"','Sony','$998.00','1080p ','Sony - 55" Class (54-5/8" Diag.) - LED - 1080p - Smart - 3D - HDTV - Black','16',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','60" - 64"','VIZIO','$749.99','1080p','VIZIO - 60" Class (60" Diag.) - LED - 1080p - Smart - HDTV - Black','17',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1399.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','60" - 64"','VIZIO','$1,199.99','2160p','VIZIO - 60" Class (60" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Black','17',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','60" - 64"','VIZIO','$749.99','1080p','VIZIO - E-Series - 60" Class (60-1/8" Diag.) - LED - 1080p - Smart - HDTV - Black','17',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Vizio6064_1199.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','65" - 69"','Samsung','$2,499.99','2160p','Samsung - 65" Class (64.5" Diag.) - Smart TV, Web browser - Silver','18',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','65" - 69"','Samsung','$2,299.99','2160p','Samsung - 65" Class (64.5" Diag.) - LED - 2160p - Smart - 3D - 4K Ultra HD TV - Silver','18',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sharp6569_1221.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','65" - 69"','Samsung','$2,499.98','2160p','Samsung - 65" Class (64.5" Diag.) Smart TV, Samsung Smart Hub, Web browser included','18',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Samsung4045_788.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','65" - 69"','Samsung','$2,499.00','2160p','Samsung - 65" Class (64-1/2" Diag.) - LED - 2160p - Smart - 3D - 4K Ultra HD TV - Silver','18',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Samsung4045_789.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$2,199.99','1080p','Samsung - 75" Class (74.5" Diag.) - LED - 1080p - Smart - HDTV - Black','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Samsung4045_1099.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$9,999.98','2160p','Samsung - 78" Class (78" Diag.) - LED - Curved - 2160p - Smart - 3D - 4K Ultra HD TV - Black','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/LG4649_899.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$8,999.98','2160p','Samsung - 85" Class (84.5" Diag.) - LED - 2160p - Smart - 3D - 4K Ultra HD TV - Silver','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$5,499.98','2160p','Samsung - 78" Class (78" Diag.) - LED - Curved - 2160p - Smart - 3D - 4K Ultra HDTV - Silver','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1399.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$6,999.98','2160p','Samsung - 78" Class (78" Diag.) - LED - 2160p - Smart - 4K Ultra HD TV - Silver','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1999.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$19,999.98','2160p','Samsung - 88" Class (88" Diag.) - LED - Curved - 2160p - Smart - 3D - 4K Ultra HD TV - Silver','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sony5559_1098.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$19,999.99','2160p','Samsung - 88" Class (88" Diag.) - LED - Curved - 2160p - Smart - 3D - 4K Ultra HD TV - Silver','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Vizio6064_1199.jpg') );
INSERT INTO niva_production.TV_HomeTheater VALUES (id,'LED TV','70" or More','Samsung','$9,997.99','2160p','Samsung - 85" Class (84-1/2" Diag.) - LED - 2160p - Smart - 3D - 4K Ultra HD TV - Black','19',LOAD_FILE('C:/Users/Igor/Desktop/JavaGuru2_2015/Git_repo/niva/src/main/webapp/images/TV/Sharp6569_1221.jpg') );
