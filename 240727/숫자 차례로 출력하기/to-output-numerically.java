import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N 입력
        int N = input.nextInt();

        print1Number(N);
        System.out.println();
        printNNumber(N);

    }
    // 1부터 N까지 출력하는 재귀함수
    private static void print1Number(int N)
    {
        print1NumberHelp(1, N);
    }

    // 1부터 N까지 출력을 도와주는 함수
    private static void print1NumberHelp(int current, int N)
    {
        if (current > N) return;

        System.out.print(current + " ");
        print1NumberHelp(current + 1, N);
    }

    // N부터 1까지 출력하는 재귀함수
    private static void printNNumber(int N)
    {
        if (N < 1) return;

        System.out.print(N + " ");
        printNNumber(N - 1);
    }
}