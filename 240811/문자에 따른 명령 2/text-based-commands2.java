import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
        String commands = input.next();
        
        // 북, 동, 남, 서 순서로 dx, dy 배열 정의
        int[] dx = {0, 1, 0, -1}; // x축 
        int[] dy = {1, 0, -1, 0}; // y축

        int direction = 0; // 초기 방향은 북쪽 (0)
        int x = 0, y = 0; // 초기 위치 (0, 0)

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);

            if (command == 'L') {
                // 왼쪽으로 90도 회전 (시계 반대 방향)
                direction = (direction + 3) % 4;
            } else if (command == 'R') {
                // 오른쪽으로 90도 회전 (시계 방향)
                direction = (direction + 1) % 4;
            } else if (command == 'F') {
                // 현재 방향으로 한 칸 이동
                x += dx[direction];
                y += dy[direction];
            }
        }

        // 출력
        System.out.println(x + " " + y);
    }
}