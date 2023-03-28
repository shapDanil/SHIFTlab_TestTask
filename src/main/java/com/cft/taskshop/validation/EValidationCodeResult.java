package com.cft.taskshop.validation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EValidationCodeResult {

    SERIAL_NUMBER_IS_EMPTY,
    MANUFACTURER_IS_EMPTY,
    PRICE_IS_EMPTY,
    PRICE_LESS_THAN_ZERO,
    AMOUNT_IS_EMPTY,
    AMOUNT_LESS_THAN_ZERO,
    UNKNOWN_ERROR,
    FORM_FACTOR_IS_EMPTY,
    THE_FORM_FACTOR_ENTERED_IS_NOT_CORRECT,
    NO_ERROR,
    LAPTOP_SIZE_IN_INCHES_IS_EMPTY,
    LAPTOP_SIZE_IN_INCHES_IS_WRONG,
    MONITOR_DIAGONAL_IS_LESS_ZERO
    ;

    @JsonSerialize
    String getCode() {return name();}

}
