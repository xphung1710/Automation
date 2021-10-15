
import java.util.Scanner;

public class Exercise2 {

	public static String capitalizeFirstLetter(String str) {

		String result = "";

		if (str != null && str.trim().length() > 0) {
			Scanner scanner = new Scanner(str.trim());
			while (scanner.hasNext()) {
				String word = scanner.next();
				result += word.length() > 1 ? Character.toUpperCase(word.charAt(0)) + word.substring(1) + " "
						: word + " ";
			}
			scanner.close();
		}
		return result.trim();
	}

	public static void main(String[] args) {

		System.out.println(capitalizeFirstLetter("This is a book"));

		System.out.println(capitalizeFirstLetter("          This is a book     "));

		System.out.println(capitalizeFirstLetter("             "));

		System.out.println(capitalizeFirstLetter("     a        "));

		System.out.println(capitalizeFirstLetter(null));

		System.out.println(capitalizeFirstLetter("          This      is     a book     "));

	}
}
