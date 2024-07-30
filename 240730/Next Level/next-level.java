import java.util.Scanner;

class save {
    private String id;
    private int level;

    public save() {
        this.id = "codetree";
        this.level = 10;
    }

    public save(String id, int level)
    {
        this.id = id;
        this.level = level;
    }

    public void print() {
        System.out.println("user" + " " + id + " " + "lv" + " " + level);
    }
};
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner input = new Scanner(System.in);

        // 아이디와 레벨 입력
        String id = input.next();
        int level = input.nextInt();

        save saving = new save();
        saving.print();
        save newSaving = new save(id, level);
        newSaving.print();

 
    }
}