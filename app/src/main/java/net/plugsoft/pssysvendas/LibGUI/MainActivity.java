package net.plugsoft.pssysvendas.LibGUI;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import net.plugsoft.pssysvendas.Controllers.EmpresaController;
import net.plugsoft.pssysvendas.LibClass.Callback.EmpresaCallback;
import net.plugsoft.pssysvendas.LibClass.Empresa;
import net.plugsoft.pssysvendas.R;
import net.plugsoft.pssysvendas.Services.EmpresaService;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EmpresaCallback {
    // "http://gestorapi.plugsoft.net/";
    // "http://192.168.0.188:50110/"
    private final String BASE_URL = "http://192.168.0.188:50110/";

    private ImageButton imgBtn;

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

    }

    @Override
    protected void onStart() {
        super.onStart();

        //getEmpresas();

    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
        result -> {
            if(result.getContents() == null) {
                Toast.makeText(this, "Leitura QR Code cancelada!", Toast.LENGTH_SHORT).show();
            } else {
                String[] strQrCode = result.getContents().split(":");
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
            }
        });

    private void getEmpresas() {
        try {
            EmpresaController empresaController = new EmpresaController(this, BASE_URL);
            empresaController.getEmpresa(this, 378);
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