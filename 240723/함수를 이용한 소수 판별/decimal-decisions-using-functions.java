import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 a, b 입력
        int a = input.nextInt();
        int b = input.nextInt();

        input.close();

        int result = sumPrime(a, b);
        System.out.println(result);

    }
// 소수들의 합을 구하는 함수
    private static int sumPrime(int a, int b)
    {
        if (a > 100 || b > 100 || a < 1 || b < 1)
        {
            System.out.println("숫자를 잘못 입력하였습니다. ( 1 < (a, b) < 100)");
            System.exit(0);
        }

        int sum = 0;
        for (int i = a; i <= b; i++)
        {
            if (isPrime(i))
            {
                sum += i;
            }
        }

        return sum;
    }

// 소수인지 아닌지 판별하는 함수
    private static boolean isPrime(int n)
    {
        if (n <= 1)
        {
            return false;
        }

        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}