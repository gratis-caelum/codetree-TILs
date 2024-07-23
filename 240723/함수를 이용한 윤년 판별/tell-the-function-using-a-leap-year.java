import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 y 입력
        int y = input.nextInt();

        if (isLeapYear(y))
        {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    private static boolean isLeapYear(int year)
    {
        if (year < 1 || year > 2021)
        {
            System.out.println("숫자를 잘못 입력하였습니다. (1 <= year <= 2021)");
            System.exit(0);
        }
        // 4로 나누어 떨어지지 않는 경우 평년
        if (year % 4 != 0) {
            return false;
        }

        // 4로 나누어 떨어지는 경우 + 100으로 나누어 떨어지지 않는 경우는 윤년
        if (year % 100 != 0) {
            return true;
        }

        // 4로 나누어 떨어지는 경우 + 100으로 나누어 떨어지는 경우 + 400으로 나누어 떨어지지 않는 경우는 평년
        if (year % 400 != 0)
        {
            return false;
        }
        // 4로 나누어 떨어지지만, 예외적인 사항은 전부 확인했으므로 윤년
        return true;
    }
}