import java.util.Scanner;

public class Main {
    public static int[] dx = {1, 0, -1, 0}; // 동 - 북 - 서 - 남
    public static int[] dy = {0, 1, 0, -1}; // 동 - 북 - 서 - 남
    public static int n;
    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // n * n 격자 입력
        n = input.nextInt();

        int[][] arr = new int[MAX][MAX];


        int dirNum = 1; // 동쪽부터 시작

        int x = (n / 2);
        int y = (n / 2);

        for (int i = 1; i <= n * n; i++) {
            arr[x][y] = i; // 현재 위치에 숫자 할당

            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            // 더 이상 나아갈 수 없으면 시계방향으로 90도 회전
            if (!inRange(nx, ny) || arr[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4; // 시계방향 회전
                if (dirNum < 0) {
                    dirNum += 4;
                }
            }

            // 하나씩 이동할 때마다 값 저장
            x += dx[dirNum];
            y += dy[dirNum];

        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}