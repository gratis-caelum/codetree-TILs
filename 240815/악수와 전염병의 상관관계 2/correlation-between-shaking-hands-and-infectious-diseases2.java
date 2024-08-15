import java.util.*;

class Developer {
    public boolean infected; // 감염 여부
    public int infectionCount; // 감염시킬 수 있는 횟수

    public Developer(int infectionCount) {
        infected = false;
        this.infectionCount = infectionCount;
    }

    public void infect() {
        this.infected = true; // 감염 처리
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // 개발자 수
        int K = input.nextInt(); // 개발자별 악수로 감염시킬 수 있는 최대 횟수
        int P = input.nextInt(); // 초기 감염된 개발자 (1-based index)
        int T = input.nextInt(); // 전체 악수의 수

        Developer[] developers = new Developer[N];

        for (int i = 0; i < N; i++) {
            developers[i] = new Developer(K);
        }

        // 초기 감염된 개발자 설정 (0-based index로 변환)
        developers[P - 1].infect();

        // 악수 정보를 저장할 리스트 (시간, 개발자 X, 개발자 Y)
        List<int[]> handshakes = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int t = input.nextInt();  // 악수 발생 시간
            int devX = input.nextInt() - 1; // 개발자 X (0-based index)
            int devY = input.nextInt() - 1; // 개발자 Y (0-based index)
            handshakes.add(new int[]{t, devX, devY});
        }

        // 악수 정보를 시간 순서대로 정렬
        handshakes.sort(Comparator.comparingInt(a -> a[0]));

        // 악수 정보 처리
        for (int i = 0; i < handshakes.size(); ) {
            int currentTime = handshakes.get(i)[0]; // 현재 시간

            // 동일한 시간에 발생한 악수들을 수집
            List<int[]> currentHandshakes = new ArrayList<>();
            while (i < handshakes.size() && handshakes.get(i)[0] == currentTime) {
                currentHandshakes.add(handshakes.get(i));
                i++;
            }

            // 감염 상태 업데이트
            Set<Integer> newlyInfected = new HashSet<>();
            for (int[] handshake : currentHandshakes) {
                int devX = handshake[1];
                int devY = handshake[2];

                if (developers[devX].infected && developers[devX].infectionCount > 0) {
                    if (!developers[devY].infected) {
                        newlyInfected.add(devY); // 나중에 감염 처리
                    }
                    developers[devX].infectionCount--; // 개발자 X의 감염 가능 횟수 감소
                }

                if (developers[devY].infected && developers[devY].infectionCount > 0) {
                    if (!developers[devX].infected) {
                        newlyInfected.add(devX); // 나중에 감염 처리
                    }
                    developers[devY].infectionCount--; // 개발자 Y의 감염 가능 횟수 감소
                }
            }

            // 새로 감염된 개발자 처리
            for (int dev : newlyInfected) {
                developers[dev].infect();
            }
        }

        // 각 개발자의 감염 상태 출력 (1이면 감염, 0이면 비감염)
        for (int i = 0; i < N; i++) {
            System.out.print(developers[i].infected ? 1 : 0);
        }
    }
}