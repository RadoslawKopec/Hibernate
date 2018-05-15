/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;



/**
 *
 * @author LabHiber
 */

@Entity 
@Table(name="TESTY")
public class Test implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TESTU")
    private int id;
    
    @Column(name = "TERMIN")
    private GregorianCalendar termin;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_PRZEDM",foreignKey = @javax.persistence.ForeignKey(name = "FK_TEST_PRZEDM"))
    private Przedmiot przedmiot;

    public Test() {
    }

    public Test(GregorianCalendar termin) {
        this.termin = termin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getTermin() {
        return termin;
    }

    public void setTermin(GregorianCalendar termin) {
        this.termin = termin;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }
}
