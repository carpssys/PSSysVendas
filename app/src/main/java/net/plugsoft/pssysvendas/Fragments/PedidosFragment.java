package net.plugsoft.pssysvendas.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.plugsoft.pssysvendas.Adapters.PedidoAdapter;
import net.plugsoft.pssysvendas.Controllers.RomaneioController;
import net.plugsoft.pssysvendas.Controllers.RomaneioPedidoController;
import net.plugsoft.pssysvendas.LibClass.RecyclerViewClickInterface;
import net.plugsoft.pssysvendas.LibClass.RomaneioPedido;
import net.plugsoft.pssysvendas.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PedidosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PedidosFragment extends Fragment implements RecyclerViewClickInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PEDIDOS = "lista";

    private RecyclerView recyclerViewPedidos;
    private ArrayList<RomaneioPedido> pedidos;



    public PedidosFragment()  {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param //param1 Parameter 1.
     * @param //param2 Parameter 2.
     * @return A new instance of fragment PedidosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PedidosFragment newInstance(ArrayList<RomaneioPedido> listaPedidos)  {
        PedidosFragment fragment = new PedidosFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PEDIDOS, listaPedidos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pedidos, container, false);

        if(getArguments() != null) {
            pedidos = (ArrayList<RomaneioPedido>) getArguments().getSerializable(ARG_PEDIDOS);
        }

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //dataInitialize();

        recyclerViewPedidos = view.findViewById(R.id.rv_lista_pedidos);
        recyclerViewPedidos.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPedidos.setHasFixedSize(true);
        PedidoAdapter pedidoAdapter =new PedidoAdapter(getContext(), pedidos, this);

        recyclerViewPedidos.setAdapter(pedidoAdapter);
        pedidoAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLongItemClick(int position) {

    }
}