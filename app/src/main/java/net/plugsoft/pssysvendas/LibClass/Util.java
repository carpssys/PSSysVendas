package net.plugsoft.pssysvendas.LibClass;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class Util {
    private static String QR_ROMANEIO = "qr_romaneio";

    // Recebe cnpj só números retorna formatado
    public static String formataCnpj(String cnpj) {
        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 3) + "." + cnpj.substring(5, 3) +
                "/" + cnpj.substring(8, 4) + "-" + cnpj.substring(12, 2);
    }
    // Grava dados do romaneio a ser entregue
    public static void saveDadosRomaneio(Context context, QrCodeToken qrCodeToken) {
        SharedPreferences.Editor editor = context.getSharedPreferences(QR_ROMANEIO, MODE_PRIVATE).edit();
        editor.putInt("id", qrCodeToken.getRomKey());
        editor.putString("cnpj", qrCodeToken.getCnpj());
        editor.putString("dtExp", qrCodeToken.getDtExp());

        editor.commit();
    }

    // Le dados do romaneio vigente
    public static QrCodeToken getDadosRomaneio(Context context) {
        QrCodeToken qrCodeToken = new QrCodeToken();
        SharedPreferences dadosRomaneio = context.getSharedPreferences(QR_ROMANEIO, MODE_PRIVATE);
        if(dadosRomaneio.contains("id")) {
            qrCodeToken.setRomKey(dadosRomaneio.getInt("id", 0));
        }
        if(dadosRomaneio.contains("cnpj")) {
            qrCodeToken.setCnpj(dadosRomaneio.getString("cnpj", ""));
        }
        if(dadosRomaneio.contains("dtExp")) {
            qrCodeToken.setDtExp(dadosRomaneio.getString("dtExp", "01/01/1900"));
        }
        return qrCodeToken;
    }

    // Verifica validade do romaneio
    public static boolean isRomaneioValid(String dtExp) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar _dtExp = DateToCalendar(sdf.parse(dtExp), true);
        Calendar _dtHoje = DateToCalendar(new Date(), true);
        //_dtHoje.add(Calendar.DAY_OF_MONTH, 1);
        if(_dtExp.getTime().compareTo(_dtHoje.getTime()) == 0) {
            return true;
        }
        if(_dtHoje.getTime().after(_dtExp.getTime())) {
            return false;
        }
        return true;
    }

    public static Calendar DateToCalendar(Date date, boolean setTimeToZero){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);
        if(setTimeToZero){
            calendario.set(Calendar.HOUR_OF_DAY, 0);
            calendario.set(Calendar.MINUTE, 0);
            calendario.set(Calendar.SECOND, 0);
            calendario.set(Calendar.MILLISECOND, 0);
        }
        return calendario;
    }

    // Verifica se tem internet e ou acesso a dados
    public static boolean hasConnectivity(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo ni = cm.getActiveNetworkInfo();
            return ni != null && ni.isConnected();
        }
        return false;
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
