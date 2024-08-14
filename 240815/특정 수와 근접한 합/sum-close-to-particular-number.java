import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N과 S 입력
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        
        // N개의 수 입력
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        // 전체 합 계산
        int totalSum = 0;
        for (int num : numbers) {
            totalSum += num;
        }
        
        // 최소 차이 초기화
        int minDifference = Integer.MAX_VALUE;

        // 모든 가능한 두 개의 숫자 조합을 생성
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // 두 숫자를 제외한 합 계산
                int currentSum = totalSum - numbers[i] - numbers[j];
                int difference = Math.abs(currentSum - S);
                
                // 최소 차이 갱신
                if (difference < minDifference) {
                    minDifference = difference;
                }
            }
        }
        
        // 결과 출력
        System.out.println(minDifference);

        scanner.close();
    }
}