import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N, M 입력
        int N = input.nextInt();
        int M = input.nextInt();

        int last = greatest_divisor(N, M);
        System.out.println(last);
    }

    private static int greatest_divisor(int N, int M) {
        // 유클리드 알고리즘 (반복문)
        while (M != 0)
        {
            int temp = M;
            M = N % M;
            N = temp;
        }
        return N;
    }
}