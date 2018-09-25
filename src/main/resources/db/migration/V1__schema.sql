CREATE TABLE users (
  id number(19) NOT NULL,
  name varchar2(40) NOT NULL,
  username varchar2(15) NOT NULL,
  email varchar2(40) NOT NULL,
  password varchar2(100) NOT NULL,
  created_at timestamp(0) DEFAULT NULL,
  updated_at timestamp(0) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT uk_users_username UNIQUE  (username),
  CONSTRAINT uk_users_email UNIQUE  (email)
) ;

-- Generate ID using sequence and trigger
CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER users_seq_tr
 BEFORE INSERT ON users FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT users_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/


CREATE TABLE roles (
  id number(19) NOT NULL,
  name varchar2(60) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT uk_roles_name UNIQUE  (name)
)  ;

-- Generate ID using sequence and trigger
CREATE SEQUENCE roles_seq START WITH 4 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER roles_seq_tr
 BEFORE INSERT ON roles FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT roles_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/


CREATE TABLE user_roles (
  user_id number(19) NOT NULL,
  role_id number(19) NOT NULL,
  PRIMARY KEY (user_id,role_id)
 ,
  CONSTRAINT fk_user_roles_role_id FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT fk_user_roles_user_id FOREIGN KEY (user_id) REFERENCES users (id)
) ;

CREATE INDEX fk_user_roles_role_id ON user_roles (role_id);


CREATE TABLE polls (
  id number(19) NOT NULL,
  question varchar2(140) NOT NULL,
  expiration_date_time timestamp(0) NOT NULL,
  created_at timestamp(0) DEFAULT NULL,
  updated_at timestamp(0) DEFAULT NULL,
  created_by number(19) DEFAULT NULL,
  updated_by number(19) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

-- Generate ID using sequence and trigger
CREATE SEQUENCE polls_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER polls_seq_tr
 BEFORE INSERT ON polls FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT polls_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/


CREATE TABLE choices (
  id number(19) NOT NULL,
  text varchar2(40) NOT NULL,
  poll_id number(19) NOT NULL,
  PRIMARY KEY (id)
 ,
  CONSTRAINT fk_choices_poll_id FOREIGN KEY (poll_id) REFERENCES polls (id)
) ;

-- Generate ID using sequence and trigger
CREATE SEQUENCE choices_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER choices_seq_tr
 BEFORE INSERT ON choices FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT choices_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/

CREATE INDEX fk_choices_poll_id ON choices (poll_id);


CREATE TABLE votes (
  id number(19) NOT NULL,
  user_id number(19) NOT NULL,
  poll_id number(19) NOT NULL,
  choice_id number(19) NOT NULL,
  created_at timestamp(0) DEFAULT NULL,
  updated_at timestamp(0) DEFAULT NULL,
  PRIMARY KEY (id)
 ,
  CONSTRAINT fk_votes_user_id FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT fk_votes_poll_id FOREIGN KEY (poll_id) REFERENCES polls (id),
  CONSTRAINT fk_votes_choice_id FOREIGN KEY (choice_id) REFERENCES choices (id)
) ;

-- Generate ID using sequence and trigger
CREATE SEQUENCE votes_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER votes_seq_tr
 BEFORE INSERT ON votes FOR EACH ROW
 WHEN (NEW.id IS NULL)
BEGIN
 SELECT votes_seq.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/

CREATE INDEX fk_votes_user_id ON votes (user_id);
CREATE INDEX fk_votes_poll_id ON votes (poll_id);
CREATE INDEX fk_votes_choice_id ON votes (choice_id);
