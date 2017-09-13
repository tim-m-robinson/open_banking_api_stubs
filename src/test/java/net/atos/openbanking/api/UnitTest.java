package net.atos.openbanking.api;

import org.apache.http.HttpStatus;
import org.jboss.resteasy.mock.MockHttpRequest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.json.JsonObject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@RunWith(JUnit4.class)
public class UnitTest {

  ServicesImpl test = new ServicesImpl();

  @Test
  public void should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET","nox://foo").header("foo","bar").getHttpHeaders();
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST);
  }

  @Test
  public void should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = MockHttpRequest.create("GET","nox://foo")
                            .header("x-fapi-financial-id","this-is-a-test-id")
                            .header("Authorization","Bearer: cMotDibBl3r")
                            .getHttpHeaders();
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
  }
}
