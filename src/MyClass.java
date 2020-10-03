import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MyClass {

	public static void main(String[] args) {

		String membersCSV = "C:\\Users\\kosha\\OneDrive\\Desktop\\csv\\members.csv";
		String offers1CSV = "C:\\Users\\kosha\\OneDrive\\Desktop\\csv\\offers1.csv";
		HashMap<String, String> members = new HashMap<>();
		HashMap<String, String> offers1 = new HashMap<>();
		BufferedReader br = null;
		FileWriter csvWriter = null;
		List<List<String>> rows = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(membersCSV));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] temp = line.split(cvsSplitBy);
				if (temp[2].equals("name") && temp[5].equals("ID")) {
				} else {
					members.put((temp[2] + "," + temp[3]), temp[6]);
				}
			}
			System.out.println(members);

			br = new BufferedReader(new FileReader(offers1CSV));
			
			csvWriter = new FileWriter("C:\\Users\\kosha\\OneDrive\\Desktop\\OUTPUT.csv");
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] temp = line.split(cvsSplitBy);
				if (temp[3].equals("ID") && temp[6].equals("Offer Recipient")) {
					csvWriter.append(temp[0]);
					csvWriter.append(",");
					csvWriter.append(temp[1]);
					csvWriter.append(",");
					csvWriter.append(temp[2]);
					csvWriter.append(",");
					csvWriter.append(temp[3]);
					csvWriter.append(",");
					csvWriter.append(temp[4]);
					csvWriter.append(",");
					csvWriter.append(temp[5]);
					csvWriter.append(",");
					csvWriter.append(temp[6]);
					csvWriter.append(",");
					csvWriter.append(temp[7]);
					csvWriter.append(",");
					csvWriter.append(temp[8]);
					csvWriter.append(",");
					csvWriter.append(temp[9]);
					csvWriter.append(",");
					csvWriter.append(temp[10]);
					csvWriter.append(",");
					csvWriter.append(temp[11]);
					csvWriter.append(",");
					csvWriter.append(temp[12]);
					csvWriter.append(",");
					csvWriter.append(temp[13]);
					csvWriter.append(",");
					csvWriter.append(temp[14] + temp[15] + temp[16] + temp[17]);
					csvWriter.append(",");
					csvWriter.append(temp[18]);
					csvWriter.append(",");
					csvWriter.append(temp[19]);
					csvWriter.append("\n");
				} else {
					String tempName = temp[7] + "," + temp[8];
					for (String key : members.keySet()) {
						if (key.equals(tempName)) {
							offers1.put(key, members.get(key));
							rows = Arrays.asList(Arrays.asList(temp[0], temp[1], temp[2], members.get(key), temp[4],
									temp[5] + "," + temp[6], temp[7] + "," + temp[8], temp[9], temp[10], temp[11],
									temp[12], temp[13], temp[14], temp[15], temp[16], temp[17], temp[18]));
							for (List<String> rowData : rows) {
								csvWriter.append(String.join(",", rowData));
								csvWriter.append("\n");
							}
						}
					}
				}
				
			}
			
			br.close();		
			csvWriter.flush();
			csvWriter.close();

			System.out.println(offers1);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
