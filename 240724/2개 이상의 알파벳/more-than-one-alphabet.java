import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);

        // 소문자 알파벳으로만 이루어진 문자열 A
        String A = input.nextLine();

        // 조건 확인
        if (checkAlphabet(A))
        {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    private static boolean checkAlphabet(String str)
    {
        Set<Character> uniqueAlphabet = new HashSet<>();

        // 문자열의 각 문자를 Set에 추가
        for (char c : str.toCharArray())
        {
            uniqueAlphabet.add(c);
        } 

        // 서로 다른 알파벳이 2개 이상인지 확인
        if (uniqueAlphabet.size() >= 2) {return true;}

        return false;
    }
}