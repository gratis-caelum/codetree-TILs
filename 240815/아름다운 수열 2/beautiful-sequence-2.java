import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N과 M 입력
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        // 수열 A 입력
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // 수열 B 입력
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = scanner.nextInt();
        }

        // 수열 B의 원소 빈도수 계산
        Map<Integer, Integer> bFrequency = new HashMap<>();
        for (int num : B) {
            bFrequency.put(num, bFrequency.getOrDefault(num, 0) + 1);
        }

        // 수열 A에서 길이가 M인 모든 연속 부분 수열 생성 및 비교
        int count = 0;
        for (int i = 0; i <= N - M; i++) {
            int[] subArray = Arrays.copyOfRange(A, i, i + M);
            if (isBeautifulSequence(subArray, bFrequency)) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);

        scanner.close();
    }

    // 부분 수열이 아름다운 수열인지 확인하는 함수
    private static boolean isBeautifulSequence(int[] subArray, Map<Integer, Integer> bFrequency) {
        Map<Integer, Integer> subArrayFrequency = new HashMap<>();
        for (int num : subArray) {
            subArrayFrequency.put(num, subArrayFrequency.getOrDefault(num, 0) + 1);
        }

        // 두 빈도수 맵이 같은지 비교
        return subArrayFrequency.equals(bFrequency);
    }
}