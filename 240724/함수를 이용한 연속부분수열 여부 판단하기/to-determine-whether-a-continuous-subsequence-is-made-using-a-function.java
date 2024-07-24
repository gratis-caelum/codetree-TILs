import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        
        Scanner input = new Scanner(System.in);

        // n1, n2 값 입력과 A, B 정보 입력
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        int[] A = new int[n1];
        for (int i = 0; i < n1; i++)
        {
            A[i] = input.nextInt();
        } 

        int[] B = new int[n2];
        for(int i = 0; i < n2; i++)
        {
            B[i] = input.nextInt();
        }

        // 연속부분수열 확인 후 출력
        if (isSequence(A, B))
        {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // 연속부분수열인지 판별하는 함수
    private static boolean isSequence(int[] A, int[] B)
    {
        int n1 = A.length;
        int n2 = B.length;

        // B의 길이가 A보다 길면 B는 A의 연속부분수열이 아님.
        if (n2 > n1)
        {
            return false;
        } 

        for (int i = 0; i <= (n1 - n2); i++)
        {
            boolean check = true;
            for (int j = 0; j < n2; j++)
            {
                if (A[i + j] != B[j])
                {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        return false;
    }
}