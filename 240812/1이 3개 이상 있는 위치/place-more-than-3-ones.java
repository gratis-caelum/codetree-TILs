import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        int[] dx = {0, 1, 0, -1}; // 북 - 동 - 남 - 서 기준
        int[] dy = {1, 0, -1, 0}; // 북 - 동 - 남 - 서 기준


        int count3 = 0; // 1이 3개 이상인 개수를 세는 변수

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int count = 0; // 1의 개수를 세는 변수

                for (int dirNum = 0; dirNum < n; dirNum++) {
                    int nx = x + dx[dirNum];
                    int ny = y + dy[dirNum];

                    if (inRange(nx, ny, n) && arr[nx][ny] == 1) {
                        count++;
                    }
                }

                if (count >= 3) {
                    count3++;
                }
            }
        }

        System.out.println(count3);
    }

    public static boolean inRange(int x, int y, int n) {
        return (0 <= x && x < n && 0 <= y && y <= n);
    }
}