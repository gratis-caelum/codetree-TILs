import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 a, b 입력
        int a = input.nextInt();
        int b = input.nextInt();
        input.close();

        // 출력
        int result = checkNumber(a, b);
        System.out.println(result);
        
    }
    // 소수인지 아닌지 판별하는 함수
    private static boolean isPrime(int n)
    {
        if (n <= 1)
        {
            return false;
        }

        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        
        return true;
    }

    // 모든 자릿수의 합이 짝수인지 아닌지를 판별하는 함수
    private static boolean digitCheck(int n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += (n % 10);
            n /= 10;
        }
        
        return sum % 2 == 0;
    }

    // a 이상 b 이하에서 조건에 맞는 수의 개수를 세는 함수
    private static int checkNumber(int a, int b)
    {
        int count = 0;
        for (int i = a; i <= b; i++)
        {
            if (isPrime(i) && digitCheck(i))
            {
                count++;
            }
        }

        return count;
    }
}