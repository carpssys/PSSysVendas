package net.plugsoft.pssysvendas.LibClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitServices {
    // Cidades
    // Retorna cidade pelo seu código IBGE
    @GET("Cidades")
    Call<Cidade> getCidade(@Path(value = "id", encoded = true) int id);

    // Empresas
    // Lista as empresas habilitadas na web
    @GET("Empresas")
    Call<List<Empresa>> getEmpresas();

    // Retorna a empresa pelo seu id
    @GET("Empresas/{id}")
    Call<Empresa> getEmpresa(@Path(value = "id", encoded = true) int id);

    // Retorna a empresa pelo CNPJ
    @GET("Empresas/{cnpj}")
    Call<Empresa> getEmpresa(@Path(value = "cnpj", encoded = true) String cnpj);

    //Funcionarios
    // Retorna os funcionários de uma empresa
    @GET("Funcionarios/empresa/{id}")
    Call<List<Funcionario>> getFuncionarios(@Path(value = "id", encoded = true) int id);

    // Motivo Recusas
    // Retorna os motivos de uma empresa
    @GET("MotivosRecusoes/empresa/{id}")
    Call<List<MotivoRecusa>> getMotivosRecusaByEmpresa(@Path(value = "id", encoded = true) int id);

    // Romaneios
    // Retorna o Romaneio pelo seu id
    @GET("Romaneios/{id}")
    Call<Romaneio> getRomaneio(@Path(value = "id", encoded = true) int id);

    // Pedidos
    // Retorna os pedidos de um romaneio
    @GET("RomaneioPedidos/romaneio/{id}")
    Call<List<RomaneioPedido>> getRomaneioPedidos(@Path(value = "id", encoded = true) int id);

    // Itens dos pedidos

    // Itens recusados

}
