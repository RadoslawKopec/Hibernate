/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author LabHiber
 */
@Entity
@Table(name="PRZEDMIOTY")
public class Przedmiot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRZED")
    private int id;
    
    @Column(name = "NAZWA")
    private String nazwa;
    
    @Column(name = "KIERUNEK")
    private String kierunek;
    
    @Column(name = "SEMESTR")
    private String semestr;
    
    @ManyToMany(mappedBy="przedmioty")
    private Set<Pracownik> pracownicy = new HashSet<>(10);
    
    @OneToMany(mappedBy = "przedmiot")
    private Set<Test> testy = new HashSet<>(10);

    public Przedmiot() {
    }

    public Przedmiot(String nazwa, String kierunek, String semestr) {
        this.nazwa = nazwa;
        this.kierunek = kierunek;
        this.semestr = semestr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public String getSemestr() {
        return semestr;
    }

    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    public Set<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Set<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public Set<Test> getTesty() {
        return testy;
    }

    public void setTesty(Set<Test> testy) {
        this.testy = testy;
    }

    @Override
    public String toString() {
        return ("Przedmiot: " + getNazwa() + " Kierunek: "
                + getKierunek()
                + " Semestr: " + getSemestr());
    }
}
