

CREATE TABLE  IF NOT EXISTS `category`(
category_id integer   NOT NULL AUTO_INCREMENT,
report_type varchar(250) NOT NULL,
reporter_id int,
request_id int,
created_by varchar(100),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_by varchar(100) ,
updated_at TIMESTAMP DEFAULT NULL,
is_deleted boolean DEFAULT false,
PRIMARY KEY(category_id),
FOREIGN KEY (reporter_id) REFERENCES reporter(reporter_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


