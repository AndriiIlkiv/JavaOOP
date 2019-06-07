
package Lab6;

public class Main2 {

    public static void main(String[] args) {
        long begin = System.nanoTime();
        RunBig run = new RunBig();
        RunWowels wowels = new RunWowels();
        RunNonWowels non = new RunNonWowels();
        non.run();
        run.run();
        wowels.run();
        long end = System.nanoTime();
        System.out.println("The time passed is: "+(double)(end-begin)/1000000000+" seconds");

    }

}