# 데이터베이스 준비 : db 서버의 여러개 테이블들을 저장 할 수 있는 공간
drop database if  exists mydb0123;   #[1] 만약에 동일한 DB명이 존재하면 데이터 베이스 삭제해요alter
create database mydb0123;              #[2] 지정한 DB명으로 데이터베이스 생성해요
use mydb0123;                            #[3] 지정한 DB를 활성화 및 사용해요.

# 테이블 준비 : 행과 열로 이루어진 표 또는 테이블을 의미해요
create table board( # 테이블명은 임의로 하되 저장할 데이터와 의미있는 이름으로 정해요
bno int auto_increment,       # 게시물번호
btitle varchar(100),          # 게시물제목
bcontent longtext,            # 게시물 내용
bwriter varchar(25),          # 게시물 작성자
bpwd varchar(20),             # 게시물 비밀번호
bdate datetime default now(), # 게시물 작성일자
bview int default 0,          # 게시물 조회수
constraint primary key(bno)   # 게시물 번호를 PK로 설정 # 식별자 역할을 해요!
);
