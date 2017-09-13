package net.atos.openbanking.api;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/open-banking")
public interface Services {

    @GET
    @Path("/accounts")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAccounts(@Context HttpHeaders headers);

    @GET
    @Path("/accounts/{accId}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAccountsByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId);

    @GET
    @Path("/accounts/{accId}/balances")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAccountBalancesByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId);

    @GET
    @Path("/accounts/{accId}/beneficiaries")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAccountBeneficiariesByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId);

    @GET
    @Path("/accounts/{accId}/products")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAccountProductsByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId);

    @GET
    @Path("/accounts/{accId}/transactions")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAccountTransactionsByAccId(@Context HttpHeaders headers, @PathParam("accId") String accId);

}
