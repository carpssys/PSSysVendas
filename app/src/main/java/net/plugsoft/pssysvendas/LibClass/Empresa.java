package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

import kotlinx.coroutines.channels.ActorKt;

public class Empresa implements Serializable {
    private int empKey;
    private String empCnpj;
    private String empNome;
    private short empAtivarWeb;
    private String empSenhaWeb;

    public Empresa() { }


    public int getEmpKey() {
        return empKey;
    }

    public void setEmpKey(int empKey) {
        this.empKey = empKey;
    }

    public String getEmpCnpj() {
        return empCnpj;
    }

    public void setEmpCnpj(String empCnpj) {
        this.empCnpj = empCnpj;
    }

    public String getEmpNome() {
        return empNome;
    }

    public void setEmpNome(String empNome) {
        this.empNome = empNome;
    }

    public short getEmpAtivarWeb() {
        return empAtivarWeb;
    }

    public void setEmpAtivarWeb(short empAtivarWeb) {
        this.empAtivarWeb = empAtivarWeb;
    }

    public String getEmpSenhaWeb() {
        return empSenhaWeb;
    }

    public void setEmpSenhaWeb(String empSenhaWeb) {
        this.empSenhaWeb = empSenhaWeb;
    }
}
