import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 a, b 입력
        int a = input.nextInt();
        int b = input.nextInt();

        input.close();

        int result = countOnJeonSu(a, b);
        System.out.println(result);

    }
    // a와 b 사이 온전수의 개수를 세는 함수
    private static int countOnJeonSu(int a, int b)
    {
        int count = 0;
        for (int i = a; i <= b; i++)
        {
            if (onJeonSu(i))
            {
                count++;
            }
        }

        return count;
    }
    

    // 온전수인지 아닌지 판별하는 함수
    private static boolean onJeonSu(int num)
    {
        if (num % 2 == 0)
        {
            return false;
        }

        if (num % 10 == 5)
        {
            return false;
        }

        if (num % 3 == 0 && num % 9 != 0)
        {
            return false;
        }

        return true;
    }
}