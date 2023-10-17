
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class pbrlm1 {

    public static int returnMinSwaps(int size, int[] array) {
        int numOnes = 0;
        int minSwapsCount = 0;
        for (int element : array) {
            if (element == 0) {
                numOnes++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (i > numOnes)
                break;
            if (array[i] == 1)
                minSwapsCount++;
        }
        return minSwapsCount;
    }

    public static void minSwaps() {
        Scanner inputScanner = new Scanner(System.in);
        int arraySize = inputScanner.nextInt();
        int[] elements = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            elements[i] = inputScanner.nextInt();
        }
        System.out.println(returnMinSwaps(arraySize, elements));
        inputScanner.close();
    }

    public static void main(String[] args) {
        minSwaps();
    }

}
