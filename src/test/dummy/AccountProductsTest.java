package net.atos.openbanking.api;

import org.apache.http.HttpStatus;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


@RunWith(Arquillian.class)
public class AccountProductsTest {

    private final String endPoint = "open-banking/accounts/22289/products";
    private final String valid_bearer_token = "cMotDibBl3r";

    @Deployment
    public static WebArchive createDeployment() {
        // Gather runtime dependencies from POM
        File[] files = Maven.resolver().loadPomFromFile("pom.xml")
                .importRuntimeDependencies().resolve().withTransitivity().asFile();

        WebArchive war = ShrinkWrap.create(WebArchive.class, "open-banking-api-test.war")
                .addClasses(Services.class, ServicesImpl.class)
                .addAsLibraries(files)
                .addAsResource("data/getAccountProducts22289.json")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(war.toString(true));
        return war;
    }

    @ArquillianResource
    URL deploymentUrl;

    // BASIC TESTS

    @Test
    @InSequence(1)
    public void should_check_test_framework() {
        Assert.assertTrue(true);
    }

    @Test
    @InSequence(2)
    public void should_have_url() {
        Assert.assertNotNull(deploymentUrl);
        System.out.println(deploymentUrl);
    }

    // API TESTS

    @Test
    @RunAsClient
    @InSequence(3)
    public void should_return_bad_request() {
        given().
        expect().
          statusCode(HttpStatus.SC_BAD_REQUEST).
        when().
          get(deploymentUrl + endPoint);
    }

    @Test
    @RunAsClient
    @InSequence(4)
    public void should_return_not_acceptable() {
        given().
          header(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML).
        expect().
          statusCode(HttpStatus.SC_NOT_ACCEPTABLE).
        when().
          get(deploymentUrl + endPoint);
    }

    @Test
    @RunAsClient
    @InSequence(5)
    public void should_return_unauthorized_empty_header() {
        given().
          header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
          header("x-fapi-financial-id", "OB/1234/ABC").
          header(HttpHeaders.AUTHORIZATION,"").
        expect().
          statusCode(HttpStatus.SC_UNAUTHORIZED).
        when().
          get(deploymentUrl + endPoint);
    }

    @Test
    @RunAsClient
    @InSequence(6)
    public void should_return_unauthorized_invalid_auth_scheme() {
        given().
          header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
          header("x-fapi-financial-id", "OB/1234/ABC").
          header(HttpHeaders.AUTHORIZATION,"Basic QWxhZGRpbjpPcGVuU2VzYW1l").
        expect().
          statusCode(HttpStatus.SC_UNAUTHORIZED).
        when().
          get(deploymentUrl + endPoint);
    }

    @Test
    @RunAsClient
    @InSequence(7)
    public void should_return_forbidden_invalid_bearer_token() {
        given().
          header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
          header("x-fapi-financial-id", "OB/1234/ABC").
          header(HttpHeaders.AUTHORIZATION,"Bearer noTauTh0riz3d").
        expect().
          statusCode(HttpStatus.SC_FORBIDDEN).
        when().
          get(deploymentUrl + endPoint);
    }

    @Test
    @RunAsClient
    @InSequence(8)
    public void should_return_data() {
        given().
          header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
          header(HttpHeaders.AUTHORIZATION, "Bearer " + valid_bearer_token).
          header("x-fapi-financial-id", "OB/1234/ABC").
          header("x-fapi-interaction-id", "9876-ABCD-1234-ZYXW").
        expect().
          statusCode(HttpStatus.SC_OK).
          header("x-fapi-interaction-id", "9876-ABCD-1234-ZYXW").
          that().header("x-jws-signature", notNullValue()).
          that().body("Data.Product.ProductIdentifier", notNullValue()).
        when().
          get(deploymentUrl + endPoint);
    }

}
