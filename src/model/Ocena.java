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
@Table(name="OCENY")
public class Ocena implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OCENY")
    private int id;
    
    @Column(name = "LICZBAPOPRODP")
    private int liczbaPoprOdp;
    
    @Column(name = "OCENA")
    private float ocena;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_TESTU",foreignKey = @javax.persistence.ForeignKey(name = "FK_OCENY_TEST"))
    private Test test;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="ID_STUD",foreignKey = @javax.persistence.ForeignKey(name = "FK_OCENY_STUD"))
    private Student student;

    public Ocena() {
    }

    public Ocena(Test test, Student student) {
        this.test = test;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLiczbaPoprOdp() {
        return liczbaPoprOdp;
    }

    public void setLiczbaPoprOdp(int liczbaPoprOdp) {
        this.liczbaPoprOdp = liczbaPoprOdp;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
