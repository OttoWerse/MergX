import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */

/**
 * @author Otto Werse
 *
 */
public class Formatter {
	// start of attributes

	// end of attributes

	// start of constructors

	// end of constructors

	// start of methods

	public static void merge(String source, String anotherSource, String target) {

		String lineA;
		String lineB;
		String[] firstValues = null;
		String[] secondValues = null;
		String s = "";
		try {
			BufferedReader firstFile = new BufferedReader(new FileReader(new File(source)));
			BufferedReader secondFile = new BufferedReader(new FileReader(new File(anotherSource)));

			while ((lineA = firstFile.readLine()) != null) {
				firstValues = lineA.split(";", -1);
				int j = firstValues.length;

				for (int i = 0; i < j - 1; i++) {
					if (firstValues[i].equals("null")) {
						s += ";";
					} else {
						s += (firstValues[i] + ";");
					}
				}
				if (firstValues[j - 1].isBlank()) {
					s += (firstValues[j - 1]);
				} else {
					s += (firstValues[j - 1] + ";");
				}

				lineB = secondFile.readLine();
				secondValues = lineB.split(";");
				if (secondValues[1].equals("null")) {
					s += ";" + System.lineSeparator();
				} else {
					s += (secondValues[1] + ";" + System.lineSeparator());
				}
			}

			firstFile.close();
			secondFile.close();

			PrintWriter out = new PrintWriter(target);
			out.print(s);

			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addColummn(String source, String target) {

		String lineA;
		String lineB;
		String firstValues = null;
		String[] secondValues = null;
		String s = "";

		try {
			BufferedReader firstFile = new BufferedReader(new FileReader(new File(target)));
			BufferedReader secondFile = new BufferedReader(new FileReader(new File(source)));
			PrintWriter out = new PrintWriter(target);

			while ((lineA = firstFile.readLine()) != null) {
				firstValues = lineA;
				lineB = secondFile.readLine();
				secondValues = lineB.split(";");
				out.print(firstValues + ";" + secondValues[1] + System.lineSeparator());
			}

			firstFile.close();
			secondFile.close();
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(s);

	}

// end of methods
}
