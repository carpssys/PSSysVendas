package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class Cidade implements Serializable {
    private int id;
    private int cidCodigo;
    private String cidNome;
    private String cidCep;
    private short ufsCodigo;
    private String ufsNome;
    private String ufsUf;

    public Cidade() { }

    // Métodos acessores
    public int getId() {
        return id;
    }

    public int getCidCodigo() {
        return cidCodigo;
    }

    public String getCidNome() {
        return cidNome;
    }

    public String getCidCep() {
        return cidCep;
    }

    public short getUfsCodigo() {
        return ufsCodigo;
    }

    public String getUfsNome() {
        return ufsNome;
    }

    public String getUfsUf() {
        return ufsUf;
    }
}
