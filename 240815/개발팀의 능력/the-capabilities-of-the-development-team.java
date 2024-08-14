import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 5명의 능력을 입력받습니다.
        int[] abilities = new int[5];
        for (int i = 0; i < 5; i++) {
            abilities[i] = scanner.nextInt();
        }
        
        // 가능한 모든 팀 조합을 생성합니다.
        List<int[]> pairs = generatePairs(abilities);
        
        // 팀 간의 능력 차이를 최소화합니다.
        int minDifference = Integer.MAX_VALUE;
        boolean valid = false;
        
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = i + 1; j < pairs.size(); j++) {
                Set<Integer> usedIndices = new HashSet<>();
                for (int k = 0; k < 2; k++) {
                    usedIndices.add(pairs.get(i)[k]);
                    usedIndices.add(pairs.get(j)[k]);
                }
                
                if (usedIndices.size() == 4) {
                    int sum1 = abilities[pairs.get(i)[0]] + abilities[pairs.get(i)[1]];
                    int sum2 = abilities[pairs.get(j)[0]] + abilities[pairs.get(j)[1]];
                    int sum3 = 0;
                    for (int k = 0; k < 5; k++) {
                        if (!usedIndices.contains(k)) {
                            sum3 = abilities[k];
                            break;
                        }
                    }
                    
                    if (sum1 != sum2 && sum2 != sum3 && sum1 != sum3) {
                        int maxSum = Math.max(sum1, Math.max(sum2, sum3));
                        int minSum = Math.min(sum1, Math.min(sum2, sum3));
                        int difference = maxSum - minSum;
                        minDifference = Math.min(minDifference, difference);
                        valid = true;
                    }
                }
            }
        }
        
        // 결과 출력
        if (valid) {
            System.out.println(minDifference);
        } else {
            System.out.println(-1);
        }
    }
    
    // 가능한 모든 2명 팀 조합을 생성하는 함수
    private static List<int[]> generatePairs(int[] abilities) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < abilities.length; i++) {
            for (int j = i + 1; j < abilities.length; j++) {
                pairs.add(new int[]{i, j});
            }
        }
        return pairs;
    }
}