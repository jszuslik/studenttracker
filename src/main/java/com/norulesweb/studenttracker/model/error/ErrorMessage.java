package com.norulesweb.studenttracker.model.error;

import com.norulesweb.studenttracker.model.common.AuditableModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
        schema = "studenttracker",
        name = "ERRORS"
)
public class ErrorMessage extends AuditableModelBase {

    private String errorMessage;

    public ErrorMessage() { }

    @Column(name = "ERROR_MSG")
    public String getErrorMessage() { return errorMessage; }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
