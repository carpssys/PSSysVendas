package net.plugsoft.pssysvendas.Controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.plugsoft.pssysvendas.LibClass.Callback.RomaneioCallback;
import net.plugsoft.pssysvendas.LibClass.RetrofitServices;
import net.plugsoft.pssysvendas.LibClass.Romaneio;
import net.plugsoft.pssysvendas.LibClass.RomaneioDeserializer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RomaneioController {
    private final String BASE_URL;
    private final Context _context;

    public RomaneioController(Context context, String url) {
        _context = context;
        BASE_URL = url;
    }

    // Retorna o romaneio pelo seu id
    public void getRomaneio(RomaneioCallback callback, String token, int id) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Romaneio.class, new RomaneioDeserializer())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitServices service = retrofit.create(RetrofitServices.class);

        Call<Romaneio> romaneio = service.getRomaneio(token, id);
        romaneio.enqueue(new Callback<Romaneio>() {
            @Override
            public void onResponse(Call<Romaneio> call, Response<Romaneio> response) {
                if(response.isSuccessful()) {
                    callback.onGetRomaneioSuccess(response.body());
                } else {
                    callback.onRomaneioFailure("ERRO: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Romaneio> call, Throwable t) {
                Log.d("error", t.getMessage());
                Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
