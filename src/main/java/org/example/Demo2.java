package org.example;

import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Demo2 {
    public  static  void main(String[] args ){
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //recuperer la liste des personnes

        Query<Personne> personneQuery= session.createQuery("from Personne");

        //avec la liste
        List<Personne> personnes = personneQuery.list();
        for (Personne p : personnes){
            System.out.println(p.getNom());
        }
        //avec l'iterator
        Iterator<Personne> personneIterator=personneQuery.iterate();
        while (personneIterator.hasNext()){
            Personne p = (Personne) personneIterator.next();
            System.out.println(p.getNom());
        }
        //Une requete avec un filtre pour recuperer une liste


        Query<Personne>personneQuery1 = session.createQuery("from Personne where nom ='toto'");
        List<Personne>personnes1=personneQuery1.list();
        for (Personne personne :personnes){
            System.out.println(personne.getPrenom());
        }
        //une requete avec un filtre pour recuperer un seul element

        Query<Personne>personneQuery2=session.createQuery("from Personne where id=1");
        Personne personne= personneQuery2.uniqueResult();
        System.out.println(personne.getNom());
    }
}

 



