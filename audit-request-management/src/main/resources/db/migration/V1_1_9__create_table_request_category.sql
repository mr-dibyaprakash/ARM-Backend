CREATE TABLE  IF NOT EXISTS `request_category`(
  request_id integer NOT NULL,
  category_id integer NOT NULL,
  PRIMARY KEY (request_id,category_id),
  FOREIGN KEY (request_id) references request(request_id),
  FOREIGN KEY (category_id) references category(category_id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


