import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();

        // 시작 시간과 종료 시간을 분 단위로 변환
        int startMinute = a * 60 + b;
        int endMinute = c * 60 + d;

        // 경과 시간 계산
        int elapsedTime = endMinute - startMinute;
    

        System.out.println(elapsedTime);
    }
}