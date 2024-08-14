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
        
        // 수열 B의 모든 순열 생성
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(B, 0, permutations);
        
        // 수열 A에서 길이가 M인 모든 연속 부분 수열 생성 및 비교
        int count = 0;
        for (int i = 0; i <= N - M; i++) {
            int[] subArray = Arrays.copyOfRange(A, i, i + M);
            if (isBeautifulSequence(subArray, permutations)) {
                count++;
            }
        }
        
        // 결과 출력
        System.out.println(count);

        scanner.close();
    }

    // 수열 B의 모든 순열을 생성하는 함수
    private static void generatePermutations(int[] B, int start, List<List<Integer>> permutations) {
        if (start == B.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : B) {
                permutation.add(num);
            }
            permutations.add(permutation);
            return;
        }
        
        for (int i = start; i < B.length; i++) {
            swap(B, start, i);
            generatePermutations(B, start + 1, permutations);
            swap(B, start, i);
        }
    }

    // 배열의 두 요소를 교환하는 함수
    private static void swap(int[] B, int i, int j) {
        int temp = B[i];
        B[i] = B[j];
        B[j] = temp;
    }

    // 부분 수열이 아름다운 수열인지 확인하는 함수
    private static boolean isBeautifulSequence(int[] subArray, List<List<Integer>> permutations) {
        for (List<Integer> permutation : permutations) {
            boolean match = true;
            for (int i = 0; i < subArray.length; i++) {
                if (subArray[i] != permutation.get(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}