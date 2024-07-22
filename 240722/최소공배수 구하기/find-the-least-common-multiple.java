import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N, M
        int N = input.nextInt();
        int M = input.nextInt();

        // 최소공배수
        int result = lcmNumber(N, M);
        System.out.println(result);
    }

    // 최대공약수 (유클리드 호제법 - 반복문)
    private static int gcd(int N, int M) {
        while (M != 0)
        {
            int temp = M;
            M = N % M;
            N = temp;
        }

        return N;
    }

    // 최소공배수 (최대공약수를 이용)
    private static int lcmNumber(int N, int M)
    {
        return N * M / gcd(N, M);
    }
}