package Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunNonWowels extends Thread{
    public int nonvowels(String check)
    {   int result = 0;
        for(char i : check.toUpperCase().toCharArray())
        {
            if(i != 'A' && i != 'O' && i != 'E' && i != 'Y' && i != 'I' && i != 'U')
            {
                result ++;
            }
        } return result;
    }

    @Override
    public void run()
    {
        String result = "D";


            try {
                Scanner in = new Scanner(new File("/users/oleg/words2.rtf"));
                while(in.hasNext())
                {
                    String temp = in.nextLine();
                    if(nonvowels(temp) <= nonvowels(result))
                        result = temp;
                }

                System.out.println("The biggest word without non-vowels is a word : "+result);
                in.close();
            }
            catch(FileNotFoundException e)
            {

                e.printStackTrace();
            }
        }


    }

