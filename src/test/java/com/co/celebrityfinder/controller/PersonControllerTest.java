package com.co.celebrityfinder.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testUpload() {
        LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new org.springframework.core.io.ClassPathResource("listOfPeople.csv"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);
        ResponseEntity<String> response = testRestTemplate.exchange("/person/findCelebrity", HttpMethod.POST, entity, String.class, "");
        // Expect Ok
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUploadCsvWithCelebrity() {
        LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new org.springframework.core.io.ClassPathResource("listOfPeople.csv"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);
        ResponseEntity<String> response = testRestTemplate.exchange("/person/findCelebrity", HttpMethod.POST, entity, String.class, "");
        // Expect celebrity found
        assertEquals(true, response.getBody().contains("Celebrity is present in the row"));
    }

    @Test
    public void testUploadCsvWithoutCelebrity() {
        LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new org.springframework.core.io.ClassPathResource("listOfPeopleWithout_celebrity.csv"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);
        ResponseEntity<String> response = testRestTemplate.exchange("/person/findCelebrity", HttpMethod.POST, entity, String.class, "");
        // Expect celebrity not found
        assertEquals(true, response.getBody().contains("Celebrity is not present."));
    }
}
