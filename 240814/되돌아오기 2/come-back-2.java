import java.util.Scanner;

public class Main {
    public static int[] dx = {1, 0, -1, 0}; // 동 - 남 - 서 - 북
    public static int[] dy = {0, -1, 0, 1}; // 동 - 남 - 서 - 북

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 이동 (L, R, F)
        String direction = input.nextLine();

        int dirNum = 0; // 북쪽 : 0, 동쪽 : 1, 남쪽 : 2, 서쪽 : 3 (북쪽부터 시작)
        int x = 0; int y = 0; // 초기 위치 설정 (0,0)

        int totalTime = 0; // 총 시간

        for (char command : direction.toCharArray()) {
            totalTime++;

            if (command == 'L') {
                dirNum = (dirNum + 3) % 4; // 왼쪽으로 90도 회전 (북 - 서 - 남 - 동)
            } else if (command == 'R') {
                dirNum = (dirNum + 1) % 4; // 오른쪽으로 90도 회전 (북 - 동 - 남 - 서)
            } else if (command == 'F') {
                x += dx[dirNum]; 
                y += dy[dirNum];
            }

            // 원점으로 돌아왔을 경우 그 동안의 시간 확인
            if (x == 0 && y == 0) {
                System.out.println(totalTime);
                return;
            }
        }

        System.out.println("-1");

    }
}