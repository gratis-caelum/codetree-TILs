import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 방의 수 입력
        int N = scanner.nextInt();
        
        // 각 방에 들어가야 하는 사람들의 인원 배열
        int[] people = new int[N];
        
        // 각 방에 들어가야 하는 사람들의 인원 입력
        for (int i = 0; i < N; i++) {
            people[i] = scanner.nextInt();
        }
        
        // 최소 거리의 합을 저장할 변수 초기화
        int minTotalDistance = Integer.MAX_VALUE;
        
        // 각 방에서 시작했을 때의 총 거리를 계산
        for (int start = 0; start < N; start++) {
            int totalDistance = 0;
            
            // 각 방에 들어가는 사람들의 거리 계산
            for (int i = 0; i < N; i++) {
                int distance = (i - start + N) % N;
                totalDistance += distance * people[i];
            }
            
            // 최소 거리의 합 갱신
            if (totalDistance < minTotalDistance) {
                minTotalDistance = totalDistance;
            }
        }
        
        // 결과 출력
        System.out.println(minTotalDistance);
        
        scanner.close();
    }
}