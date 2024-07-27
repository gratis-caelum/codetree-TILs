import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N 입력
        int N = input.nextInt();

        int result = squareSum(N);
        System.out.println(result);

    }
    private static int squareSum(int n)
    {
        if (n < 10)
            return n * n;
        
        return squareSum(n / 10) + ((n % 10) * (n % 10));
    }
}