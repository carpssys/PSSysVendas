package net.plugsoft.pssysvendas.LibGUI;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import net.plugsoft.pssysvendas.Controllers.EmpresaController;
import net.plugsoft.pssysvendas.LibClass.Callback.EmpresaCallback;
import net.plugsoft.pssysvendas.LibClass.Empresa;
import net.plugsoft.pssysvendas.LibClass.QrCodeToken;
import net.plugsoft.pssysvendas.LibClass.Util;
import net.plugsoft.pssysvendas.R;

import java.util.List;

public class MainActivity extends AppCompatActivity  {
    // "http://gestorapi.plugsoft.net/";
    // "http://192.168.0.188:50110/"
    private final String BASE_URL = "http://gestorapi.plugsoft.net/";
    private AlertDialog alert;

    private ImageButton imgBtn;
    private Button btnRomaneio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn = findViewById(R.id.imgBtnCamera);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barcodeLauncher.launch(new ScanOptions());
            }
        });

        btnRomaneio = findViewById(R.id.btnRomaneio);
        btnRomaneio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RomaneioActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        verificaConectividade();
        verificaRomaneioValido();
        //getEmpresa("12801594000119");
        //Intent intent = new Intent(MainActivity.this, RomaneioActivity.class);
        //startActivity(intent);

    }

    private void verificaConectividade() {
        if(!Util.hasConnectivity(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Atenção!");
            builder.setMessage("Verifique sua Conectividade wi-fi ou de dados.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert = builder.create();
            alert.show();
        }
    }

    private void verificaRomaneioValido() {
        QrCodeToken qrCodeToken = Util.getDadosRomaneio(this);
        try {
                if((qrCodeToken == null) ||
                    !Util.isRomaneioValid(qrCodeToken.getDtExp())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Atenção!");
                    builder.setMessage("Não há um Romaneio Válido para a entrega de Pedidos! Leia " +
                            "um novo QR Code.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert = builder.create();
                    alert.show();

                }
            } catch (Exception e) {
            Toast.makeText(this, "ERRO: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
        result -> {
            if(result.getContents() == null) {
                Toast.makeText(this, "Leitura QR Code cancelada!", Toast.LENGTH_SHORT).show();
                // Comentar quando for usar a leitura do QR Code
                String [] strQrCode = ("id:72:cnpj:12801594000119:dtExp:31/10/2022").split(":");
                saveQrCode(strQrCode);
            } else {
                String[] strQrCode = result.getContents().split(":");
                saveQrCode(strQrCode);

            }
        });

    private void saveQrCode(String[] strQrCode) {
        QrCodeToken qrCodeToken = new QrCodeToken();

        for(int i=0; i<strQrCode.length; i++) {
            switch(i) {
                case 1:
                    qrCodeToken.setRomKey(Integer.parseInt(strQrCode[i]));
                    break;
                case 3:
                    qrCodeToken.setCnpj(strQrCode[i]);
                    break;
                case 5:
                    qrCodeToken.setDtExp(strQrCode[i]);
                    break;
            }
        }
        Util.saveDadosRomaneio(this, qrCodeToken);
    }
}