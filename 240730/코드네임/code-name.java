import java.util.Scanner;

class agent {
    String codeName;
    int score;

    public agent(String codeName, int score)
    {
        this.codeName = codeName;
        this.score = score;
    }

};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 5명의 코드네임과 점수를 가진 객체
        agent[] agents = new agent[5];

        for (int i = 0; i < 5; i++)
        {
            String codeName = input.next();
            int score = input.nextInt();
            agents[i] = new agent(codeName, score);
        }

        // 점수가 제일 낮은 요원 찾기
        agent minAgent = agents[0];
        for (int i = 1; i < agents.length; i++)
        {
            if (agents[i].score < minAgent.score)
            {
                minAgent = agents[i];
            }
        }

        // 출력
        System.out.println(minAgent.codeName + " " + minAgent.score);
    }  
}