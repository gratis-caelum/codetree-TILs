import java.util.Scanner;

public class Main {
    static int[] A;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);
        
        // 정수 n, m 입력
        int n = input.nextInt();
        int m = input.nextInt();

        A = new int[n];
        for (int i = 0; i < n; i++)
        {
            A[i] = input.nextInt();
        }

        for (int i = 0; i < m; i++)
        {
            int a1 = input.nextInt();
            int a2 = input.nextInt();
            int sum = getSum(a1, a2);
            System.out.println(sum);
        }

        input.close();
    }

    private static int getSum(int a1, int a2)
    {
        int sum = 0;
        for (int i = a1 - 1; i < a2; i++)
        {
            sum += A[i];
        }

        return sum;
    }
}