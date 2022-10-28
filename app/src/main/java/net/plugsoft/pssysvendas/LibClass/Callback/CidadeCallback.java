package net.plugsoft.pssysvendas.LibClass.Callback;

import net.plugsoft.pssysvendas.LibClass.Cidade;

public interface CidadeCallback {
    void onGetCidadeSuccess(Cidade cidade);
    void onCidadeFailure(String message);
}
