package DivideConquer;
import java.util.*;

public class PartASolution {
    public static void main(String[] args) {

        System.out.println("Enter the size of array:");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int array[] = new int[size + 1];
        System.out.println("Enter values in array in ascending order:");
        for (int i = 1; i <= size; i++) {
            array[i] = input.nextInt();
        }

        System.out.print("Index: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\nValue: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(array[i] + " ");
        }

        int first = 1;
        int last = size;
        int result = search(array, first, last);
        if (result == -1) {
            System.out.println("\nNot_Found");
        }
        else {
            System.out.println("\n" + result);
        }
    }

    public static int search(int[] array, int first, int last) {

        int mid = (first + last) / 2;
        int temp = -2;
        if (first <= last && first < array.length) {

            if (mid == array[mid]) {

                int ans = mid;
                if (first <= last) {
                    temp = search(array, first, mid-1);
                }
                if (temp == -1) {
                    return ans;
                }
                else {
                    return temp;
                }
            }

            else if (mid > array[mid]) {
                return search(array, mid + 1, last);
            }
            else {
                return search(array, first, mid - 1);
            }

        }

        return -1;
    }

}
