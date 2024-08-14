import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 N, H, T를 입력받습니다.
        int N = scanner.nextInt();
        int H = scanner.nextInt();
        int T = scanner.nextInt();

        // 두 번째 줄에서 N개의 높이 정보를 입력받습니다.
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }

        // 최소 비용을 초기화합니다.
        int minCost = Integer.MAX_VALUE;

        // 슬라이딩 윈도우를 사용하여 구간을 검사합니다.
        for (int i = 0; i <= N - T; i++) {
            int currentCost = 0;

            // 현재 구간의 비용을 계산합니다.
            for (int j = i; j < i + T; j++) {
                currentCost += Math.abs(heights[j] - H);
            }

            // 최소 비용을 갱신합니다.
            minCost = Math.min(minCost, currentCost);
        }

        // 최소 비용을 출력합니다.
        System.out.println(minCost);
    }
}