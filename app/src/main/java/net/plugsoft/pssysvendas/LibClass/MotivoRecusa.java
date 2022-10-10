package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class MotivoRecusa implements Serializable {
    private int motRecKey;
    private int motRecEmpKey;
    private String motRecDescricao;
    private short motRecExc;
    private String motRecDataMud;
    private int motRecUsu;
    private String motRecComput;
    private String motRecSinc;

    public MotivoRecusa() { }


    public int getMotRecKey() {
        return motRecKey;
    }

    public void setMotRecKey(int motRecKey) {
        this.motRecKey = motRecKey;
    }

    public int getMotRecEmpKey() {
        return motRecEmpKey;
    }

    public void setMotRecEmpKey(int motRecEmpKey) {
        this.motRecEmpKey = motRecEmpKey;
    }

    public String getMotRecDescricao() {
        return motRecDescricao;
    }

    public void setMotRecDescricao(String motRecDescricao) {
        this.motRecDescricao = motRecDescricao;
    }

    public short getMotRecExc() {
        return motRecExc;
    }

    public void setMotRecExc(short motRecExc) {
        this.motRecExc = motRecExc;
    }

    public String getMotRecDataMud() {
        return motRecDataMud;
    }

    public void setMotRecDataMud(String motRecDataMud) {
        this.motRecDataMud = motRecDataMud;
    }

    public int getMotRecUsu() {
        return motRecUsu;
    }

    public void setMotRecUsu(int motRecUsu) {
        this.motRecUsu = motRecUsu;
    }

    public String getMotRecComput() {
        return motRecComput;
    }

    public void setMotRecComput(String motRecComput) {
        this.motRecComput = motRecComput;
    }

    public String getMotRecSinc() {
        return motRecSinc;
    }

    public void setMotRecSinc(String motRecSinc) {
        this.motRecSinc = motRecSinc;
    }
}
