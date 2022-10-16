package net.plugsoft.pssysvendas.LibClass;

public class QrCodeToken {
    private String cnpj;
    private int romKey;
    private String dtExp;

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

    public String getDtExp() {
        return dtExp;
    }

    public void setDtExp(String dtExp) {
        this.dtExp = dtExp;
    }

    public void getQRCode(String qrCode) throws Exception {
        String[] _qrCode = qrCode.split(":");
        setCnpj(_qrCode[1]);
        setRomKey(Integer.getInteger(_qrCode[3]));
        setDtExp(_qrCode[5]);
    }
}
