package net.plugsoft.pssysvendas.LibClass.Callback;

import net.plugsoft.pssysvendas.LibClass.Funcionario;

import java.util.List;

public interface FuncionarioCallback {
    void onGetFuncionariosSuccess(List<Funcionario> funcionarios);
    void onFuncionarioFailure(String message);
}
