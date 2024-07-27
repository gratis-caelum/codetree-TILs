import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
        
        // 정수 N 입력
        int N = input.nextInt();

        int result = pibonacci(N);
        System.out.println(result);
    }
    // 피보나치를 구현하는 재귀함수
    private static int pibonacci(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return pibonacci(n - 1) + pibonacci(n - 2);
    }
}