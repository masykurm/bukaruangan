
CREATE DATABASE IF NOT EXISTS  hackhaton_2017;

CREATE TABLE IF NOT EXISTS `booked_room` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `building` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `room`;
CREATE TABLE IF NOT EXISTS `room` (
  `id` int(11) NOT NULL,
  `building_id` int(11) DEFAULT NULL,
  `room_name` varchar(128) DEFAULT NULL,
  `room_capacity` int(11) DEFAULT NULL,
  `room_location` varchar(128) DEFAULT NULL,
  `facilities` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
