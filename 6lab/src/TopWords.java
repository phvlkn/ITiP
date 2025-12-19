import java.util.*;
import java.io.*;

public class TopWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String filePath = sc.nextLine().trim();

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zа-я0-9]+", " ").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        int limit = Math.min(10, sortedWords.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(sortedWords.get(i).getKey());
        }
    }
}