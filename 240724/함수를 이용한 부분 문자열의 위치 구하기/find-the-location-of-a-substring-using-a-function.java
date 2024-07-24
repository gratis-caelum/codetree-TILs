import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
    
        // 입력 문자열과 목적 문자열 입력
        String inputString = input.nextLine();
        String objectString = input.nextLine();
        input.close();

        int find = indexSearch(inputString, objectString);  
        System.out.println(find);
    }

    // 입력 문자열에서 목적 문자열의 시작 인덱스를 찾는 함수
    private static int indexSearch(String input, String object)
    {
        return input.indexOf(object);
    }
}