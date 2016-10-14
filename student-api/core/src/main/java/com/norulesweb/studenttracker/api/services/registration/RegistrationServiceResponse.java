package com.norulesweb.studenttracker.api.services.registration;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, include= JsonTypeInfo.As.PROPERTY, property="@class")
public class RegistrationServiceResponse extends RegistrationBaseResponse {
}
