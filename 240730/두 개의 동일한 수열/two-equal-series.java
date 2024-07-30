import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 n, A, B 입력
        int n = input.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++)
        {
            A[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++)
        {
            B[i] = input.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);
        
        boolean isSame = Arrays.equals(A, B);

        if (isSame)
        {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}