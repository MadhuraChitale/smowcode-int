import java.util.Scanner;

class problem1 {
    public static int minimumswapsaps(int[] number) {
        int[] t = new int[number.length * 2];

        for (int i = 0; i < t.length; ++i) {
            t[i] = number[i % number.length];
        }

        int win = 0;
        for (int num : number) {
            if (num == 1)
                win++;
        }

        if (win == number.length)
            return 0;
        int minimumswapsaps = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int cone = 0;
        while (r < number.length + win) {
            if (t[r] == 1)
                cone++;

            if (r - l + 1 > win) {
                if (t[l] == 1)
                    cone--;
                l++;
            }

            if (r - l + 1 == win) {
                int currentWinSwapNeeded = win - cone;
                minimumswapsaps = Math.min(minimumswapsaps, currentWinSwapNeeded);
            }
            r++;
        }

        return minimumswapsaps;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int g = 0; g < n; g++) {
            arr[g] = sc.nextInt();
        }
        System.out.println(minimumswapsaps(arr));
    }
}