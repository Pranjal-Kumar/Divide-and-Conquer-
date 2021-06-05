package DivideConquer;

import java.util.Scanner;

public class PartBSolution {
    public static void main(String[] args) {

        System.out.println("Enter the size of array:");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int array[] = new int[size + 1];

        System.out.println("Enter values in array in ascending order:");
        for (int i = 1; i <= size; i++) {
            array[i] = input.nextInt();
        }

        System.out.println("Enter the value to be searched:");
        int key = input.nextInt();

        System.out.print("Index: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\nValue: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(array[i] + " ");
        }

        int first = 1;
        int last = 2;
        search(array, first, last, key);

    }

    public static void search(int[] array, int first, int last, int key) {

        int last1 = last;

        while (first < last1) {
            try {
                int result = BinarySearch(array, first, last1, key);
                if (result != -1) {
                    System.out.println("\n" + result);
                    return;
                }
                else {
                    first = last1 + 1;
                    last1 = last1 * 2;
                    last = first - 1;
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                last1 = (last1 + last) / 2;
            }
        }

        if (first > last1) {
            System.out.println("\nNot_Found");
        }
    }

    public static int BinarySearch(int arr[],int first,int last, int key){

        if (first <= last && first < arr.length-1) {

            int mid = first + (last - first) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                return BinarySearch(arr, first,mid-1, key);
            }
            else {
                return BinarySearch(arr,mid+1, last, key);
            }
        }
        return -1;
    }

}
