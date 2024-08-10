import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N 입력
        int N = input.nextInt();

        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};

        int x = 0, y = 0; // 초기 위치

        for (int i = 0; i < N; i++) {
            char direction = input.next().charAt(0);
            int distance = input.nextInt();

            int dirNum = 0;

            if (direction == 'W') dirNum = 0;
            else if (direction == 'S') dirNum = 1;
            else if (direction == 'N') dirNum = 2;
            else if (direction == 'E') dirNum = 3;
            else {
                System.out.println("잘못 입력하였습니다. (W, S, N, E)");
                i--;
            }

            // x, y 위치 update
            x += dx[dirNum] * distance;
            y += dy[dirNum] * distance;
        }

        // 출력
        System.out.println(x + " " + y);

    }
}