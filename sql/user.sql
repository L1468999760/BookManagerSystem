DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT '',
  `password` varchar(256) DEFAULT '',
  `isOnline` int(1) DEFAULT '0', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
