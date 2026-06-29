package core_java_practice.gcr_codebase.Array;
import java.util.*;

public class Warehouse {

    public static void main(String[] args) {
        int[] stock = {10, 20, 15, 20, 30, 10};

        int max = stock[0];
        int min = stock[0];
        int sum = 0;

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int item : stock) {
            if (item > max) max = item;
            if (item < min) min = item;
            sum += item;

            if (!seen.add(item)) {
                duplicates.add(item);
            }
        }

        System.out.println("Max Stock: " + max);
        System.out.println("Min Stock: " + min);
        System.out.println("Total Stock: " + sum);
        System.out.println("Duplicates: " + duplicates);

        // Rotate by k positions
        int k = 2;
        rotate(stock, k);

        System.out.println("Rotated Array:");
        System.out.println(Arrays.toString(stock));

        // 2D shelf grid transpose
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] transposed = transpose(grid);

        System.out.println("Transposed Grid:");
        for (int[] row : transposed) {
            System.out.println(Arrays.toString(row));
        }
    }

    static void rotate(int[] arr, int k) {
        int n = arr.length;
        k %= n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}