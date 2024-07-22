import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 N
        int N = input.nextInt();
        input.close();

        nSquare(N);

    }

    private static void nSquare(int N)
    {
        int currentNumber = 1;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
                {
                    System.out.print(currentNumber + " ");
                    currentNumber++;
                    if (currentNumber == 10) {
                        currentNumber = 1;
                    }
                }
            System.out.println();
        }
    }
}