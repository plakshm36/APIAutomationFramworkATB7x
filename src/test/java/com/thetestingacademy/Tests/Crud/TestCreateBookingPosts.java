package com.thetestingacademy.Tests.Crud;


import com.thetestingacademy.BaseTests.BaseTest;
import com.thetestingacademy.Endpoints.APIConstants;
import com.thetestingacademy.Pojos.BookingResponse;
import com.thetestingacademy.Utils.PropertyReader;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestCreateBookingPosts extends BaseTest {

        @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
        @Issue("JIRA_RBT-4")
        @TmsLink("RBT-4")
        @Owner("Promode")
        @Severity(SeverityLevel.BLOCKER)
        @Description("Verify that POST request is working fine.")
        @Test
        public void testTC3VerifyCreateBookingPOST01() {
            requestSpecification
                    .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

            response = requestSpecification
                    .when().body(payloadManager.createPayloadBookingAsString()).post();
            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(Integer.parseInt(PropertyReader.readkey("booking.post.statuscode.success")));


            //Default Rest Assured
            validatableResponse.body("booking.firstname", Matchers.equalTo(PropertyReader.readkey("booking.post.firstname")));


            BookingResponse bookingResponse = payloadManager.getbookingResponseFromJson(response.asString());

            // AssertJ
            assertThat(bookingResponse.getBookingid()).isNotNull();
            assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
            assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(PropertyReader.readkey("booking.post.firstname"));

            // TestNG Assertions
            assertActions.verifyStatusCode(response,200);




        }
}