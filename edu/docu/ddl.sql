create table member(
id 	varchar2(20) primary key,--아디
pwd varchar2(60), --패스워드
name varchar2(20), --이름
hobby varchar2(20), --취미(h01,h02)
gender char(1),  --성별
religion char(3), --종교
introduction varchar2(1000), --자기소개
regdt date --가입일자 
)

drop table board

create table board(
seq number(20),
title varchar2(20), 
contents varchar2(60), 
regdt date , 
id varchar2(20) ,
CONSTRAINT boared_PK PRIMARY KEY (seq),
CONSTRAINT boared_FK FOREIGN KEY (id) REFERENCES member(id)
)

select*from board

CREATE SEQUENCE seq_board;