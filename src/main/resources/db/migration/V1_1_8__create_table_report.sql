CREATE TABLE report(
report_id integer  NOT NULL AUTO_INCREMENT,
category varchar(150) NOT NULL,
audit_start_date date NOT NULL,
audit_end_date date NOT NULL,
request_id int ,
created_by varchar(100) NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_by varchar(100) ,
updated_at TIMESTAMP DEFAULT NULL,
is_deleted boolean DEFAULT false,
PRIMARY KEY (report_id),
FOREIGN KEY (request_id)references request(request_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


