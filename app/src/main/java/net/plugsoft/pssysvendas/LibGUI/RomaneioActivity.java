package net.plugsoft.pssysvendas.LibGUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import net.plugsoft.pssysvendas.Controllers.RomaneioController;
import net.plugsoft.pssysvendas.LibClass.Callback.RomaneioCallback;
import net.plugsoft.pssysvendas.LibClass.Romaneio;
import net.plugsoft.pssysvendas.LibClass.RomaneioStatus;
import net.plugsoft.pssysvendas.LibClass.Util;
import net.plugsoft.pssysvendas.R;

public class RomaneioActivity extends AppCompatActivity implements RomaneioCallback {
    // Variáveis privadas
    private final String BASE_URL = "http://gestorapi.plugsoft.net/";
    // Elementos de interface
    private TextView txtEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romaneio);

        txtEmpresa = findViewById(R.id.txtRomaneioEmpresa);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getRomaneio(72);
    }

    // Métodos privados das funcionalidades
    public void getRomaneio(int id) {
        try {
            RomaneioController romaneioController = new RomaneioController(this, BASE_URL);
            romaneioController.getRomaneio(this, id);
        } catch (Exception e) {
            Toast.makeText(this, "ERRO: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Implementações interfaces
    @Override
    public void onGetRomaneioSuccess(Romaneio romaneio) {
        if(romaneio != null) {
            Toast.makeText(this, "Situação: " + Util.getSituacaoRomaneio(romaneio.getRomStatus()), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRomaneioFailure(String message) {
        Toast.makeText(this, "ERRO: " + message, Toast.LENGTH_SHORT).show();
    }
}