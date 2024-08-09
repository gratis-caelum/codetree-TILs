import java.util.Scanner;

public class Main {
    public static final int MAX_D = 1000000; // 거리의 한계

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);

        // 이동횟수 n, m 입력
        int n = input.nextInt();
        int m = input.nextInt();

        // 로봇 A와 B의 위치를 기억하는 배열
        int[] posA = new int[MAX_D + 1];
        int[] posB = new int[MAX_D + 1];

        // A와 B의 위치와 방향 입력
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int t = input.nextInt(); // 1초당 1칸씩 움직임. 초를 입력
            char direction = input.next().charAt(0); // 방향

            while (t-- > 0) {
                // 왼쪽으로 움직이는 경우
                if (direction == 'L') {
                    posA[timeA] = posA[timeA - 1] - 1; // 왼쪽은 -1
                } else if (direction == 'R') { // 오른쪽으로 움직이는 경우
                    posA[timeA] = posA[timeA - 1] + 1; // 오른쪽은 +1
                } else { // 둘 다 해당되지 않는 경우
                    System.out.println("잘못 입력하였습니다. (L or R)");
                    i--;
                }

                timeA++;
            }


        }

        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int t = input.nextInt(); // 1초당 1칸씩 움직임. 초를 입력
            char direction = input.next().charAt(0); // 방향

            while (t-- > 0) {
                // 왼쪽으로 움직이는 경우
                if (direction == 'L') {
                    posB[timeB] = posB[timeB - 1] - 1; // 왼쪽은 -1
                } else if (direction == 'R') { // 오른쪽으로 움직이는 경우
                    posB[timeB] = posB[timeB - 1] + 1; // 오른쪽은 +1
                } else { // 둘 다 해당되지 않는 경우
                    System.out.println("잘못 입력하였습니다. (L or R)");
                    i--;
                }

                timeB++;
            }
        }

        // A와 B의 시간이 다른 경우를 보완
        if (timeA < timeB) {
            for (int i = timeA; i < timeB; i++) {
                posA[i] = posA[i - 1];
            }
        } else if (timeA > timeB){
            for (int i = timeB; i < timeA; i++) {
                posB[i] = posB[i - 1];
            }
        }

        // 최대 시간이 얼마인지 확인
        int count = 0;
        int timeMax = 0;
        if (timeA < timeB) {
            timeMax = timeB;
        } else if (timeA > timeB){
            timeMax = timeA;
        }

        // A와 B가 바로 직전에는 다른 위치에 있다가 그 다음번에 같은 위치에 있는 경우 찾기
        for (int i = 1; i < timeMax; i++) {
            if (posA[i] == posB[i] && posA[i - 1] != posB[i - 1]) {
                count++;
            }
        }

        System.out.println(count);
        input.close();
    }
}