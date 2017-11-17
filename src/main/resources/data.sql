
USE hackhaton_2017;

TRUNCATE TABLE `booked_room`;
INSERT INTO `booked_room` VALUES (1,12,2,'Jason','R.Meeting Merah','2017-11-18 09:00:00','2017-11-18 10:00:00','@masykurm','Weekly Core Search','2017-11-17 19:36:34');


TRUNCATE TABLE 	`building`;
INSERT INTO `building` (`id`,`name`,`location`) VALUES (1,'PCV','Jl. Kemang Timur Raya No.22, RT.14/RW.8, Pejaten Bar., Ps. Minggu, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12510');
INSERT INTO `building` (`id`,`name`,`location`) VALUES (2,'Ampera',' Jl. Ampera Raya Cilandak Tim. Ps. Minggu Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12560 ');		
		
TRUNCATE TABLE `room`;		
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (1,1,'Blue Room',14,'Lt.1 (pojok engineer)','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (2,1,'Besar (Orange)',16,'Lt.2 (samping Telesales)','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (3,1,'Library',16,'Lt.2 (samping orange)','Table, chair, whiteboard, infocus, sofa, lots of books');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (4,1,'Fun Room',12,'Lt.2 (depan ruang Library)','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (5,1,'Ice Pop',8,'Lt. 1 (Samping Receptionist)','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (6,1,'Super Burger',8,'Lt.1 (Samping Ice Pop)','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (7,1,'Ding Dong',6,'Lt.1 (Samping Super Burger)','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (8,1,'Silent Room',8,'Lt.1 ( Xbox / Rumput Sintetis)','whiteboard, TV, PS4, Pillow');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (9,2,'R.Meeting Biru',16,'Lantai 1','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (10,2,'R.Meeting Abu',12,'Lantai 1','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (11,2,'R.Meeting Cokelat',6,'Lantai 1','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (12,2,'R.Meeting Merah',6,'Lantai 1','Table, chair, whiteboard, infocus');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (13,2,'R.Meeting Merah Putih (Lesehan)',18,'Lantai 1','Table, whiteboard, infocus, Pillow');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (14,2,'Area Kolaborasi Red Circle',18,'Lantai 1','Table, 2 TVs');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (15,2,'Area Diskusi 1',4,'Lantai 1','Table, Chair ');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (16,2,'Area Diskusi 2',4,'Lantai 1','Table, Chair ');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (17,2,'Area Diskusi 3',4,'Lantai 1','Table, Chair ');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (18,2,'Area Diskusi 4',4,'Lantai 2','Table, Chair ');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (19,2,'Area Diskusi 5',4,'Lantai 2','Table, Chair ');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (20,2,'Area Diskusi 6',4,'Lantai 2','Table, Chair ');
INSERT INTO `room` (`id`,`building_id`,`room_name`,`room_capacity`,`room_location`,`facilities`) VALUES (21,2,'Hall ',100,'Lantai 2','Chair, Infocus, Speaker, Remote conference needs');
