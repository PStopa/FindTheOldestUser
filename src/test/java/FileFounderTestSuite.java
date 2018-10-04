import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FileFounderTestSuite {

    UserRepository userRepo = UserRepository.getInstance();
    FileFounder fileFounder = new FileFounder(userRepo);

    @Test
    public void readFileTest() {

    }

    @Test
    public void trimStringTest() {
        //Given
        String stringToTrim = "    Karol,   No wak, 2000-10-  1  0, 48 123 345 567";
        String[] expecteTrimStrings = {"Karol", "Nowak", "2000-10-10", "48123345567"};
        //When
        String[] result = fileFounder.trimString(stringToTrim);
        //Then
        Assert.assertEquals(expecteTrimStrings[0],result[0]);
        Assert.assertEquals(expecteTrimStrings[1],result[1]);
        Assert.assertEquals(expecteTrimStrings[2],result[2]);
        Assert.assertEquals(expecteTrimStrings[3],result[3]);
    }

    @Test
    public void parseStringToDataTest() {
        //Given
        String stringData = "1990-10-10";
        //When
        LocalDate resultData = fileFounder.parseStringToData(stringData);
        LocalDate expectedData = LocalDate.of(1990, 10, 10);
        //Then
    }

    @Test
    public void openFileTest() {
        //Given
        String mockString = "plik.txt";

        // When
        boolean result = fileFounder.openFile(mockString);

        //Then
        Assert.assertTrue(result);
    }
}