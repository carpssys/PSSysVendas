package net.plugsoft.pssysvendas.LibClass.Callback;

import net.plugsoft.pssysvendas.LibClass.MotivoRecusa;

import java.util.List;

public interface MotivoRecusaCallback {
    void onGetMotivoRecusaByEmpresaSuccess(List<MotivoRecusa> motivosRecusa);
    void onMotivoRecusaFailure(String message);
}
