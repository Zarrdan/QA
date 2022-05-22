package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Arguments {
    public static Stream<org.junit.jupiter.params.provider.Arguments> checkAuth() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("qa@qa.qa", "111", "https://partner.agentapp.ru/v1/users/obtain-token")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> checkDriver() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("{\r\n  \"first_name\": \"Имя\",\r\n  " +
                        "\"last_name\": \"Фамилия\",\r\n  \"patronymic\": \"Отчество\",\r\n " +
                        " \"birth_date\": \"1990-01-01\",\r\n  \"driving_experience_started\": " +
                        "\"2010-10-10\",\r\n  \"driver_licenses\": [\r\n    {\r\n      \"credential_type\": \"DRIVER_LICENSE\",\r\n  " +
                        "    \"number\": \"012345\",\r\n      \"series\": \"1234\",\r\n   " +
                        "   \"issue_date\": \"2010-10-10\"\r\n    }\r\n  ]\r\n}", "https://partner.agentapp.ru/v1/insured_objects/drivers")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> checkOwner() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("{\r\n  \"last_name\": \"Фамилия\",\r\n  \"first_name\": " +
                                "\"Имя\",\r\n  \"patronymic\": \"Отчество\",\r\n  \"birth_date\": \"1990-01-01\",\r\n  " +
                                "\"credential\": [\r\n    {\r\n      \"credential_type\": \"RUSSIAN_INTERNAL_PASSPORT\",\r\n    " +
                                "  \"issue_date\": \"2017-03-08\",\r\n      \"issue_point\": \"УФМС\",\r\n    " +
                                "  \"issue_point_code\": \"123-456\",\r\n      \"number\": \"123456\",\r\n    " +
                                "  \"series\": \"1234\"\r\n    }\r\n  ],\r\n  \"address\": [\r\n    {\r\n    " +
                                "  \"address_query\": \"г Санкт-Петербург, г Ломоносов, ул Швейцарская, д 1 к 1, кв 1\",\r\n " +
                                "     \"address_type\": \"LEGAL_ADDRESS\",\r\n      \"region_kladr_id\": \"7800000000000\",\r\n  " +
                                "    \"city_kladr_id\": \"7800000600000\"\r\n    },\r\n    {\r\n   " +
                                "   \"address_query\": \"г Санкт-Петербург, г Ломоносов, ул Швейцарская, д 1 к 1, кв 1\",\r\n   " +
                                "   \"address_type\": \"ACTUAL_ADDRESS\",\r\n      \"region_kladr_id\": \"7800000000000\",\r\n   " +
                                "   \"city_kladr_id\": \"7800000600000\"\r\n    }\r\n      ]\r\n}\r\n\r\n\r\n",
                        "https://partner.agentapp.ru/v1/insured_objects/owners/natural_persons")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> checkIncurance() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("{\r\n  \"last_name\": \"Фамилия\",\r\n " +
                                " \"first_name\": \"Имя\",\r\n  \"patronymic\": \"Отчество\",\r\n  \"birth_date\":" +
                                " \"1990-01-01\",\r\n  \"credential\": [\r\n    {\r\n      \"credential_type\": " +
                                "\"RUSSIAN_INTERNAL_PASSPORT\",\r\n      \"issue_date\": \"2010-10-10\",\r\n    " +
                                "  \"issue_point\": \"УФМС\",\r\n      \"issue_point_code\": \"123-456\",\r\n   " +
                                "   \"number\": \"123456\",\r\n      \"series\": \"1234\"\r\n    }\r\n  ],\r\n  " +
                                "\"address\": [\r\n    {\r\n      \"address_query\": \"г Санкт-Петербург, г Ломоносов," +
                                " ул Швейцарская, д 1 к 1, кв 1\",\r\n      \"address_type\": \"LEGAL_ADDRESS\",\r\n    " +
                                "  \"region_kladr_id\": \"7800000000000\",\r\n      \"city_kladr_id\": \"7800000600000\"\r\n " +
                                "   },\r\n    {\r\n      \"address_query\": \"г Санкт-Петербург, г Ломоносов, ул Швейцарская," +
                                " д 1 к 1, кв 1\",\r\n      \"address_type\": \"ACTUAL_ADDRESS\",\r\n      \"region_kladr_id\":" +
                                " \"7800000000000\",\r\n      \"city_kladr_id\": \"7800000600000\"\r\n    }\r\n  ],\r\n " +
                                " \"contact\": [\r\n        {\r\n            \"contact_type\": \"EMAIL\",\r\n          " +
                                "  \"data\": \"lol@mail.ru\"\r\n        },\r\n        {\r\n            \"contact_type\": " +
                                "\"PHONE\",\r\n            \"data\": \"+7 (777) 222-33-44\"\r\n        }\r\n    ]\r\n}\r\n",
                        "https://partner.agentapp.ru/v1/insured_objects/insurants/natural_persons")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> checkCar() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("{\r\n  \"car_model_id\": 864026180,\r\n " +
                                " \"engine_power\": 211,\r\n  \"vin_number\": \"WAUZZZ8T4BA037241\",\r\n  \"number_plate\":" +
                                " \"Р904МХ178\",\r\n  \"manufacturing_year\": 2010,\r\n  \"max_mass\": null,\r\n  " +
                                "\"credential\": [\r\n    {\r\n      \"credential_type\": \"VEHICLE_REGISTRATION\",\r\n   " +
                                "   \"issue_date\": \"2010-11-01\",\r\n      \"number\": \"267461\",\r\n  " +
                                "    \"series\": \"78УН\"\r\n    }\r\n  ]\r\n}",
                        "https://partner.agentapp.ru/v3/insured_objects/cars")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> checkInsuranceObject() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("https://partner.agentapp.ru/v1/insured_objects/")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> checkContract() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("{\r\n    \"valid_from\": \"2022-05-07\",\r\n " +
                                "   \"valid_to\": \"2023-05-06\",\r\n    \"insurance_period\": 8,\r\n " +
                                "   \"target_of_using\": 11,\r\n    \"drivers_ids\": " +
                                "[\"a3c3eb22-8c1b-4a7a-893a-4bd5364a2ff9\"],\r\n    " +
                                "\"is_car_without_registration\": false,\r\n    \"engine_power\": 211,\r\n  " +
                                "  \"has_car_trailer\": false,\r\n    \"car_type\": \"B\",\r\n  " +
                                "  \"owner_registration\": {\r\n      \"address_query\":" +
                                " \"г Санкт-Петербург, г Ломоносов, ул Швейцарская, д 1 к 1, кв 1\",\r\n   " +
                                "   \"address_type\": \"LEGAL_ADDRESS\",\r\n     " +
                                " \"region_kladr_id\": \"7800000000000\",\r\n      \"city_kladr_id\": " +
                                "\"7800000600000\"\r\n    },\r\n    \"periods\": null\r\n}",
                        "https://partner.agentapp.ru/v3/agreements/calculations")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> checkUpdateContract() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("https://partner.agentapp.ru/v1/agreements/")
        );
    }

    public static Stream<org.junit.jupiter.params.provider.Arguments> getInsuranceCompany() {
        List<String> company = new ArrayList<>();
        company.add("RENAISSANCE");
        company.add("ZETTA");
        company.add("ALPHA_STRAH");
        company.add("SDS");
        company.add("RGS");
        company.add("SNGI");
        company.add("UGORIA");
        company.add("INGOSSTRAH");
        company.add("TINKOFF");
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(company)
        );
    }
}
