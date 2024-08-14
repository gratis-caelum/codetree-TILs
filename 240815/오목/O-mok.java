import java.util.Scanner;

public class Main {
    private static final int SIZE = 19;
    private static final int[][] DIRECTIONS = {
        {0, 1}, // 오른쪽
        {1, 0}, // 아래쪽
        {1, 1}, // 오른쪽 아래 대각선
        {1, -1} // 왼쪽 아래 대각선
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[SIZE][SIZE];
        
        // 바둑판 상태 입력
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        
        // 승리 여부 확인
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    int winner = board[i][j];
                    if (checkWin(board, i, j, winner)) {
                        System.out.println(winner);
                        int[] winningPosition = findWinningPosition(board, i, j, winner);
                        System.out.println((winningPosition[0] + 1) + " " + (winningPosition[1] + 1));
                        return;
                    }
                }
            }
        }
        
        // 승부가 결정되지 않음
        System.out.println(0);
    }

    // 주어진 위치에서 승리 조건을 만족하는지 확인하는 함수
    private static boolean checkWin(int[][] board, int x, int y, int player) {
        for (int[] direction : DIRECTIONS) {
            int count = 1;
            int dx = direction[0];
            int dy = direction[1];
            
            // 한 방향으로 연속된 바둑알 개수 세기
            for (int step = 1; step < 5; step++) {
                int nx = x + dx * step;
                int ny = y + dy * step;
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny] == player) {
                    count++;
                } else {
                    break;
                }
            }
            
            // 반대 방향으로 연속된 바둑알 개수 세기
            for (int step = 1; step < 5; step++) {
                int nx = x - dx * step;
                int ny = y - dy * step;
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny] == player) {
                    count++;
                } else {
                    break;
                }
            }
            
            // 연속된 바둑알이 5개인 경우 승리
            if (count == 5) {
                return true;
            }
        }
        return false;
    }

    // 승리한 바둑알의 위치를 찾는 함수
    private static int[] findWinningPosition(int[][] board, int x, int y, int player) {
        for (int[] direction : DIRECTIONS) {
            int count = 1;
            int dx = direction[0];
            int dy = direction[1];
            int startX = x;
            int startY = y;
            
            // 한 방향으로 연속된 바둑알 개수 세기
            for (int step = 1; step < 5; step++) {
                int nx = x + dx * step;
                int ny = y + dy * step;
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny] == player) {
                    count++;
                    startX = nx;
                    startY = ny;
                } else {
                    break;
                }
            }
            
            // 반대 방향으로 연속된 바둑알 개수 세기
            for (int step = 1; step < 5; step++) {
                int nx = x - dx * step;
                int ny = y - dy * step;
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ ```java
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny] == player) {
                    count++;
                } else {
                    break;
                }
            }
            
            // 연속된 바둑알이 5개인 경우, 시작점과 끝점 중간의 위치 반환
            if (count == 5) {
                int midX = (x + startX) / 2;
                int midY = (y + startY) / 2;
                return new int[]{midX, midY};
            }
        }
        return new int[]{x, y};  // 기본값으로 현재 위치 반환
    }
}