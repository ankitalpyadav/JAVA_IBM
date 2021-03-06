import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		String path = "C:/Users/ibmjavafsdmr03/Desktop/IBM_JAVA/hello.txt";
		BufferedReader reader = null;
		String line = null;
		
		try {
			FileReader fr = new FileReader(path);
			reader = new BufferedReader(fr);
			
			while(true) {
				line = reader.readLine();
				if(line == null)
					break;
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

}
