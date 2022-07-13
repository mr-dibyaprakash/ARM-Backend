
CREATE TABLE  IF NOT EXISTS `request` (
request_id integer  NOT NULL AUTO_INCREMENT,
priority varchar(45) NOT NULL,
union_name varchar(45) NOT NULL,
status varchar(45) NOT NULL,
production_id int,
request_created_date date NOT NULL,
audit_start_date date NOT NULL,
audit_end_date date NOT NULL,
contract_date date,
request_schedule_id int,
created_by varchar(100) NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_by varchar(100) ,
updated_at TIMESTAMP DEFAULT NULL,
is_deleted boolean DEFAULT false,
PRIMARY KEY(request_id),
FOREIGN KEY (production_id) references production(production_id),
FOREIGN KEY (request_schedule_id) REFERENCES request_schedule(request_schedule_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

