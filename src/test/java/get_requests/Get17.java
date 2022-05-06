package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponseBodyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get17 extends DummyRestApiBaseUrl {

    /*
       URL: https://dummy.restapiexample.com/api/v1/employee/1
       HTTP Request Method: GET Request
       Test Case: Type by using Gherkin Language
       Assert: 	i) Status code is 200
               ii) "employee_name" is "Tiger Nixon"
              iii) "employee_salary" is 320800
               iv)  "employee_age" is 61
                v) "status" is "success"
               vi)  "message" is "Successfully! Record has been fetched."
     */
    /*
        Given
            https://dummy.restapiexample.com/api/v1/employee/1
        When
            User send GET Request
        Then
            Status code is 200
        And
           "employee_name" is "Tiger Nixon"
        And
           "employee_salary" is 320800
        And
          "employee_age" is 61
        And
          "status" is "success"
       And
          "message" is "Successfully! Record has been fetched."
     */
    @Test
    public void get01(){
        spec.pathParams("first", "employee", "second", 1);
        DummyApiDataPojo dataPojo = new DummyApiDataPojo("Tiger Nixon", 320800, 61, "");
        DummyApiResponseBodyPojo responsePojo = new DummyApiResponseBodyPojo("success", dataPojo, "Successfully! Record has been fetched.");
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.then().assertThat().statusCode(200);
        DummyApiResponseBodyPojo responseBodyPojo = JsonUtil.convertJsonToJavaObject(response.asString(), DummyApiResponseBodyPojo.class);
        assertEquals(responsePojo.getStatus(), responseBodyPojo.getStatus());
        assertEquals(responsePojo.getMessage(), responseBodyPojo.getMessage());
        assertEquals(responsePojo.getData().getEmployee_name(), responseBodyPojo.getData().getEmployee_name());
        assertEquals(responsePojo.getData().getEmployee_salary(), responseBodyPojo.getData().getEmployee_salary());
        assertEquals(responsePojo.getData().getEmployee_age(), responseBodyPojo.getData().getEmployee_age());
        assertEquals(responsePojo.getData().getProfile_image(), responseBodyPojo.getData().getProfile_image());
    }
}
