import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Developer {
    public boolean infected;
    public int infectionCount;

    public Developer(int infectionCount) {
        infected = false;
        this.infectionCount = infectionCount;
    }

    public void infection() {
        this.infected = true;
    }
};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // N명의 개발자
        int K = input.nextInt(); // 감염시킬 수 있는 악수의 횟수
        int P = input.nextInt(); // 초기 전염된 개발자
        int T = input.nextInt(); // 악수의 총 횟수

        Developer[] developers = new Developer[N];

        for (int i = 0; i < N; i++) {
            developers[i] = new Developer(K);
        }

        // 초기 감염자 설정
        developers[P - 1].infection(); // 0-based index로 바꿈

        // 악수 정보를 저장할 List
        List<int[]> handshakes = new ArrayList<>();

        // 악수 정보 처리
        for (int i = 0; i < T; i++) {
            int t = input.nextInt(); // 시간
            int devX = input.nextInt() - 1; // x 개발자 (0-based index)
            int devY = input.nextInt() - 1; // y 개발자 (0-based index)
            handshakes.add(new int[] {t, devX, devY}); 
        }
        // 시간순으로 악수 정보 정렬
        handshakes.sort(Comparator.comparingInt(a -> a[0]));

        // 악수 정보 처리
        for (int[] handshake : handshakes) {
            int devX = handshake[1];
            int devY = handshake[2];

            // devX가 감염되었고 전염 가능 횟수가 남아있는 경우
            if (developers[devX].infected && developers[devX].infectionCount > 0) {
                if (!developers[devY].infected) {
                    developers[devY].infection(); // devY 감염
                }
                developers[devX].infectionCount--; // devX의 감염 가능 횟수 감소
            }
            // devY가 감염되었고 전염 가능 횟수가 남아있는 경우
            if (developers[devY].infected && developers[devY].infectionCount > 0) {
                if (!developers[devX].infected) {
                    developers[devY].infection(); // devX 감염
                }
                developers[devY].infectionCount--; // devY의 감염 가능 횟수 감소
            }
        }       

        // 출력
        for (int i = 0; i < N; i++) {
            System.out.print(developers[i].infected ? 1 : 0);
        }
    
    }
}