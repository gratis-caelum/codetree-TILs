import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N과 K 입력
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        // 바구니 정보 입력
        int[] candies = new int[101]; // 바구니 위치는 0부터 100까지
        for (int i = 0; i < N; i++) {
            int candyCount = scanner.nextInt();
            int position = scanner.nextInt();
            candies[position] += candyCount;
        }

        // 최대 사탕 수 계산
        int maxCandies = 0;
        for (int c = 0; c <= 100; c++) {
            int sum = 0;
            for (int i = Math.max(0, c - K); i <= Math.min(100, c + K); i++) {
                sum += candies[i];
            }
            maxCandies = Math.max(maxCandies, sum);
        }

        // 결과 출력
        System.out.println(maxCandies);

        scanner.close();
    }
}