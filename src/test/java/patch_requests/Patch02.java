package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Patch02 extends JsonPlaceHolderBaseUrl {

        /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/3
	        2) {
                    "title": "UI Testing",
                    "completed": true
                }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
                                            "userId": 1,
                                            "id": 3,
                                            "title": "UI Testing",
                                            "completed": true
                                        }
     */

    @Test
    public void patch01(){
        //1.Step: Set the URL
        spec.pathParams("first","todos","second",3);

        //2.Step: Set the Request Body
        JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
        Map<String, Object> requestBodyMap = requestBody.expectedDataWithMissingKeys(null, "UI Testing", true);

        //3.Step: Send the PATCH Request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{first}/{second}");
        Map<String, Object> actualBodyMap = response.as(HashMap.class);
        response.prettyPrint();

        //4.Step: Do Assertions
        //1.Way:
        assertEquals(200, response.getStatusCode());
        assertEquals(requestBodyMap.get("title"), actualBodyMap.get("title"));
        assertEquals(requestBodyMap.get("completed"), actualBodyMap.get("completed"));

        //2.Way:
        response.then().assertThat().statusCode(200).body("title", equalTo(requestBodyMap.get("title")),
                "completed", equalTo(requestBodyMap.get("completed")));
    }

}
