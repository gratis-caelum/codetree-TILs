import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 정수 n과 배열 입력
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = input.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // 내림차순 정렬 
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());

        for (int i = 0; i < n; i++)
        {
            System.out.print(arr2[i] + " ");
        }
    }
}