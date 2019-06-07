package lab1oop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Functions {
    private String text;
    private StringBuilder newText = new StringBuilder();
    private int count_words = 0;
    private int counter = 0;
    private int letterCounter = 0;
    private int wordCounter = 1;
    public String input_text(){
        Scanner input_text = new Scanner(System.in);
        setText(input_text.nextLine() + ' ');
        System.out.println("Your text is: " + getText());
     return getText();
    }

    public void output_result(){
        StringBuilder []words = new StringBuilder[getText().length()];
        System.out.println("Making changes");

        StringBuilder arrayOfWords = new StringBuilder();
        for(int i = 0; i< getText().length(); i++){
            String[] newText = getText().split(" ");
        }

        for(int k = counter; k < count_words; k++) {
            String anotherText = words[k].toString();
            int amountMain = words[k].length();
            if(anotherText.charAt(amountMain - 1) != ' '){
                for (int l = counter + 1; l < count_words; l++) {
                    String newAnotherText = words[l].toString();
                    int amount = words[l].length();
                    //System.out.println(newAnotherText + " " + l + " " + amount);
                    if(newAnotherText.charAt(amount - 1) != ' ') {
                        if (amount == amountMain) {
                            for (int i = 0; i < amountMain; i++) {
                                if (anotherText.charAt(i) == newAnotherText.charAt(i)) {
                                    letterCounter += 1;
                                }
                            }
                            if (letterCounter == amountMain) {
                                this.wordCounter += 1;
                                newText.append(words[l]);
                                newText.append(" ");
                                words[l] = newText;
                                //System.out.println(words[l]);
                            }
                        }
                    }
                    letterCounter = 0;
                }
                System.out.println("Word  \""  + words[k] + "\" repeated " + wordCounter + " times");
                wordCounter = 1;
            }
            counter += 1;
        }
    }

    public void debug() throws IOException {
        StringBuilder []words = new StringBuilder[10];
        count_words = 0;
        StringBuilder arrayOfWords = new StringBuilder();
        for(int i = 0; i< getText().length(); i++){
            if(getText().charAt(i) != ' ') arrayOfWords.append(getText().charAt(i));

            else if(getText().charAt(i) == ' ') {
                words[count_words] = arrayOfWords;
                this.count_words++;
                arrayOfWords = new StringBuilder();
                System.out.println(count_words);
            }
        }

        for(int k = counter; k < count_words; k++) {
            String anotherText = words[k].toString();
            int amountMain = words[k].length();
            System.out.println(amountMain);
            if(anotherText.charAt(amountMain - 1) != ' '){
                for (int l = counter + 1; l < count_words; l++) {
                    String newAnotherText = words[l].toString();
                    int amount = words[l].length();
                    System.out.println(newAnotherText + " " + l + " " + amount);
                    if(newAnotherText.charAt(amount - 1) != ' ') {
                        if (amount == amountMain) {
                            for (int i = 0; i < amountMain; i++) {
                                if (anotherText.charAt(i) == newAnotherText.charAt(i)) {
                                    letterCounter += 1;
                                }
                            }
                            if (letterCounter == amountMain) {
                                this.wordCounter += 1;
                                newText.append(words[l]);
                                newText.append(" ");
                                words[l] = newText;
                                System.out.println(words[l]);
                            }
                        }
                    }

                    letterCounter = 0;
                }
                System.out.println("Word  \""  + words[k] + "\" repeated " + wordCounter + " times");
                wordCounter = 1;

            }
            counter += 1;
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"));
        oos.writeObject((String) getText());
        oos.flush();
        oos.close();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}