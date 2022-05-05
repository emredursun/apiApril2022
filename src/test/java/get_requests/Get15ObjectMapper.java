package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {

    /*
        Given
	            https://restful-booker.herokuapp.com/booking/2
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                {
                    "firstname": "Jim",
                    "lastname": "Smith",
                    "totalprice": 649,
                    "depositpaid": false,
                    "bookingdates": {
                        "checkin": "2015-09-16",
                        "checkout": "2018-04-09"
                    },
                    "additionalneeds": "Breakfast"
                }
     */
    @Test
    public void get01(){

        //1.Step: Set the URL
        spec.pathParams("first", "booking", "second", 2);

        //2.Step: Set the Expected Data
        String expectedData = "{\n" +
                                "\"firstname\": \"Mark\",\n" +
                                "\"lastname\": \"Jones\",\n" +
                                "\"totalprice\": 802,\n" +
                                "\"depositpaid\": false,\n" +
                                "\"bookingdates\": {\n" +
                                "\"checkin\": \"2017-02-18\",\n" +
                                "\"checkout\": \"2019-10-26\"\n" +
                                "},\n" +
                                "\"additionalneeds\": \"Breakfast\"\n" +
                                "}";
        BookingPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, BookingPojo.class);

        //3.Step: Send GET Request and get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4.Step: Do Assertions
        BookingPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), BookingPojo.class);

        assertEquals(200, response.getStatusCode());

        //Hard Assertion
//        assertEquals(expectedDataPojo.getFirstname(), actualDataPojo.getFirstname());
//        assertEquals(expectedDataPojo.getLastname(), actualDataPojo.getLastname());
//        assertEquals(expectedDataPojo.getTotalprice(), actualDataPojo.getTotalprice());
//        assertEquals(expectedDataPojo.getDepositpaid(), actualDataPojo.getDepositpaid());
//        assertEquals(expectedDataPojo.getBookingdates().getCheckin(), actualDataPojo.getBookingdates().getCheckin());
//        assertEquals(expectedDataPojo.getBookingdates().getCheckout(), actualDataPojo.getBookingdates().getCheckout());
//        assertEquals(expectedDataPojo.getAdditionalneeds(), actualDataPojo.getAdditionalneeds());

        //Soft Assertion
        //1)Create SoftAssert Object
        SoftAssert softAssert = new SoftAssert();
        //2)Do Assertions
        softAssert.assertEquals(actualDataPojo.getFirstname(), expectedDataPojo.getFirstname(), "Firstname did not match");
        softAssert.assertEquals(actualDataPojo.getLastname(), expectedDataPojo.getLastname(), "Lastname did not match");
        softAssert.assertEquals(actualDataPojo.getTotalprice(), expectedDataPojo.getTotalprice(), "Total price did not match");
        softAssert.assertEquals(actualDataPojo.getDepositpaid(), expectedDataPojo.getDepositpaid(), "Deposit paid did not match");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckin(), expectedDataPojo.getBookingdates().getCheckin(), "Checkin paid did not match");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckout(), expectedDataPojo.getBookingdates().getCheckout(), "Checkout paid did not match");
        //3)Use assertAll()
        softAssert.assertAll();

        //Note: Improve String Expected Data to a Method in HerOkuAppTestData Class
    }

}
