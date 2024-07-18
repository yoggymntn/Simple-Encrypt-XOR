package encryption;
import java.io.*;
import java.util.Scanner;

public class enk_xor {
    public static void main(String[] args) {
        try {
            File inputFile = new File("plain.txt");
            File outputFile = new File("cipher.txt");
            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Kata kunci: ");
            String key = scanner.nextLine();
            int keyLength = key.length();
            int i = 0;

            int ch;
            while ((ch = fileReader.read()) != -1) {
                char P = (char) ch;
                char C = (char) (P ^ key.charAt(i));
                fileWriter.write(C);
                i++;
                if (i >= keyLength) i = 0;
            }

            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
