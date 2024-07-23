import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);

        // 정수 a, b 입력
        int a = input.nextInt();
        int b = input.nextInt();

        int result = power(a, b);
        System.out.println(result);

    }

    private static int power(int a, int b)
    
    {
        return (int)Math.pow(a, b);
    }
}