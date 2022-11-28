package org.example.entities;

//hibernate utilise les meme annotation que JPA

import javax.persistence.*;

@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID ;

    @Column(name = "nom")//optionnel dans le cadre ou le nom de la col est different de l'atribut
    private  String nom;

    private  String prenom;

    private int  age;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  int getAge(){return  age;}

}
