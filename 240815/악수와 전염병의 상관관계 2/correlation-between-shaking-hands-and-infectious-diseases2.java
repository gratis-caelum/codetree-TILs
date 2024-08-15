import java.util.Scanner;
import java.util.Arrays;

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
        Arrays.sort(inputs, (a, b) -> Integer.compare(a[0], b[0]));

        // 악수 처리
        for (int i = 0; i < T; i++) {
            int x = inputs[i][1];
            int y = inputs[i][2];

            // x가 감염자이고 전염 횟수가 남아있는 경우
            if (infected[x] == 1 && con[x] < K) {
                con[x]++;
                infected[y] = 1;
            }
            // y가 감염자이고 전염 횟수가 남아있는 경우
            if (infected[y] == 1 && con[y] < K) {
                con[y]++;
                infected[x] = 1;
            }
        }

        // 감염 여부 출력
        for (int i = 0; i < N; i++) {
            System.out.print(infected[i]);
        }
    }
}