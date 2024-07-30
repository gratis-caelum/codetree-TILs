import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 만들어야 하는 그룹 수 n 입력
        int n = input.nextInt();

        // 2n개의 숫자 입력
        int[] arr = new int[n];
        for (int i = 0; i < 2 * n; i++)
        {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);

        // 최댓값 계산
        int maxSum = 0;
        for (int i = 0; i < n; i++)
        {
            int sum = arr[i] + arr[2 * n - 1 - i];
            if (sum > maxSum)
            {
                maxSum = sum;
            }
        }

        // 출력
        System.out.println(maxSum);
    }
}