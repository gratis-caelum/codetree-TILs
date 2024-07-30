import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math)
    {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 총점 기준으로 오름차순 정렬
    @Override
    public int compareTo(Student other)
    {
        int totalScoreThis = this.kor + this.eng + this.math;
        int totalScoreOther = other.kor + other.eng + other.math;
        return totalScoreThis - totalScoreOther;
    }

    // 학생 정보를 출력할 형식으로 변환
    @Override   
    public String toString() {
        return name + " " + kor + " " + eng + " " + math;
    }
}
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();

        Student[] students = new Student[n];


        // 정보 입력
        for (int i = 0; i < n; i++)
        {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int kor = Integer.parseInt(parts[1]);
            int eng = Integer.parseInt(parts[2]);
            int math = Integer.parseInt(parts[3]);
            students[i] = new Student(name, kor, eng, math);
        }

        // 학생 오름 정렬
        Arrays.sort(students);

        // 결과 출력
        for (Student student : students) {
            System.out.println(student);
        }
    }
}