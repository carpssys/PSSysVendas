package net.plugsoft.pssysvendas.LibClass.Callback;

import net.plugsoft.pssysvendas.LibClass.Empresa;

import java.util.List;

public interface EmpresaCallback {
    void onGetEmpresasSuccess(List<Empresa> empresas);
    void onGetEmpresaSuccess(Empresa empresa);
    void onEmpresaFailure(String message);
}
