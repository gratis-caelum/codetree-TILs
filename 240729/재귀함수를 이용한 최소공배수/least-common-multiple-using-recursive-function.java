import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 n 입력
        int n = input.nextInt();

        // 배열 A 입력
        int[] A = new int[n];

        for(int i = 0; i < n; i++)
        {
            A[i] = input.nextInt();
        }

        System.out.println(findLcm(A, n));
    }
    // 두 수의 최대공약수를 구하는 함수 (유클리드 호제법)
    private static int gcd(int a, int b)
    {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 두 수의 최소공배수를 구하는 함수
    private static int lcm(int a, int b)
    {
        return (a * b) / gcd(a, b);
    }

    // n개의 수들 중 최소공배수를 구하는 재귀함수
    private static int findLcm(int[] A, int n)
    {
        if (n == 1) return A[0];
        return lcm(A[n - 1], findLcm(A, n - 1)); 
    }
}