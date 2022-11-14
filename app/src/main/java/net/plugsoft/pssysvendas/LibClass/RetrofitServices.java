package net.plugsoft.pssysvendas.LibClass;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitServices {
    // Autoriza
    // Retorna mensagem de acesso
    @GET("Autoriza")
    Call<JsonObject> getAutoriza();

    @POST("Autoriza")
    Call<UsuarioToken> postAutoriza(@Body QrCodeToken qrCodeToken);

    // Cidades
    // Retorna cidade pelo seu código IBGE
    @GET("Cidades")
    Call<Cidade> getCidade(@Header("Authorization") String token,
                           @Path(value = "id", encoded = true) int id);

    // Empresas
    // Lista as empresas habilitadas na web
    @GET("Empresas")
    Call<List<Empresa>> getEmpresas(@Header("Authorization") String token);

    // Retorna a empresa pelo seu id
    @GET("Empresas/{id}")
    Call<Empresa> getEmpresa(@Header("Authorization") String token,
                             @Path(value = "id", encoded = true) int id);

    // Retorna a empresa pelo CNPJ
    @GET("Empresas/{cnpj}")
    Call<Empresa> getEmpresa(@Header("Authorization") String token,
                             @Path(value = "cnpj", encoded = true) String cnpj);

    //Funcionarios
    // Retorna os funcionários de uma empresa
    @GET("Funcionarios/empresa/{id}")
    Call<List<Funcionario>> getFuncionarios(@Header("Authorization") String token,
                                            @Path(value = "id", encoded = true) int id);

    // Motivo Recusas
    // Retorna os motivos de uma empresa
    @GET("MotivosRecusoes/empresa/{id}")
    Call<List<MotivoRecusa>> getMotivosRecusaByEmpresa(@Header("Authorization") String token,
                                                       @Path(value = "id", encoded = true) int id);

    // Romaneios
    // Retorna o Romaneio pelo seu id
    @GET("Romaneios/{id}")
    Call<Romaneio> getRomaneio(@Header("Authorization") String token,
                               @Path(value = "id", encoded = true) int id);

    // Pedidos
    // Retorna os pedidos de um romaneio
    @GET("RomaneioPedidos/romaneio/{id}")
    Call<List<RomaneioPedido>> getRomaneioPedidos(@Header("Authorization") String token,
                                                  @Path(value = "id", encoded = true) int id);

    // Itens dos pedidos

    // Itens recusados

}
