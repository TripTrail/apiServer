package com.company.application.co;

import com.company.application.enums.Gender;
import com.company.application.validation.EnumValidator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import static com.company.application.constants.ValidationConstants.*;

public class RegistrationDetailsCO {

    @Email(message = EMAIL_MANDATORY)
    @NotEmpty(message = EMAIL_INVALID)
    private String emailId;

    @NotEmpty(message = PASSWORD_MANDATORY)
    private String password;

    @NotEmpty(message = FIRST_NAME_MANDATORY)
    private String firstName;

    @NotEmpty(message = LAST_NAME_MANDATORY)
    private String lastName;

    private String middleName;

    @NotEmpty(message = GENDER_MANDATORY)
    @EnumValidator(enumClass = Gender.class, message = GENDER_INVALID)
    private String gender;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
