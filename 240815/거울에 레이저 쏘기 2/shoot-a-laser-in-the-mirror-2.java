import java.util.Scanner;

public class Main {
    public static int n;
    public static final int MAX_N = 1000;

    public static int[] dx = {1, 0, -1, 0}; // 동 - 남 - 서 - 북
    public static int[] dy = {0, -1, 0, 1}; // 동 - 남 - 서 - 북
    public static char[][] matrix = new char[MAX_N][MAX_N];
    public static int x;
    public static int y;
    public static int dir;  // 레이저 위치 (0 : 동, 1 : 남, 2 : 서, 3 : 북)


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 격자의 개수 입력
        n = input.nextInt();
        input.nextLine(); // 개행 문자


        for (int i = 0; i < n; i++) {
            String mirror = input.nextLine(); // '/' or '\' 거울
            for (int j = 0; j < mirror.length(); j++) {
                matrix[i][j] = mirror.charAt(j);
            }
        }

        int k = input.nextInt() - 1; // 레이저를 쏘는 위치 (0-based index)

        initialize(k);

        int moveNum = simulate();

        System.out.println(moveNum);

    }

    // 격자 범위 내에 있는지 확인하는 함수
    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    //
    public static int simulate() {
        int moveNum = 0;
        while (inRange(x, y)) {
            if (matrix[x][y] == '/') {
                move(dir ^ 1);
            } else {
                move(3 - dir);
            }

            moveNum += 1;
        }

        return moveNum;

    }

    // 시작 위치와 방향 구하기
    public static void initialize(int k) {
        if (k <= n) {
            x = 0; y = k - 1; dir = 0;
        } else if (k <= 2 * n) {
            x = k - n - 1; y = n - 1; dir = 1;
        } else if (k <= 3 * n) {
            x = n - 1; y = n - (k - 2 * n); dir = 2;
        } else {
            x = n - (k - 3 * n); y = 0; dir = 3;
        }
    }

    
    public static void move(int nextDir) {
        x += dx[nextDir];
        y += dy[nextDir];
        dir = nextDir;
    }
}