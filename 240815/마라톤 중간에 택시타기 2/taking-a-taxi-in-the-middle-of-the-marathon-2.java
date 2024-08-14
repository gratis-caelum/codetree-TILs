import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 체크포인트 수 입력
        int N = scanner.nextInt();
        
        // 체크포인트 좌표 배열
        int[][] checkpoints = new int[N][2];
        
        // 체크포인트 좌표 입력
        for (int i = 0; i < N; i++) {
            checkpoints[i][0] = scanner.nextInt();
            checkpoints[i][1] = scanner.nextInt();
        }
        
        // 모든 체크포인트를 순서대로 방문했을 때의 총 거리 계산
        int totalDistance = 0;
        for (int i = 0; i < N - 1; i++) {
            totalDistance += manhattanDistance(checkpoints[i], checkpoints[i + 1]);
        }
        
        // 최소 거리 초기화
        int minDistance = totalDistance;
        
        // 각 체크포인트를 하나씩 건너뛰었을 때의 거리 계산
        for (int i = 1; i < N - 1; i++) {
            int distanceWithoutCheckpoint = totalDistance 
                                            - manhattanDistance(checkpoints[i - 1], checkpoints[i])
                                            - manhattanDistance(checkpoints[i], checkpoints[i + 1])
                                            + manhattanDistance(checkpoints[i - 1], checkpoints[i + 1]);
            if (distanceWithoutCheckpoint < minDistance) {
                minDistance = distanceWithoutCheckpoint;
            }
        }
        
        // 결과 출력
        System.out.println(minDistance);
        
        scanner.close();
    }
    
    // 택시 거리 계산 함수
    public static int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}