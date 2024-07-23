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

        if (year % 4 == 0)
        {
            if (year % 100 == 0)
            {
                if (year % 400 == 0)
                {
                    return true; // 400으로 나누어 떨어지는 해는 윤년
                } else {
                    return false; // 예외적으로 100으로 나누어 떨어지되 400으로 나누어 떨어지지 않는 해는 평년
                }
            } else {
                return true; // 4로 나누어 떨어지되 100으로 나누어 떨어지지 않는 해는 윤년
            }
        } else {
            return false; // 4로 나누어 떨어지지 않는 해는 평년
        }
    }
}