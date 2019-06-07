package Lab6;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunWowels extends Thread{
    public int vowels(String check)
    {   int result = 0;
        for(char i : check.toUpperCase().toCharArray()) {
            if(i == 'A' || i == 'O' || i == 'E' || i == 'Y' || i == 'I' || i == 'U') {
                result ++;
            }
        } return result;
    }

    @Override
    public void run() {
        String result = "";
            try {
                Scanner in = new Scanner(new File("/users/oleg/words2.rtf"));
                while(in.hasNext()) {
                    String temp = in.nextLine();
                    if(vowels(temp) >= vowels(result))
                        result = temp;
                }

                System.out.println("The biggest num of vowels is in a word : "+result);
                in.close();
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
