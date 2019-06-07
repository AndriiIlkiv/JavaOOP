package lab4;



import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    int k;
    public int execute(Scanner in) {
        System.out.println("Choose what you want to do:");
        System.out.println("1. Create new user");
        System.out.println("2. Name of the station");
        System.out.println("3. Name of user");
        System.out.println("4. Arrival time");
        System.out.println("5. Department Time");
        System.out.println("6. Number of free places");
        System.out.println("7. Number of places");
        System.out.println("8. Get name of the station");
        System.out.println("9. Get num of user");
        System.out.println("10. Get arrival time");
        System.out.println("11. Get department time");
        System.out.println("12. Get number of free places");
        System.out.println("13. Get number of places");
        System.out.println("14. Print to the file");
        System.out.println("15. Get from the file");
        System.out.println("16. Change the user");
        System.out.println("17. Close the program");
        k = in.nextInt();

        return k;
    }

}
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<TicketBox> list = new LinkedList<>();
        int user = -1;
        Scanner in = new Scanner(System.in);
        Scanner on = new Scanner(System.in);
        Menu main = new Menu();
        boolean isAuto = false;
        boolean kon = true;
        for (String i: args) {
            if (i.equals("-auto")){
                isAuto = true;
                System.out.println(" Auto is enabled ");
            }

        }
        if (isAuto) {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Ready.xml")));
            list =(LinkedList<TicketBox>) decoder.readObject();
            decoder.close();
            user++;
            System.out.println("Output: ");
            System.out.println("Station name: " + list.get(user).getStationName());
            System.out.println("Name of user: "+ list.get(user).getName());
            System.out.println("Time of arr: "+list.get(user).getArrTime());
            System.out.println("Free place: " + list.get(user).getFreePlace());
            System.out.println("Number of places: " + list.get(user).getOverPlace());
            kon = false;
        }




        while (kon) {
            int k = main.execute(in);

            switch (k) {
                case 1:
                    list.add(new TicketBox());
                    user++;
                    break;

                case 2:
                    System.out.println("Type name of the station: ");
                    list.get(user).setStationName(on.nextLine());
                    break;

                case 3:
                    System.out.println("Type name of the user: ");
                    list.get(user).setName(in.next());
                    break;

                case 4:
                    System.out.println("Type arrival time: ");
                    list.get(user).setArrTime(on.next());
                    break;

                case 5:
                    System.out.println("Type department time: ");
                    list.get(user).setDepTime(on.next());
                    break;

                case 6:
                    System.out.println("Type number of free places: ");
                    list.get(user).setFreePlace(on.next());
                    break;

                case 7:
                    System.out.println("Type number of places: ");
                    list.get(user).setOverPlace(in.next());
                    break;

                case 8:
                    System.out.println(list.get(user).getStationName());
                    break;

                case 9:
                    System.out.println(list.get(user).getName());
                    break;

                case 10:
                    System.out.println(list.get(user).getArrTime());
                    break;

                case 11:
                    System.out.println(list.get(user).getDepTime());
                    break;

                case 12:
                    System.out.println(list.get(user).getFreePlace());
                    break;
                case 13:
                    System.out.println(list.get(user).getOverPlace());
                    break;
                case 14:
                    XMLEncoder encoder;
                    try {
                        encoder = new XMLEncoder(
                                new BufferedOutputStream(
                                        new FileOutputStream(PathGetter.getPath(in).toString())));
                        encoder.writeObject(list);
                        encoder.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 15:
                    XMLDecoder decoder = new XMLDecoder(
                            new BufferedInputStream(
                                    new FileInputStream(PathGetter.getPath(in).toString())));

                    list =(LinkedList<TicketBox>) decoder.readObject();
                    decoder.close();
                    user++;
                    break;

                case 16:
                    System.out.println("Choose the user from 0 to " + (list.size() - 1));
                    user = in.nextInt();
                    break;

                case 17:
                    in.close();
                    on.close();
                    return;

            }
        }

    }
}
