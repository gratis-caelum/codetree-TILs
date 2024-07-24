import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner input = new Scanner(System.in);

        // 월과 일 입력
        int M = input.nextInt();
        int D = input.nextInt();

        // 조건 확인
        if (DataCheck(M, D))
        {
            System.out.println("Yes");
        } else
        {
            System.out.println("No");
        }
    }

    private static boolean DataCheck(int M, int D)
    {
        // 각 달의 최대 일수 배열 정리
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
                        31 // 12월
        };

        // 월이 1 - 12 안에 존재하는지 확인
        if (M < 1 || M > 12) return false;

        // 주어진 일의 최대 일수를 가져와서 일이 유효한지 확인
        int maxDays = daysInMonth[M - 1];
        if (D < 1 || D > maxDays) return false;

        return true;
    }
}