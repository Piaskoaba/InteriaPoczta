package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;

import javax.naming.Name;
import java.io.*;
import java.util.Scanner;

public class AddNewContactPage extends BasePage {


    //ToDo Metoda generujaca imie i nazwisko, metoda generująca email na podstawie imienia i nazwiska 999-99999, generator numerow
    public AddNewContactPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }


    //  public static void main(String[] args) throws FileNotFoundException {
//
    //      File namesFile = new File("C:\\Users\\barte\\OneDrive\\Pulpit\\InteriaPoczta\\src\\main\\resources");
    //      Scanner scannerNames = new Scanner(namesFile);
    //      String choosenRandomName = scannerNames.nextLine();
    //      System.out.println(choosenRandomName);
    //  }


    public void namesTabele() {

        String[] names = {"Anna", "Bogumiła", "Aneta", "Maria", "Kazimiera", "Justyna", "Marlena", "Sylwia", "Aleksandra", "Marianna", "Eugenia"};

    }

    public void sureNamesTabele() {

        String[] names = {"Kowalska", "Michalska", "Janiak", "Kozioł", "Balcerzak", "Nowak", "Posarek", "Janicka", "Woźniak", "Bojarska", "Kulesza"};




    }
}
