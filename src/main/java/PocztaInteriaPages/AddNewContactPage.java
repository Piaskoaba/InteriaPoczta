package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddNewContactPage extends BasePage {


    //ToDo Metoda generujaca imie i nazwisko, metoda generująca email na podstawie imienia i nazwiska 999-99999, generator numerow
    public AddNewContactPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }


    public static void main(String[] args) {


            File file = new File("Names");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println();
        }


    }
    }

