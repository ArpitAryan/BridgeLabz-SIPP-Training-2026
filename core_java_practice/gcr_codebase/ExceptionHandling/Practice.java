package core_java_practice.gcr_codebase.ExceptionHandling;
import java.io.FileReader;

public class Practice {
    public static void main(String[] args){
        int i = 0;
        try{
            FileReader read = new FileReader("question.txt");
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("xyzException");
        }

        try {
            funct1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("xyz");
    }

    static void funct1() throws Exception{
        int i = 1;
        int age = 10;
        System.out.println(2/i);
        if(age < 18){
            throw new AgeIsWrong();
        }
    }
}

class AgeIsWrong extends Exception {
    public AgeIsWrong() {
        super("Age is less than 18");
    }
}
