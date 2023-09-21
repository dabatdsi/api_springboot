package test.api.testapi.entites;

import jakarta.persistence.*;
import test.api.testapi.enums.TypeSentiment;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private TypeSentiment type;
    @ManyToOne(cascade={PERSIST , MERGE} ) //persist c ajouter leclient dans la db et merge on fusione les infos
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String texte, TypeSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public Sentiment setId(int id) {
        this.id = id;
        return this;
    }

    public String getTexte() {
        return texte;
    }

    public Sentiment setTexte(String texte) {
        this.texte = texte;
        return this;
    }

    public TypeSentiment getType() {
        return type;
    }

    public Sentiment setType(TypeSentiment type) {
        this.type = type;
        return this;
    }

    public Client getClient() {
        return client;
    }

    public Sentiment setClient(Client client) {
        this.client = client;
        return this;
    }
}
