package com.montellano.restclient.service;

import com.montellano.restclient.dao.entity.ClientModel;
import com.montellano.restclient.dao.entity.ClientRepository;
import com.montellano.restclient.data.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client createClient(final Client client){

        ClientModel clientModel = new ClientModel();
        BeanUtils.copyProperties(client, clientModel);
        clientModel=clientRepository.save(clientModel);

        Client clientData = new Client();
        BeanUtils.copyProperties(clientModel, clientData);

        return clientData;
    }

    public List<Client> getClients() {
        List<ClientModel> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);

        List<Client> clientList = new ArrayList<>();
        for (ClientModel clientModel : clients) {
            Client client = new Client();
            BeanUtils.copyProperties(clientModel, client);
            clientList.add(client);
        }

        return clientList;
    }

    public Client getClient(Long id) {

        Optional<ClientModel> client = clientRepository.findById(id);
        Client clientData = new Client();
        BeanUtils.copyProperties(client.get(), clientData);

        return clientData;
    }

    /*
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
     */
}
