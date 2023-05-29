package org.wiremockRequests;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class SampleApiGetRequestExtFile {
    public  static final int PORT=8080;
    public  static  final String HOST="localhost";
    @BeforeClass
    public  static void setUp(){
        WireMock.configureFor(HOST,PORT);
        stubFor(get(urlEqualTo("/v1/players")).
                willReturn(aResponse().withStatus(200)
                        .withBodyFile("sample.json")
                        .withHeader("Content-Type","application/json")));

    }
    @Test
    public void testMockedApi() {
        Response response=RestAssured.given().
                baseUri("http://" + HOST)
                .port(PORT)
                .contentType(ContentType.JSON)
                .when()
                .get("/v1/players");
        int StatusCode=response.getStatusCode();
        response.prettyPrint();
        response.contentType().contentEquals("application/json");
    }
    @AfterClass
    public static void teardown() {
        WireMock.reset();
    }

}
