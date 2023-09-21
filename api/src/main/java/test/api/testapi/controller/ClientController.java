package test.api.testapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import test.api.testapi.entites.Client;
import test.api.testapi.services.ClientServices;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")

public class ClientController {
    private ClientServices clientServices;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Client client){
        this.clientServices.creer(client);

    }
    @GetMapping(produces= APPLICATION_JSON_VALUE)
    public List<Client> rechercher(){

        return  this.clientServices.rechercher();
    }
    @GetMapping(path = "{id}" , produces= APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id){
        return this.clientServices.lire(id);
    }
    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "{id}",consumes = APPLICATION_JSON_VALUE)
    public void modifier(@PathVariable int id ,@RequestBody Client client){
       this.clientServices.modifier(id,client) ;

    }
}
