/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author LabHiber
 */
// <joined-subclass extends="model.Osoba" lazy="false" name="model.Pracownik" table="PRACOWNICY">
//<key foreign-key="FK_PRAC_OS">
//      <column name="ID_PRAC"/>
//    </key>
@Entity
@PrimaryKeyJoinColumn(name = "ID_PRAC", foreignKey = @javax.persistence.ForeignKey(name = "FK_PRAC_OS"))
//@ForeignKey(name="FK_PRAC_OS") //z hib 4 i 3
@Table(name = "PRACOWNICY")
public class Pracownik extends Osoba implements Serializable {

    @Column(name = "STANOWISKO")
    private String stanowisko;

    @Column(name = "TYTUL")
    private String tytul;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "PRAC_PRZED",
            joinColumns = @JoinColumn(name = "ID_PRAC"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRZED"),
            foreignKey = @javax.persistence.ForeignKey(name = "FK_PRAC_PRZED"),
            inverseForeignKey = @javax.persistence.ForeignKey(name = "FK_PRZED_PRAC"))
    private Set<Przedmiot> przedmioty = new HashSet<>(10);

    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, String stanowisko, String tytul, String pesel) {
        super(imie, nazwisko, pesel);
        this.stanowisko = stanowisko;
        this.tytul = tytul;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Set<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(Set<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    @Override
    public String toString() {
        return (super.getImie() + " "
                + super.getNazwisko() + " PESEL: " + super.getPesel()
                + " stanowisko: " + stanowisko
                + " tytuł: " + tytul);
    }
}
