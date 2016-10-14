package com.norulesweb.studenttracker.api.services.registration;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({
        RegistrationServiceResponse.class
})
@JsonSubTypes({
        @JsonSubTypes.Type(RegistrationServiceResponse.class)
})
public class RegistrationBaseResponse {
}
