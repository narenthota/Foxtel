package service;

import clients.RestClient;
import io.restassured.response.Response;

public class ServiceFactory {
		
	RestClient restClient;
	
	public ServiceFactory() {
		restClient = new RestClient();
	}
	
	public Response getAllBooks() {
		
		return restClient.SendGetRequest("/BookStore/v1/Books");
	}
	
	public Response addbooks(String requestPayload) {
		
		return restClient.SendPostRequest("/BookStore/v1/Books", "TestNT1", "Test@123", requestPayload);
	}
	
	public Response updatebooks(String requestPayload, String isbn) {
		
		return restClient.SendPutRequest("/BookStore/v1/Books/{isbn}", "TestNT1", "Test@123", requestPayload, isbn);
	}
	
	public Response removebooks(String requestPayload) {
		
		return restClient.SendDeleteRequest("/BookStore/v1/Book", "TestNT1", "Test@123", requestPayload);
	}
}
