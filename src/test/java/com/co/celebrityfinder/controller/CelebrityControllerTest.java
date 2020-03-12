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
public class CelebrityControllerTest {

    public static final String CELEBRITY_IS_PRESENT_IN_THE_ROW = "Celebrity is present in the row";
    public static final String CELEBRITY_IS_NOT_PRESENT = "Celebrity is not present.";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testUpload() {
        LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new org.springframework.core.io.ClassPathResource("listOfPeople.csv"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);
        ResponseEntity<String> response = testRestTemplate.exchange("/celebrity/findCelebrity", HttpMethod.POST, entity, String.class, "");

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUploadCsvWithACelebrity() {
        LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new org.springframework.core.io.ClassPathResource("listOfPeople.csv"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);
        ResponseEntity<String> response = testRestTemplate.exchange("/celebrity/findCelebrity", HttpMethod.POST, entity, String.class, "");

        assertEquals(true, response.getBody().contains(CELEBRITY_IS_PRESENT_IN_THE_ROW));
    }

    @Test
    public void testUploadCsvWithoutCelebrity() {
        LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new org.springframework.core.io.ClassPathResource("listOfPeopleWithout_celebrity.csv"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);
        ResponseEntity<String> response = testRestTemplate.exchange("/celebrity/findCelebrity", HttpMethod.POST, entity, String.class, "");

        assertEquals(true, response.getBody().contains(CELEBRITY_IS_NOT_PRESENT));
    }
}
