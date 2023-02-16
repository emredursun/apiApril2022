package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.*;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {

    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Emre Dursun",
                        "employee_salary": 48000,
                        "employee_age": 35,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Emre Dursun",
                            "employee_salary": 48000,
                            "employee_age": 35,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    /*
        Given
            https://dummy.restapiexample.com/api/v1/update/21

                   Request body: {
                        "employee_name": "Emre Dursun",
                        "employee_salary": 48000,
                        "employee_age": 35,
                        "profile_image": "Perfect image"
                     }
        When
	 		I send Put Request to the Url
	 	Then
		 	Status code is 200

		And
            Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Emre Dursun",
                            "employee_salary": 48000,
                            "employee_age": 35,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    @Test
    public void put01() {
        //1.Step: Set the URL
        spec.pathParams("first","update","second",21);

        //2.Step: Set the Expected Data
        DummyApiDataPojo expectedDummyApiData = new DummyApiDataPojo("Emre Dursun", 48000, 35, "Perfect image");
        DummyApiResponseBodyPojo expectedDummyApiResponseBody = new DummyApiResponseBodyPojo("success", expectedDummyApiData , "Successfully! Record has been updated.");

        //3.Step:Send PUT Request and get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDummyApiData).when().put("/{first}/{second}");
        DummyApiResponseBodyPojo actualDummyApiResponseBody = JsonUtil.convertJsonToJavaObject(response.asString(),DummyApiResponseBodyPojo.class);

        //4.Step: Do Assertion
        assertEquals(200, response.statusCode());
        assertEquals(expectedDummyApiResponseBody.getStatus(), actualDummyApiResponseBody.getStatus());
        assertEquals(expectedDummyApiData.getEmployee_name(), actualDummyApiResponseBody.getData().getEmployee_name());
        assertEquals(expectedDummyApiData.getEmployee_salary(), actualDummyApiResponseBody.getData().getEmployee_salary());
        assertEquals(expectedDummyApiData.getEmployee_age(), actualDummyApiResponseBody.getData().getEmployee_age());
        assertEquals(expectedDummyApiData.getProfile_image(),actualDummyApiResponseBody.getData().getProfile_image());
        assertEquals(expectedDummyApiResponseBody.getMessage(), actualDummyApiResponseBody.getMessage());
    }
}
