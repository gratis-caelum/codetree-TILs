import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 숫자의 개수 입력
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        
        // 숫자 입력
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        // 최대 합 초기화
        int maxSum = -1;
        
        // 모든 가능한 3개의 숫자 조합을 생성
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k) {
                        int sum = numbers[i] + numbers[j] + numbers[k];
                        if (isCarryFree(numbers[i], numbers[j], numbers[k])) {
                            maxSum = Math.max(maxSum, sum);
                        }
                    }
                }
            }
        }
        
        // 결과 출력
        System.out.println(maxSum);
        
        scanner.close();
    }
    
    // 세 숫자를 더했을 때 carry가 발생하지 않는지 확인하는 함수
    public static boolean isCarryFree(int a, int b, int c) {
        while (a > 0 || b > 0 || c > 0) {
            int sum = (a % 10) + (b % 10) + (c % 10);
            if (sum >= 10) {
                return false;
            }
            a /= 10;
            b /= 10;
            c /= 10;
        }
        return true;
    }
}