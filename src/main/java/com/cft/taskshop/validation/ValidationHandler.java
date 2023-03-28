package com.cft.taskshop.validation;

import com.cft.taskshop.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public EValidationCodeResult handleAnyException(Throwable e) {
        return EValidationCodeResult.UNKNOWN_ERROR;
    }
    public static EValidationCodeResult validateCommodity(Сommodity entityCommodity ) {
        if (entityCommodity.getSerialNumber() == null && entityCommodity.getManufacturer() == null
                && entityCommodity.getPrice() == 0 && entityCommodity.getAmount() == 0)
            return EValidationCodeResult.ALL_FIELDS_ARE_EMPTY;

        if (entityCommodity.getSerialNumber().equals(""))
            return EValidationCodeResult.SERIAL_NUMBER_IS_EMPTY;

        if (entityCommodity.getManufacturer() == null)
            return EValidationCodeResult.MANUFACTURER_IS_EMPTY;

        if (entityCommodity.getPrice() == 0)
            return EValidationCodeResult.PRICE_IS_EMPTY;

        if (entityCommodity.getPrice() < 0)
            return EValidationCodeResult.PRICE_LESS_THAN_ZERO;

        if (entityCommodity.getAmount() == 0)
            return EValidationCodeResult.AMOUNT_IS_EMPTY;

        if (entityCommodity.getAmount() < 0)
            return EValidationCodeResult.AMOUNT_LESS_THAN_ZERO;

        return EValidationCodeResult.NO_ERROR;
    }

}
