package tests.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import object_api.CommonMethod;
import object_api.OrderMethod;
import org.junit.BeforeClass;
import org.junit.Test;

import static constant.ServiceName.BASE_URI_QA_SCOOTER;
import static constant.StatusCode.CODE_200;

public class OrderListTest {

    private final String orderBodyFieldOrders = "orders";

    @BeforeClass
    public static void suiteSetup() {
        RestAssured.baseURI = BASE_URI_QA_SCOOTER;
    }

    @Test
    @DisplayName("Check get order list")
    public void checkOrderList() {
        Response response = OrderMethod.sendGetRequestGetOrderList();
        CommonMethod.checkResponseCode(response, CODE_200);
        CommonMethod.checkResponseBodyNotNullField(response, orderBodyFieldOrders);
    }


}
