import java.util.Scanner;

public class Main {
    private String secretCode;
    private String meetingPlace;
    private int time;

    public Main(String secretCode, String meetingPlace, int time)
    {
        this.secretCode = secretCode;
        this.meetingPlace = meetingPlace;
        this.time = time;
    }

    public void display() {
        System.out.println("secret code : " + secretCode);
        System.out.println("meeting point : " + meetingPlace);
        System.out.println("time : " + time);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 입력 받기
        String secretCode = input.next();
        String meetingPlace = input.next();
        int time = input.nextInt();

        // 객체 생성 및 출력
        Main meeting = new Main(secretCode, meetingPlace, time);
        meeting.display();
    }
    

}