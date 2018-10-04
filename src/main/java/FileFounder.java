import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class FileFounder {

    BufferedReader bf = null;
    private UserRepository userRepo;

    public FileFounder(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean openFile() {
        System.out.print("Enter the absolute path of the file (Ex. C:\\files\\text.txt): ");
        Scanner readPath = new Scanner(System.in);
        String path = readPath.nextLine();

        try {
            bf = new BufferedReader(new java.io.FileReader(path));
            System.out.println("\n\t--- I found the file ---");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return false;
    }

    public void readFile() {
        boolean fileIsOpen = false;
       // String path = getAbsolutPath();
        while(!fileIsOpen) {
            if(openFile()) fileIsOpen = true;
        }
            try {
                String line;
                do {
                    line = bf.readLine();
                    if (line != null){
                        String[] userData = trimString(line);
                        LocalDate date = parseStringToData(userData[2]);
                        userRepo.addUser(userData, date);
                    }
                } while(line != null);
                System.out.println("\t--- I found " + userRepo.getUsers().size() + " users ---\n");
            } catch (IOException e) {
                System.out.println("Can not read a file");
            } finally {
                try {
                    bf.close();
                } catch (IOException e) {
                    System.out.println("Can not close the file");
                }
            }
    }

    public String[] trimString(String linia) {
        String[] splitedArray = null;
        linia = linia.replaceAll(" ", "");
        splitedArray = linia.split(",");
        return splitedArray;
    }

    public LocalDate parseStringToData(String userData) {
        String stringData = userData;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(stringData, formatter);
        return date;
    }
}
