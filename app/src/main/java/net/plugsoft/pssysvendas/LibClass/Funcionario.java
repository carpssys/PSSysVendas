package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private int funKey;
    private int funKeyLocal;
    private String funNome;
    private String funApelido;
    private int funEmpKey;

    // Construtor
    public Funcionario() { }

    // Métodos acessores e modificadores
    public int getFunKey() {
        return funKey;
    }

    public void setFunKey(int funKey) {
        this.funKey = funKey;
    }

    public int getFunKeyLocal() {
        return funKeyLocal;
    }

    public void setFunKeyLocal(int funKeyLocal) {
        this.funKeyLocal = funKeyLocal;
    }

    public String getFunNome() {
        return funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public String getFunApelido() {
        return funApelido;
    }

    public void setFunApelido(String funApelido) {
        this.funApelido = funApelido;
    }

    public int getFunEmpKey() {
        return funEmpKey;
    }

    public void setFunEmpKey(int funEmpKey) {
        this.funEmpKey = funEmpKey;
    }
}
