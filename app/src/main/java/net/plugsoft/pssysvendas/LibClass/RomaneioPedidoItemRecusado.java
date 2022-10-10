package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class RomaneioPedidoItemRecusado implements Serializable {
    private int romPedIteRecKey;
    private int romPedIteRecRomPedKey;
    private int romPedIteRecRomPedIteKey;
    private float romPedIteRecQtdRec;
    private int romPedIteRecMotRecKey;
    private short romPedIteRecExc;
    private String romPedIteRecDataMud;
    private int romPedIteRecUsu;
    private String romPedIteRecComput;

    // Construtor
    public RomaneioPedidoItemRecusado() { }


    public int getRomPedIteRecKey() {
        return romPedIteRecKey;
    }

    public void setRomPedIteRecKey(int romPedIteRecKey) {
        this.romPedIteRecKey = romPedIteRecKey;
    }

    public int getRomPedIteRecRomPedKey() {
        return romPedIteRecRomPedKey;
    }

    public void setRomPedIteRecRomPedKey(int romPedIteRecRomPedKey) {
        this.romPedIteRecRomPedKey = romPedIteRecRomPedKey;
    }

    public int getRomPedIteRecRomPedIteKey() {
        return romPedIteRecRomPedIteKey;
    }

    public void setRomPedIteRecRomPedIteKey(int romPedIteRecRomPedIteKey) {
        this.romPedIteRecRomPedIteKey = romPedIteRecRomPedIteKey;
    }

    public float getRomPedIteRecQtdRec() {
        return romPedIteRecQtdRec;
    }

    public void setRomPedIteRecQtdRec(float romPedIteRecQtdRec) {
        this.romPedIteRecQtdRec = romPedIteRecQtdRec;
    }

    public int getRomPedIteRecMotRecKey() {
        return romPedIteRecMotRecKey;
    }

    public void setRomPedIteRecMotRecKey(int romPedIteRecMotRecKey) {
        this.romPedIteRecMotRecKey = romPedIteRecMotRecKey;
    }

    public short getRomPedIteRecExc() {
        return romPedIteRecExc;
    }

    public void setRomPedIteRecExc(short romPedIteRecExc) {
        this.romPedIteRecExc = romPedIteRecExc;
    }

    public String getRomPedIteRecDataMud() {
        return romPedIteRecDataMud;
    }

    public void setRomPedIteRecDataMud(String romPedIteRecDataMud) {
        this.romPedIteRecDataMud = romPedIteRecDataMud;
    }

    public int getRomPedIteRecUsu() {
        return romPedIteRecUsu;
    }

    public void setRomPedIteRecUsu(int romPedIteRecUsu) {
        this.romPedIteRecUsu = romPedIteRecUsu;
    }

    public String getRomPedIteRecComput() {
        return romPedIteRecComput;
    }

    public void setRomPedIteRecComput(String romPedIteRecComput) {
        this.romPedIteRecComput = romPedIteRecComput;
    }
}
