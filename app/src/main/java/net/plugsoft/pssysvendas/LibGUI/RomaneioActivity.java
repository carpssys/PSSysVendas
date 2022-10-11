package net.plugsoft.pssysvendas.LibGUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import net.plugsoft.pssysvendas.R;

public class RomaneioActivity extends AppCompatActivity {

    private TextView txtEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romaneio);

        txtEmpresa = findViewById(R.id.txtRomaneioEmpresa);

    }
}