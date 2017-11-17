create database hackhaton_2017;

CREATE TABLE `hackhaton_2017`.`room` (
  `id` INT NOT NULL,
  `building_id` INT NULL,
  `room_name` VARCHAR(128) NULL,
  `room_capacity` INT NULL,
  `room_location` VARCHAR(128) NULL,
  PRIMARY KEY (`id`));
  
  
CREATE TABLE `hackhaton_2017`.`building` (
  `id` INT NOT NULL,
  `name` VARCHAR(128) NULL,
  `location` VARCHAR(256) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `hackhaton_2017`.`booked_room` (
  `id` INT NOT NULL,
  `building_name` VARCHAR(128) NULL,
  `room_name` VARCHAR(128) NULL,
  `booked_date` datetime NULL, 
  `booked_by` VARCHAR(128) NULL,
  `meeting_name` VARCHAR(128) NULL,
  `created_date` timestamp NULL,
  PRIMARY KEY (`id`));