import java.util.Scanner;

public class Main {
    public static final int MAX_D = 1000000; // 거리의 한계

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);
        
        // 움직이는 횟수 n, m 입력
        int n = input.nextInt();
        int m = input.nextInt();

        // 로봇 A와 로봇 B가 움직이는 정보를 담을 배열
        int[] posA = new int[MAX_D + 1];
        int[] posB = new int[MAX_D + 1];

        // 로봇 A가 움직이는 정보 입력
        int timeA = 1; // 시간은 1초부터 시작하고, A가 움직이는 시간 변수
        for (int i = 0; i < n; i++) {
            int t = input.nextInt(); // 얼마동안 움직였나를 판단하는 시간 (이동거리는 1칸에 1초씩)
            char direction = input.next().charAt(0); // 방향
            
            // 왼쪽으로 움직인 경우
            if (direction == 'L') {
                for (int j = 0; j < t; j++) {
                    posA[timeA] = posA[timeA - 1] - 1; // 왼쪽으로 움직이므로 줄어듦
                }
            } else if (direction == 'R') { // 오른쪽으로 움직이는 경우
                for (int j = 0; j < t; j++) {
                    posA[timeA] = posA[timeA - 1] + 1; // 오른쪽으로 움직이므로 늘어남
                }
            } else { // 둘 다 아닌 경우
                System.out.println("잘못 입력하였습니다. (L or R)");
                i--;
            }
            timeA++; // 시간은 움직일 때마다 1초씩 늘어남.
        }

        // 로봇 B가 움직이는 정보 입력
        int timeB = 1; // 시간은 1초부터 시작하고, B가 움직이는 시간 변수
        for (int i = 0; i < m; i++) {
            int t = input.nextInt(); // 얼마동안 움직였나를 판단하는 시간 (이동거리는 1칸에 1초씩)
            char direction = input.next().charAt(0); // 방향
            
            // 왼쪽으로 움직인 경우
            if (direction == 'L') {
                for (int j = 0; j < t; j++) {
                    posB[timeB] = posB[timeB - 1] - 1; // 왼쪽으로 움직이므로 줄어듦 
                }
            } else if (direction == 'R') { // 오른쪽으로 움직이는 경우
                for (int j = 0; j < t; j++) {
                    posB[timeB] = posB[timeB - 1]  + 1; // 오른쪽으로 움직이므로 늘어남
                }
            } else { // 둘 다 아닌 경우
                System.out.println("잘못 입력하였습니다. (L or R)");
                i--;
            }
            timeB++; // 시간은 움직일 때마다 1초씩 늘어남.
        }

        // A와 B의 시간이 다를 수 있으므로 작은 쪽을 늘려줌
        if (timeA < timeB) {
            for (int i = timeA; i < timeB; i++) {
                posA[i] = posA[i - 1];
            }
        } else if (timeA > timeB) {
            for (int i = timeB; i < timeA; i++) {
                posB[i] = posB[i - 1];
            }
        }

        // 같은 위치에 있는 경우
        int timeMax = 0;
        int count = 0;

        if (timeA > timeB) {
            timeMax = timeA;
        } else if (timeA < timeB) {
            timeMax = timeB;
        }

        // 이전시간과 비교하기 때문에 i = 1부터 시작
        // 마지막 인덱스는 이미 포함되기 때문에 timeMax - 1까지만 파악
        for (int i = 1; i < timeMax; i++) {
            if ((posA[i] == posB[i]) && (posA[i - 1] != posB[i - 1])) {
                count++;
            }    
        }

        // 출력
        System.out.println(count);
        input.close();
    }
}