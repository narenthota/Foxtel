package tests;



import java.nio.file.Paths;

import org.testng.annotations.Test;
import org.testng.reporters.Files;

import io.restassured.response.ValidatableResponse;

public class MethodTests extends BaseTest{
	
	
	@Test
	public void testGetRequest() {
		
		extentReport.createTestCase("Verify Get Request");
		ValidatableResponse valResponse = serviceFactory.getAllBooks().then();
		valResponse.log().all();
		valResponse.statusCode(200);
	}
	
	
	@Test
	public void testPostRequest() {
		
		extentReport.createTestCase("Verify Post Request");
		String requestPayload = "{\r\n"
				+ "  \"userId\": \"28f4af6f-d5ca-4c53-98eb-ca5fa6d895df\",\r\n"
				+ "  \"collectionOfIsbns\": [\r\n"
				+ "    {\r\n"
				+ "      \"isbn\": \"9781449331818\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		serviceFactory.addbooks(requestPayload).then().log().all().statusCode(201);
	}
	
	@Test
	public void testPutRequest() {
		
		extentReport.createTestCase("Verify Put Request");
		String requestPayload = "{\r\n"
				+ "  \"userId\": \"28f4af6f-d5ca-4c53-98eb-ca5fa6d895df\",\r\n"
				+ "  \"isbn\": \"9781449337711\"\r\n"
				+ "}";
		String isbn = "9781449331818";
		serviceFactory.updatebooks(requestPayload, isbn).then().log().all().statusCode(200);
	}
	
	@Test
	public void testDeleteRequest() {
		
		extentReport.createTestCase("Verify Delete Request");
		String requestPayload = "{\r\n"
				+ "  \"isbn\": \"9781449337711\",\r\n"
				+ "  \"userId\": \"28f4af6f-d5ca-4c53-98eb-ca5fa6d895df\"\r\n"
				+ "}";
		serviceFactory.removebooks(requestPayload).then().log().all().statusCode(204);
	}
	
}
