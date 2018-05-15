/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;



/**
 *
 * @author LabHiber
 */
@Entity

// <joined-subclass extends="model.Osoba" lazy="false" name="model.Pracownik" table="PRACOWNICY">
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="OSOBY")
public class Osoba implements Serializable{
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID_OSOBY")
    private int id;
    
    @Column(name = "IMIE")
    private String imie;
    
    @Column(name = "NAZWISKO")
    private String nazwisko;
    
    @Column(name = "PESEL")
    private String pesel;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ADRES_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_OSOBA_AD"))
    private Adres adres;

    public Osoba() {
    }
    
    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Osoba(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
      return (getImie() + " "+getNazwisko() + " PESEL: " + getPesel());
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
