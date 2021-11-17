package utilities;

import com.thoughtworks.xstream.XStream;

public class XStreamGenSetup {
	private static XStream xstream; 
	protected static final String fileName = "LastSnapshot";
	protected static final String fileExtension = ".xml";
	static{
		xstream = new XStream();
		xstream.allowTypesByRegExp(new String[] { ".*" });
	}
	public static XStream getXStreamObject() {
		return xstream;
	}
	public static String assembleFileName(String fileNamePostfix) {
		return fileName + fileNamePostfix + fileExtension;
	}
}
