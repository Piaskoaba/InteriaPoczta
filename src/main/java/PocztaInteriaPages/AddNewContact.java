package PocztaInteriaPages;

import com.sun.tools.javac.util.Names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.random.RandomGenerator;
public class AddNewContact {

    //ToDo Metoda generujaca imie i nazwisko, metoda generująca email na podstawie imienia i nazwiska 999-99999, generator numerow



    File fileNames = new File("Names");
    File fileSureNames = new File("SureNames");

    FileReader nameData;

    {
        try {
            nameData = new FileReader(fileNames);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    FileReader sureNameData;

    {
        try {
            sureNameData = new FileReader(fileSureNames);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader bf = new BufferedReader();



    public String RandomNamesGenerator(){


    }
}
