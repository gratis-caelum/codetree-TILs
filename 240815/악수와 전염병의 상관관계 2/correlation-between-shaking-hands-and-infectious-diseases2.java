import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개발자 수
        int K = sc.nextInt(); // 최대 전염 횟수
        int P = sc.nextInt(); // 첫 감염자 (1-based index)
        int T = sc.nextInt(); // 악수의 수

        int[] infected = new int[N]; // 감염 여부 배열
        infected[P-1] = 1;           // 첫 감염자 설정
        int[] con = new int[N];      // 전염 횟수 배열

        // 입력값 받기
        int[][] inputs = new int[T][3];
        for (int i = 0; i < T; i++) {
            inputs[i][0] = sc.nextInt();  // 악수 시간
            inputs[i][1] = sc.nextInt() - 1;  // 개발자 X (0-based index)
            inputs[i][2] = sc.nextInt() - 1;  // 개발자 Y (0-based index)
        }

        // 입력값 정렬 (첫 번째 열 기준으로 시간 순서 정렬)
        Arrays.sort(inputs, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        while (i < T) {
            int currentTime = inputs[i][0];
            List<int[]> currentHandshakes = new ArrayList<>();

            // 현재 시간에 해당하는 모든 악수를 수집
            while (i < T && inputs[i][0] == currentTime) {
                currentHandshakes.add(inputs[i]);
                i++;
            }

            // 새로 감염될 수 있는 개발자를 추적하기 위해 세트를 사용
            Set<Integer> newlyInfected = new HashSet<>();

            // 동일한 시간에 발생한 모든 악수 처리
            for (int[] handshake : currentHandshakes) {
                int x = handshake[1];
                int y = handshake[2];

                // x가 감염자이고 전염 횟수가 남아있는 경우
                if (infected[x] == 1 && con[x] < K) {
                    newlyInfected.add(y);
                }
                // y가 감염자이고 전염 횟수가 남아있는 경우
                if (infected[y] == 1 && con[y] < K) {
                    newlyInfected.add(x);
                }
            }

            // 새롭게 감염된 개발자 처리 및 전염 횟수 증가
            for (int dev : newlyInfected) {
                infected[dev] = 1;  // 감염 처리
            }
            
            // 전염 횟수 감소를 별도로 처리
            for (int[] handshake : currentHandshakes) {
                int x = handshake[1];
                int y = handshake[2];
                if (infected[x] == 1 && newlyInfected.contains(y)) {
                    con[x]++;
                }
                if (infected[y] == 1 && newlyInfected.contains(x)) {
                    con[y]++;
                }
            }
        }

        // 감염 여부 출력
        for (int j = 0; j < N; j++) {
            System.out.print(infected[j]);
        }
    }
}