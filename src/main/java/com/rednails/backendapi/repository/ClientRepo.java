package com.rednails.backendapi.repository;

import com.rednails.backendapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByNameAndPhone(String name, String phone);
}
