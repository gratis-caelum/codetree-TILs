import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 N을 입력받습니다.
        int N = scanner.nextInt();

        // 두 번째 줄부터 N개의 줄에 걸쳐 B가 묻는 세 자리 수와 카운트 정보를 입력받습니다.
        int[][] queries = new int[N][5];
        for (int i = 0; i < N; i++) {
            queries[i][0] = scanner.nextInt(); // B가 묻는 세 자리 수
            queries[i][1] = scanner.nextInt(); // 1번 카운트
            queries[i][2] = scanner.nextInt(); // 2번 카운트
        }

        // 가능한 세 자리 수를 저장할 리스트
        List<int[]> candidates = generateCandidates();

        // 가능한 수의 총 개수를 저장할 변수
        int possibleCount = 0;

        // 각 후보 숫자에 대해 조건을 만족하는지 확인합니다.
        for (int[] candidate : candidates) {
            boolean isValid = true;
            for (int i = 0; i < N; i++) {
                int[] query = queries[i];
                int[] queryDigits = getDigits(query[0]);
                int count1 = countExactMatches(candidate, queryDigits);
                int count2 = countPartialMatches(candidate, queryDigits);
                if (count1 != query[1] || count2 != query[2]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                possibleCount++;
            }
        }

        // 가능한 수의 총 개수를 출력합니다.
        System.out.println(possibleCount);
    }

    // 1부터 9까지의 서로 다른 숫자 세 개로 구성된 모든 세 자리 수를 생성하는 함수
    private static List<int[]> generateCandidates() {
        List<int[]> candidates = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == i) continue;
                for (int k = 1; k <= 9; k++) {
                    if (k == i || k == j) continue;
                    candidates.add(new int[]{i, j, k});
                }
            }
        }
        return candidates;
    }

    // 세 자리 수를 각 자리의 숫자로 분리하는 함수
    private static int[] getDigits(int number) {
        return new int[]{number / 100, (number / 10) % 10, number % 10};
    }

    // 정확히 같은 자리에 있는 숫자의 개수를 세는 함수
    private static int countExactMatches(int[] candidate, int[] query) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (candidate[i] == query[i]) {
                count++;
            }
        }
        return count;
    }

    // 다른 자리에 있는 숫자의 개수를 세는 함수
    private static int countPartialMatches(int[] candidate, int[] query) {
        int count = 0;
        boolean[] usedCandidate = new boolean[3];
        boolean[] usedQuery = new boolean[3];

        // 정확히 같은 자리에 있는 숫자는 제외
        for (int i = 0; i < 3; i++) {
            if (candidate[i] == query[i]) {
                usedCandidate[i] = true;
                usedQuery[i] = true;
            }
        }

        // 다른 자리에 있는 숫자의 개수를 셈
        for (int i = 0; i < 3; i++) {
            if (!usedCandidate[i]) {
                for (int j = 0; j < 3; j++) {
                    if (!usedQuery[j] && candidate[i] == query[j]) {
                        count++;
                        usedQuery[j] = true;
                        break;
                    }
                }
            }
        }

        return count;
    }
}