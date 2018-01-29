CREATE TABLE `menu_item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MENU_NAME` varchar(45) DEFAULT NULL,
  `LINK` varchar(255) DEFAULT NULL,
  `MENU_ID` int(11) NOT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  `ICON` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
SELECT * FROM avella.menu_item;