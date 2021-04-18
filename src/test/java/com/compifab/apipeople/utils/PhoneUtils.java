package com.compifab.apipeople.utils;

import com.compifab.peopleapi.dto.request.PhoneDTO;
import com.compifab.peopleapi.entity.Phone;
import com.compifab.peopleapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "6899459-0092";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final Long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
