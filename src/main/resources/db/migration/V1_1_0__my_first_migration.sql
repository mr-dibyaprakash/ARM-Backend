
CREATE TABLE `expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(45) NOT NULL,
  `amount` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;