package org.authentication;

public interface ApiAUthenticationCall extends ApiReqData {
    ApiKeyAuthentication apikey=new ApiKeyAuthentication();
    BasicAuthentication basic=new BasicAuthentication();
    BeaerToken bt=new BeaerToken();
    DigestAuth dt=new DigestAuth();
    Outh1oAuthentication outh1=new Outh1oAuthentication();
    Outh2oAuthentication outh2=new Outh2oAuthentication();
    NtlmAuthentication ntlm=new NtlmAuthentication();
    AkaaiAuth akaauth=new AkaaiAuth();
    JwtToken jwt =new JwtToken();
    AwsSignetureAuthentication awssigneture=new AwsSignetureAuthentication();
    HawkAuthentication hawkauth=new HawkAuthentication();

    public static void main(String[] args) {
//        apikey.ApiKeyAuth();
//        basic.BasicAuth();
//        bt.BeaerTokenAuth();
//        dt.DigestAut();
//        outh1.Outh1Auth();
//        outh2.outh2Auth();
//        ntlm.NtlmAuth();
//        akaauth.Akamai();
//        jwt.JwtAUth();
//        awssigneture.AwsAuth();
        hawkauth.HawkAuth();

    }


}
