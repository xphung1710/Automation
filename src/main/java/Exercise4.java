
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {

		final int cocaPrice = 5000, noodlePrice = 3000, orangePrice = 7000;
		int total = 0, price = 0;

		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			FileWriter writer = new FileWriter("output.txt");
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				if (data.length() != 0) {
					String[] item = data.split(" ");
					int quantity = Integer.parseInt(item[1]);
					switch (item[0].toUpperCase()) {
					case "COCA":
						price = cocaPrice * quantity;
						break;
					case "NOODLE":
						price = noodlePrice * quantity;
						break;
					case "ORANGE":
						price = quantity > 2 ? orangePrice * quantity - 5000 : orangePrice * quantity;
						break;
					default:
						break;
					}
					total += price;
					writer.write(item[0] + " " + price + "\n");
				}
			}
			writer.write("--------------\nTotal " + total);
			writer.close();
			scanner.close();
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}
}
