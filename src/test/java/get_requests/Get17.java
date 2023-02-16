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
        DummyApiResponseBodyPojo expectedResponseBodyPojo = new DummyApiResponseBodyPojo("success", dataPojo, "Successfully! Record has been fetched.");
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.then().assertThat().statusCode(200);
        DummyApiResponseBodyPojo actualResponseBodyPojo = JsonUtil.convertJsonToJavaObject(response.asString(), DummyApiResponseBodyPojo.class);
        assertEquals(expectedResponseBodyPojo.getStatus(), actualResponseBodyPojo.getStatus());
        assertEquals(expectedResponseBodyPojo.getMessage(), actualResponseBodyPojo.getMessage());
        assertEquals(expectedResponseBodyPojo.getData().getEmployee_name(), actualResponseBodyPojo.getData().getEmployee_name());
        assertEquals(expectedResponseBodyPojo.getData().getEmployee_salary(), actualResponseBodyPojo.getData().getEmployee_salary());
        assertEquals(expectedResponseBodyPojo.getData().getEmployee_age(), actualResponseBodyPojo.getData().getEmployee_age());
        assertEquals(expectedResponseBodyPojo.getData().getProfile_image(), actualResponseBodyPojo.getData().getProfile_image());
    }
}
