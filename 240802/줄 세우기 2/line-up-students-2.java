import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student> {
    int height;
    int weight;
    int number;

    public Student(int height, int weight, int number) {
        this.height = height;
        this.weight = weight;
        this.number = number;
    }

    @Override
    public int compareTo(Student other) {
        // 키가 동일하다면 몸무게가 더 큰 학생이 앞으로
        if (this.height != other.height) {
            return Integer.compare(this.height, other.height);
        } else {
            return Integer.compare(other.weight, this.weight);
        }
    }

    @Override
    public String toString() {
        return height + " " + weight + " " + number;
    }
}

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            int height = input.nextInt();
            int weight = input.nextInt();
            students[i] = new Student(height, weight, i + 1);
        }

        // 정렬
        Arrays.sort(students);

        // 출력
        for (Student student : students) {
            System.out.println(student);
        }

        
    }
}