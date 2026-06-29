package core_java_practice.gcr_codebase.BufferReader;
import java.util.Arrays;

public class Double {

    public static void main(String[] args){

        int[][] arr = new int[3][4];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = (int)(Math.random() * 100);
            }
        }

        System.out.println("The 2D array is:");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        if(arr[0] <= arr[1]){
            System.out.println("The first row is less than or equal to the second row.");
        } else {
            System.out.println("The first row is greater than the second row.");
        }
    }
    
}
