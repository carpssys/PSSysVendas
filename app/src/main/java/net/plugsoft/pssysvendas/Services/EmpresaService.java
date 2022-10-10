package net.plugsoft.pssysvendas.Services;

import android.content.Context;
import android.widget.Toast;

import net.plugsoft.pssysvendas.Controllers.EmpresaController;
import net.plugsoft.pssysvendas.LibClass.Callback.EmpresaCallback;
import net.plugsoft.pssysvendas.LibClass.Empresa;

import java.util.List;

public class EmpresaService implements EmpresaCallback {
    private Context _context;
    private String BASE_URL;

    private Empresa _empresa;
    private List<Empresa> _empresas;

    public EmpresaService(Context context, String url) {
        _context = context;
        BASE_URL = url;
    }

    // Retorna a empresa pelo id
    public Empresa getEmpresa(int id) {
        try {
            EmpresaController empresaController = new EmpresaController(_context, BASE_URL);
            empresaController.getEmpresa(this, id);
        }
        catch (Exception e) {
            Toast.makeText(_context , e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            return _empresa;
        }
    }

    public List<Empresa> getEmpresas() {
        try {
            EmpresaController empresaController = new EmpresaController(_context, BASE_URL);
            empresaController.getEmpresas(this);
        }
        catch (Exception e) {
            Toast.makeText(_context , e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            return _empresas;
        }
    }

    @Override
    public void onGetEmpresasSuccess(List<Empresa> empresas) {
        if(!empresas.isEmpty()) {
            _empresas = empresas;
        }
    }

    @Override
    public void onGetEmpresaSuccess(Empresa empresa) {
        if(empresa != null) {
            _empresa = empresa;
        }
    }

    @Override
    public void onEmpresaFailure(String message) {
        Toast.makeText(_context , message, Toast.LENGTH_SHORT).show();
    }
}
