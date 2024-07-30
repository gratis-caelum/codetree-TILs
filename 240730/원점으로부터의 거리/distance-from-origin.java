import java.util.Scanner;
import java.util.Arrays;

class Point implements Comparable<Point> {
    int x, y, number;
    int distance;

    public Point(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.distance = Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(Point other)
    {
        // 거리가 같은 경우
        if (this.distance == other.distance) {
            return this.number - other.number; // 번호가 작은 점부터 출력
        }

        return this.distance - other.distance;
    }
}

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 점의 수 n 입력
        int n = input.nextInt();
        Point[] points = new Point[n];

        // 점의 정보 입력
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            points[i] = new Point(x, y, i + 1); // i가 0부터 시작하므로
        }

        // 정렬
        Arrays.sort(points);

        // 출력
        for (Point point : points) {
            System.out.println(point.number);
        }


    }
}