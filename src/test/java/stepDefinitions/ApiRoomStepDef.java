package stepDefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.RoomPojo;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.MedunnaRoomStepDef.roomID;
import static stepDefinitions.MedunnaRoomStepDef.roomNumberFaker;

public class ApiRoomStepDef {

    Response response;
    RoomPojo expectedData;

    @Given("send the request to url")
    public void sendTheRequestToUrl() {
        // set the url  ---> https://medunna.com/api/rooms?sort=createdDate,desc
        spec.pathParams("first","api","second","rooms").queryParams("sort","createdDate,desc");

        // set the expected data


        // send the request and get the response
        response = given(spec).get("{first}/{second}");
  //    response.prettyPrint();

    }

    @When("validate body")
    public void validateBody() {

        // do assertion
        Object actualRoomType = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomType").get(0);
       // System.out.println(response.jsonPath().getList("findAll{it.roomNumber==320437}.roomType").get(0));

        Object actualStatus = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.status").get(0);
        Object actualPrice = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.price").get(0);
        Object actualDescription = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.description").get(0);
        Object actualRoomNumber= response.jsonPath().getList("findAll{it.roomNumber=="+roomNumberFaker+"}.roomNumber").get(0);

        assertEquals("PREMIUM_DELUXE",actualRoomType);
        assertEquals(true,actualStatus);
        assertEquals("123.00",actualPrice+"");  //float double sorunu var, ikisini de string yaptım
        assertEquals("Created For E2E Test",actualDescription);
        assertEquals(roomNumberFaker,actualRoomNumber);

    }







    @Given("get request to url by id")
    public void getRequestToUrlById() {
        //set the url
        spec.pathParams("first","api","second","rooms","third",roomID);

        //set the expected data
        expectedData = new RoomPojo(roomNumberFaker,"PREMIUM_DELUXE",true,123.00,"Created For E2E Test");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        response= given(spec).get("{first}/{second}/{third}");
    //    response.prettyPrint();

    }


    @When("validate response body")
    public void validateResponseBody() throws JsonProcessingException {

      RoomPojo actualData = new ObjectMapper().readValue(response.asString(),RoomPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getPrice(),actualData.getPrice());
        assertEquals(expectedData.getDescription(),actualData.getDescription());
    }

}
