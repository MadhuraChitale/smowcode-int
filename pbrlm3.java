import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pbrlm3 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter the file path for the input data (e.g., data.txt):");
        String inputFilePath = inputScanner.nextLine();

        System.out.println("Please enter the desired keys in sequential order (comma-separated, e.g., 5,7,10,23):");
        String keysInput = inputScanner.nextLine();
        List<Integer> selectedKeys = Arrays.stream(keysInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(inputFilePath));
            String line;
            Map<Integer, String[]> uniqueStringsCount = new HashMap<>();

            while ((line = fileReader.readLine()) != null) {

                String[] keyAndValuePairs = line.split(";");

                for (int i = 0; i < keyAndValuePairs.length; i++) {
                    String keyValue = keyAndValuePairs[i];
                    String[] keyValuePair = keyValue.split("=");

                    int currentKey = Integer.parseInt(keyValuePair[0]);
                    String value = keyValuePair[1];

                    if (selectedKeys.contains(currentKey)) {
                        if (uniqueStringsCount.containsKey(currentKey)) {
                            String[] uniqueValues = uniqueStringsCount.get(currentKey);
                            String[] updatedUniqueValues = new String[uniqueValues.length + 1];
                            System.arraycopy(uniqueValues, 0, updatedUniqueValues, 0, uniqueValues.length);
                            updatedUniqueValues[uniqueValues.length] = value;
                            uniqueStringsCount.put(currentKey, updatedUniqueValues);
                        } else {
                            uniqueStringsCount.put(currentKey, new String[] { value });
                        }
                    }
                }
            }

            for (Entry<Integer, String[]> entry : uniqueStringsCount.entrySet()) {
                String[] uniqueValues = entry.getValue();
                String concatenatedString = String.join("|", uniqueValues);
                System.out.println("Concatenated String: " + concatenatedString + ", Count: "
                        + uniqueValues.length);
            }

            fileReader.close();
            inputScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
