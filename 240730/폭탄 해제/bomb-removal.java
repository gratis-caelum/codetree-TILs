import java.util.Scanner;

class boom {
    private String code;
    private char wireColor;
    private int seconds;

    public boom(String code, char wireColor, int seconds)
    {
        this.code = code;
        this.wireColor = wireColor;
        this.seconds = seconds;
    }

    public void display() {
        System.out.println("code : " + code);
        System.out.println("color : " + wireColor);
        System.out.println("second : " + seconds);
    }
};

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 입력
        String code = input.next();
        char wireColor = input.next().charAt(0);
        int seconds = input.nextInt();

        // 객체 생성 및 출력
        boom info = new boom(code, wireColor, seconds);
        info.display();
    }
}