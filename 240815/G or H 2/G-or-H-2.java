import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 첫 번째 줄에서 N을 입력받습니다.
        int N = scanner.nextInt();
        
        // 사람들의 위치와 알파벳 정보를 저장할 리스트
        List<Person> people = new ArrayList<>();
        
        // N개의 줄에 걸쳐 위치와 알파벳 정보를 입력받습니다.
        for (int i = 0; i < N; i++) {
            int position = scanner.nextInt();
            char alphabet = scanner.next().charAt(0);
            people.add(new Person(position, alphabet));
        }
        
        // 위치를 기준으로 정렬합니다.
        Collections.sort(people, Comparator.comparingInt(p -> p.position));
        
        // G와 H의 누적 개수를 기록할 맵
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        
        int gCount = 0;
        int hCount = 0;
        int maxSize = 0;
        
        // 초기 상태에서의 차이를 기록합니다.
        prefixCounts.put(0, -1);
        
        // 사람들의 위치를 순회하면서 G와 H의 개수를 누적합니다.
        for (int i = 0; i < N; i++) {
            Person person = people.get(i);
            
            if (person.alphabet == 'G') {
                gCount++;
            } else {
                hCount++;
            }
            
            // G와 H의 누적 개수 차이
            int diff = gCount - hCount;
            
            if (prefixCounts.containsKey(diff)) {
                // 이전에 같은 diff가 나온 적이 있으면
                maxSize = Math.max(maxSize, person.position - people.get(prefixCounts.get(diff) + 1).position);
            } else {
                // 처음 나온 diff라면 현재 위치를 기록
                prefixCounts.put(diff, i);
            }
        }
        
        // 최대 사진 크기를 출력합니다.
        System.out.println(maxSize);
    }
    
    // 사람의 위치와 알파벳 정보를 저장하는 클래스
    static class Person {
        int position;
        char alphabet;
        
        Person(int position, char alphabet) {
            this.position = position;
            this.alphabet = alphabet;
        }
    }
}