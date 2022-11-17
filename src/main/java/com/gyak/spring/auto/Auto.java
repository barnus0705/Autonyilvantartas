package com.gyak.spring.auto;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Auto {
    @Id
    @SequenceGenerator(
            name = "auto_sequence",
            sequenceName = "auto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "auto_sequence"
    )
    private int id;
    private String rendszam;
    @Enumerated(EnumType.STRING)
    private AutoMarka marka;
    private LocalDate datum;
    private int km;

    public Auto(){

    }

    public Auto(int id, String rendszam, AutoMarka marka, LocalDate datum, int km) {
        this.id = id;
        this.rendszam = rendszam;
        this.marka = marka;
        this.datum = datum;
        this.km = km;
    }

     public Auto(String rendszam, AutoMarka marka, LocalDate datum, int km) {
        this.rendszam = rendszam;
        this.marka = marka;
        this.datum = datum;
        this.km = km;
    }



    public String getRendszam() {
        return rendszam;
    }

    public int getId() {
        return id;
    }

    public AutoMarka getMarka() {
        return marka;
    }



    public int getKm() {
        return km;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarka(AutoMarka marka) {
        this.marka = marka;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "rendszam='" + rendszam + '\'' +
                ", id=" + id +
                ", marka='" + marka + '\'' +
                ", datum=" + datum +
                ", km=" + km +
                '}';
    }
}
