package net.atos.openbanking.api;

import org.apache.http.HttpStatus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.jboss.resteasy.mock.MockHttpRequest;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


@RunWith(JUnit4.class)
public class UnitTest {

  ServicesImpl test = new ServicesImpl();

  @Test
  public void get_acc_should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
                                   .header("foo","bar")
                                   .getHttpHeaders();
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
  }

  @Test
  public void get_acc_should_return_unauthorized() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatus());
  }

  @Test
  public void get_acc_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
                                  .header("x-fapi-financial-id","this-is-a-test")
                                  .header("Authorization","Bearer: cMotDibBl3r")
                                  .getHttpHeaders();
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
  }

  @Test
  public void get_acc_by_id_should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("foo","bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
  }

  @Test
  public void get_acc_by_id_should_return_unauthorized() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatus());
  }

  @Test
  public void get_acc_by_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_by_id_with_bad_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountsByAccId(headers, "12345");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_by_id_should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
  }

  @Test
  public void get_acc_bal_by_id_should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("foo","bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBalancesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
  }

  @Test
  public void get_acc_bal_should_return_unauthorized() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBalancesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatus());
  }

  @Test
  public void get_acc_bal_by_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBalancesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_bal_by_id_with_bad_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBalancesByAccId(headers, "12345");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_bal_by_id_should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBalancesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
  }

  @Test
  public void get_acc_ben_by_id_should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("foo","bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBeneficiariesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
  }

  @Test
  public void get_acc_ben_should_return_unauthorized() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBeneficiariesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatus());
  }

  @Test
  public void get_acc_be_nby_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBeneficiariesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_ten_by_id_with_bad_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBeneficiariesByAccId(headers, "12345");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_ben_by_id_should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountBeneficiariesByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
  }

  @Test
  public void get_acc_prod_by_id_should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("foo","bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountProductsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
  }

  @Test
  public void get_acc_prod_by_id_should_return_unauthorized() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountProductsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatus());
  }

  @Test
  public void get_acc_prod_by_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountProductsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_prod_by_id_with_bad_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountProductsByAccId(headers, "12345");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_prod_by_id_should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountProductsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
  }

  @Test
  public void get_acc_trans_by_id_should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("foo","bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountTransactionsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
  }

  @Test
  public void get_acc_trans_should_return_unauthorized() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountTransactionsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.getStatus());
  }

  @Test
  public void get_acc_trans_by_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: foo-bar")
            .getHttpHeaders();
    //When
    Response response = test.getAccountTransactionsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_trans_by_id_with_bad_id_should_return_forbidden() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountTransactionsByAccId(headers, "12345");
    //Then
    Assert.assertEquals(HttpStatus.SC_FORBIDDEN, response.getStatus());
  }

  @Test
  public void get_acc_trans_by_id_should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET", "nox://foo-bar")
            .header("x-fapi-financial-id","this-is-a-test")
            .header("Authorization","Bearer: cMotDibBl3r")
            .getHttpHeaders();
    //When
    Response response = test.getAccountTransactionsByAccId(headers, "22289");
    //Then
    Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
  }

}
