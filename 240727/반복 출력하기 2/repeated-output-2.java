import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N 입력
        int N = input.nextInt();

        printHelloWorld(N);

    }

    private static void printHelloWorld(int N)
    {
        if (N == 0) return;

        printHelloWorld(N - 1);
        System.out.println("HelloWorld");
    }

}