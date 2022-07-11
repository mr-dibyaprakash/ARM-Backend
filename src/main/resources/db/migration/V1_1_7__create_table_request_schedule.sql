
CREATE TABLE  IF NOT EXISTS `request_schedule`(
request_schedule_id integer  NOT NULL AUTO_INCREMENT,
request_created date NOT NULL,
expected_closure date NOT NULL ,
audit_start_date date NOT NULL,
audit_end_date date NOT NULL,
report_submission date NOT NULL,
settlement_date date NOT NULL,
receipt_date date NOT NULL,
request_id int,
created_by varchar(100) NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
updated_by varchar(100) ,
updated_at TIMESTAMP DEFAULT NULL,
is_deleted boolean DEFAULT false,
PRIMARY KEY(request_schedule_id),
FOREIGN KEY (request_id) REFERENCES request(request_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

