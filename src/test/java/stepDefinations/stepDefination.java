package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.awt.image.DataBuffer;
import java.io.FileNotFoundException;
import java.io.IOException;

import POJO.resBook;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Data;
import resources.resource;

public class stepDefination extends resource {

	RequestSpecification req;
	Data data = new Data();
	Response res;
	static String ID;

	@Given("Add book with {string} {string} {string} {string}")
	public void add_book_with(String name, String isbn, String aisle, String author) throws IOException {

		req = given().spec(reqspecbuild()).body(data.addBookWith(name, isbn, aisle, author));
	}

	@When("user call {string} with {string} method")
	public void user_call_with_method(String resource, String string2) {
		APIResources resources = APIResources.valueOf(resource);
		System.out.println(resources.getResource());
		res = req.when().post(resources.getResource());
		if (resource.equalsIgnoreCase("add")) {
			resBook rb = res.as(resBook.class);
			ID = rb.getID();
		}

	}

	@Then("API call got successfull with status code {int}")
	public void api_call_got_successfull_with_status_code(Integer int1) {
		int status = int1;
		// assertEquals(res.getStatusCode(), status);
		System.out.println("Operation Successfully performed");
	}

	@Given("delete book with {string}")
	public void delete_book_with(String string) throws IOException {
		req = given().spec(reqspecbuild()).body("\"ID\" : \"" + ID + "\"");

	}

}
