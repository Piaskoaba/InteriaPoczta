package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;
import java.util.Random;


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


    @FindBy(xpath = "//*[@id=\"wrapper\"]/section[4]/div/div/div[2]")
    WebElement contaktBook;

    Random randomNamesAndSureNamesGenerator = new Random();


    String[] names = {"Anna", "Bogumiła", "Aneta", "Maria", "Kazimiera", "Justyna", "Marlena", "Sylwia", "Aleksandra", "Marianna", "Eugenia"};


    String[] sureNames = {"Kowalska", "Michalska", "Janiak", "Kozioł", "Balcerzak", "Nowak", "Posarek", "Janicka", "Woźniak", "Bojarska", "Kulesza"};

    Random namesAndSurenamesGenerator = new Random();


    String randomNames = names[randomNamesAndSureNamesGenerator.nextInt(names.length)];

    String randomSureNames = sureNames[randomNamesAndSureNamesGenerator.nextInt(sureNames.length)];

    public MailPage clickContactBookButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(contaktBook));
        contaktBook.click();

        return new MailPage(driver);
    }


}

