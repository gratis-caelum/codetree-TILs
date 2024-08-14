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
        int moveNum = 1; // 이동 횟수
        int cnt = 1;
        int x = x + dx[dirNum];
        int y = y + dy[dirNum];

        while(!inRange(x, y)) {
            for (int i = 0; i < moveNum; i++) {
                arr[x][y] = cnt++;
                
                x += dx[dirNum];
                y += dy[dirNum];

                // 격자를 벗어나면 종료
                if (inRange(x, y)) {
                    break;
                }
            }

            dirNum = (dirNum + 1) % 4; // 동 - 북 - 서 - 남

            if (dirNum == 0 || dirNum == 2) {
                moveNum++;
            }
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