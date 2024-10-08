package com.thetestingacademy.Modules;

//This class is used for payload management like serialisation/deserialisation

import com.google.gson.Gson;
import com.thetestingacademy.Pojos.*;

public class PayloadManager {

    Gson gson;


    // Refers to TC3-Create a Booking
    // Converting the JAVA object to the String
    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking);


        // Java Object -> JSON String (byteStream) - Serlization to convert booking data from javaobjects to json format
        gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);
        return jsonStringpayload;
    }
/*//this class was created to show how to fill dynamic data using faker lib instead of hardcoding data
    public String createPayloadBookingAsStringFaker() {
        Faker faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1000));
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Java Object -> JSON String (byteStream) - Serlization
        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);
        return jsonStringpayload;
    }*/

    //Deserialisation to convert all json response recieved from createbooking tc3  to java object
    public BookingResponse getbookingResponseFromJson(String bookingResponse) {
        gson = new Gson();
        BookingResponse bookingResponse1 = gson.fromJson(bookingResponse, BookingResponse.class);
        return bookingResponse1;
    }

    // get Token
    public String setAuthPayload() {
        // Auth Object -> json String
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        // Java Object -> JSON String (byteStream) - Serlization to convert createAuthTC1 data from javaobjects to json format
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;
    }
    //Deserialisation to convert all json response recieved from createAuthTC1  to java object
    public String getTokenFromJSON(String tokenResponse) {
        gson = new Gson();
        AuthResponse tokenResponse1 = gson.fromJson(tokenResponse, AuthResponse.class);
        return tokenResponse1.getToken();
    }


    // get Booking ID
    public Booking getResponseFromJSON(String getResponse){
        gson = new Gson();
        // Response ( JSON) ->  Object TokenResponse
        // Deserialization
        Booking booking = gson.fromJson(getResponse,Booking.class);
        return booking;
    }

    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);
    }

}

