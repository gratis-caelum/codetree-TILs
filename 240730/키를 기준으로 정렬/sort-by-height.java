import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

class Person {
    String name;
    int height;
    int weight;

    Person(String name, int height, int weight)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " " + height + " " + weight;
    }
};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();

        List<Person> people = new ArrayList<>();

        // 정보 입력
        for (int i = 0; i < n; i++)
        {
            String[] parts = input.nextLine().split(" ");
            String name = parts[0];
            int height = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);
            people.add(new Person(name, height, weight));
        }

        // 키를 기준으로 오름정렬
        Collections.sort(people, Comparator.comparingInt(p -> p.height));

        // 출력
        for (Person person : people) {
            System.out.println(person);
        }
    }
}