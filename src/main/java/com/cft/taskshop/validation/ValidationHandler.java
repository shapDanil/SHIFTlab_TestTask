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

        if (entityCommodity.getSerialNumber() == null)
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
    public static EValidationCodeResult validateDesktopComputer(DesktopComputer desktopComputer) {
        EValidationCodeResult validationCodeResult = validateDesktopComputer(desktopComputer);
        if (validationCodeResult == EValidationCodeResult.NO_ERROR) {
            if (desktopComputer.getFormFactor() == null) {
                return EValidationCodeResult.FORM_FACTOR_IS_EMPTY;
            } else {
                if (!desktopComputer.getFormFactor().equalsIgnoreCase("моноблок") &&
                    !desktopComputer.getFormFactor().equalsIgnoreCase("десктоп") &&
                    !desktopComputer.getFormFactor().equalsIgnoreCase("неттоп")) {
                    return EValidationCodeResult.THE_FORM_FACTOR_ENTERED_IS_NOT_CORRECT;
                }
            }
        } else {
            return validationCodeResult;
        }
        return EValidationCodeResult.NO_ERROR;
    }

}
