import java.util.Scanner;
import java.util.Arrays;

class Person implements Comparable<Person>{
    String name;
    int height;
    double weight;

    public Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person other)
    {
        // 이름 순으로 정렬
        return this.name.compareTo(other.name);

    }

    @Override
    public String toString() {
        return String.format("%s %d %.1f", name, height, weight);
    }
}

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        Person[] people = new Person[5];

        // 5명 정보 입력
        for (int i = 0; i < 5; i++)
        {   
            String name = input.next();
            int height = input.nextInt();
            double weight = input.nextDouble();
            people[i] = new Person(name, height, weight);
        }

        // 이름 순 정렬
        Arrays.sort(people);

        System.out.println("name");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println();
        
        // 키가 큰 순으로 정렬
        Arrays.sort(people, (p1, p2) -> Integer.compare(p2.height, p1.height));
        System.out.println("height");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}