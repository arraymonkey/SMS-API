package com.rednails.backendapi.controller;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageCreateResponse;
import com.rednails.backendapi.model.Appointment;
import com.rednails.backendapi.model.AppointmentForm;
import com.rednails.backendapi.model.Client;
import com.rednails.backendapi.repository.AppointmentRopo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/appointment")
public class AppointmentController {

    private AppointmentRopo appointmentRopo;
    private ClientController clientController;

    @Autowired
    public AppointmentController(AppointmentRopo appointmentRopo) {
        this.appointmentRopo = appointmentRopo;

    }

    @Autowired
    public void ClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    @RequestMapping(value = "/add_appt", method = RequestMethod.POST)
    public Appointment requestAppt(@RequestBody AppointmentForm appointmentForm) {
        Client client = clientController.searchForClient(new Client(appointmentForm.getName(), appointmentForm.getPhone()));
        System.out.println(appointmentForm.checkPhone(appointmentForm.getPhone()));

        sendSmsMessage(appointmentForm);
        return appointmentRopo.save(new Appointment(client.getId(), appointmentForm.getDate(), appointmentForm.getTime(),
                appointmentForm.getServices(), appointmentForm.getMessage()));

    }


    private void sendSmsMessage(AppointmentForm appointmentForm) {
        Plivo.init("API-KEY", "PUBLIC-KEY");

        try {
            MessageCreateResponse response = Message.creator("PLIVO#", Collections.singletonList("RECIEVER#"), appointmentForm.getSmsMessage())
                    .create();

            System.out.println(response);
        } catch (PlivoRestException | IOException e) {

            e.printStackTrace();
        }
    }

}
