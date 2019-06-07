package lab1oop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

class Menu {
    Scanner in = new Scanner(System.in);
    int k;
    public int execute()
    {
        System.out.println("Choose what you want to do:");
        System.out.println("1. Create new container");
        System.out.println("2. print the container");
        System.out.println("3. get word");
        System.out.println("4. add new word");
        System.out.println("5. clear the container");
        System.out.println("6. remove the word specified");
        System.out.println("7. get a Striing array");
        System.out.println("8. get the size");
        System.out.println("9. check if container has the String specified");
        System.out.println("10.check the work of Iterator by printing all words using for each loop");
        System.out.println("11. Print the string to file 'File.txt'");
        System.out.println("12. Print 'File.txt'");
        k = in.nextInt();

        return k;

    }
}
public class main {

    public static void main(String[] args) throws IOException , ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        Container main= new Container();
        while(true)
        {

            int choice = menu.execute();

            if(choice == 1) {

                main = new Container(in.nextLine());

            }
            else if(choice == 2) {
                String s = main.toString();
                System.out.println(s);
            }
            else if(choice == 3) {
                System.out.println("Print the possition of word you need");

                System.out.println(main.get(in.nextInt()));

            }
            else if(choice == 4) {
                System.out.println("Pls print the string");

                main.add(in.next());

            }
            else if(choice == 5) {
                main.clear();
            }
            else if(choice == 6) {
                System.out.println("Print the word you want to delete");

                main.remove(in.next());

            }
            else if(choice == 7) {
                Object[] array = main.toArray();
                System.out.println(array);
            }
            else if(choice == 8) {
                System.out.println("The size is : "+main.size());
            }
            else if(choice == 9) {
                System.out.println("Print the word you want to find");

                if(main.contains(in.next()))
                    System.out.println("Yes");
                else
                    System.out.println("No");

            }
            else if(choice == 10) {
                for(String s : main)
                {
                    System.out.println(s);
                }
            }
            else if(choice == 11)
            {
                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Asus\\Desktop\\save.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                objectOutputStream.writeObject(main);

                objectOutputStream.close();
            }
            else if(choice == 12)
            {
                FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Asus\\Desktop\\save.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                main = (Container) objectInputStream.readObject();


                objectInputStream.close();
                System.out.println(main.toString());
            }
        }
    }
}