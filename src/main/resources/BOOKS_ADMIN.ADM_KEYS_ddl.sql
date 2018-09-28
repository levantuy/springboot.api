-- Start of DDL Script for Table BOOKS_ADMIN.ADM_KEYS
-- Generated 9/28/2018 4:59:36 PM from BOOKS_ADMIN@STORES

CREATE TABLE adm_keys
    (keyname                        VARCHAR2(100 BYTE) NOT NULL,
    nextval                        NUMBER(20,0) NOT NULL)
  SEGMENT CREATION IMMEDIATE
  PCTFREE     10
  INITRANS    1
  MAXTRANS    255
  TABLESPACE  users
  STORAGE   (
    INITIAL     65536
    NEXT        1048576
    MINEXTENTS  1
    MAXEXTENTS  2147483645
  )
  NOCACHE
  MONITORING
  NOPARALLEL
  LOGGING
/





-- End of DDL Script for Table BOOKS_ADMIN.ADM_KEYS

