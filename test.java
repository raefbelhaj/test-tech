import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        String filePath = "C:\\\\Users\\\\RAEF\\\\Desktop\\\\test tech\\\\document.txt";
        int totalSum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String digits = line.replaceAll("\\D", "");

                if (digits.length() >= 2) {
                    int firstDigit = Character.getNumericValue(digits.charAt(0));
                    int lastDigit = Character.getNumericValue(digits.charAt(digits.length() - 1));

                    int calibrationValue = firstDigit * 10 + lastDigit;
                    totalSum += calibrationValue;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        System.out.println("La somme totale des valeurs d'étalonnage est : " + totalSum);
    }
}
