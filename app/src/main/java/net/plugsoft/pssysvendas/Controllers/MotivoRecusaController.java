package net.plugsoft.pssysvendas.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.plugsoft.pssysvendas.LibClass.Callback.MotivoRecusaCallback;
import net.plugsoft.pssysvendas.LibClass.MotivoRecusa;
import net.plugsoft.pssysvendas.LibClass.MotivoRecusaDeserializer;
import net.plugsoft.pssysvendas.LibClass.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MotivoRecusaController {
    private final String BASE_URL;
    private final Context _context;

    public MotivoRecusaController(Context context, String url) {
        _context = context;
        BASE_URL = url;
    }

    public void getMotivosRecusaByEmpresa(MotivoRecusaCallback callback, int id) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(MotivoRecusa.class, new MotivoRecusaDeserializer())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitServices service = retrofit.create(RetrofitServices.class);

        Call<List<MotivoRecusa>> motivosRecusa = service.getMotivosRecusaByEmpresa(id);

        motivosRecusa.enqueue(new Callback<List<MotivoRecusa>>() {
            @Override
            public void onResponse(Call<List<MotivoRecusa>> call, Response<List<MotivoRecusa>> response) {
                if(response.isSuccessful()) {
                    callback.onGetMotivoRecusaByEmpresaSuccess(response.body());
                } else {
                    callback.onMotivoRecusaFailure("ERRO: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<MotivoRecusa>> call, Throwable t) {
                Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
