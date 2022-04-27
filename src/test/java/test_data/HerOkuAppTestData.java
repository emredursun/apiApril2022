package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String, String> bookingDateSetUp(String checkin, String checkout){

        Map<String, String> bookingDateMap = new HashMap<>();
        bookingDateMap.put("checkin", checkin);
        bookingDateMap.put("checkout", checkout);
        return bookingDateMap;
    }

    public Map<String, Object> expectedDataSetUp(String firstname, String lastname, int totalprice, boolean depoaitpaid,  Map<String, String> bookingdates){

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname", firstname);
        expectedDataMap.put("lastname", lastname);
        expectedDataMap.put("totalprice", totalprice);
        expectedDataMap.put("depoaitpaid", depoaitpaid);
        expectedDataMap.put("bookingdates", bookingdates);

        return expectedDataMap;

    }
}
