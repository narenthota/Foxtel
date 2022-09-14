package clients;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class RestClient {

	public Response SendGetRequest(String uri) {
		
		return given().when().get(uri);
		
	}
	
	public Response SendPostRequest(String uri, String userName, String password, Object requestPayload) {
		
		return given()
				.auth()
				.preemptive()
				.basic(userName, password)
				.contentType(ContentType.JSON)
				.when()
				.body(requestPayload)
				.post(uri);
	}
	
	public Response SendPutRequest(String uri, String userName, String password, Object requestPayload, Object isbn) {
		
		return given()
				.auth()
				.preemptive()
				.basic(userName, password)
				.contentType(ContentType.JSON)
				.pathParam("isbn", isbn)
				.when()
				.body(requestPayload)
				.put(uri);
	}
	
	public Response SendDeleteRequest(String uri, String userName, String password, Object requestPayload) {
		
		return given()
				.auth()
				.preemptive()
				.basic(userName, password)
				.when()
				.body(requestPayload)
				.delete(uri);	
	}
}

