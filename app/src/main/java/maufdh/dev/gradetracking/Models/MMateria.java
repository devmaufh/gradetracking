package maufdh.dev.gradetracking.Models;

import android.util.Log;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import maufdh.dev.gradetracking.Application.MyApplication;

public class MMateria extends RealmObject {
    @PrimaryKey
    int id;
    @Required
    String name;
    String teacher;
    String semester;
    int p1,p2,p3,p4,p5;

    public int getIdportada() {
        return idportada;
    }

    public void setIdportada(int idportada) {
        this.idportada = idportada;
    }

    public int idportada;
    RealmList<MDetails> detailsList;
    public MMateria(){}

    public MMateria(String name, String teacher, String semester, int p1, int p2, int p3, int p4, int p5) {
        this.id = MyApplication.idMateria.incrementAndGet();
        Log.w(" -   -   -IDENTIFICADOR", "id: "+id);
        this.name = name;
        this.teacher = teacher;
        this.semester = semester;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        detailsList = new RealmList<MDetails>();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public int getP1() {
        return p1;
    }
    public void setP1(int p1) {
        this.p1 = p1;
    }
    public int getP2() {
        return p2;
    }
    public void setP2(int p2) {
        this.p2 = p2;
    }
    public int getP3() {
        return p3;
    }
    public void setP3(int p3) {
        this.p3 = p3;
    }
    public int getP4() {
        return p4;
    }
    public void setP4(int p4) {
        this.p4 = p4;
    }
    public int getP5() {
        return p5;
    }
    public void setP5(int p5) {
        this.p5 = p5;
    }

    public RealmList<MDetails> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(RealmList<MDetails> detailsList) {
        this.detailsList = detailsList;
    }
}
