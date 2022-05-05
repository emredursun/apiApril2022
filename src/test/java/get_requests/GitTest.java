package get_requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GitTest {

    @Test
    public void get01(){

        //1.Step: Set the URL
        String url = "https://dummy.restapiexample.com/api/v1/employees";

        //2.Step: Set the Expected Data

        //3.Step: Send the Request and Get the Response
        Response response = given().when().get(url);
        response.prettyPrint();

        //4.Step: Do Assertions
        response.
                then().
                assertThat().
                statusCode(200).
                body("data.id", hasSize(24),
                        "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters"));



        JsonPath json = response.jsonPath();
        List<Integer> ageList = json.getList("data.findAll{it.id>0}.employee_age");
        Collections.sort(ageList);
        assertEquals((int)ageList.get(ageList.size()-1), 66);

        String groovySyntax = "data.findAll{it.employee_age==" + ageList.get(0) + "}.employee_name";
        String minAgeName = json.getString(groovySyntax);
        assertEquals(minAgeName, "[Tatyana Fitzpatrick]");


        List<Integer> salaryList = json.getList("data.findAll{it.id>0}.employee_salary");
        System.out.println(salaryList);

        int sum = 0;
        for(int w : salaryList){
            sum = sum + w;
        }
        assertEquals(6644770, sum);



    }
}
