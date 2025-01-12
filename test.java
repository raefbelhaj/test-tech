import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\RAEF\\Desktop\\test tech\\document.txt";
        int totalSum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                int firstDigit = -1;
                int lastDigit = -1;

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (Character.isDigit(ch)) {
                        if (firstDigit == -1) {
                            firstDigit = Character.getNumericValue(ch);
                        }
                        lastDigit = Character.getNumericValue(ch);
                    }
                }

                if (firstDigit != -1 && lastDigit != -1) {
                    int calibrationValue = firstDigit * 10 + lastDigit;
                    totalSum += calibrationValue;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("La somme totale des valeurs d étalonnage est : " + totalSum);
    }
}
