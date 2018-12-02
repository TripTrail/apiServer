package com.company.application.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHERS("Others");

    final String value;

    Gender(String value){
        this.value = value;
    }

}
