package test.api.testapi.services;

import org.springframework.stereotype.Service;
import test.api.testapi.entites.Client;
import test.api.testapi.entites.Sentiment;
import test.api.testapi.enums.TypeSentiment;
import test.api.testapi.repository.SentimentRepository;

import java.util.List;

@Service

public class SentimentServices {
    private ClientServices clientServices;  // pour eviter les doublons
    private SentimentRepository sentimentRepository;

    public SentimentServices(ClientServices clientServices, SentimentRepository sentimentRepository) {
        this.clientServices = clientServices;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment) {
        Client client = this.clientServices.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        // analyse

        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        } else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);


    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);

        }
    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
