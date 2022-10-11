    package net.plugsoft.pssysvendas.Controllers;

    import android.content.Context;
    import android.widget.Toast;

    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import net.plugsoft.pssysvendas.LibClass.Callback.EmpresaCallback;
    import net.plugsoft.pssysvendas.LibClass.Empresa;
    import net.plugsoft.pssysvendas.LibClass.EmpresaDeserializer;
    import net.plugsoft.pssysvendas.LibClass.RetrofitServices;

    import java.util.List;

    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;
    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;

    public class EmpresaController {

        private final String BASE_URL;
        private final Context _context;

        // Construtor - Injeta contexto e url base
        public EmpresaController(Context context, String url) {
            _context = context;
            BASE_URL = url;
        }

        // Retorna a empresa pelo seu id
        public void getEmpresa(final EmpresaCallback callback, int id) throws Exception {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Empresa.class, new EmpresaDeserializer())
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            RetrofitServices empresaService = retrofit.create(RetrofitServices.class);

            Call<Empresa> empresa = empresaService.getEmpresa(id);
            empresa.enqueue(new Callback<Empresa>() {
                @Override
                public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                    if(response.isSuccessful()) {
                        callback.onGetEmpresaSuccess(response.body());
                    } else {
                        callback.onEmpresaFailure("ERRO: " + response.code() + " - " + response.message());
                    }
                }

                @Override
                public void onFailure(Call<Empresa> call, Throwable t) {
                    Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

        // Retorna a empresa pelo CNPJ
        public void getEmpresa(final EmpresaCallback callback, String cnpj) throws Exception {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Empresa.class, new EmpresaDeserializer())
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            RetrofitServices empresaService = retrofit.create(RetrofitServices.class);

            Call<Empresa> empresa = empresaService.getEmpresa(cnpj);
            empresa.enqueue(new Callback<Empresa>() {
                @Override
                public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                    if(response.isSuccessful()) {
                        callback.onGetEmpresaSuccess(response.body());
                    } else {
                        callback.onEmpresaFailure("ERRO: " + response.code() + " - " + response.message());
                    }
                }

                @Override
                public void onFailure(Call<Empresa> call, Throwable t) {
                    Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

        // Retorna as empresas habilitadas na nuvem
        public void getEmpresas(final EmpresaCallback callback) throws Exception {
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Empresa.class, new EmpresaDeserializer())
                        .create();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                RetrofitServices empresaService = retrofit.create(RetrofitServices.class);

                Call<List<Empresa>> empresas = empresaService.getEmpresas();
                empresas.enqueue(new Callback<List<Empresa>>() {
                    @Override
                    public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                        if(response.isSuccessful()) {
                            callback.onGetEmpresasSuccess(response.body());
                        } else {
                            callback.onEmpresaFailure("ERRO: " + response.code() + " - " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Empresa>> call, Throwable t) {
                        Toast.makeText(_context, "ERRO: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        }
    }
