package agentApp;

import Class.*;
import Class.CheckAuthSucsecc;
import Result.Result;
import Result.Parameters;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Tests {
    private static String token = "a3f1f7e29076fc6ecc4f3b49c7ee8e71c605a37c";
    private static String idDriver = "a3c3eb22-8c1b-4a7a-893a-4bd5364a2ff9";
    private static String idOwner = "df6f3a5a-793f-4acf-b5aa-9c6d9c082a50";
    private static String idInsurance = "13b859be-0f75-4fdb-ae52-7683a85aed09";
    private static String idCar = "97b1f3f9-06e0-48aa-9a19-04021df9a6d9";
    private static String insuranceObject = "ac9a66c9-1e97-48fb-b1b8-005704b15167";
    private static String contractId = "7e1e7581-e7e2-4ea9-81e2-022ad94d5800";

    @DisplayName("Получаю токена авторизации")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkAuth")
    public void TestGetToken(String username, String password, String url) {
        NewUser newUser = new NewUser(username, password);
        CheckAuthSucsecc authResponse = given()
                .contentType("application/json")
                .body(newUser)
                .when()
                .post(url)
                .then()
                .extract().as(CheckAuthSucsecc.class);
        token = authResponse.getToken();
    }

    @DisplayName("Получаю Id водителя")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkDriver")
    public void TestGetDriverId(String payLoad, String url) {
        DriverAnswer driver = given()
                .header("Authorization", "Token " + token)
                .contentType("application/json")
                .body(payLoad)
                .post(url)
                .then()
                .statusCode(201)
                .extract().as(DriverAnswer.class);
        idDriver = driver.getId();
    }

    @DisplayName("Получаю Id собственника")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkOwner")
    public void TestGetOwnerId(String payLoad, String url) {
        Owner owner = given()
                .header("Authorization", "Token " + token)
                .contentType("application/json")
                .body(payLoad)
                .post(url)
                .then()
                .statusCode(201)
                .extract().as(Owner.class);
        idOwner = owner.getPerson();
    }

    @DisplayName("Получаю Id страховщика")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkIncurance")
    public void TestGetInsuranceId(String payLoad, String url) {
        AnswerInsurance answerInsuranceId = given()
                .header("Authorization", "Token " + token)
                .contentType("application/json")
                .body(payLoad)
                .post(url)
                .then()
                .statusCode(201)
                .extract().as(AnswerInsurance.class);
        idInsurance = answerInsuranceId.getPerson();
    }

    @DisplayName("Получаю Id автомобиля")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkCar")
    public void TestGetCarId(String payLoad, String url) {
        Car carId = given()
                .header("Authorization", "Token " + token)
                .contentType("application/json")
                .body(payLoad)
                .post(url)
                .then()
                .statusCode(201)
                .extract().as(Car.class);
        idCar = carId.getId();
    }


    @DisplayName("Получаю объект страхования")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkInsuranceObject")
    public void TestGetInsuranceObjectId(String url) {
        List<String> drivers = new ArrayList<>();
        drivers.add(idDriver);
        Insurance insurance = new Insurance(drivers, idOwner, idCar,
                idInsurance);

        InsuranceObject insuranceID = given()
                .header("Authorization", "Token " + token)
                .contentType("application/json")
                .body(insurance)
                .post(url)
                .then().statusCode(201)
                .extract().as(InsuranceObject.class);
        insuranceObject = insuranceID.getId();
    }

    @DisplayName("Получаю Id договора")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkContract")
    public void TestGetContract(String payLoad, String url) {
        Contract contract = given()
                .header("Authorization", "Token " + token)
                .contentType("application/json")
                .body(payLoad)
                .post(url)
                .then()
                .statusCode(200)
                .extract().as(Contract.class);
        contractId = contract.getId();
    }

    @DisplayName("Внесение объекта страхования в договор")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#checkUpdateContract")
    public void TestUpdateContract(String url) {
        InsuredObject insuredObject = new InsuredObject(insuranceObject);
        Response updateContract = given()
                .header("Authorization", "Token " + token)
                .contentType("application/json")
                .body(insuredObject)
                .patch(url + contractId)
                .then()
                .extract().response();
    }

    @DisplayName("Получение расчета по страховым компаниям")
    @ParameterizedTest
    @MethodSource("helpers.Arguments#getInsuranceCompany")
    public void TestGetResult(List<String> companies) {
        String url = "https://partner.agentapp.ru/v1/agreements/" + contractId + "/results/";
        for (String company : companies) {
            GetResult getResult = new GetResult(contractId, company);
            Response response = given()
                    .header("Authorization", "Token " + token)
                    .contentType("application/json")
                    .body(getResult).post(url + company).then().extract().response();
            Result insuranceID = given()
                    .header("Authorization", "Token " + token)
                    .contentType("application/json")
                    .body(getResult)
                    .post(url + company)
                    .then()
                    .extract().as(Result.class);
            if (response.getStatusCode() == 200) {
                Parameters parameters = insuranceID.getParametersObject();
                System.out.printf("Страховая компания: %s %s %s \n", parameters.getIntegrated_company_title(),
                        parameters.getIntegrated_company_code(), parameters.getPremium());
            } else {
                System.out.printf("Страховая компания: %s %s %s %s %d \n", company, insuranceID.getError(),
                        insuranceID.getDetail(), "Статус код:", response.getStatusCode());
            }
        }
    }
}
