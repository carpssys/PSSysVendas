package net.plugsoft.pssysvendas.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import net.plugsoft.pssysvendas.LibClass.Callback.AutorizaCallback;
import net.plugsoft.pssysvendas.LibClass.QrCodeToken;
import net.plugsoft.pssysvendas.LibClass.RetrofitServices;
import net.plugsoft.pssysvendas.LibClass.UsuarioToken;
import net.plugsoft.pssysvendas.LibClass.UsuarioTokenDeserializer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AutorizaController {
    private final String BASE_URL;
    private final Context _context;

    public AutorizaController(Context context, String url) {
        _context = context;
        BASE_URL = url;
    }

    public void getAutoriza(final AutorizaCallback callback) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(UsuarioToken.class, new UsuarioTokenDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitServices service = retrofit.create(RetrofitServices.class);

        Call<JsonObject> autoriza = service.getAutoriza();
        autoriza.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()) {
                    callback.onGetAutorizaSuccess(response.body().getAsString());
                } else {
                    callback.onAutorizaFailure("ERRO: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void postAutoriza(final AutorizaCallback callback, QrCodeToken qrCodeToken) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(UsuarioToken.class, new UsuarioTokenDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitServices service = retrofit.create(RetrofitServices.class);
        Call<UsuarioToken> usuarioToken = service.postAutoriza(qrCodeToken);
        usuarioToken.enqueue(new Callback<UsuarioToken>() {
            @Override
            public void onResponse(Call<UsuarioToken> call, Response<UsuarioToken> response) {
                if(response.isSuccessful()) {
                    callback.onPostAutorizaSuccess(response.body());
                } else {
                    callback.onAutorizaFailure("ERRO: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<UsuarioToken> call, Throwable t) {
                Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
