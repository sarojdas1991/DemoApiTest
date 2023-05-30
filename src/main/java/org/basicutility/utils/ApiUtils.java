package org.basicutility.utils;

import java.security.PublicKey;

public class ApiUtils {

    public static final String PostmanUrl ="https://postman-echo.com";
    public static final String postmanUId ="postman";
    public static final String PostmanPw ="password";
    public static final String DigestEndPoint="/digest-auth";
    public static final String BasicEndPoint="/basic-auth";
    public static final String ApiKeyEndPoint="/v1/account/test-api-keys";
    public static final String ApiKey="appid";
    public static final String ApiValue="test_larZQEJCa2I3KYt5ff5S00yaMB5tZk5B7LmWHPcA";

    public static final String API_AUTH_URL="https://api.nettoolkit.com";
    public static final String BeaerAuthUrl="http://restapi.adequateshop.com";
    public static final String LoginEndPoint="/api/authaccount/login";
    public static final String RegEndPoint="/api/authaccount/registration";
    public static final String Outh1EndPoint="/oauth1";
    public static final String GitApiUrl="https://api.github.com";
    public static final String GitEndPoint="/user/repos";
    public static final String GitToken="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";
    public static final String AkamaiAuthValue="EG1-HMAC-SHA256 client_token=Cl8633678;access_token=Api6365337;timestamp=20230502T13:22:21+0000;nonce=d8fa8783-7cc3-4147-909f-0962f3a0d005;signature=y4HInGjQNdAipMFFWIEXBDQwZLBmJH+M4tlauHZgw+Y=";
    public static final String JwtToken="Bearer eyJhbGciOiJIUzI1NiJ9.e30.WMgiu96412-06K72RtdCw5BFVJndgQVF1GxP5UZQXkM";
    public static final String AwsToken="AWS4-HMAC-SHA256 Credential=APITEST/20230502/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-date, Signature=3d5fcd0f030e1df076725000381657e1ae74c278978e373d5eea0adad510f5f7";
    public static final String HawkToken="Hawk id=\"dh37fgj492je\", ts=\"1683044507\", nonce=\"HEbG-s\", mac=\"OpKwRZ1L4bPh2mHpKHd61QfD1lT9uZ/9iDP0WacOwME=\"";

    public  static final int Status_Ok=200;
    public  static final int Status_Created=201;
    public  static final int Status_NotFound=404;
    public static final int Status_NoContent=204;



}
