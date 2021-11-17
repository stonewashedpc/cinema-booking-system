package utilities;

import java.io.File;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
/**
 * Reads and writes objects from / to an XML File
 */
public class XStreamManager<T> {
	private FileManager fm;
	public XStreamManager() {
		this.fm = new FileManager();
	}
	public void write(String fileNamePostfix, T object) throws IOException {
		XStream xstream = XStreamGenSetup.getXStreamObject();
		this.fm.createFile(new File(XStreamGenSetup.assembleFileName(fileNamePostfix)),xstream.toXML(object));
	}
	public T read(String fileNamePostfix) throws IOException {
		XStream xstream = XStreamGenSetup.getXStreamObject();
		return (T)xstream.fromXML(this.fm.readAsString(XStreamGenSetup.assembleFileName(fileNamePostfix)));
	}
}
