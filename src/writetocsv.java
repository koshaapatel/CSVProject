import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class writetocsv {
	public static void main(String[] args) {
		List<List<String>> rows = Arrays.asList(
			    Arrays.asList("Jean", "author", "Java"),
			    Arrays.asList("David", "editor", "Python"),
			    Arrays.asList("Scott", "editor", "Node.js")
			);

			FileWriter csvWriter;
			try {
				csvWriter = new FileWriter("C:\\Users\\kosha\\OneDrive\\Desktop\\new.csv");
				csvWriter.append("Name");
				csvWriter.append(",");
				csvWriter.append("Role");
				csvWriter.append(",");
				csvWriter.append("Topic");
				csvWriter.append("\n");

				for (List<String> rowData : rows) {
				    csvWriter.append(String.join(",", rowData));
				    csvWriter.append("\n");
				}

				csvWriter.flush();
				csvWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

	}

}
