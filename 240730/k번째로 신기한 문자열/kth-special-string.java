import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
        
        // 첫 번째 줄 입력
        int n = input.nextInt();
        int k = input.nextInt();
        String T = input.next();
        input.nextLine(); // 개행 문자 처리

        // 단어 저장 리스트
        List<String> words = new ArrayList<>();

        // n개의 단어 입력
        for (int i = 0; i < n; i++)
        {
            String word = input.nextLine();
            // T로 시작하는 단어들만 리스트에 추가
            if (word.startsWith(T))
            {
                words.add(word);
            }
        }

        // 사전순으로 정렬
        Collections.sort(words);

        // k번째 단어 출력
        System.out.println(words.get(k - 1));
    }
}