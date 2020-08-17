import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static java.util.Map.Entry.comparingByKey;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F:\\TextReader\\src\\zadanie.txt"));
		String s;
		int lineNumber = 1;

		Map<String, Set<Integer>> readMap = new HashMap<>();

		while ((s = br.readLine()) != null) {
			String words[] = s.replaceAll("\\p{P}", "").split(" ");

			for (int i = 0; i < words.length; i++) {
				Set<Integer> currentWordSet = readMap.get(words[i]) != null ? readMap.get(words[i]) : new HashSet<Integer>();
				currentWordSet.add(lineNumber);
				readMap.put(words[i], currentWordSet);
			}
			lineNumber++;
		}
		readMap.entrySet()
				.stream()
				.sorted(comparingByKey())
				.forEach((word) ->
						System.out.println(word.getKey() +
						" - " + word.getValue().size() +
						" pozycje -> " +
						word.getValue()));
	}
}