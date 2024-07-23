import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 a, 연산자 o, 정수 c 입력 (공백 사이)
        int a = input.nextInt();
        char o = input.next().charAt(0);
        int c = input.nextInt();

        int result = 0;

        switch (o) {
            case '+':
                result = add(a, c);
                System.out.println(a + " + " + c + " = " + result);
                break;
            case '-':
                result = subtract(a, c);
                System.out.println(a + " - " + c + " = " + result);
                break;
            case '*':
                result = multiple(a, c);
                System.out.println(a + " * " + c + " = " + result);
                break;
            case '/':
                result = divide(a, c);
                System.out.println(a + " / " + c + " = " + result);
                break;
            default:
                System.out.println("잘못 입력하였습니다.");
        }
    }

    private static int add(int a, int b)
    {
        return a + b;
    }

    private static int subtract(int a, int b)
    {
        return a - b;
    }

    private static int multiple(int a, int b)
    {
        return a * b;
    }

    // 정수 부분만 출력하므로 Int
    private static int divide(int a, int b)
    {
        return a / b;
    }
}