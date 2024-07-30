import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    int height, weight, number;

    public Student(int height, int weight, int number) {
        this.height = height;
        this.weight = weight;
        this.number = number;
    }

    @Override
    public int compareTo(Student other)
    {
        // 키가 더 큰 학생을 앞으로
        if (this.height != other.height) {
            return other.height - this.height; // 내림차순
        }

        // 키가 동일하면 몸무게가 더 큰 학생을 앞으로
        if (this.weight != other.weight) {
            return other.weight - this.weight; // 내림차순
        }

        // 키와 몸무게가 동일하다면 번호가 작은 학생을 앞으로
        return this.number - other.number; // 오름차순
        
    }
};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine(); // 개행 문자 
        Student[] students = new Student[n];

        // 정보 입력
        for (int i = 0; i < n; i++)
        {
            int height = input.nextInt();
            int weight = input.nextInt();
            students[i] = new Student(height, weight, i + 1); // i = 0부터 시작하므로 i + 1
        }

        // 정렬
        Arrays.sort(students);

        // 출력
        for (Student student : students) {
            System.out.println(student.height + " " + student.weight + " " + student.number);
        }
    }
}