package net.plugsoft.pssysvendas.LibGUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import net.plugsoft.pssysvendas.Controllers.EmpresaController;
import net.plugsoft.pssysvendas.LibClass.Callback.EmpresaCallback;
import net.plugsoft.pssysvendas.LibClass.Empresa;
import net.plugsoft.pssysvendas.R;
import net.plugsoft.pssysvendas.Services.EmpresaService;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EmpresaCallback {

    private final String BASE_URL = "http://gestorapi.plugsoft.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        getEmpresas();

    }

    private void getEmpresas() {
        try {
            EmpresaController empresaController = new EmpresaController(this, BASE_URL);
            empresaController.getEmpresas(this);
        }
        catch (Exception e) {

        }
    }
    @Override
    public void onGetEmpresasSuccess(List<Empresa> empresas) {
        if(!empresas.isEmpty()) {
            Toast.makeText(this, empresas.size(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGetEmpresaSuccess(Empresa empresa) {

    }

    @Override
    public void onEmpresaFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}