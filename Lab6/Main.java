package Lab6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RunBig run = new RunBig();
        Thread thread = new Thread(run);
        RunWowels runne = new RunWowels();
        Thread thread1 = new Thread(runne);
        RunNonWowels non = new RunNonWowels();
        Thread thread2 = new Thread(non);
        System.out.println("Do u want to limit the time?");
        System.out.println("Print Yes or No");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        double n = 0;
        if(str.equals("Yes"))
        {
            System.out.println("Print the limit");
            n = in.nextDouble();
        }
        long time1 = System.nanoTime();
        thread1.start();
        thread.start();
        thread2.start();
        if(n == 0)
        {
            while(thread.isAlive() || thread1.isAlive() || thread2.isAlive()) {
                try {
                    thread2.join();
                    thread.join();
                    thread1.join();
                }
                catch(InterruptedException e) {

                }
            }
            long time2 = System.nanoTime();
            System.out.println("The time passed is: "+(double)(time2-time1)/1000000000+" seconds");
        }
        else
        {

                if(thread2.isAlive() || thread1.isAlive() || thread2.isAlive())
                {
                    thread.interrupt();
                    thread1.interrupt();
                    thread2.interrupt();
                }

                long time2 = System.nanoTime();
                System.out.println("The time passed is: "+(double)(time2-time1)/1000000000+" seconds");
            }
    }

}