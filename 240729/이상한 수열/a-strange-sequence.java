import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N 입력
        int N = input.nextInt();

        System.out.println(getNumber(N));
    }
    // 재귀호출을 이용해서 수열의 N번째 수를 구하는 재귀함수
    private static int getNumber(int n)
    {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return getNumber(n / 3) + getNumber(n - 1);
    }
}