import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 격자의 크기 N 입력
        int N = scanner.nextInt();
        int[][] grid = new int[N][N];

        // 격자 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 최대 동전 개수 초기화
        int maxCoins = 0;

        // 모든 가능한 1x3 격자를 찾기
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 < N - 2; j1++) {
                int coins1 = grid[i1][j1] + grid[i1][j1 + 1] + grid[i1][j1 + 2];

                for (int i2 = 0; i2 < N; i2++) {
                    for (int j2 = 0; j2 < N - 2; j2++) {
                        // 겹치지 않는지 확인
                        if (i1 == i2 && (j1 <= j2 && j2 <= j1 + 2 || j2 <= j1 && j1 <= j2 + 2)) {
                            continue;
                        }

                        int coins2 = grid[i2][j2] + grid[i2][j2 + 1] + grid[i2][j2 + 2];
                        maxCoins = Math.max(maxCoins, coins1 + coins2);
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(maxCoins);

        scanner.close();
    }
}