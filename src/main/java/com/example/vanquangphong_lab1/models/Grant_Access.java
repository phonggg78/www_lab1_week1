package com.example.vanquangphong_lab1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "grant_acess")
public class Grant_Access {
    private Isgrant is_grant;
    private  String note;
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accout_id;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Grant_Access(Account accout_id, Isgrant is_grant, String note, Role role) {
        this.accout_id = accout_id;
        this.is_grant = is_grant;
        this.note = note;
        this.role = role;
    }

    public Grant_Access() {
    }

    public Account getAccout_id() {
        return accout_id;
    }

    public void setAccout_id(Account accout_id) {
        this.accout_id = accout_id;
    }

    public Isgrant getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(Isgrant is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
