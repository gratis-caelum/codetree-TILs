import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 이동 횟수
        int[] dx = {0, 1, 0, -1};  // 동, 남, 서, 북
        int[] dy = {1, 0, -1, 0};  // 동, 남, 서, 북

        int x = 0, y = 0;  // 초기 위치
        int totalTime = 0;

        for (int i = 0; i < N; i++) {
            char dir = sc.next().charAt(0);
            int distance = sc.nextInt();

            int dirNum = getDir(dir);

            for (int j = 0; j < distance; j++) {
                x += dx[dirNum];
                y += dy[dirNum];
                totalTime++;

                // 매 이동 후 (0, 0)에 도달했는지 확인
                if (x == 0 && y == 0) {
                    System.out.println(totalTime);
                    return;
                }
            }
        }

        // 끝까지 (0, 0)에 도달하지 못하면 -1 출력
        System.out.println(-1);
    }

    public static int getDir(char dir) {
        if (dir == 'E') return 0;
        else if (dir == 'S') return 1;
        else if (dir == 'W') return 2;
        else if (dir == 'N') return 3;
        else return -1;
    }
}