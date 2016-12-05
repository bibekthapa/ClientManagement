
package com.leapfrog.springjdbc.entity;

import java.util.Date;


//VVI Name in the Client.java and the names in the form inputs must be similiar otherwise the error comes
//So careful consideration must be given

public class Client {
    private int id;
    private String name,email;
      private String  contactNo;
    private Date addedDate;
    private Boolean status;

    public Client(int id, String name, String email, String contactNo, Boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.status = status;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
    
}
