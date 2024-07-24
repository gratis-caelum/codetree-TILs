import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 연, 월, 일을 확인
        int Y = input.nextInt();
        int M = input.nextInt();
        int D = input.nextInt();
        input.close();

        // 출력
        if (checkData(Y, M, D))
        {
            System.out.println(printSeason(M));
        } else
        {
            System.out.println("-1");
        }
    }

    // 윤년인지 아닌지 판별하는 함수
    private static boolean isLeapYear(int n)
    {
        if (n % 4 == 0)
        {
            if (n % 100 == 0 && n % 400 != 0) return false;
            else return true;
        } else {
            return false;
        }
    }

    // 주어진 연, 월과 일이 유효한지 확인하는 함수
    private static boolean checkData(int Y, int M, int D)
    {
        // 각 달의 최대 일수 확인
        int[] daysInMonth = {
                31, // 1월
                28, // 2월
                31, // 3월
                30, // 4월
                31, // 5월
                30, // 6월
                31, // 7월
                31, // 8월
                30, // 9월
                31, // 10월
                30, // 11월
                31  // 12월
        };

        // 윤년일 경우 2월의 최대 일수를 29일로 설정
        if (isLeapYear(Y))
        {
            daysInMonth[1] = 29; // 2월
        }

        // 월이 1 - 12 안에 존재하는지 확인
        if (M < 1 || M > 12) return false;

        // 주어진 월의 최대 일수를 통해 일을 확인
        int maxDays = daysInMonth[M - 1];
        return D >= 1 && D <= maxDays;
    }

    // 주어진 월에 따라 계절을 반환하는 함수
    private static String printSeason(int M)
    {
        switch (M)
        {
            case 3: case 4: case 5:
                return "Spirng";
            case 6: case 7: case 8:
                return "Summer";
            case 9: case 10: case 11:
                return "Fall";
            case 12: case 1: case 2:
                return "Winter";
            default: return ""; // 없는 경우
        }
    }
}