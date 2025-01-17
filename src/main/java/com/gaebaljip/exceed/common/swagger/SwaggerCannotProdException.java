package com.gaebaljip.exceed.common.swagger;

import com.gaebaljip.exceed.common.exception.EatCeedException;

public class SwaggerCannotProdException extends EatCeedException {
    public static EatCeedException EXCEPTION = new SwaggerCannotProdException();

    private SwaggerCannotProdException() {
        super(SwaggerError.SWAGGER_CANNOT_PROD);
    }
}
