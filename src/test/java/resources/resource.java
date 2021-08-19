package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.System.Logger;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class resource {

	public static RequestSpecification reqspec;

	public RequestSpecification reqspecbuild() throws IOException {
		PrintStream log = new PrintStream(new File("logger.txt"));
		if (reqspec == null) {
			reqspec = new RequestSpecBuilder().setBaseUri(url()).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return reqspec;
		}
		return reqspec;
	}

	public String url() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Asus\\eclipse-workspace\\APIByMe\\src\\test\\java\\resources\\data.properties");
		prop.load(fis);
		return prop.getProperty("baseURL");

	}
}
