package net.atos.openbanking.api;

import org.apache.http.HttpStatus;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//import org.apache.cxf.jaxrs.impl.HttpHeadersImpl;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@RunWith(Arquillian.class)
public class UnitTest {

  @Deployment
  public static WebArchive createDeployment() {
    // Gather runtime dependencies from POM
    File[] files = Maven.resolver().loadPomFromFile("pom.xml")
            .importRuntimeDependencies().resolve().withTransitivity().asFile();

    WebArchive war = ShrinkWrap.create(WebArchive.class, "open-banking-api-test.war")
            .addClasses(Services.class, ServicesImpl.class)
            .addAsLibraries(files)
            .addAsResource("data/getAccounts.json")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    System.out.println(war.toString(true));
    return war;
  }

  @Inject
  private ServicesImpl test1;

  //ServicesImpl test = new ServicesImpl();

  @Test
  public void tmp() {
    if (test1 != null) {
      System.out.println("*** " + test1.toString());
    } else {
      System.out.println("*** NULL");
    }
  }

  @ArquillianResource
  URL url;

  @Test
  @RunAsClient()
  public void do_stuff() {
    given().
    when().
      get(url + "open-banking/accounts").
    then().
      assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
  }

/*

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
*/
}
