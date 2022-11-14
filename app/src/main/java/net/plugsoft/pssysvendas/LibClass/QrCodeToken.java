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
        // Testa se o CNPJ já está formatado
        if(cnpj.length() > 14) {
            this.cnpj = cnpj;
        } else {
            this.cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." +
                    cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
        }
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
