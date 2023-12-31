package com.mindhub.homebanking.services;

import com.mindhub.homebanking.DTO.ClientDTO;
import com.mindhub.homebanking.models.Client;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getClientsDTO();
    void saveClient(Client client);
    ClientDTO getClient(Long id);
    Client findById(Long id);
    Client findByEmail(String email);
}
