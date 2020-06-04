package com.montellano.restclient;

import com.montellano.restclient.data.Client;
import com.montellano.restclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired ClientService clientService;

    /**
     * Retorna toda la lista de clientes
     * @return lista de clientes
     */
    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = clientService.getClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    /**
     * Crea un nuevo cliente en base a un formato json
     * @param client
     * @return nuevo cliente creado
     */
    @PostMapping(value = "/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        final Client clientData = clientService.createClient(client);
        return new ResponseEntity<>(clientData, HttpStatus.CREATED);
    }

    /**
     * Devuelve informacion del cliente en base a su ID
     * @param id
     * @return detalles del cliente
     */
    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        Client client = clientService.getClient(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    /**
     * Remueve un cliente en base a su ID proporcionado
     * @param id
     * @return
     */
    /*
    @DeleteMapping(value = "/client/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */

}
