import java.io.BufferedReader;
import java.io.FileReader;

public class Task1 {

    public static void main(String[] args) {
        String filePath = "homework10\src\file.txt";
        readValidPhoneNumbers(filePath);
    }
    public static void readValidPhoneNumbers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while (line = br.readLine()) != null) {
    String phoneNumber = line.trim();
                if (phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}$") || phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}$")) {
                    System.out.println(phoneNumber);
                }
            }
            catch (IOException e) {
    e.printStackTrace();
            }

        }
    }
}