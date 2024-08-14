import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] dx = {1, 0, -1, 0}; // 동 - 남 - 서 - 북 (시계방향)
    public static int[] dy = {0, -1, 0, 1}; // 동 - 남 - 서 - 북 (시계방향)
    public static final int MAX_N = 100;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 격자의 개수 입력
        n = input.nextInt();
        int m = input.nextInt(); // 색칠할 칸 입력

        boolean[][] arr = new boolean[MAX_N][MAX_N];

        for (int i = 0; i < m; i++) {
            int r = input.nextInt() - 1;
            int c = input.nextInt() - 1;

            arr[r][c] = true;

            int count = 0;
            // 인접한 칸중 색칠된 칸의 개수 세기
            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];

                // 격자 범위 내에 있는지 확인
                if (inRange(nr, nc) && arr[nr][nc]) {
                    count++;
                }
            }

            // 편안한 상태인지 확인
            if (count == 3) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}