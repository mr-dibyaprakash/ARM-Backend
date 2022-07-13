
CREATE TABLE  IF NOT EXISTS `production`(
production_id integer  NOT NULL AUTO_INCREMENT,
production_name varchar(255) NOT NULL,
created_by varchar(100),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_by varchar(100) ,
updated_at TIMESTAMP DEFAULT NULL,
is_deleted boolean DEFAULT false,
PRIMARY KEY (production_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

