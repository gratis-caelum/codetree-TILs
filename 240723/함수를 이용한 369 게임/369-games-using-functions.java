import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 a, b 입력
        int a = input.nextInt();
        int b = input.nextInt();

        input.close();

        int result = game(a, b);
        System.out.println(result);    
            
    }
    // a 이상 b 이하의 숫자 중 조건을 만족하는 숫자의 개수를 세는 함수
    private static int game(int a, int b) {
        int numberCount = 0;
        for (int i = a; i <= b; i++) {
            if (isSpeical(i)) {
                numberCount++;
            }
        }
        return numberCount;
    }

    // 주어진 숫자가 조건을 만족하는지 확인하는 함수
    private static boolean isSpeical(int num) {
        if (num % 3 == 0) {
            return true;
        }

        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 6 || digit == 9) {
                return true;
            }

            num /= 10;
        }
        return false;
    }
}