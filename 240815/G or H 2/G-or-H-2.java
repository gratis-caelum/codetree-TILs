import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N 입력
        int N = scanner.nextInt();
        
        // 사람들의 위치와 팻말 정보를 저장할 리스트
        List<Person> people = new ArrayList<>();
        
        // 사람들의 위치와 팻말 정보 입력
        for (int i = 0; i < N; i++) {
            int position = scanner.nextInt();
            char letter = scanner.next().charAt(0);
            people.add(new Person(position, letter));
        }
        
        // 위치를 기준으로 정렬
        people.sort(Comparator.comparingInt(p -> p.position));
        
        // 최대 사진 크기 계산
        int maxPhotoSize = 0;
        
        // 오로지 'G'로만 이루어진 경우
        maxPhotoSize = Math.max(maxPhotoSize, calculateMaxPhotoSize(people, 'G'));
        
        // 오로지 'H'로만 이루어진 경우
        maxPhotoSize = Math.max(maxPhotoSize, calculateMaxPhotoSize(people, 'H'));
        
        // 'G'와 'H'가 정확히 같은 개수만큼 나오는 경우
        maxPhotoSize = Math.max(maxPhotoSize, calculateMaxBalancedPhotoSize(people));
        
        // 결과 출력
        System.out.println(maxPhotoSize);

        scanner.close();
    }
    
    // 특정 문자로만 이루어진 최대 사진 크기를 계산하는 함수
    private static int calculateMaxPhotoSize(List<Person> people, char target) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).letter == target) {
                if (start == -1) {
                    start = people.get(i).position;
                }
                end = people.get(i).position;
            }
        }
        return (start != -1 && end != -1) ? end - start : 0;
    }
    
    // 'G'와 'H'가 정확히 같은 개수만큼 나오는 최대 사진 크기를 계산하는 함수
    private static int calculateMaxBalancedPhotoSize(List<Person> people) {
        Map<Integer, Integer> balanceMap = new HashMap<>();
        int balance = 0;
        int maxSize = 0;
        
        balanceMap.put(0, -1);
        
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).letter == 'G') {
                balance++;
            } else {
                balance--;
            }
            
            if (balanceMap.containsKey(balance)) {
                int start = balanceMap.get(balance);
                int end = people.get(i).position;
                maxSize = Math.max(maxSize, end - people.get(start + 1).position);
            } else {
                balanceMap.put(balance, i);
            }
        }
        
        return maxSize;
    }
    
    // 사람 정보를 저장할 클래스
    static class Person {
        int position;
        char letter;
        
        Person(int position, char letter) {
            this.position = position;
            this.letter = letter;
        }
    }
}