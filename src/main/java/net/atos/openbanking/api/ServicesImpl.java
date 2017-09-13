package net.atos.openbanking.api;

import org.apache.commons.io.IOUtils;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@ApplicationPath("/")
public class ServicesImpl extends Application implements Services {

    private String hdr_x_fapi_financial_id = "";
    private String hdr_x_fapi_interaction_id = "";
    private String hdr_Authorization = "";
    private String req_bearer_token = "";

    private final String valid_bearer_token = "cMotDibBl3r";
    private final String x_jws_signature = "V2hhdCB3ZSBnb3QgaGVyZQ0K..aXMgZmFpbHVyZSB0byBjb21tdW5pY2F0ZQ0K";

    private final String accId22289 = "22289";

    private JsonObjectBuilder jb = Json.createObjectBuilder();


    @Override
    public Response getAccounts(@Context HttpHeaders headers) {

        Response errResponse = validateHeaders(headers);

        if(errResponse != null) {
            return errResponse;
        }

        // Everything seems OK, let's return dummy data
        // read dummy JSON response body
        ClassLoader classLoader = getClass().getClassLoader();
        String getAccountsData = "";
        try {
            getAccountsData = IOUtils.toString(classLoader.getResourceAsStream("data/getAccounts.json"), "UTF-8");
        } catch (Exception e) {};
        return Response.ok(getAccountsData)
                .header("x-jws-signature", x_jws_signature)
                .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                .build();
    }

    @Override
    public Response getAccountsByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId) {

        Response errResponse = validateHeaders(headers);

        if(errResponse != null) {
            return errResponse;
        }

        if (!accId.equals(accId22289)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .entity(jb.add("Error", "Access to resource forbidden with token: "+req_bearer_token).build())
                    .build();
        }

        // Everything seems OK, let's return dummy data
        // read dummy JSON response body
        ClassLoader classLoader = getClass().getClassLoader();
        String getAccountsData = "";
        try {
            getAccountsData = IOUtils.toString(classLoader.getResourceAsStream("data/getAccounts22289.json"), "UTF-8");
        } catch (Exception e) {};
        return Response.ok(getAccountsData)
                .header("x-jws-signature", x_jws_signature)
                .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                .build();
    }

    @Override
    public Response getAccountBalancesByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId) {

        Response errResponse = validateHeaders(headers);

        if(errResponse != null) {
            return errResponse;
        }

        if (!accId.equals(accId22289)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .entity(jb.add("Error", "Access to resource forbidden with token: "+req_bearer_token).build())
                    .build();
        }

        // Everything seems OK, let's return dummy data
        // read dummy JSON response body
        ClassLoader classLoader = getClass().getClassLoader();
        String getAccountsData = "";
        try {
            getAccountsData = IOUtils.toString(classLoader.getResourceAsStream("data/getAccountBalances22289.json"), "UTF-8");
        } catch (Exception e) {};
        return Response.ok(getAccountsData)
                .header("x-jws-signature", x_jws_signature)
                .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                .build();
    }

    @Override
    public Response getAccountBeneficiariesByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId) {

        Response errResponse = validateHeaders(headers);

        if(errResponse != null) {
            return errResponse;
        }

        if (!accId.equals(accId22289)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .entity(jb.add("Error", "Access to resource forbidden with token: "+req_bearer_token).build())
                    .build();
        }

        // Everything seems OK, let's return dummy data
        // read dummy JSON response body
        ClassLoader classLoader = getClass().getClassLoader();
        String getAccountsData = "";
        try {
            getAccountsData = IOUtils.toString(classLoader.getResourceAsStream("data/getAccountBeneficiaries22289.json"), "UTF-8");
        } catch (Exception e) {};
        return Response.ok(getAccountsData)
                .header("x-jws-signature", x_jws_signature)
                .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                .build();
    }

    @Override
    public Response getAccountProductsByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId) {

        Response errResponse = validateHeaders(headers);

        if(errResponse != null) {
            return errResponse;
        }

        if (!accId.equals(accId22289)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .entity(jb.add("Error", "Access to resource forbidden with token: "+req_bearer_token).build())
                    .build();
        }

        // Everything seems OK, let's return dummy data
        // read dummy JSON response body
        ClassLoader classLoader = getClass().getClassLoader();
        String getAccountsData = "";
        try {
            getAccountsData = IOUtils.toString(classLoader.getResourceAsStream("data/getAccountProducts22289.json"), "UTF-8");
        } catch (Exception e) {};
        return Response.ok(getAccountsData)
                .header("x-jws-signature", x_jws_signature)
                .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                .build();
    }

    @Override
    public Response getAccountTransactionsByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId) {

        Response errResponse = validateHeaders(headers);

        if(errResponse != null) {
            return errResponse;
        }

        if (!accId.equals(accId22289)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .entity(jb.add("Error", "Access to resource forbidden with token: "+req_bearer_token).build())
                    .build();
        }

        // Everything seems OK, let's return dummy data
        // read dummy JSON response body
        ClassLoader classLoader = getClass().getClassLoader();
        String getAccountsData = "";
        try {
            getAccountsData = IOUtils.toString(classLoader.getResourceAsStream("data/getAccountTransactions22289.json"), "UTF-8");
        } catch (Exception e) {};
        return Response.ok(getAccountsData)
                .header("x-jws-signature", x_jws_signature)
                .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                .build();
    }

    // Private functions

    private Response validateHeaders(HttpHeaders headers) {
        // process headers
        hdr_x_fapi_financial_id = headers.getHeaderString("x-fapi-financial-id");
        hdr_x_fapi_interaction_id = headers.getHeaderString("x-fapi-interaction-id");
        hdr_Authorization = headers.getHeaderString("Authorization");
        req_bearer_token = parse_auth_header();

        // Catch missing mandatory header
        if(hdr_x_fapi_financial_id == null || hdr_x_fapi_financial_id == "") {
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .entity(jb.add("Error", "Missing mandatory header 'x-fapi-financial-id'").build())
                    .build();
        }

        // Catch missing or invalid Authorization header
        if(hdr_Authorization == null || !hdr_Authorization.startsWith("Bearer")) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .header("WWW-Authenticate","Bearer")
                    .entity(jb.add("Error", "Missing or invalid header 'Authorization'").build())
                    .build();
        }

        // Catch invalid Authorization token
        if(!req_bearer_token.equals(valid_bearer_token)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .header("x-jws-signature", x_jws_signature)
                    .header("x-fapi-interaction-id",hdr_x_fapi_interaction_id)
                    .entity(jb.add("Error", "Access to resource forbidden with token: "+req_bearer_token).build())
                    .build();
        }

        // Everything OK return an empty response
        return null;
    }

    private String parse_auth_header() {
        final int BEARER_STR_LNG = "Bearer ".length();
        return (hdr_Authorization == null || hdr_Authorization.length() < BEARER_STR_LNG) ? "" : hdr_Authorization.substring(BEARER_STR_LNG).trim();
    }
}
