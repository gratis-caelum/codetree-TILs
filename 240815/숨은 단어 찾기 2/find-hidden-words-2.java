import java.util.Scanner;

public class Main {
    private static final int[][] DIRECTIONS = {
        {0, 1}, // 오른쪽
        {1, 0}, // 아래쪽
        {1, 1}, // 오른쪽 아래 대각선
        {1, -1} // 왼쪽 아래 대각선
    };
    private static final String TARGET = "LEE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // N과 M 입력
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비
        
        // 문자열 배열 입력
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }
        
        // 'LEE'의 개수 세기
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[] direction : DIRECTIONS) {
                    if (checkWord(board, i, j, direction)) {
                        count++;
                    }
                }
            }
        }
        
        // 결과 출력
        System.out.println(count);
        
        scanner.close();
    }

    // 주어진 방향으로 'LEE'가 있는지 확인하는 함수
    private static boolean checkWord(char[][] board, int x, int y, int[] direction) {
        int N = board.length;
        int M = board[0].length;
        
        for (int k = 0; k < TARGET.length(); k++) {
            int nx = x + direction[0] * k;
            int ny = y + direction[1] * k;
            
            // 범위를 벗어나거나 문자가 일치하지 않으면 false 반환
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] != TARGET.charAt(k)) {
                return false;
            }
        }
        
        return true;
    }
}