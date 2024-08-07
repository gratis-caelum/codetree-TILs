import java.util.Scanner;

public class Main {
    public static final int MAX_K = 100000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 명령의 수 n을 입력받음
        int n = input.nextInt();
        int[] arr = new int[2 * MAX_K + 1]; // 색을 저장할 배열
        int[] cntB = new int[2 * MAX_K + 1]; // 각 위치의 검은색 타일의 개수 저장
        int[] cntW = new int[2 * MAX_K + 1]; // 각 위치의 흰색 타일의 개수 저장
        int b = 0, w = 0, g = 0; // b는 최종 검은색 타일의 개수, w는 흰색 타일의 개수, g는 회색 타일의 개수 저장하는 변수로 타일의 개수를 카운트할 때 사용됨.

        int cur = MAX_K; // 배열의 중앙을 시작 위치로 설정
        // 초기 위치 설정
        for (int i = 0; i < n; i++) {
            int x = input.nextInt(); // 위치를 이동할 변수
            char c = input.next().charAt(0); // 방향을 결정하는 변수
            if (c == 'L') {
                // x만큼 왼쪽으로 이동
                while (x-- > 0) {
                    arr[cur] = 1;
                    cntW[cur]++; // 왼쪽으로 이동하면서 x칸의 타일을 흰색으로 연속하게 칠함
                    if (x > 0) cur--; 
                }
            } else if (c == 'R') {
                while (x-- > 0) {
                    arr[cur] = 2;
                    cntB[cur]++; // 오른쪽으로 이동하면서 x칸의 타일을 검은색으로 연속하게 칠함
                    if (x > 0) cur++; 
                }
            } else {
                    System.out.println("잘못 입력하였습니다(L or R)");
                    i--;
                }
            }

            // 타일 색상 카운트 계산
            for (int i = 0; i <= 2 * MAX_K; i++) {
                if (cntB[i] >= 2 && cntW[i] >= 2) g++;
                else if (arr[i] == 2) b++;
                else if (arr[i] == 1) w++;

            }

            // 결과 출력
            System.out.println(w + " " + b + " " + g);

            input.close();


        }
    }