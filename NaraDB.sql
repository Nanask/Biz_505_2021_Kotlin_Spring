/*
DB 3대 Schema
외부, 개념, 내부
외부 : 모든 데이터는 Tabel 형태로 되어있다.
내부 : DBMS 엔진(SW)이 자체적으로 OS와 함께 연동되어
	Storage에 어떻게 데이터를 보관하는가 하는 관점
    데이터를 어떤 기준으로 저장할 것인가
    (ORACLE : TableSpace , MySQL : DataBase)
    오라클을 제외하고는 거의 데부분 DataBase에 만든다
개념 : 사용자의 SQL을 번역하여 실제 데이터에 어떻게 반영 할 것인가
	조회된 데이터를 어떻게 하여 Table 모양으로 바꿀것인가
*/

/*
RDBMS(Relation DataBase Management System)
	데이터베이스 관리 소프트웨어(ORACLE, MySQL, MSSQL, ....)

RDMS 차원에서의 Schema
	Data를 보관하는(관리하는) 가장 큰 주체가 무엇이냐
    일반 : DataBase를 기준으로 Schema
		사용자는 login을 통한 권한을 획득한 사용자
    Oracla : User를 기준으로 Schema
		tablespace는 데이터를 보관하는 장소일 뿐
*/
-- naraDB Schema 생성하기
create DATABASE NaraDB;
USE naraDB;
show tables;
DESC tbl_buyer;
DROP table tbl_buyer;

INSERT INTO tbl_buyer(userid, name)
VALUES('B001','홍길동');
INSERT INTO tbl_buyer(userid, name)
VALUES('B002','성춘향');

-- 업데이트를 실행할 때는 반드시 변경하고자 하는 데이터의
-- PK를 확인하고 PK를 조건절(WHERE)에 지정하여 실행을 한다
UPDATE tbl_buyer SET tel='010-111-1111'
WHERE userid = 'B001';

-- DELETE를 실행할때도 반드시 삭제하고자 하는 데이터의 PK를 확인하고
-- 조건절에 PK를 설정하여 실행한다
DELETE FROM tbl_buyer
WHERE userid = 'B002';

-- 보안사고 : 권한이 없는 사용자가 침투하여 사고내기
/* 
	무결성파괴 : 권한이 있는 사용자가 잘못하여 DB에 문제를 일으키는 것이다
		역할을 적절하게 부여하는 것이 좋다.
        PK와 FK 관리를 잘 해야 한다
*/		

DESC tbl_sales;	


show tables;
desc tbl_sales;
desc hibernate_sequence;