/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author LabHiber
 */
@Entity
@PrimaryKeyJoinColumn(name = "ID_STUD", foreignKey = @javax.persistence.ForeignKey(name = "FK_STUD_OS"))
@Table(name = "STUDENCI")
public class Student extends Osoba implements Serializable {
    
    @Column(name = "NRALBUMU")
    private String nrAlbumu;
   
    public Student() {
    }

    public Student(String imie, String nazwisko, String nrAlbumu, String pesel) {
        super(imie, nazwisko, pesel);
        this.nrAlbumu = nrAlbumu;
    }

    public String getNrAlbumu() {
        return nrAlbumu;
    }

    public void setNrAlbumu(String nrAlbumu) {
        this.nrAlbumu = nrAlbumu;
    }

    @Override
    public String toString() {
        return (super.getImie() + " "
                + super.getNazwisko() + " PESEL: " + super.getPesel()
                + " nr albumu: " + nrAlbumu);
    }
}
