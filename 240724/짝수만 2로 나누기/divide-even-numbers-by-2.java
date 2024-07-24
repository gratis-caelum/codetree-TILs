import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
        // 정수 N, 배열 A 입력
        int N = input.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
        {
            A[i] = input.nextInt();
        }  
        input.close();

        divideNumber(A);

        for (int i = 0; i < N; i++)
        {
            System.out.print(A[i] + " ");
        }

    }
    
    private static void divideNumber(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                arr[i] /= 2;
            }
        }
    }
}