import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 a, b 입력
        int a = input.nextInt();
        int b = input.nextInt();

        int[] values = {a, b};
        changeNumber(values);

        System.out.println(values[0] + " " + values[1]);

    }

    private static void changeNumber(int[] values)
    {
        int a = values[0];
        int b = values[1];

        if (a < b)
        {
            values[0] = a + 10;
            values[1] = b * 2;
        } else {
            values[0] = a * 2;
            values[1] = b + 10;
        }
    }
}