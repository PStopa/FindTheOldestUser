import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.time.LocalDate;

public class FileFounderTestSuite {

    private UserRepository userRepo = UserRepository.getInstance();
    private FileFounder fileFounder = new FileFounder(userRepo);

    @Test
    public void readFileTest() {
        //Given
        fileFounder.openFile("plik.txt");
        //When
        fileFounder.readFile();
        //Then
        assertEquals(5, userRepo.getUsers().size());
    }

    @Test
    public void trimStringTest() {
        //Given
        String stringToTrim = " Karol,   No wak, 2000-10-  1  0, 48 123 345 567";
        String[] expecteTrimStrings = {"Karol", "Nowak", "2000-10-10", "48123345567"};
        //When
        String[] result = fileFounder.trimString(stringToTrim);
        //Then
        assertEquals(expecteTrimStrings[0],result[0]);
        assertEquals(expecteTrimStrings[1],result[1]);
        assertEquals(expecteTrimStrings[2],result[2]);
        assertEquals(expecteTrimStrings[3],result[3]);
    }

    @Test
    public void parseStringToDataTest() {
        //Given
        String stringData = "1990-10-10";
        //When
        LocalDate resultData = fileFounder.parseStringToData(stringData);
        LocalDate expectedData = LocalDate.of(1990, 10, 10);
        //Then
        assertEquals(resultData, expectedData);
    }

    @Test
    public void openFileTest() {
        //Given
        String filePath = "plik.txt";

        // When
        boolean result = fileFounder.openFile(filePath);

        //Then
        assertTrue(result);
    }
}