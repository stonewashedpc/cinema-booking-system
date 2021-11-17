package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	public void createFile(File fileObject, String contents) throws IOException{
		File file = new File(fileObject.getAbsolutePath());
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(contents);
		writer.close();
	}
	public String readAsString(String fileName) throws IOException {
		BufferedReader reader = this.createReader(fileName);
		String result = "";
		String line = ""; 
		while((line = reader.readLine())!=null) result = result + line + "\n";
		reader.close();
		return result;
	}
	private BufferedReader createReader(String fileName) throws IOException{
		File virtualFile = new File(fileName);
		String absolutePath = virtualFile.getAbsolutePath();
		return new BufferedReader(new java.io.FileReader(new File(absolutePath)));
	}
}
