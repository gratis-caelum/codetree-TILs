import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
        
        // 첫 번째 단어 입력
        String word1 = input.nextLine();

        // 두 번째 단어 입력
        String word2 = input.nextLine();

        // 두 단어가 같은 길이인지 비교
        if (word1.length() != word2.length())
        {
            System.out.println("No");
        } else {
            // 두 단어의 문자 배열을 정렬
            char[] charArray1 = word1.toCharArray();
            char[] charArray2 = word2.toCharArray();
          
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            // 정렬된 배열 비교
            if (Arrays.equals(charArray1, charArray2))
            {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}