package com.gaebaljip.exceed.common;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Converter
@Component
@RequiredArgsConstructor
public class ColumnEncryptor implements AttributeConverter<String, String> {

    private final Encryption encryption;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }
        return encryption.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return encryption.decrypt(dbData);
    }
}
