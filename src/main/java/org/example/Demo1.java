package org.example;

import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo1 {
    public static void main(String [] args){
        //Creation d'un registre pour charger la configuation à partir de notre fichier de configuration
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        //creation de la session
        Session session = sessionFactory.openSession();
        //des l'ouverture de la session, et en fonction de la proprieté hibernate.hbm2ddl.auto
        //hibernate va agir sur la base de données

       // l'ajout d'une personne
        Personne p = new Personne();
        p.setNom("toto");
        p.setPrenom("tata");
        session.save(p);
        System.out.println("Id : "+ p.getID());

        //recuperer une persoone
        //c'est important d'être dans la meme transaction si on souhaite modifier ou supprimer

        session.getTransaction().begin();
        Personne p2 = session.load(Personne.class, Long.valueOf(1));
        System.out.println(p2.getNom());

        //Modifier
        p2.setPrenom("titi");
        session.update(p2);

        //Suppression

        session.delete(p);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
