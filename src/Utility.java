import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {
	public static List<String> returnNewLineFromFile(String file) throws IOException {
		List<String> fileData = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new FileReader(file));
		// if line[0] != '/'
		String line = in.readLine(); // read a line at a time
		while(line != null){ // loop till you have no more lines
			if(line.charAt(0) != '/')
				fileData.add(line); // add the line to your list
		    line = in.readLine(); // read another line
		}
		return fileData;
	}
	
	public static List<String> returnBySplitAtSemiColons(String line) {
		List<String> lineData = new ArrayList<String>();
		String[] split = line.split(";");
		for(String s : split) {
			lineData.add(s);
		}
		return lineData;
	}

	public static List<String> returnBySplitAtComma(String line) {
		List<String> lineData = new ArrayList<String>();
		String[] split = line.split(",");
		for(String s : split) {
			if(!s.isEmpty() && s != null)
				lineData.add(s);
		}
		return lineData;
	}
}
