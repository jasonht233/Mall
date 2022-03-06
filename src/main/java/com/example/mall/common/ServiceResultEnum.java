package com.example.mall.common;

public enum ServiceResultEnum {
    ERROR("error"),
    SUCCESS("success"),

    DATA_NOT_EXIST("Not found data"),
    PARAM_ERROR("Wrong Parameter"),
    SAME_CATEGORY_EXIST("Same name/level object exist"),

    SAME_LOGIN_NAME_EXIST("Login Name exist"),
    LOGIN_NAME_NULL("Please enter Null Name"),
    LOGIN_NAME_IS_NOT_PHONE("Please enter correct phone name"),
    LOGIN_PASSWORD_NULL("Enter Password"),
    LOGIN_VERIFY_CODE_NULL("Ender Varify code"),
    LOGIN_VERIFY_CODE_ERROR("Wrong Varify code"),

    SAME_INDEX_CONFIG_EXIST("Existed same page"),
    GOODS_CATEGORY_ERROR("Classification error"),
    SAME_GOODS_EXIST("Existed same good"),
    GOODS_NOT_EXIST("Good doesn't exist"),
    GOODS_PUT_DOWN("Good has been put down"),

    SHOPPING_CART_ITEM_LIMIT_NUMBER_ERROR("exceed number of single good"),
    SHOPPING_CART_ITEM_NUMBER_ERROR("item number should not less than 1"),
    SHOPPING_CART_ITEM_TOTAL_NUMBER_ERROR("Out of cart bound"),
    SHOPPING_CART_ITEM_EXIST_ERROR("item existed"),

    LOGIN_ERROR("Login Failure"),
    NOT_LOGIN_ERROR("Doesn't login"),
    ADMIN_NOT_LOGIN_ERROR("Admin doesn't login"),
    TOKEN_EXPIRE_ERROR("Token expire, re-login"),
    ADMIN_TOKEN_EXPIRE_ERROR("Admin login token expire"),
    USER_NULL_ERROR("user doesn't exist"),
    LOGIN_USER_LOCKED_ERROR("Prohibted login"),

    ORDER_NOT_EXIST_ERROR("Order doesn't exist"),
    ORDER_ITEM_NOT_EXIST_ERROR("Order item doesn't exist"),

    NULL_ADDRESS_ERROR("Address cannot be empty"),
    ORDER_PRICE_ERROR("order price abnormal"),
    ORDER_ITEM_NULL_ERROR("Order item abnormal"),
    ORDER_GENERATE_ERROR("Order creation fails"),
    SHOPPING_ITEM_ERROR("Cart data abnormal"),
    SHOPPING_ITEM_COUNT_ERROR("storage is not enough"),
    ORDER_STATUS_ERROR("Abnormal order"),
    OPERATE_ERROR("Operation Failure"),

    REQUEST_FORBIDEN_ERROR("Forbidden Behavior"),
    NO_PERMISSION_ERROR("No Authority"),
    DB_ERROR("database error");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

}
