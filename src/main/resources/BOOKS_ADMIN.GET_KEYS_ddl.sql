-- Start of DDL Script for Function BOOKS_ADMIN.GET_KEYS
-- Generated 9/28/2018 5:00:06 PM from BOOKS_ADMIN@STORES

CREATE OR REPLACE 
FUNCTION get_keys
(  keyname   IN   VARCHAR2,
   numblocksize         IN   NUMBER DEFAULT 1,
   numretry             IN   NUMBER DEFAULT 10
)
   RETURN NUMBER
IS
   PRAGMA AUTONOMOUS_TRANSACTION;
-- Thuc hien get primary key tu bang keys
--    + keyname : ten sequence (truong cc_domain)
--    + numBlockSize : so key lay ve trong 1 lan query
--    + numRetry : so lan retry query cg_code_controls neu detect thay co client khac dang dong thoi truy cap
-- MODIFICATION HISTORY
-- Person               Date     Comments
-- Truong Minh Thanh      31/05/2018  ---------------------------------
   str_sql        VARCHAR2 (1000);
   sequencename   VARCHAR2 (50);
   retrycount     NUMBER;
   retvalue       NUMBER;

   TYPE empcurtyp IS REF CURSOR;

   c1             empcurtyp;
   ignore         PLS_INTEGER;
-- Declare program variables as shown above
BEGIN
   IF (numblocksize < 1)
   THEN
      RETURN 0;
   END IF;

   sequencename := UPPER (keyname);
   retrycount := 0;

   WHILE (retrycount < numretry)
   LOOP
      BEGIN
         str_sql :=
               'update adm_keys SET NEXTVAL = NEXTVAL + :TOKEN_BLOCKSIZE
         WHERE KEYNAME = :TOKEN_KEYNAME';

--       dbms_output.put_line(str_sql);
         EXECUTE IMMEDIATE str_sql
                     USING numblocksize, sequencename;

         EXIT;
      EXCEPTION
         WHEN OTHERS
         THEN
            retrycount := retrycount + 1;
      END;
   END LOOP;

   IF (retrycount = numretry)
   THEN
      RETURN 0;
   END IF;

   str_sql :=
         'SELECT (NEXTVAL - :TOKEN_BLOCKSIZE) FROM adm_keys '
      || 'WHERE KEYNAME = :TOKEN_KEYNAME';

-- dbms_output.put_line(str_sql);
   OPEN c1
    FOR str_sql USING numblocksize, sequencename;

   FETCH c1
    INTO retvalue;

   CLOSE c1;

   COMMIT;
   RETURN retvalue;
EXCEPTION
   WHEN OTHERS
   THEN
      RETURN -1;
END;
/



-- End of DDL Script for Function BOOKS_ADMIN.GET_KEYS

