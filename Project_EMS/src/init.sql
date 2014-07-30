CREATE TABLE EMPLOYEE 
(
  EID NUMBER NOT NULL 
, ENAME VARCHAR2(20) 
, PASSWORD VARCHAR2(20) 
, ADDRESS VARCHAR2(50) 
, PHONENUM VARCHAR2(20) 
, EMAIL VARCHAR2(30) 
, IMGPATH VARCHAR2(50) 
, JOINDATE DATE 
, SALARY NUMBER 
, MANAGER NUMBER 
, ISMANAGER NUMBER 
, CONSTRAINT EMPLOYEE_PK PRIMARY KEY 
  (
    EID 
  )
  ENABLE 
);

CREATE TABLE DEPARTMENT 
(
  DID NUMBER NOT NULL 
, DNAME VARCHAR2(20) 
, CONSTRAINT DEPARTMENT_PK PRIMARY KEY 
  (
    DID 
  )
  ENABLE 
);

CREATE TABLE EMPDPT 
(
  EDID NUMBER NOT NULL 
, EID NUMBER 
, DID NUMBER 
, CONSTRAINT EMPDPT_PK PRIMARY KEY 
  (
    EDID 
  )
  ENABLE 
);

ALTER TABLE EMPDPT
ADD CONSTRAINT EMPDPT_FK1 FOREIGN KEY
(
  EID 
)
REFERENCES EMPLOYEE
(
  EID 
)
ENABLE;

ALTER TABLE EMPDPT
ADD CONSTRAINT EMPDPT_FK2 FOREIGN KEY
(
  DID 
)
REFERENCES DEPARTMENT
(
  DID 
)
ENABLE;

CREATE TABLE UPDATEREQ 
(
  UPID NUMBER NOT NULL 
, EID NUMBER 
, ENAME VARCHAR2(20) 
, ADDRESS VARCHAR2(50) 
, PHONENUM VARCHAR2(20) 
, PASSWORD VARCHAR2(30) 
, IMGPATH VARCHAR2(50) 
, CONSTRAINT UPDATEREQ_PK PRIMARY KEY 
  (
    UPID 
  )
  ENABLE 
);

ALTER TABLE UPDATEREQ
ADD CONSTRAINT UPDATEREQ_FK1 FOREIGN KEY
(
  EID 
)
REFERENCES EMPLOYEE
(
  EID 
)
ENABLE;



CREATE SEQUENCE EMP_INCRE INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE DPT_INCRE INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE ED_INCRE INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE UR_INCRE INCREMENT BY 1 START WITH 1;


