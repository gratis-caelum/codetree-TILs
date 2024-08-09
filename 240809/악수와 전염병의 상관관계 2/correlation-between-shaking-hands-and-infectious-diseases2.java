import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
        
        int N = input.nextInt(); // N명의 개발자
        int K = input.nextInt(); // 전염을 시킬 수 있는 악수의 횟수
        int P = input.nextInt(); // 처음 전염병에 걸려있는 개발자
        int T = input.nextInt(); // 총 악수 횟수

        
        int[] infected = new int[N + 1]; // 감염 상태
        int[] infectionCount = new int[N + 1]; // 남은 전염 가능 횟수

        // 초기 상태 설정
        infected[P] = 1; // P는 감염됨
        infectionCount[P] = K; // P는 K번 감염시킬 수 있음

        for (int i = 0; i < T; i++) {
            int t = input.nextInt(); // 시간 (t초동안 악수 가능) -> 사실상 아무 상관 없는거 아닌가..?
            int x = input.nextInt(); // x 개발자
            int y = input.nextInt(); // y 개발자

            // x가 감염자이고 y에게 감염시킬 경우
            if (infected[x] == 1 && infectionCount[x] > 0) {
                if (infected[y] == 0) {
                    infected[y] = 1; // y 개발자도 감염됨
                }

                infectionCount[x]--; // 감염시킬 수 있는 악수 횟수 감소
            }

            // y가 감염자이고 x에게 감염시킬 경우
            if (infected[y] == 1 && infectionCount[y] > 0) {
                if (infected[x] == 0) {
                    infected[x] = 1; // x 개발자도 감염됨
                }

                infectionCount[y]--; // 감염시킬 수 있는 악수 횟수 감소
            }
        }

        // 출력
            for (int i = 0; i < N; i++) {
                System.out.print(infected[i]);
            }
    }
}