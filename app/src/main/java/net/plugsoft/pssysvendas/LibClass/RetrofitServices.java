package net.plugsoft.pssysvendas.LibClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitServices {
    // Empresas
    // Lista as empresas habilitadas na web
    @GET("Empresas")
    Call<List<Empresa>> getEmpresas();

    // Retorna a empresa pelo seu id
    @GET("Empresas/{id}")
    Call<Empresa> getEmpresa(@Path(value = "id", encoded = true) int id);

}
