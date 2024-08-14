import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int[][] answer;
    public static int[] dx = {0, 1, 0, -1}; // 북 - 동 - 남 - 서 기준
    public static int[] dy = {1, 0, -1, 0}; // 북 - 동 - 남 - 서 기준
    public static final int MAX = 100;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        n = input.nextInt(); // n행
        m = input.nextInt(); // m열

        answer = new int[n][m];

        int x = 0; int y = 0; // 초기 위치 설정
        answer[x][y] = 1; // 1부터 시작
        int dirNum = 0; // 오른쪽 : 0, 아래 : 1, 왼쪽 : 2, 위 : 3

        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

             // 더 이상 나아갈 수 없다면 시계방향으로 90도 회전
            if (!inRange(nx, ny) || answer[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4; // 0 : 동쪽, 1 : 아래, 2 : 왼쪽, 3 : 위쪽
                if (dirNum < 0) {
                    dirNum += 4;
                }
            }

            // 하나씩 이동할 때마다 값을 저장
            x += dx[dirNum];
            y += dy[dirNum];
            answer[x][y] = i;
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}