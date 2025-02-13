package day05.task1;

public class BoardDto { //cs

	private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String bpwd;
    private String bdate;
    private int bview;

 public BoardDto() {}


    public BoardDto( int bno , String btitle , String bcontent , String bwriter , String bpwd , String bdate , int bview) {
    	super();
    	this.bno = bno;
    	this.btitle=btitle;
    	this.bcontent=bcontent;
    	this.bwriter=bwriter;
    	this.bpwd=bpwd;
    	this.bview=bview;
    	this.bdate=bdate;
    }
    
    public int getBno() {return bno;}
    public void setBno(int bno) {this.bno=bno;}
    
    public String getBtitle() {return btitle;}
    public void setBtitle(String btitle) {this.btitle=btitle;}
    
    public String getBcontent() {return bcontent;}
    public void setBcontent(String bcontent) {this.bcontent=bcontent;}
    
    public String getBwriter() {return bwriter;}
    public void setBwriter(String bwriter) {this.bwriter=bwriter;}
    
    public String getBpwd() {return bpwd;}
    public void setBpwd(String bpwd) {this.bpwd=bpwd;}
    
    public String getBdate() {return bdate;}
    public void setBdate(String bdate) {this.bdate=bdate;}
    
    public int getBview() {return bview;}
    public void setBview(int bview) {this.bview=bview;}
    

    
    public String toString() {
    	return "BoardDto [bno="+bno+" , btitle="+btitle+" , bcontent="+bcontent+" , bwriter="+bwriter+" , bpwd="+bpwd+", bdate="+bdate+" , bview ="+bview+"]";
    }
 } //ce