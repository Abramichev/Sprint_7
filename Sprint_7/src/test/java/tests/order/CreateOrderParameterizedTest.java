package tests.order;


import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import object_api.CommonMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.qa.Order;

import java.util.List;

import static constant.ServiceName.BASE_URI_QA_SCOOTER;
import static constant.StatusCode.CODE_201;
import static object_api.OrderMethod.sendPostRequestCreateOrder;

@RunWith(Parameterized.class)
    public class CreateOrderParameterizedTest {

        // Test data
        private final String orderBodyFieldTrack = "track";

        public CreateOrderParameterizedTest(String firstName, String lastName, String address, int metroStation, String phone, int rentTime, String deliveryDate, String comment, List<String> color) {

        }

        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][] {
                    {"Harry", "Potter", "Prospect 1", 1, "+79587", 5, "2023-06-07", "comment1", List.of("BLACK")},
                    {"Harry", "Potter", "Prospect 1", 1, "+79587", 5, "2023-06-07", "comment1", List.of("GREY")},
                    {"Harry", "Potter", "Prospect 1", 1, "+79587", 5, "2023-06-07", "comment1", List.of("BLACK", "GREY")},
                    {"Harry", "Potter", "Prospect 1", 1, "+79587", 5, "2023-06-07", "comment1", List.of()},
            };
        }

        @Test
        @DisplayName("Check create order (parameterized)")
        public void createOrderTest() {
            RestAssured.baseURI = BASE_URI_QA_SCOOTER;
            Order order = new Order();
            Response response = sendPostRequestCreateOrder(order);
            CommonMethod.checkResponseCode(response, CODE_201);
            CommonMethod.checkResponseBodyNotNullField(response, orderBodyFieldTrack);
        }

}
