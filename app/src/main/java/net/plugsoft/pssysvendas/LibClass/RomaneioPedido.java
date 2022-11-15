package net.plugsoft.pssysvendas.LibClass;

import java.io.Serializable;

public class RomaneioPedido implements Serializable {
    private int romPedKey;
    private int romPedStatus;
    private int romPedRomKey;
    private int romPedPedKey;
    private String romPedNomePedido;
    private String romPedDataRecebimento;
    private String romPedNomeRespRecebimento;
    private String romPedCep;
    private int romPedUfsCodigo;
    private int romPedCidCodigo;
    private String romPedBairro;
    private String romPedEndereco;
    private int romPedNumero;
    private String romPedComplemento;
    private String romPedReferencia;
    private short romPedExc;
    private String romPedDataMud;
    private int romPedUsu;
    private String romPedComput;
    private int romPedOrdem;
    
    // Construtor
    private RomaneioPedido() { }


    public int getRomPedKey() {
        return romPedKey;
    }

    public void setRomPedKey(int romPedKey) {
        this.romPedKey = romPedKey;
    }

    public int getRomPedStatus() {
        return romPedStatus;
    }

    public void setRomPedStatus(int romPedStatus) {
        this.romPedStatus = romPedStatus;
    }

    public int getRomPedRomKey() {
        return romPedRomKey;
    }

    public void setRomPedRomKey(int romPedRomKey) {
        this.romPedRomKey = romPedRomKey;
    }

    public int getRomPedPedKey() {
        return romPedPedKey;
    }

    public void setRomPedPedKey(int romPedPedKey) {
        this.romPedPedKey = romPedPedKey;
    }

    public String getRomPedNomePedido() {
        return romPedNomePedido;
    }

    public void setRomPedNomePedido(String romPedNomePedido) {
        this.romPedNomePedido = romPedNomePedido;
    }

    public String getRomPedDataRecebimento() {
        if(romPedDataRecebimento != null) {
            return romPedDataRecebimento.substring(8, 10) + "/" + romPedDataRecebimento.substring(5, 7) +
                    "/" + romPedDataRecebimento.substring(0,4) +
                    " " + romPedDataRecebimento.substring(11,16);
        } else {
            return null;
        }
    }

    public void setRomPedDataRecebimento(String romPedDataRecebimento) {
        this.romPedDataRecebimento = romPedDataRecebimento;
    }

    public String getRomPedNomeRespRecebimento() {
        return romPedNomeRespRecebimento;

    }

    public void setRomPedNomeRespRecebimento(String romPedNomeRespRecebimento) {
        this.romPedNomeRespRecebimento = romPedNomeRespRecebimento;
    }

    public String getRomPedCep() {
        return romPedCep;
    }

    public void setRomPedCep(String romPedCep) {
        this.romPedCep = romPedCep;
    }

    public int getRomPedUfsCodigo() {
        return romPedUfsCodigo;
    }

    public void setRomPedUfsCodigo(int romPedUfsCodigo) {
        this.romPedUfsCodigo = romPedUfsCodigo;
    }

    public int getRomPedCidCodigo() {
        return romPedCidCodigo;
    }

    public void setRomPedCidCodigo(int romPedCidCodigo) {
        this.romPedCidCodigo = romPedCidCodigo;
    }

    public String getRomPedBairro() {
        return romPedBairro;
    }

    public void setRomPedBairro(String romPedBairro) {
        this.romPedBairro = romPedBairro;
    }

    public String getRomPedEndereco() {
        return romPedEndereco;
    }

    public void setRomPedEndereco(String romPedEndereco) {
        this.romPedEndereco = romPedEndereco;
    }

    public int getRomPedNumero() {
        return romPedNumero;
    }

    public void setRomPedNumero(int romPedNumero) {
        this.romPedNumero = romPedNumero;
    }

    public String getRomPedComplemento() {
        return romPedComplemento;
    }

    public void setRomPedComplemento(String romPedComplemento) {
        this.romPedComplemento = romPedComplemento;
    }

    public String getRomPedReferencia() {
        return romPedReferencia;
    }

    public void setRomPedReferencia(String romPedReferencia) {
        this.romPedReferencia = romPedReferencia;
    }

    public short getRomPedExc() {
        return romPedExc;
    }

    public void setRomPedExc(short romPedExc) {
        this.romPedExc = romPedExc;
    }

    public String getRomPedDataMud() {
        return romPedDataMud;
    }

    public void setRomPedDataMud(String romPedDataMud) {
        this.romPedDataMud = romPedDataMud;
    }

    public int getRomPedUsu() {
        return romPedUsu;
    }

    public void setRomPedUsu(int romPedUsu) {
        this.romPedUsu = romPedUsu;
    }

    public String getRomPedComput() {
        return romPedComput;
    }

    public void setRomPedComput(String romPedComput) {
        this.romPedComput = romPedComput;
    }

    public int getRomPedOrdem() {
        return romPedOrdem;
    }

    public void setRomPedOrdem(int romPedOrdem) {
        this.romPedOrdem = romPedOrdem;
    }


}
