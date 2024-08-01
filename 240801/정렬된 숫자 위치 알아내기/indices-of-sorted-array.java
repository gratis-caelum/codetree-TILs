import java.util.Scanner;
import java.util.Arrays;

class Location implements Comparable<Location> {
    int value;
    int originIndex;

    public Location(int value, int originIndex)
    {
        this.value = value;
        this.originIndex = originIndex;
    }

    @Override
    public int compareTo(Location other) {
        return Integer.compare(this.value, other.value);
    }
}

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 수열의 길이 n 입력
        int n = input.nextInt();
        Location[] location = new Location[n];

        // 정보 입력
        for (int i = 0; i < n; i++) {
            location[i] = new Location(input.nextInt(), i);
        }

        // 정렬
        Arrays.sort(location);

        // 정렬 후 위치 배열 생성
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[location[i].originIndex] = i + 1;
        }

        // 출력
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}