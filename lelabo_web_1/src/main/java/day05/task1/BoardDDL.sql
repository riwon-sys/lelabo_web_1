# DDL 
# 데이터베이스 준비 : db 서버의 여러개 테이블들을 저장할 수 있는 공간 
drop database if exists mydb0122;      #[1] 만약에 동일한 DB명이 존재하면 데이터베이스 삭제 
create database mydb0122;            #[2] 지정한 DB명으로 데이터베이스 생성 
use mydb0122;                     #[3] 지정한 DB를 활성화/사용
# 테이블 준비 : 행/열 로 이루어진 표/테이블 
create table board( # 테이블명은 임의로 하되 저장할 데이터와 의미있는 이름으로 정하기.
   bno int auto_increment ,       # 게시물번호 
    btitle varchar(100),         # 게시물제목 
    bcontent longtext,            # 게시물내용 
    bwriter varchar(10),         # 게시물작성자
    bpwd varchar(10),            # 게시물비밀번호 
    bdate datetime default now(),   # 게시물작성일 
    bview int default 0,         # 게시물조회수 
    constraint primary key( bno )   # 게시물번호를 pk로 설정 
);

# (1) 게시물 등록 (api 명세서를 보고 해보세요)
insert into board ( btitle , bcontent , bwriter , bpwed) values('test제목1' , 'test내용1' , 'test작성자1' , 'test비밀번호1');
# java dao : String sql = "insert into board ( btitle , bcontent , bwriter , bpwed) values(? , ? , ? , ?)";

# (2) 게시물 전체 조회
select * from board;
# java dao : String sql ="select * from board";

#(3) 게시물 개별 조회
select * from board where bno = 1;
# java dao : String sql ="select * from board where bno=?";

#(4) 게시물 개별 수정
update board set bitle = '수정제목1' , bcontent ='수정내용1' where bno =1;
# java dao : String sql = "update board set btitle =? , bcontent = ? where bno = ?"; 

#(5) 게시물 개별 삭제
delete from board where bno =1;
# java dao : String sql = " delete from board where bno =?";


INSERT INTO board (btitle, bcontent, bwriter, bpwd)
VALUES ('테스트 제목', '테스트 내용', '홍길동', '1234');

SELECT * FROM board;