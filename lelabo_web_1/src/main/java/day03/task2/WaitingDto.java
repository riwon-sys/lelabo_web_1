package day03.task2;

public class WaitingDto {
	private String content;
	private int age;
	public WaitingDto() {}
	public WaitingDto(String content , int age) {
		super();
		this.content = content;
		this.age =age;
	}
	
 // 1. get / set
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
// 2. toString	
	@Override
	public String toString() {
		return "WaitingDto [content=" + content + ", age=" + age + "]";
	}
	

}
