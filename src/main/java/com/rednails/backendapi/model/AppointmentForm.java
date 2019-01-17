package com.rednails.backendapi.model;

import javax.persistence.*;

@Table(name = "apptform")
@Entity
public class AppointmentForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "services")
    private String services;
    @Column(name = "message")
    private String message;

    public AppointmentForm() {
    }

    public AppointmentForm(String name, String phone, String date, String time, String services, String message) {
        this.name = name;
        this.phone = checkPhone(phone);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSmsMessage() {
        return this.message = name +" " + phone + " request an appointment on " + date +
                " at " + time + " for " + services + " **" + message + "**";
    }
}
