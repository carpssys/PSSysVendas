package net.plugsoft.pssysvendas.LibClass.Callback;

import net.plugsoft.pssysvendas.LibClass.Romaneio;

public interface RomaneioCallback {
    void onGetRomaneioSuccess(Romaneio romaneio);
    void onRomaneioFailure(String message);
}
