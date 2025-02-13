package day03.task4;

public class WaitingDto {
    private int num;       // 대기 번호 (예: PK 역할)
    private String content; // 간단한 내용
    private int age;       // 나이 등등

    public WaitingDto() {}

    public WaitingDto(int num, String content, int age) {
        this.num = num;
        this.content = content;
        this.age = age;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

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

    @Override
    public String toString() {
        return "WaitingDto [num=" + num + ", content=" + content + ", age=" + age + "]";
    }
}