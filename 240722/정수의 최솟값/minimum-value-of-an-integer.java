import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 a, b, c 입력
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int result = minimalValue(a, b, c);
        System.out.println(result);
    }

    private static int minimalValue(int a, int b, int c)
    {
        if (a < b && a < c) {
            return a;
        } else if (b < c)
        {
            return b;
        } else
        {
            return c;
        }
    }
}