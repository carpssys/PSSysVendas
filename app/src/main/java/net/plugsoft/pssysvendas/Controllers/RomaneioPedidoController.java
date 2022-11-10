package net.plugsoft.pssysvendas.Controllers;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.plugsoft.pssysvendas.LibClass.Callback.RomaneioPedidoCallback;
import net.plugsoft.pssysvendas.LibClass.RetrofitServices;
import net.plugsoft.pssysvendas.LibClass.RomaneioPedido;
import net.plugsoft.pssysvendas.LibClass.RomaneioPedidoDeserializer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RomaneioPedidoController {
    private final String BASE_URL;
    private final Context _context;

    public RomaneioPedidoController(Context context, String url) {
        _context = context;
        BASE_URL = url;
    }

    public void getRomaneioPedidos(RomaneioPedidoCallback callback, int id ) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(RomaneioPedido.class, new RomaneioPedidoDeserializer())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitServices service = retrofit.create(RetrofitServices.class);

        Call<List<RomaneioPedido>> romaneioPedidos = service.getRomaneioPedidos(id);

        romaneioPedidos.enqueue(new Callback<List<RomaneioPedido>>() {
            @Override
            public void onResponse(Call<List<RomaneioPedido>> call, Response<List<RomaneioPedido>> response) {
                if(response.isSuccessful()) {
                    callback.onGetRomaneioPedidoSuccess(response.body());
                } else {
                    callback.onRomaneioPedidoFailure("ERRO: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<RomaneioPedido>> call, Throwable t) {
                Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
