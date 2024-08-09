import java.util.Scanner;

public class Main {

    public static final int MAX_N = 1000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // A의 움직임 개수
        int M = input.nextInt(); // B의 움직임 개수

        // A와 B의 위치 추적 변수 (N + M + 1 크기로 설정)
        int[] aPositions = new int[MAX_N * 1000 + 1];
        int[] bPositions = new int[MAX_N * 1000 + 1];

        // A의 이동 정보 입력 및 위치 계산
        int aPosition = 0;
        int aTime = 0;
        for (int i = 0; i < N; i++) {
            int v = input.nextInt();
            int t = input.nextInt();

            for (int j = 0; j < t; j++) {
                aTime++;
                aPosition += v;
                aPositions[aTime] = aPosition;
            }
        }

        // B의 이동 정보 입력 및 위치 계산
        int bPosition = 0;
        int bTime = 0;
        for (int i = 0; i < M; i++) {
            int v = input.nextInt();
            int t = input.nextInt();

            for (int j = 0; j < t; j++) {
                bTime++;
                bPosition += v;
                bPositions[bTime] = bPosition;
            }
        }

        // 명예의 전당 변경 횟수
        int changes = 0;
        int currentLeader = 0; // 0 : 동일, 1 : A가 선두, 2 : B가 선두

        // 각 시간별로 위치를 비교하여 명예의 전당 횟수 추적
        for (int i = 1; i <= aTime; i++) {
            if (aPositions[i] > bPositions[i] && currentLeader != 1) {
                currentLeader = 1;
                changes++;
            } else if (bPositions[i] > aPositions[i] && currentLeader != 2) {
                currentLeader = 2;
                changes++;
            } else if (aPositions[i] == bPositions[i] && currentLeader != 0) {
                currentLeader = 0;
                changes++;
            }
        }

        // 출력
        System.out.println(changes);
    }
}