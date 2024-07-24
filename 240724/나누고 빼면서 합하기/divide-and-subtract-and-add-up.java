import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 n, m 입력
        int n = input.nextInt();
        int m = input.nextInt();

        int[] A = new int[n];

        for (int i = 0; i < n; i++)
        {
            A[i] = input.nextInt();
        }

        int result = sumSequence(n, m, A);
        System.out.println(result);

    }
    // A의 m번째 원소를 계속 더해 출력하는 함수
    private static int sumSequence(int n, int m, int[] A)
    {
        int sum = 0;

        while (m != 1)
        {
            sum += A[m - 1]; // A의 m번째 원소 더함 (0, 1, 2...)
            if (m % 2 == 0)
            {
                m /= 2; // m이 짝수면 2로 나누기
            } else {
                m -= 1; // m이 홀수면 1을 빼기
            }
        }
        sum += A[m - 1]; // m이 1일 때 원소도 더하기.
        return sum;
    }

}