package nl.agility.commons.actuator.test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

public abstract class BaseActuatorIntegrationTest extends BaseTest {

    public static final String OPS_URI = "/ops";

    protected String username = "gebruiker";
    protected String password = "raadjenooit";

    @Value("${info.app.name}")
    protected String appName;

    @Value("${info.app.description}")
    protected String appDescription;

    @Value("${info.app.version}")
    protected String appVersion;

    @Test
    public void verifyHealthEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/health")
                .then()
                .statusCode(SC_OK)
                .contentType(JSON)
                .body("status", equalTo("UP"))
                .body("diskSpace.status", equalTo("UP"))
        ;
    }

    @Test
    public void verifyHealthEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/health")
                .then()
                .statusCode(SC_OK)
                .contentType(JSON)
                .body("status", equalTo("UP"))
        ;
    }

    @Test
    public void verifyInfoEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/info")
                .then()
                .statusCode(SC_OK)
                .contentType(JSON)
                .body("app.name", equalTo(appName))
                .body("app.description", equalTo(appDescription))
                .body("app.version", equalTo(appVersion))
        ;
    }

    @Test
    public void verifyInfoEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/info")
                .then()
                .statusCode(SC_OK)
                .contentType(JSON)
                .body("app.name", equalTo(appName))
                .body("app.description", equalTo(appDescription))
                .body("app.version", equalTo(appVersion))
        ;
    }

    @Test
    public void verifyAutoconfigEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/autoconfig")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyAutoconfigEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/autoconfig")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

    @Test
    public void verifyBeansEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/beans")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyBeansEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/beans")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

    @Test
    public void verifyConfigpropsEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/configprops")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyConfigpropsEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/configprops")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

    @Test
    public void verifyDumpEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/dump")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyDumpEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/dump")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

    @Test
    public void verifyEnvEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/env")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyEnvEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/env")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

    @Test
    public void verifyMappingsEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/mappings")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyMappingsEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/mappings")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

    @Test
    public void verifyMetricsEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/metrics")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyMetricsEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/metrics")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

    @Test
    public void verifyTraceEndpoint() {
        given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(OPS_URI + "/trace")
                .then()
                .statusCode(SC_OK)
        ;
    }

    @Test
    public void verifyTraceEndpointWithoutBasicAuthentication() {
        given()
                .when()
                .get(OPS_URI + "/trace")
                .then()
                .statusCode(SC_UNAUTHORIZED)
        ;
    }

}
