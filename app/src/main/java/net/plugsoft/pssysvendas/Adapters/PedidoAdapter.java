package net.plugsoft.pssysvendas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.plugsoft.pssysvendas.LibClass.RomaneioPedido;
import net.plugsoft.pssysvendas.LibClass.Util;
import net.plugsoft.pssysvendas.R;

import java.util.ArrayList;

public class PedidoAdapter  extends RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder> {
    Context _context;
    ArrayList<RomaneioPedido> pedidos;

    public PedidoAdapter(Context context, ArrayList<RomaneioPedido> listaPedidos) {
        _context = context;
        pedidos = listaPedidos;
    }

    @NonNull
    @Override
    public PedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(_context).inflate(R.layout.lv_pedidos, parent, false);
        return new PedidoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidoViewHolder holder, int position) {
        RomaneioPedido romaneioPedido = pedidos.get(position);
        holder.txtNumPedido.setText(String.valueOf(romaneioPedido.getRomPedNumero()));
        if(romaneioPedido.getRomPedDataRecebimento() != null) {
            holder.txtDtReceb.setText(romaneioPedido.getRomPedDataRecebimento());
        } else {
            holder.txtDtReceb.setText("");
        }

        holder.txtSituacao.setText(Util.getSituacaoRomaneio(romaneioPedido.getRomPedStatus()));
        holder.txtPedidoNome.setText(romaneioPedido.getRomPedNomePedido());
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public static class PedidoViewHolder extends RecyclerView.ViewHolder {
        // Declarar elementos a serem associados da listview
        TextView txtNumPedido;
        TextView txtDtReceb;
        TextView txtSituacao;
        TextView txtPedidoNome;

        public PedidoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Associar campos do pedido do layout da lista
            txtNumPedido = itemView.findViewById(R.id.txtLvPedidoNumPedido);
            txtDtReceb = itemView.findViewById(R.id.txtLvPedidoDtReceb);
            txtSituacao = itemView.findViewById(R.id.txtLvPedidoSituacao);
            txtPedidoNome = itemView.findViewById(R.id.txtLvPedidoNome);

            //txtNumPedido.setText();
        }
    }
}
