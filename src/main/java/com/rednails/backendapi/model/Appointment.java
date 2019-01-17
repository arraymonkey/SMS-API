package com.rednails.backendapi.model;


import javax.persistence.*;

@Table(name = "appointment")
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "client_id")
    private long client_id;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "services")
    private String services;
    @Column(name = "message")
    private String message;


    public Appointment(long client_id, String date, String time, String services, String message) {
        this.client_id = client_id;
        this.date = date;
        this.time = time;
        this.services = services;
        this.message = message;
    }

    public String checkPhone(String phone) {
        if (phone.length() == 10) {
            return "1" + phone;
        } else {
            return phone;
        }
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public Appointment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getMessage() {
        return message;
    }


}
