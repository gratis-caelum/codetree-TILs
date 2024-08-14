import java.util.Scanner;

public class Main {
    public static int[] dx = {0, -1, 0, 1}; // 북 - 서 - 남 - 동
    public static int[] dy = {1, 0, -1, 0}; // 북 - 서 - 남 - 동
    public static int n;
    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // n * n 격자 입력
        n = input.nextInt();

        int[][] arr = new int[MAX][MAX];


        int dirNum = 0; // 동쪽부터 시작

        int x = (n / 2);
        int y = (n / 2);

        for (int i = 1; i <= n * n; i++) {
            arr[x][y] = i; // 현재 위치에 숫자 할당

            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            // 다음 위치가 범위를 벗어나거나 이미 채워진 경우, 방향 전환
            if (!inRange(nx, ny) || arr[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4; // 시계방향 회전
                nx = x + dx[dirNum];
                ny = y + dy[dirNum];
            }

            // 위치 갱신
            x = nx;
            y = ny;
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