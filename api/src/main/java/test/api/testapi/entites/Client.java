package test.api.testapi.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String email;
    private String telephone;

    public Client() {
    }

    public Client(int id,String email) {
        this.id = id;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public Client setId(int id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Client setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
}

