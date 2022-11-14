package net.plugsoft.pssysvendas.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.plugsoft.pssysvendas.LibClass.Callback.CidadeCallback;
import net.plugsoft.pssysvendas.LibClass.Cidade;
import net.plugsoft.pssysvendas.LibClass.CidadeDeserializer;
import net.plugsoft.pssysvendas.LibClass.Empresa;
import net.plugsoft.pssysvendas.LibClass.RetrofitServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CidadeController {
    private final String BASE_URL;
    private final Context _context;

    public CidadeController(Context context, String url) {
        _context = context;
        BASE_URL = url;
    }

    // Retorna a cidade pelo seu código IBGE
    public void getCidade(final CidadeCallback callback, String token, int cidCodigo) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Empresa.class, new CidadeDeserializer())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitServices cidadeService = retrofit.create(RetrofitServices.class);

        Call<Cidade> cidade = cidadeService.getCidade(token, cidCodigo);
        cidade.enqueue(new Callback<Cidade>() {
            @Override
            public void onResponse(Call<Cidade> call, Response<Cidade> response) {
                if(response.isSuccessful()) {
                    callback.onGetCidadeSuccess(response.body());
                } else {
                    callback.onCidadeFailure("ERRO: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Cidade> call, Throwable t) {
                Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
