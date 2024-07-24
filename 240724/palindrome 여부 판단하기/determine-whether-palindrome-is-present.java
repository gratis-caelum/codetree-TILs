import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);

        // 문자열 A 입력
        String A = input.nextLine();

        // 조건 확인
        if (isPalindrome(A))
        {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }


    // palindrome 판별 함수
    private static boolean isPalindrome (String str)
    {
        int left = 0;
        int right = str.length() - 1;

        while (left < right)
        {
            if (str.charAt(left) != str.charAt(right)) 
            {
                return false;
            }
                left++;
                right--;
            
        }

        return true;
    }
}