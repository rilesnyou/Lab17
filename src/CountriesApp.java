import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {


	private static Path filePath = Paths.get("ListofCountries.txt");
	
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		while (true) {
			System.out.print("What do you wanna do (list, add, quit): ");
			String command = scnr.nextLine();
			if (command.equals("quit")) {
				break;
			} else if (command.equals("list")) {
				List<Countries> things = readFile();
				int i = 1; 
				for (Countries thing : things) {
					System.out.println(i++ + ". " + thing);
				}
			} else if (command.equals("add")) {
				Countries add = getCountry(scnr);
				System.out.println("Adding " + add);
				appendLineToFile(add);

			} else {
				System.out.println("Invalid command.");
			}
		}
		System.out.println("Fine, guess you don't wanna see more countries....");
		scnr.close();
	}
	
	private static Countries getCountry(Scanner scnr) {
		String place = Validator.getString(scnr, "Enter a country to add: ");
		return new Countries(place);
	}
	
	public static List<Countries> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Countries> country = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				String place = parts[0];
				country.add(new Countries(place));
			}
			
			return country;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}
	
	public static void appendLineToFile(Countries thing) {
		String line = thing.getPlace();
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}

}


