package PocztaInteriaPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;


/*public class AddNewContactPage extends BasePage {


    //ToDo Metoda generujaca imie i nazwisko, metoda generująca email na podstawie imienia i nazwiska 999-99999, generator numerow
    public AddNewContactPage(WebDriver driver) throws FileNotFoundException {
        super(driver);

    }

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement contactNameLabel;

    //  public static void main(String[] args) throws FileNotFoundException {
//
    //      File namesFile = new File("C:\\Users\\barte\\OneDrive\\Pulpit\\InteriaPoczta\\src\\main\\resources");
    //      Scanner scannerNames = new Scanner(namesFile);
    //      String choosenRandomName = scannerNames.nextLine();
    //      System.out.println(choosenRandomName);
    //  }


    String[] names = {"Anna", "Bogumiła", "Aneta", "Maria", "Kazimiera", "Justyna", "Marlena", "Sylwia", "Aleksandra", "Marianna", "Eugenia"};


    String[] sureNames = {"Kowalska", "Michalska", "Janiak", "Kozioł", "Balcerzak", "Nowak", "Posarek", "Janicka", "Woźniak", "Bojarska", "Kulesza"};


    int pickNames = (int) (Math.random() * names.length);
    String choosenName = names[pickNames];


    int pickSureNames = (int) (Math.random() * sureNames.length);
    String choosenSureNames = sureNames[pickSureNames];


    // String randomSureNames = sureNames[randomNamesAndSureNamesGenerator.nextInt(sureNames.length)];

    public void fillContactName() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(contactNameLabel));
        contactNameLabel.sendKeys(choosenName, choosenSureNames);

    }
    }

*/



