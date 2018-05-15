package hiberApp;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import model.Adres;
import model.Ocena;
import model.Osoba;
import model.Pracownik;
import model.Przedmiot;
import model.Student;
import model.Test;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zti
 */
public class Main {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //create(); 
       showAll();
    }
    
    private static void showAll() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("from java.lang.Object");
            query.setComment("All objects list");
            List<Object> all = query.list();
            all.forEach(System.out::println);
        }
    }
    
    private static void create() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            
            Adres adres = new Adres("1", "2", "3", "4", "5");
            session.save(adres);
            Osoba o1 = new Osoba("Jan", "Kowalski", "11");
            o1.setAdres(adres);
            session.save(o1);
            
            Adres adres1 = new Adres("11", "22", "33", "44", "55");
            session.save(adres1);
            Osoba o2 = new Osoba("Tomasz", "Barański", "22");
            o2.setAdres(adres1);
            session.save(o2);
            
            Przedmiot przed1 = new Przedmiot("nazwa", "kier", "semestr");
            session.save(przed1);
            
            Adres adres2 = new Adres("111", "222", "333", "444", "555");
            session.save(adres2);
            Pracownik p1 = new Pracownik("Jan", "Kowalski", "wykladowca", "dr", "988");
            p1.setAdres(adres2);
            p1.getPrzedmioty().add(przed1);
            session.save(p1);
            
            
            Adres adres3 = new Adres("1111", "2222", "3333", "4444", "5555");
            session.save(adres3);
            Student s1 = new Student("Lukasz", "Szczerba", "ADDA111111", "965");
            s1.setAdres(adres3);
            session.save(s1);
            
            Test test = new Test(new GregorianCalendar(2017,5,6));
            test.setPrzedmiot(przed1);
            session.save(test);
            
            Ocena ocena = new Ocena(test, s1);
            ocena.setOcena(10);
            ocena.setLiczbaPoprOdp(2);
            session.save(ocena);
            
            tx.commit();
        }
    }
}
