import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // n, m 입력
        int n = input.nextInt();
        int m = input.nextInt();

        // 교환
        int temp = n;
        n = m;
        m = temp;

        System.out.print(n + " " + m);       
    }
}