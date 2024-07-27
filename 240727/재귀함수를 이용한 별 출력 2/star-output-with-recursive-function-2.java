import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N 입력
        int N = input.nextInt();

        printStar(N);
    }

    private static void printStar(int N)
    {
        if (N < 1) return;
        for (int i = 0; i < N; i++)
        {
            System.out.print("* ");
        }
        System.out.println();
        printStar(N - 1);
        for (int i = 0; i < N; i++)
        {
            System.out.print("* ");
        }
        System.out.println();
    }
}