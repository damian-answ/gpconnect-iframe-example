package uk.nhs.digital.iframe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uk.nhs.digital.iframe.model.AccessRecordBody;
import uk.nhs.digital.iframe.model.AccessRecordHeader;
import uk.nhs.digital.iframe.model.PatientDemographics;

import java.util.Base64;

public class JWTForAccessRecord {
    ObjectMapper objectMapper = new ObjectMapper();

    public String getJWT(String username, String password, String token, PatientDemographics patientDemographics) throws JsonProcessingException {

        String encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        AccessRecordHeader header = new AccessRecordHeader()
                .withAlg("HS256")
                .withTyp("JWT")
                .withAuthorisation("Basic " + encoding);


        final AccessRecordBody payload = new AccessRecordBody()
                .withClientId(username)
                .withUsername("Jack")
                .withClientCredentials(password)
                .withToken(token)
                .withSection("ENC")
                .withPatientDemographics(patientDemographics)
                .withStartDate("2015-12-01T12:00:00+00:00")
                .withEndDate("2017-12-12T12:00:00+00:00");


        String headerStr = objectMapper.writeValueAsString(header);
        String payloadStr = objectMapper.writeValueAsString(payload);

        String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(headerStr.getBytes());
        String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payloadStr.getBytes());

        String jwtString = encodedHeader + "." + encodedPayload + ".";

        return jwtString;

    }
}
