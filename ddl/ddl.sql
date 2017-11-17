create database hackhaton_2017;

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `building_id` int(11) DEFAULT NULL,
  `room_name` varchar(128) DEFAULT NULL,
  `room_capacity` int(11) DEFAULT NULL,
  `room_location` varchar(128) DEFAULT NULL,
  `facilities` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  
CREATE TABLE `building` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

  
CREATE TABLE `booked_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `building_name` varchar(45) DEFAULT NULL,
  `room_name` varchar(45) DEFAULT NULL,
  `booked_start_date` datetime DEFAULT NULL,
  `booked_end_date` datetime DEFAULT NULL,
  `booked_by` varchar(45) DEFAULT NULL,
  `meeting_name` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

