import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 8;
    public static final int MAX_N = 100;
    
    public static int n, m;
    public static String[] arr = new String[MAX_N];
    
    public static int[] dx = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
    public static int[] dy = new int[]{-1, 0, 1, -1, 0, 1, -1, 1};
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.next();
        
        // 모든 좌표에서 다 확인해봅니다.
        int cnt = 0;
        for(int i = 0; i < n; i++)
            // 격자를 벗어나지 않을 범위로만 잡습니다.
            for(int j = 0; j < m; j++) {
                
                if(arr[i].charAt(j) != 'L') continue;
                
                for(int k = 0; k < DIR_NUM; k++) {
                    int curt = 1;
                    int curx = i;
                    int cury = j;
                    while(true) {
                        int nx = curx + dx[k];
                        int ny = cury + dy[k];
                        if(inRange(nx, ny) == false)
                            break;
                        if(arr[nx].charAt(ny) != 'E')
                           break;
                        curt++;
                        curx = nx;
                        cury = ny;
                    }
                    if(curt >= 3) {
                        cnt++;
                    }
                }
            }
        
        System.out.print(cnt);
    }
}