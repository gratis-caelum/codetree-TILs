import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 6명의 능력을 입력받습니다.
        int[] abilities = new int[6];
        for (int i = 0; i < 6; i++) {
            abilities[i] = scanner.nextInt();
        }
        
        // 가능한 모든 팀 조합을 생성합니다.
        List<int[]> teams = generateTeams(abilities);
        
        // 팀 간의 능력 차이를 최소화합니다.
        int minDifference = Integer.MAX_VALUE;
        for (int[] team : teams) {
            int sum1 = abilities[team[0]] + abilities[team[1]];
            int sum2 = abilities[team[2]] + abilities[team[3]];
            int sum3 = abilities[team[4]] + abilities[team[5]];
            int maxSum = Math.max(sum1, Math.max(sum2, sum3));
            int minSum = Math.min(sum1, Math.min(sum2, sum3));
            int difference = maxSum - minSum;
            minDifference = Math.min(minDifference, difference);
        }
        
        // 최소 차이를 출력합니다.
        System.out.println(minDifference);
    }
    
    // 가능한 모든 팀 조합을 생성하는 함수
    private static List<int[]> generateTeams(int[] abilities) {
        List<int[]> teams = new ArrayList<>();
        int n = abilities.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // 모든 조합을 생성합니다.
        generateCombinations(indices, 0, n, 6, teams);
        return teams;
    }
    
    // 조합을 생성하는 함수
    private static void generateCombinations(int[] indices, int start, int n, int k, List<int[]> teams) {
        if (k == 0) {
            teams.add(indices.clone());
            return;
        }
        for (int i = start; i <= n - k; i++) {
            swap(indices, start, i);
            generateCombinations(indices, start + 1, n, k - 1, teams);
            swap(indices, start, i);
        }
    }
    
    // 배열의 두 요소를 교환하는 함수
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}