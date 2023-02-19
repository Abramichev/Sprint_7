package object_api;


import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.praktikum.qa.Order;

import static constant.Header.APPLICATION_JSON;
import static constant.Header.CONTENT_TYPE;
import static io.restassured.RestAssured.given;

public class OrderMethod {

    public static final String ORDER_API_CREATE = "/api/v1/orders";
    public static final String ORDER_API_GET_LIST = "/api/v1/orders";

    @Step("Send POST create order")
    public static Response sendPostRequestCreateOrder(Order order) {
        return given().header(CONTENT_TYPE, APPLICATION_JSON).and().body(order).when().post(ORDER_API_CREATE);
    }

    @Step("Send GET get order list")
    public static Response sendGetRequestGetOrderList() {
        return given().get(ORDER_API_GET_LIST);
    }

}
