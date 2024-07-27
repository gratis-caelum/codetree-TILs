import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);

        // 정수 N 입력
        int N = input.nextInt();

        int count = getSum(N);
        System.out.println(count);

    }
    // 1이 될 때까지 진행한 작업의 횟수를 구하는 재귀함수
    private static int getSum(int n)
    {   
        // 1이 되면 작업 횟수 증가하지 않음.
        if (n == 1) return 0;

        // 짝수면 2로 나누고, 그 나눈 값의 몫과 + 1
        if (n % 2 == 0) return getSum(n / 2) + 1;

        // 홀수면 3으로 나누고 나눈 값의 몫과 + 1
        else return getSum(n / 3) + 1;
    }
}