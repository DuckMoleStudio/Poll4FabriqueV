
-- Init new schema & tables for Postgre DB for Poll Example, existing ones would be dropped
-- Copy this script to Beaver console & execute


DROP TABLE IF exists pollV.variant;
DROP TABLE IF exists pollV.answer;
DROP TABLE IF exists pollV.question;
DROP TABLE IF exists pollV.poll;

DROP SEQUENCE IF exists pollV.poll_pollid;
DROP SEQUENCE IF exists pollV.question_questionid;
DROP SEQUENCE IF exists pollV.variant_variantid;
DROP SEQUENCE IF exists pollV.answer_answerid;
DROP SCHEMA IF exists pollV;

CREATE SCHEMA pollV AUTHORIZATION postgres;

CREATE SEQUENCE pollV.poll_pollid
	INCREMENT BY 1;

CREATE SEQUENCE pollV.question_questionid
	INCREMENT BY 1;

CREATE SEQUENCE pollV.variant_variantid
    INCREMENT BY 1;

CREATE SEQUENCE pollV.answer_answerid
     INCREMENT BY 1;




CREATE TABLE pollV.poll (
	pollid int4 NOT NULL DEFAULT nextval('pollV.poll_pollid'),
	name varchar(100) NOT NULL,
	description varchar(255),
	startdate date,
	enddate date,

	CONSTRAINT poll_pkey PRIMARY KEY (pollid)
);


CREATE TABLE pollV.question (
	questionid int4 NOT NULL DEFAULT nextval('pollV.question_questionid'),
	pollid int not null,
	questiontext varchar(255),

	CONSTRAINT question_pkey PRIMARY KEY (questionid),
	CONSTRAINT question_fkey1 FOREIGN KEY (pollid) REFERENCES pollV.poll (pollid)

);


CREATE TABLE pollV.variant (
	variantid int4 NOT NULL DEFAULT nextval('pollV.variant_variantid'),
	questionid int not null,
	varianttext varchar(255),

	CONSTRAINT variant_fkey1 FOREIGN KEY (questionid) REFERENCES pollV.question (questionid),
	CONSTRAINT variant_pkey PRIMARY KEY (variantid)
);

CREATE TABLE pollV.answer (
	answerid int4 NOT NULL DEFAULT nextval('pollV.answer_answerid'),
	questionid int not null,
	answertext varchar(255),

	CONSTRAINT answer_fkey1 FOREIGN KEY (questionid) REFERENCES pollV.question (questionid),
	CONSTRAINT answer_pkey PRIMARY KEY (answerid)
);



