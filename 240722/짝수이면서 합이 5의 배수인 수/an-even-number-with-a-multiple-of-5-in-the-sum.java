import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 9 < n < 100 사이인 n 입력
        int n = input.nextInt();

        numberPrint(n);

    }

    private static void numberPrint(int n)
    {
        if (n < 9 || n > 100)
        {
            System.out.println("숫자를 잘못 입력하였습니다.");
            System.exit(0);
        }
        int a = n % 10;
        int b = n / 10;

        if (n % 2 == 0 && (a + b) % 5 == 0)
        {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}