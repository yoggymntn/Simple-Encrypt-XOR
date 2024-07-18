package decryption;
import java.io.*;
import java.util.Scanner;

public class dek_xor {
    public static void main(String[] args) {
        try {
            File inputFile = new File("cipher.txt");
            File outputFile = new File("plain2.txt");
            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Kata kunci: ");
            String key = scanner.nextLine();
            int keyLength = key.length();
            int i = 0;

            int ch;
            while ((ch = fileReader.read()) != -1) {
                char C = (char) ch;
                char P = (char) (C ^ key.charAt(i));
                fileWriter.write(P);
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
