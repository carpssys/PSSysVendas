package net.plugsoft.pssysvendas.LibGUI;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import net.plugsoft.pssysvendas.Controllers.AutorizaController;
import net.plugsoft.pssysvendas.Controllers.EmpresaController;
import net.plugsoft.pssysvendas.Controllers.RomaneioController;
import net.plugsoft.pssysvendas.Controllers.RomaneioPedidoController;
import net.plugsoft.pssysvendas.Fragments.PedidosFragment;
import net.plugsoft.pssysvendas.LibClass.Callback.AutorizaCallback;
import net.plugsoft.pssysvendas.LibClass.Callback.EmpresaCallback;
import net.plugsoft.pssysvendas.LibClass.Callback.RomaneioCallback;
import net.plugsoft.pssysvendas.LibClass.Callback.RomaneioPedidoCallback;
import net.plugsoft.pssysvendas.LibClass.Empresa;
import net.plugsoft.pssysvendas.LibClass.QrCodeToken;
import net.plugsoft.pssysvendas.LibClass.RecyclerViewClickInterface;
import net.plugsoft.pssysvendas.LibClass.Romaneio;
import net.plugsoft.pssysvendas.LibClass.RomaneioPedido;
import net.plugsoft.pssysvendas.LibClass.RomaneioStatus;
import net.plugsoft.pssysvendas.LibClass.UsuarioToken;
import net.plugsoft.pssysvendas.LibClass.Util;
import net.plugsoft.pssysvendas.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RomaneioActivity extends AppCompatActivity implements RomaneioCallback, EmpresaCallback,
        RomaneioPedidoCallback, AutorizaCallback {
    // Variáveis privadas
    private AlertDialog alert;
    private final String BASE_URL = "http://gestorapi.plugsoft.net/";
    private QrCodeToken qrCodeToken;
    private UsuarioToken _usuarioToken;
    private String token;

    private Romaneio _romaneio;
    private Empresa _empresa;
    private List<RomaneioPedido> _romaneioPedidos;

    // Elementos de interface
    private TextView txtEmpresa;
    private TextView txtDtCadastro;
    private TextView txtDtEntrada;
    private TextView txtSituacao;

    RecyclerView recyclerViewPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romaneio);

        txtEmpresa = findViewById(R.id.txtRomaneioEmpresa);
        txtDtCadastro = findViewById(R.id.txtRomaneioCadastro);
        txtDtEntrada = findViewById(R.id.txtRomaneioEntrada);
        txtSituacao = findViewById(R.id.txtRomaneioSituacao);
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificaRomaneioValido();
        getToken();


    }

    // Métodos privados das funcionalidades
    // Gera token válido
    private void getToken() {
        try {
            if(qrCodeToken != null) {
                AutorizaController autorizaController = new AutorizaController(this, BASE_URL);
                autorizaController.postAutoriza(this, qrCodeToken);
            } else {
                throw new Exception("Leia o QR Code para validar Romaneio!");
            }

        } catch(Exception e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void verificaRomaneioValido() {
        qrCodeToken = Util.getDadosRomaneio(this);
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
                        finish();
                    }
                });
                alert = builder.create();
                alert.show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "ERRO: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Le dados Romaneio
    public void getRomaneio(int id) {
        try {
            RomaneioController romaneioController = new RomaneioController(this, BASE_URL);
            romaneioController.getRomaneio(this, token, id);
        } catch (Exception e) {
            Toast.makeText(this, "ERRO: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Le dados Empresa
    public void getEmpresa(int empKey) {
        try {
            EmpresaController empresaController = new EmpresaController(this, BASE_URL);
            empresaController.getEmpresa(this, token, _romaneio.getRomEmpKey());
        } catch (Exception e) {
            Toast.makeText(this, "ERRO: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Le a lista de pedidos do romaneio
    public void getPedidos(int id) {
        try {
            RomaneioPedidoController romaneioPedidoController = new RomaneioPedidoController(this, BASE_URL);
            romaneioPedidoController.getRomaneioPedidos(this, token, id);
        } catch (Exception e) {
            Toast.makeText(this, "ERRO: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // Implementações interfaces
    @Override
    public void onGetRomaneioSuccess(Romaneio romaneio) {
        if(romaneio != null) {
            _romaneio = romaneio;
            getEmpresa(_romaneio.getRomEmpKey());
        }
    }

    @Override
    public void onRomaneioFailure(String message) {
        Toast.makeText(this, "ERRO: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetEmpresasSuccess(List<Empresa> empresas) {

    }

    @Override
    public void onGetEmpresaSuccess(Empresa empresa) {
        if(empresa != null) {
            _empresa = empresa;
            txtEmpresa.setText(_empresa.getEmpNome());
            txtDtCadastro.setText(_romaneio.getRomDataCad());
            txtDtEntrada.setText(_romaneio.getRomDataEnt());

            txtSituacao.setText(Util.getSituacaoRomaneio(_romaneio.getRomStatus()));
            getPedidos(_romaneio.getRomKey());
        }
    }

    @Override
    public void onEmpresaFailure(String message) {
        Toast.makeText(this, "ERRO: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetRomaneioPedidoSuccess(List<RomaneioPedido> romaneioPedidos) {
        if(!romaneioPedidos.isEmpty()) {
            _romaneioPedidos = romaneioPedidos;
            // Fazer chamada para o fragment pedidos

            PedidosFragment pedidosFragment = PedidosFragment.newInstance((ArrayList<RomaneioPedido>) _romaneioPedidos);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout_pedidos, pedidosFragment)
                    .commit();
            //replaceFragment(pedidosFragment);
        } else {
            Toast.makeText(this, "Romaneio NÃO possui Pedidos Vinculados!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRomaneioPedidoFailure(String message) {
        Toast.makeText(this, "ERRO: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetAutorizaSuccess(String message) {

    }

    @Override
    public void onPostAutorizaSuccess(UsuarioToken usuarioToken) {
        if(usuarioToken != null) {
            _usuarioToken =  usuarioToken;
            token = "Bearer " + _usuarioToken.getToken();
            if(qrCodeToken != null) {
                getRomaneio(qrCodeToken.getRomKey());
            }
        }
    }

    @Override
    public void onAutorizaFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}