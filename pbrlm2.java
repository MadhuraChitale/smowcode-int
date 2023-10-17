import java.util.Scanner;

public class pbrlm2 {
    public static int puzzle(int H, int U, int S) {
        int difference = U - S;
        int hour = (H - U) / difference;
        return hour + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int U = sc.nextInt();
        int S = sc.nextInt();
        int ans = puzzle(H, U, S);
        System.out.println(ans);
        sc.close();
    }
}
