import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 첫 번째 줄 입력 받기
        int n = input.nextInt();
        int[] arr = new int[n];

        // 두 번째 줄 입력
        for (int i = 0; i < n; i++)
        {
            arr[i] = input.nextInt();
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            list.add(arr[i]);
            // 홀수 번째 원소인 경우
            if ((i + 1) % 2 == 1)
            {
                // 리스트를 정렬
                Collections.sort(list);
                // 중앙값 계산
                int median = list.get(list.size() / 2);
                // 중앙값 출력
                System.out.print(median + " ");
            }
        }
    }
}