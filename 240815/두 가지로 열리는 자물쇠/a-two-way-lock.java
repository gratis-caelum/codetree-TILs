import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 N을 입력받습니다.
        int N = scanner.nextInt();

        // 두 번째 줄에서 첫 번째 조합을 입력받습니다.
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int c1 = scanner.nextInt();

        // 세 번째 줄에서 두 번째 조합을 입력받습니다.
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        // 가능한 조합의 수를 계산합니다.
        int result = countCombinations(N, a1, b1, c1) + countCombinations(N, a2, b2, c2) - countCommonCombinations(N, a1, b1, c1, a2, b2, c2);

        // 결과를 출력합니다.
        System.out.println(result);
    }

    // 주어진 조합에 대해 가능한 조합의 수를 계산하는 함수
    private static int countCombinations(int N, int a, int b, int c) {
        Set<List<Integer>> combinations = new HashSet<>();
        for (int i : getValidNumbers(N, a)) {
            for (int j : getValidNumbers(N, b)) {
                for (int k : getValidNumbers(N, c)) {
                    combinations.add(Arrays.asList(i, j, k));
                }
            }
        }
        return combinations.size();
    }

    // 두 조합에 대해 공통으로 가능한 조합의 수를 계산하는 함수
    private static int countCommonCombinations(int N, int a1, int b1, int c1, int a2, int b2, int c2) {
        Set<List<Integer>> combinations1 = new HashSet<>();
        Set<List<Integer>> combinations2 = new HashSet<>();
        for (int i : getValidNumbers(N, a1)) {
            for (int j : getValidNumbers(N, b1)) {
                for (int k : getValidNumbers(N, c1)) {
                    combinations1.add(Arrays.asList(i, j, k));
                }
            }
        }
        for (int i : getValidNumbers(N, a2)) {
            for (int j : getValidNumbers(N, b2)) {
                for (int k : getValidNumbers(N, c2)) {
                    combinations2.add(Arrays.asList(i, j, k));
                }
            }
        }
        combinations1.retainAll(combinations2);
        return combinations1.size();
    }

    // 주어진 숫자에 대해 거리가 2 이내인 유효한 숫자들을 반환하는 함수
    private static List<Integer> getValidNumbers(int N, int num) {
        List<Integer> validNumbers = new ArrayList<>();
        for (int i = -2; i <= 2; i++) {
            int validNum = (num + i - 1 + N) % N + 1;
            validNumbers.add(validNum);
        }
        return validNumbers;
    }
}