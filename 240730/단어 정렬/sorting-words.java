import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 단어의 길이 정수 n 입력
        int n = input.nextInt();

        // 알파벳 단어가 나열된 배열 입력
        String[] words = new String[n];
        for (int i = 0; i < n; i++)
        {
            words[i] = input.nextLine();
        }

        // 오름차순 정렬
        Arrays.sort(words);
        for (int i = 0; i < n; i++)
        {
            System.out.println(words[i]);
        }
    }
}