# DML : INSERT SELECT UPDATE DELETE 

#(1) 게시물 등록
insert into board(btitle,bcontent,bwriter,bpwd) values('TItitle1','TTcontent1','TTwriter1','TTpwd1');
#DAO : String sql = "insert into board(btitle,bcontent,bwriter,bpwd) values(?,?,?,?)";

#(2) 게시물 전체 조회
select * from board;
#DAO : String sql = "select * from board";

#(3) 게시물 개별 조회
select * from board where bno = 1;
#DAO : String sql = "select * from board where bno =?";

#(4) 게시물 개별수정
update board set btitle = 'TUtitle1', bcontent='TUcontent1' where bno =1;
#DAO : String sql = "update board set btitle = ? , bcontent = ? where bno =?";

#(5) 게시물 개별삭제
delete from board where bno =1;
#DAO : String sql = "delete from board where bno = ?";