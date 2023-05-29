package org.wiremockRequests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class SampleWareMockServerOperation {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    WireMockServer wireMockServer;
//    WireMock wireMock;
    @BeforeClass
    void start(){
        wireMockServer = new WireMockServer(wireMockConfig().port(PORT));
        wireMockServer.start();
        createStub();
//        WireMock.configureFor(HOST, PORT);
//        wireMock = new WireMock(HOST, PORT);
    }
    public static void createStub(){
        WireMock.configureFor(HOST, PORT);
        stubFor(get(urlEqualTo("/api/example"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": 500, \"name\": \"Saroj\"}")));
    }
    @Test
    public void testMockedApi() {
        Response response= RestAssured.given().
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
    public void teardown() {
//        WireMock.reset();
        wireMockServer.stop();
    }

}
