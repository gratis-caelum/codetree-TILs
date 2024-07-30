import java.util.Scanner;

class person {
    String name;
    String address;
    String region;

    public person(String name, String address, String region)
    {
        this.name = name;
        this.address = address;
        this.region = region;
    }
};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine(); 

        person[] people = new person[n];

        // 정보 입력
        for (int i = 0; i < n; i++)
        {
            String name = input.next();
            String address = input.next();
            String region = input.next();
            people[i] = new person(name, address, region);
        }

        // 사전순으로 이름이 가장 느린 사람 찾기
        person maxNamePerson = people[0];
        for (int i = 1; i < n; i++)
        {
            if (people[i].name.compareTo(maxNamePerson.name) > 0)
            {
                maxNamePerson = people[i];
            }
        }

        // 결과 출력
        System.out.println("name " + maxNamePerson.name);
        System.out.println("addr " + maxNamePerson.address);
        System.out.println("city " + maxNamePerson.region);    
    }
}