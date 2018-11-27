package com.company.application.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHERS("Others");

    private String value;

    Gender(String value){
        this.value = value;
    }

}
