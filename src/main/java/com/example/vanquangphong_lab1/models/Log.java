package com.example.vanquangphong_lab1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "log")
public class   Log {
    @Id
    private String account_id;
    private Date login_time;
    private Date logout_time;
    private String notes;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log() {
    }

    public Log(String account_id, Date login_time, Date logout_time, String notes) {
        this.account_id = account_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "account_id='" + account_id + '\'' +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
