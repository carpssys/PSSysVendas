package net.plugsoft.pssysvendas.LibClass.Callback;

import net.plugsoft.pssysvendas.LibClass.RomaneioPedido;

import java.util.List;

public interface RomaneioPedidoCallback {
    void onGetRomaneioPedidoSuccess(List<RomaneioPedido> romaneioPedidos);
    void onRomaneioPedidoFailure(String message);
}
