import java.util.Scanner;

public class Main {
    public static final int ASCII_NUM = 128;
    public static final int DIR_NUM = 4;

    public static int n, t;
    public static int x, y, dir;
    public static int[] mapper = new int[ASCII_NUM];
    
    public static int[] dx = new int[]{0, 1, -1,  0};
    public static int[] dy = new int[]{1, 0,  0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void simulate() {
        while(t-- > 0) {
            int nx = x + dx[dir], ny = y + dy[dir];
            // 범위 안에 들어온다면 그대로 진행합니다.
            if(inRange(nx, ny)) {
                x = nx; y = ny;
            }
            // 벽에 부딪힌다면, 방향을 바꿔줍니다.
            else
                dir = 3 - dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        t = sc.nextInt();

        // 각 알파벳 별 방향 번호를 설정합니다.
        mapper['R'] = 0;
        mapper['D'] = 1;
        mapper['U'] = 2;
        mapper['L'] = 3;
        
        x = sc.nextInt();
        y = sc.nextInt();
        char cDir = sc.next().charAt(0);
        x--; y--; dir = mapper[cDir];
        
        simulate();
        
        System.out.println((x + 1) + " " + (y + 1));
    }
}