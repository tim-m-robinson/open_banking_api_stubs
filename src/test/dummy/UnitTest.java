package net.atos.openbanking.api;

import org.apache.http.HttpStatus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class UnitTest {

  ServicesImpl test = new ServicesImpl();

  @Test
  public void should_return_bad_request() throws Exception {
    //Given
    HttpHeaders headers = mock(HttpHeaders.class);
    when(headers.getRequestHeader(anyString()))
            .thenReturn(Arrays.asList(""));
    when(headers.getRequestHeader("foo"))
            .thenReturn(Arrays.asList("bar"));
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST);
  }

  @Test
  public void should_return_ok() throws Exception {
    //Given
    HttpHeaders headers = mock(HttpHeaders.class);
    when(headers.getRequestHeader(anyString()))
            .thenReturn(Arrays.asList(""));
    when(headers.getRequestHeader("x-fapi-financial-id"))
            .thenReturn(Arrays.asList("this-is-a-test"));
    when(headers.getRequestHeader("Authorization"))
            .thenReturn(Arrays.asList("Bearer: cMotDibBl3r"));
    //When
    Response response = test.getAccounts(headers);
    //Then
    Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
  }
}
