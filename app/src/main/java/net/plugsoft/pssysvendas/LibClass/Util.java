package net.plugsoft.pssysvendas.LibClass;

import android.net.ConnectivityManager;

import java.text.NumberFormat;

public class Util {
    // Verifica se tem internet e ou acesso a dados
    public boolean hasConnectivity() {
        return true;
    }

    // Retorna a descrição da situação do roamneio
    public static String getSituacaoRomaneio(int value) {
        String strStatus = "";
        switch (value) {
            case 0 :
                strStatus =  RomaneioStatus.TODOS.getDescricao();
                break;
            case 1:
                strStatus =  RomaneioStatus.ABERTO.getDescricao();
                break;
            case 2:
                strStatus =  RomaneioStatus.ENTREGUE.getDescricao();
                break;
            case 3:
                strStatus =  RomaneioStatus.PARCIAL.getDescricao();
                break;
            case 4:
                strStatus =  RomaneioStatus.RECUSADO.getDescricao();
                break;
        }
        return strStatus;
    }

    public static String getCurrencyValue(float value) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String currencyValue = nf.format(value);
        return currencyValue;
    }

    public static String getDecimalValue(float value, int digits) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(digits);
        nf.setMaximumFractionDigits(digits);
        String currencyValue = nf.format(value);
        return currencyValue;
    }
}
