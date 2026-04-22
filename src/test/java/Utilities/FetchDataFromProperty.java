package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ConstantsData.Constant;

public class FetchDataFromProperty {
public static Properties readDataFromProperty() throws IOException {
	FileReader reader=new FileReader(Constant.proppath);
	Properties prop=new Properties();
	prop.load(reader);
	return prop;
	
}
}
