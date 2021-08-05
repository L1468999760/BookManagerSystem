DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `author` varchar(256) DEFAULT NULL,
  `price` varchar(256) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;

INSERT INTO `book` (`id`, `name`, `author`, `price`, `status`)
VALUES
	(1,'机器学习','周志华','66',0),
	(2,'图解HTTP','L.','100',0),
	(3,'史记','司马迁','100',0),
	(4,'百面机器学习','人民邮电出版社','50',0),
	(5,'Spring实战','人民邮电出版社','80',0);

/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;