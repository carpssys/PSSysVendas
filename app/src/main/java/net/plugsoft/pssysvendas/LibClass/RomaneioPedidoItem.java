package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class RomaneioPedidoItem implements Serializable {
    private int romPedIteKey;
    private int romPedIteItem;
    private String romPedIteProCodigo;
    private float romPedIteValorUnitario;
    private float romPedIteDesconto;
    private float romPedIteSubTotal;
    private float romPedIteQtd;
    private float romPedIteTotal;
    private int romPedItePedKey;
    private short romPedIteExc;
    private String romPedIteNome;
    private short romPedIteLancado;
    private short romPedIteServico;
    private int romPedIteFunKey;
    private int romPedIteEmpKey;
    private String romPedIteUniUn;
    private String romPedIteUniNome;
    private int romPedItePedIteKey;

    public RomaneioPedidoItem() { }


    public int getRomPedIteKey() {
        return romPedIteKey;
    }

    public void setRomPedIteKey(int romPedIteKey) {
        this.romPedIteKey = romPedIteKey;
    }

    public int getRomPedIteItem() {
        return romPedIteItem;
    }

    public void setRomPedIteItem(int romPedIteItem) {
        this.romPedIteItem = romPedIteItem;
    }

    public String getRomPedIteProCodigo() {
        return romPedIteProCodigo;
    }

    public void setRomPedIteProCodigo(String romPedIteProCodigo) {
        this.romPedIteProCodigo = romPedIteProCodigo;
    }

    public float getRomPedIteValorUnitario() {
        return romPedIteValorUnitario;
    }

    public void setRomPedIteValorUnitario(float romPedIteValorUnitario) {
        this.romPedIteValorUnitario = romPedIteValorUnitario;
    }

    public float getRomPedIteDesconto() {
        return romPedIteDesconto;
    }

    public void setRomPedIteDesconto(float romPedIteDesconto) {
        this.romPedIteDesconto = romPedIteDesconto;
    }

    public float getRomPedIteSubTotal() {
        return romPedIteSubTotal;
    }

    public void setRomPedIteSubTotal(float romPedIteSubTotal) {
        this.romPedIteSubTotal = romPedIteSubTotal;
    }

    public float getRomPedIteQtd() {
        return romPedIteQtd;
    }

    public void setRomPedIteQtd(float romPedIteQtd) {
        this.romPedIteQtd = romPedIteQtd;
    }

    public float getRomPedIteTotal() {
        return romPedIteTotal;
    }

    public void setRomPedIteTotal(float romPedIteTotal) {
        this.romPedIteTotal = romPedIteTotal;
    }

    public int getRomPedItePedKey() {
        return romPedItePedKey;
    }

    public void setRomPedItePedKey(int romPedItePedKey) {
        this.romPedItePedKey = romPedItePedKey;
    }

    public short getRomPedIteExc() {
        return romPedIteExc;
    }

    public void setRomPedIteExc(short romPedIteExc) {
        this.romPedIteExc = romPedIteExc;
    }

    public String getRomPedIteNome() {
        return romPedIteNome;
    }

    public void setRomPedIteNome(String romPedIteNome) {
        this.romPedIteNome = romPedIteNome;
    }

    public short getRomPedIteLancado() {
        return romPedIteLancado;
    }

    public void setRomPedIteLancado(short romPedIteLancado) {
        this.romPedIteLancado = romPedIteLancado;
    }

    public short getRomPedIteServico() {
        return romPedIteServico;
    }

    public void setRomPedIteServico(short romPedIteServico) {
        this.romPedIteServico = romPedIteServico;
    }

    public int getRomPedIteFunKey() {
        return romPedIteFunKey;
    }

    public void setRomPedIteFunKey(int romPedIteFunKey) {
        this.romPedIteFunKey = romPedIteFunKey;
    }

    public int getRomPedIteEmpKey() {
        return romPedIteEmpKey;
    }

    public void setRomPedIteEmpKey(int romPedIteEmpKey) {
        this.romPedIteEmpKey = romPedIteEmpKey;
    }

    public String getRomPedIteUniUn() {
        return romPedIteUniUn;
    }

    public void setRomPedIteUniUn(String romPedIteUniUn) {
        this.romPedIteUniUn = romPedIteUniUn;
    }

    public String getRomPedIteUniNome() {
        return romPedIteUniNome;
    }

    public void setRomPedIteUniNome(String romPedIteUniNome) {
        this.romPedIteUniNome = romPedIteUniNome;
    }

    public int getRomPedItePedIteKey() {
        return romPedItePedIteKey;
    }

    public void setRomPedItePedIteKey(int romPedItePedIteKey) {
        this.romPedItePedIteKey = romPedItePedIteKey;
    }
}
