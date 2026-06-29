package core_java_practice.gcr_codebase.Recursion;
import java.util.Scanner;

public class Reverse {

    public static void main(String[] arg){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printReverse(n);
        sc.close();
    }

    public static int printReverse(int n){

        if(n == 0){
            return 0;
        }

        System.out.print(n + " ");

        return printReverse(n - 1);
    }
    
}
