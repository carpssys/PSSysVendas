package net.plugsoft.pssysvendas.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.plugsoft.pssysvendas.LibClass.Callback.FuncionarioCallback;
import net.plugsoft.pssysvendas.LibClass.Funcionario;
import net.plugsoft.pssysvendas.LibClass.FuncionarioDeserializer;
import net.plugsoft.pssysvendas.LibClass.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FuncionarioController {
    private final String BASE_URL;
    private final Context _context;

    // Construtor
    public FuncionarioController(Context context, String url) {
        _context = context;
        BASE_URL = url;
    }

    // Retorna os funcionários de uma empresa
    public void getFuncionarios(final FuncionarioCallback callback, int id) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Funcionario.class, new FuncionarioDeserializer())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitServices service = retrofit.create(RetrofitServices.class);
        Call<List<Funcionario>> funcionario = service.getFuncionarios(id);
        funcionario.enqueue(new Callback<List<Funcionario>>() {
            @Override
            public void onResponse(Call<List<Funcionario>> call, Response<List<Funcionario>> response) {
                if(response.isSuccessful()) {
                    callback.onGetFuncionariosSuccess(response.body());
                } else {
                    callback.onFuncionarioFailure("ERRO: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Funcionario>> call, Throwable t) {
                Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
