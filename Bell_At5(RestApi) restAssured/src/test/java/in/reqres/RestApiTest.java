package in.reqres;

import Assertions.NewAsserts;
import dto.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Function;

import java.util.*;

import static io.restassured.RestAssured.given;
import static specification.Specification.*;

public class RestApiTest {

    @AfterEach
    public void afterTest() {
        deleteSpec();
    }

    @DisplayName("Проверка аватаров на уникальность")
    @ParameterizedTest
    @MethodSource("helpers.DataProvider#provideCheckingArguments")
    public void checkUniqieAvatar(String url) {
        installSpec(requestSpec(), 200);
        UserData userData = given()
                .when()
                .get(url)
                .then()
                .extract().body().as(UserData.class);
        List<UserDataResponse> usersAvatars = userData.getUserDataResponseList();
        List<String> onlyAvatar = Function.getOnlyAvatar(usersAvatars);
        Set<String> uniqie = Function.getUniqieAvatar(usersAvatars);
        NewAsserts.assertEquals(onlyAvatar, uniqie, "Все аватары уникальны");
    }

    @DisplayName("Проверка успешной авторизации с логином и паролем")
    @ParameterizedTest
    @MethodSource("helpers.DataProvider#provideCheckingSucsessAuth")
    public void checkSucsessAuth(String url, String login, String password) {
        installSpec(requestSpec(), 200);
        CheckAuth newUser = new CheckAuth(login, password);
        CheckAuthSucsecc authResponse = given()
                .body(newUser)
                .when()
                .post(url)
                .then()
                .extract()
                .as(CheckAuthSucsecc.class);
        String token = authResponse.getToken();
        NewAsserts.assertTrue(token != null, "Токен есть");
    }

    @DisplayName("Проверка не успешной авторизации с логином")
    @ParameterizedTest
    @MethodSource("helpers.DataProvider#provideCheckingUnSucsessAuth")
    public void authWithoutPassTest(String url, String login) {
        installSpec(requestSpec(), 400);
        CheckAuth userWithoutPass = new CheckAuth(login);
        CheckAuthError errorResponse = given()
                .body(userWithoutPass)
                .when()
                .post(url)
                .then()
                .extract().as(CheckAuthError.class);
        String error = errorResponse.getError();
        String expected = "Missing password";
        NewAsserts.assertTrue(error.equals(expected),
                "Ошибка" + expected + " получена");
    }

    /**
     * Задание 2.3
     * Используя сервис https://reqres.in/ убедиться, что LIST \<RESOURCE\> возвращает
     * данные отсортированные по годам
     */
    @DisplayName("Проверка, что данные отсортированы по годам")
    @ParameterizedTest
    @MethodSource("helpers.DataProvider#provideCheckingSortYears")
    public void sortYearsTest(String url) {
        installSpec(requestSpec(), 200);
        ResourceInfo pageInfo = given()
                .when()
                .get(url)
                .then()
                .extract()
                .body()
                .as(ResourceInfo.class);
        List<ResourceInfoData> years = pageInfo.getUserDataResponseList();
        List<Integer> actualYears = Function.getActualYear(years);
        List<Integer> sortedYears = Function.getSortedYear(years);
        NewAsserts.assertEqualsYear(actualYears, sortedYears, "Данные отсортированы");
    }

    /**
     * Задание 2.4
     * Используя сервис https://gateway.autodns.com/ убедиться, что количество тегов равно 14.
     */
    @DisplayName("Проверка количество тэгов на странице = 14")
    @ParameterizedTest
    @MethodSource("helpers.DataProvider#provideCheckingCountTag")
    public void Test(String url, int actualTag) {
        String resourse = given()
                .when()
                .get(url)
                .then()
                .log().all()
                .extract().response().xmlPath().prettyPrint();
        List<String> listTag = Function.makeTagList(resourse);
        NewAsserts.assertEqualsSize(actualTag, listTag.size(), "Проверяю, что количество тегов равно: " + actualTag);
    }

}

