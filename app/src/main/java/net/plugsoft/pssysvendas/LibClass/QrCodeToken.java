package net.plugsoft.pssysvendas.LibClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QrCodeToken {
    private String cnpj;
    private int romKey;
    private Date dtExp;

    // Construtor
    public QrCodeToken() { }

    // Métodos acessores e modificadores
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getRomKey() {
        return romKey;
    }

    public void setRomKey(int romKey) {
        this.romKey = romKey;
    }

    public Date getDtExp() {
        return dtExp;
    }

    public void setDtExp(Date dtExp) {
        this.dtExp = dtExp;
    }

    public void getQRCode(String qrCode) throws Exception {
        String[] _qrCode = qrCode.split(":");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
        setCnpj(_qrCode[1]);
        setRomKey(Integer.getInteger(_qrCode[3]));
        setDtExp(sdf.parse(_qrCode[5]));
    }
}
