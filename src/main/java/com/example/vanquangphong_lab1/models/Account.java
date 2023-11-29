package com.example.vanquangphong_lab1.models;

import com.example.vanquangphong_lab1.respository.GrantAccessRepository;
import com.example.vanquangphong_lab1.respository.RoleRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity()
public class Account {
    @Id
    private String account_id;
    private String full_name;
    private String password;
    private String email;
    private String phone;
    private int status;

    public String getAccount_id() {
        return account_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account() {
    }

    public Account(String account_id, String full_name, String password, String email, String phone, int status) {
        this.account_id = account_id;
        this.full_name = full_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id='" + account_id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
    public Role getRole() throws Exception {
        GrantAccessRepository grantAccessResposotory = new GrantAccessRepository();
        RoleRepository roleRespository = new RoleRepository();
        Role role = roleRespository.getById(grantAccessResposotory.getRoleID(this.account_id));
        return role;
    }
}
