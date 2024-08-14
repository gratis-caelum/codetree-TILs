import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 예제 입력
        Scanner input = new Scanner(System.in);
        String a = input.nextInt();
        
        // 가능한 최대값을 찾는 함수 호출
        int maxValue = findMaxPossibleValue(a);
        
        // 결과 출력
        System.out.println(maxValue);  // 출력: 14
    }

    // 주어진 2진수 문자열에서 정확히 한 숫자를 바꿔서 만들 수 있는 가능한 최대값을 찾는 함수
    public static int findMaxPossibleValue(String a) {
        int maxValue = 0;
        
        // 2진수 문자열의 각 자리를 순회
        for (int i = 0; i < a.length(); i++) {
            // 새로운 2진수 문자열 생성 (한 비트를 뒤집음)
            String newA;
            if (a.charAt(i) == '0') {
                newA = a.substring(0, i) + '1' + a.substring(i + 1);
            } else {
                newA = a.substring(0, i) + '0' + a.substring(i + 1);
            }
            
            // 새로운 2진수 문자열을 10진수로 변환
            int newValue = Integer.parseInt(newA, 2);
            
            // 최대값 갱신
            if (newValue > maxValue) {
                maxValue = newValue;
            }
        }
        
        return maxValue;
    }
}