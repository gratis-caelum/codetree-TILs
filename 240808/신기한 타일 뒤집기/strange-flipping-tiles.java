import java.util.Scanner;

public class Main {
    public static final int OFFSET = 100000;
    public static final int MAX_N = 1000;
    public static final int MAX_R = 2000;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 명령의 수 n 입력
        int n = input.nextInt();
        
        // 무한한 한 줄의 타일을 저장할 배열
        int[] arr = new int[2 * OFFSET + 1];

        int cur = OFFSET; // 현재 위치

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            char option = input.next().charAt(0);

            // 왼쪽으로 이동할 경우
            if (option == 'L') {
                for (int j = 0; j < x; j++) {
                    arr[cur] = 1;
                    if (j < x - 1) cur--;
                }
            } else if (option == 'R') { // 오른쪽으로 이동할 경우
                for (int j = 0; j < x; j++) {
                    arr[cur] = 2;
                    if (j < x - 1) cur++;
                }
            }
        }

        // 흰색, 검은색 타일 개수
        int b = 0, w = 0;
        for (int i = 0; i < 2 * OFFSET; i++) {
            if (arr[i] == 1) b++;
            else if (arr[i] == 2) w++;
        }
        
        // 출력
        System.out.println(b + " " + w);
        input.close();
    }
}