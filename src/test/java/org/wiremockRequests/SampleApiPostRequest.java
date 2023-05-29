package org.wiremockRequests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static com.github.tomakehurst.wiremock.extension.responsetemplating.helpers.WireMockHelpers.jsonPath;

public class SampleApiPostRequest {
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
        stubFor(post(urlEqualTo("/api/example"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withStatusMessage("created")
                        .withHeader("Content-Type", "application/json")
                        .withBody("{{jsonPath request.body '$.email'}}")
//                        .withBody("{request.port}")
                        . withTransformers("response-template")));
    }
    @Test
    public void testStub(){
        Response response= RestAssured.given().log().all().
                baseUri("http://" + HOST)
                .port(PORT)
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "  \"name\": \"APITestDemo2\",\n" +
                        "  \"email\": \"APItestDemo2@gmail.com\",\n" +
                        "  \"password\": \"password@123\" \n}")
                .post("/api/example");
        int StatusCode=response.getStatusCode();
        System.out.println("Status code "+ StatusCode);
        response.prettyPrint();
    }
    @AfterClass
    public void teardown() {
//        WireMock.reset();
    }
    }
