package delete_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDeleteResponseBodyPojo;
import pojos.DummyApiResponseBodyPojo;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete02 extends DummyRestApiBaseUrl {

    /*
       URL: https://dummy.restapiexample.com/api/v1/delete/2
       HTTP Request Method: DELETE Request
       Test Case: Type by using Gherkin Language
       Assert: 	i) Status code is 200
               ii) "status" is "success"
              iii) "data" is "2"
               iv) "message" is "Successfully! Record has been deleted"
     */

        /*
        Given
            https://dummy.restapiexample.com/api/v1/delete/2
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200

		And
            Response body should be like the following
              {
                "status": "success",
                "data": "2",
                "message": "Successfully! Record has been deleted"
             }
     */

    @Test
    public void delete01(){

        //1.Step: Set the URL
        spec.pathParams("first", "delete", "second", 2);

        //2.Step: Set the Expected Data
        DummyApiDeleteResponseBodyPojo expectedDummyApiDeleteResponseBody = new DummyApiDeleteResponseBodyPojo("success", "2", "Successfully! Record has been deleted");

        //3.Step: Send DELETE Request and get the Response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();
        DummyApiDeleteResponseBodyPojo actualDummyApiDeleteResponseBody = JsonUtil.convertJsonToJavaObject(response.asString(), DummyApiDeleteResponseBodyPojo.class);

        //4.Step: Do Assertion
        response.then().assertThat().statusCode(200);
        assertEquals(expectedDummyApiDeleteResponseBody.getStatus(),actualDummyApiDeleteResponseBody.getStatus());
        assertEquals(expectedDummyApiDeleteResponseBody.getData(),actualDummyApiDeleteResponseBody.getData());
        assertEquals(expectedDummyApiDeleteResponseBody.getMessage(),actualDummyApiDeleteResponseBody.getMessage());

        /*
            Interview Question:
            How to automate "DELETE Request" in API Testing?
            i)Create new data by using "POST Request"
            ii)Use "DELETE Request" to delete newly created data.

            Note: Do not use "DELETE Request" for the existing data, create your own data then delete it.
         */

    }
}
