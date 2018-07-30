package maufdh.dev.gradetracking.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import maufdh.dev.gradetracking.Application.MyApplication;

public class MDetails extends RealmObject {
    @PrimaryKey
    int id;
    @Required
    String cause;
    @Required
    String annotation;
    public MDetails(){}

    public MDetails(String cause, String annotation) {
        this.id = MyApplication.idMateria.incrementAndGet();
        this.cause = cause;
        this.annotation = annotation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
