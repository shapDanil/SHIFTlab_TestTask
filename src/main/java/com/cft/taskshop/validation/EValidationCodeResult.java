package com.cft.taskshop.validation;

public enum EValidationCodeResult {

    ALL_FIELDS_ARE_EMPTY,
    SOME_FIELDS_ARE_EMPTY,
    SERIAL_NUMBER_IS_EMPTY,
    MANUFACTURER_IS_EMPTY,
    PRICE_IS_EMPTY,
    PRICE_LESS_THAN_ZERO,
    AMOUNT_IS_EMPTY,
    AMOUNT_LESS_THAN_ZERO,
    UNKNOWN_ERROR,
    NO_ERROR,
    ;
}
