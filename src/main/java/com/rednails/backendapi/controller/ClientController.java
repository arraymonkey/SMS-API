package com.rednails.backendapi.controller;


import com.rednails.backendapi.model.Client;
import com.rednails.backendapi.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/clients")
public class ClientController {

    private ClientRepo clientRepo;

    @Autowired
    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Client> getAll() {
        return this.clientRepo.findAll();

    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public Client searchForClient(@RequestBody Client client) {
        Client dataFromDb = clientRepo.findByNameAndPhone(client.getName(), client.getPhone());
        if (dataFromDb == null) {
            clientRepo.save(client);
            return client;

        } else {
            return client;
        }
    }

    public void addClient(String name, String phone) {
        clientRepo.save(new Client(name, phone));
    }


}
