package sn.kai.kaivoiture.Entites;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Event {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datedebut;
    private String description;
    private String lieu;
}
