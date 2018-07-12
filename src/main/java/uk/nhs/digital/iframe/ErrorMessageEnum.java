package uk.nhs.digital.iframe;

public enum ErrorMessageEnum {

    //consumer data validation
    GIVEN_NAME_EMPTY("<p>The patient's given name was not included in request.</p>"),
    FAMILY_NAME_EMPTY("<p>The patient's family name was not included in request.</p>"),
    BIRTHDATE_EMPTY("<p>The patient's birth date was not included in request.</p>"),
    BIRTHDATE_INVALID("<p>The patient's birth date is not in a valid format. Please see the GP Connect specification for the correct date/time format.</p>"),
    ODS_CODE_EMPTY("<p>The target organization ODS Code was not included in request.</p>"),
    GENDER_EMPTY("<p>The patient's gender was not included in request.</p>");


    ErrorMessageEnum(String message) {
        this.setMessage(message);
    }

    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
