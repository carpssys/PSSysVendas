package net.plugsoft.pssysvendas.LibClass.Callback;

import net.plugsoft.pssysvendas.LibClass.UsuarioToken;

public interface AutorizaCallback {
    void onPostAutorizaSuccess(UsuarioToken usuarioToken);
    void onAutorizaFailure(String message);
}
