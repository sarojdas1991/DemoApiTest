package org.wiremockRequests;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class SampleApiGetRequest {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    @BeforeClass
    public static void setup() {
        WireMock.configureFor(HOST, PORT);
        stubFor(get(urlEqualTo("/api/example"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": 500, \"name\": \"Saroj\"}")));
    }
    @Test
    public void testMockedApi() {
        Response response=RestAssured.given().
               baseUri("http://" + HOST)
                .port(PORT)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/example");
               response .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", Matchers.equalTo(500))
                .body("name", Matchers.equalTo("Saroj")).log().all();
        int sc=response.getStatusCode();
        System.out.println("status code "+ sc);
        String ct=response.contentType();
        System.out.println("content type "+ ct);
        response.prettyPrint();
        String id=response.body().toString();
    }
    @AfterClass
    public static void teardown() {
        WireMock.reset();
    }

}
