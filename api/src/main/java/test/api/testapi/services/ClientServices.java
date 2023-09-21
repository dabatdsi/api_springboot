package test.api.testapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.api.testapi.entites.Client;
import test.api.testapi.repository.ClientRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServices {
    @Autowired
   private ClientRepository clientRepository;

    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer (Client client){
        Client clientDansDB = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansDB == null){
            this.clientRepository.save(client);

        }


    }
    public List<Client> rechercher(){
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();

        }
        return null;
    }
// methode pour eviter le doublon de client
    public Client lireOuCreer(Client clientAcreer) {
        Client clientDansDB = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientDansDB == null){
            this.clientRepository.save(clientAcreer);

        }

        return clientDansDB ;
    }

    public void modifier(int id, Client client) {
      Client clientDansBD =  this.lire(id); // recuperer client dans la base de donnéé en fonction de id
        // ajout des information recu
        if(clientDansBD.getId()== client.getId()){
            // modification du client
            clientDansBD.setEmail(client.getEmail());
            clientDansBD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansBD);

        }

    }
}


