package com.example.appantincendio;

import java.util.Date;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String dataNascita;
    private String password;

    public Utente(String nome, String cognome, String email, String dataNascita, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.password = password;
    }

    // Getter per i campi dell'utente
    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public String getDataNascita()
    {
        return dataNascita;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

}
