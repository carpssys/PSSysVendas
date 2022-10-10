package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class Romaneio implements Serializable {
    private int romKey;
    private int romEmpKey;
    private int romStatus;
    private String romDataCad;
    private String romDataEnt;
    private int romFunKey;
    private short romExc;
    private String romDataMud;
    private int romUsu;
    private String romComput;
    private int romOrdem;

    // Cosntrutor da classe
    public Romaneio() { }


    public int getRomKey() {
        return romKey;
    }

    public void setRomKey(int romKey) {
        this.romKey = romKey;
    }

    public int getRomEmpKey() {
        return romEmpKey;
    }

    public void setRomEmpKey(int romEmpKey) {
        this.romEmpKey = romEmpKey;
    }

    public int getRomStatus() {
        return romStatus;
    }

    public void setRomStatus(int romStatus) {
        this.romStatus = romStatus;
    }

    public String getRomDataCad() {
        return romDataCad;
    }

    public void setRomDataCad(String romDataCad) {
        this.romDataCad = romDataCad;
    }

    public String getRomDataEnt() {
        return romDataEnt;
    }

    public void setRomDataEnt(String romDataEnt) {
        this.romDataEnt = romDataEnt;
    }

    public int getRomFunKey() {
        return romFunKey;
    }

    public void setRomFunKey(int romFunKey) {
        this.romFunKey = romFunKey;
    }

    public short getRomExc() {
        return romExc;
    }

    public void setRomExc(short romExc) {
        this.romExc = romExc;
    }

    public String getRomDataMud() {
        return romDataMud;
    }

    public void setRomDataMud(String romDataMud) {
        this.romDataMud = romDataMud;
    }

    public int getRomUsu() {
        return romUsu;
    }

    public void setRomUsu(int romUsu) {
        this.romUsu = romUsu;
    }

    public String getRomComput() {
        return romComput;
    }

    public void setRomComput(String romComput) {
        this.romComput = romComput;
    }

    public int getRomOrdem() {
        return romOrdem;
    }

    public void setRomOrdem(int romOrdem) {
        this.romOrdem = romOrdem;
    }
}
