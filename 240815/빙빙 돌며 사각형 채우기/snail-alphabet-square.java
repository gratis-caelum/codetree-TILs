import java.util.Scanner;

public class Main {
    public static int[] dx = {0, 1, 0, -1}; // 북 - 동 - 남 - 서
    public static int[] dy = {1, 0, -1, 0}; // 북 - 동 - 남 - 서
    public static int n, m;
    public static final int MAX = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // n * m 격자 입력
        n = input.nextInt();
        m = input.nextInt();

        char[][] arr = new char[MAX][MAX];


        int dirNum = 0; // 남 : 0, 서 : 1, 북 : 2, 동 : 3
        int x = 0; int y = 0; // 초기 위치 설정
        char currentChar = 'A';

        for (int i = 2; i < n * m; i++) {
            arr[x][y] = currentChar;

            // 알파벳 순환
            currentChar = (char) (currentChar + 1);
            if (currentChar > 'Z') {
                currentChar = 'A';
            }
            // 위치 이동 (남 - 동 - 서 - 북)
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            // 더 이상 나아갈 수 없으면 반시계방향으로 90도 회전
            if (!inRange(nx, ny) || arr[nx][ny] != '\u0000') {
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
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }
}