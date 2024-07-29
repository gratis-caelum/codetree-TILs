import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        
        Scanner input = new Scanner(System.in);

        // 정수 n과 배열 A 입력
        int n = input.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++)
        {
            A[i] = input.nextInt();
        }

        int result = findMax(A, n);
        System.out.println(result);
    }
    // 최댓값을 찾는 재귀함수
    private static int findMax(int[] A, int n)
    {
        // 배열의 크기가 1인 경우
        if (n == 1) return A[0];

        // 재귀함수를 호출하여 배열의 첫 n - 1 개의 원소 중 최댓값 찾기
        int maxOfRest = findMax(A, n - 1);

        if (A[n - 1] > maxOfRest) {
            return A[n - 1];
        } else {
            return maxOfRest;
        }
    }
}