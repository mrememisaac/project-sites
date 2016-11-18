package com.sites;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sites.models.Site;

//This class contains web integration tests for the Sites Controller class
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class SitesControllerWebIntegrationTest {

	private String baseUrl = "http://localhost:8080/api/v1/sites";
	private RestTemplate restTemplate;
	private ResponseEntity<String> response;
	private ObjectMapper objectMapper;

	@Test
	public void testInsert() throws IOException {

		restTemplate = new TestRestTemplate();

		Site site = new Site();
		site.setCondition("Inserting");
		site.setDescription("Site Insert being tested");
		site.setLatitude(10D);
		site.setLongitude(10D);
		site.setName("Insert Test Site :)");
		site.setYearStarted(2016);
		ResponseEntity<Site> response = restTemplate.postForEntity(baseUrl, site, Site.class);

		// check for a successful request
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		// get the object
		Site returnedSite = response.getBody();

		// check that the object was returned with a new valid id
		assertThat(returnedSite.getId() != site.getId(), is(true));

		// check that all other fields are intact
		assertThat(returnedSite.getName().equals(site.getName()), is(true));
		assertThat(returnedSite.getCondition().equals(site.getCondition()), is(true));


		
	}

	@Test
	public void testUpdate() throws IOException {

		restTemplate = new TestRestTemplate();

		Site site = new Site();
		site.setCondition("Inserting");
		site.setDescription("Site Insert being tested");
		site.setLatitude(10D);
		site.setLongitude(10D);
		site.setName("Insert Test Site :)");
		site.setYearStarted(2016);
		ResponseEntity<Site> response = restTemplate.postForEntity(baseUrl, site, Site.class);

		restTemplate = new RestTemplate();

		// get the returned object
		Site returnedSite = response.getBody();

		String oldname = returnedSite.getName();
		
		// change its name
		returnedSite.setName("Your name is now Update");

		//create the post object
		HttpHeaders requestHeaders=new HttpHeaders();
	    requestHeaders.add("X-Emem-Isaac", "Emem Isaac");
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<Site> entity = new HttpEntity<Site>(returnedSite);
	    
		// post the change
		response = restTemplate.exchange(baseUrl + "/" + returnedSite.getId(), HttpMethod.PUT, entity, Site.class);

		// check for a successful request
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		Site updatedSite = response.getBody();
		
		//check for the name update
		assertThat(updatedSite.getName().equals(oldname)==false, is(true));	
		
	}

	@Test
	public void testListAll() throws IOException {
		restTemplate = new TestRestTemplate();

		// place the call to the list end point
		response = restTemplate.getForEntity(baseUrl, String.class);

		// check that the response was ok
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		JsonNode responseJson = convertToJNode(response);
		

		// final checks
		assertThat(responseJson.isMissingNode(), is(false));
		
	}

	private JsonNode convertToJNode(ResponseEntity<String> response) throws IOException, JsonProcessingException {
		objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		return responseJson;
	}

	

	@Test
	public void testGet() throws IOException {
		restTemplate = new TestRestTemplate();

		response = restTemplate.getForEntity(baseUrl + "/1", String.class);

		// check that the response was OK
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		// Convert the response to a JSON object
		JsonNode responseJson = convertToJNode(response);

		// final checks
		assertThat(responseJson.isMissingNode(), is(false));

		// that the expected field exists in the returned object
//		assertThat(responseJson.fieldNames().toString().contains("id"), is(true));
//		assertThat(responseJson.fieldNames().toString().contains("name"), is(true));
//		assertThat(responseJson.fieldNames().toString().contains("condition"), is(true));
//		assertThat(responseJson.fieldNames().toString().contains("yearStarted"), is(true));
	}

}
