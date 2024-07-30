import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int korean, english, math;

    public Student(String name, int korean, int english, int math)
    {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    
    @Override
    public int compareTo(Student other)
    {
        // 국어 점수를 기준으로 내림차순 정렬
        if (this.korean != other.korean) {
            return other.korean - this.korean;
        }

        // 국어 점수가 같으면 영어 점수를 기준으로 내림차순 정렬
        if (this.english != other.english) {
            return other.english - this.english;
        }

        // 국어와 영어 점수가 같으면 수학 점수를 기준으로 내림차순 정렬
        return other.math - this.math;
    }

    @Override
    public String toString() {
        return name + " " + korean + " " + english + " " + math;
    }
};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        input.nextLine();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++)
        {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int korean = Integer.parseInt(parts[1]);
            int english = Integer.parseInt(parts[2]);
            int math = Integer.parseInt(parts[3]);
            students[i] = new Student(name, korean, english, math);
        }

        // 학생 배열 정렬
        Arrays.sort(students);

        // 결과 출력
        for (Student student : students)
        {
            System.out.println(student);
        }


    }
}