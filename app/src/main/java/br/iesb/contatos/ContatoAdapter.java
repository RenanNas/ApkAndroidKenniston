package br.iesb.contatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import Model.Contato;

/**
 * Created by 1514290039 on 10/03/2017.
 */

public class ContatoAdapter extends ArrayAdapter<Contato> {

    private LayoutInflater mInflater;
    private List<Contato> listaItens;

    public ContatoAdapter(Context context, int resource, List<Contato> listaItens) {
        super(context, resource);

        mInflater = LayoutInflater.from(context);
        listaItens = listaItens;

    }
    public View getView(int position, View convertView, ViewGroup parent) {

    View formatoItemLista = mInflater.inflate(R.layout.celula_lista, null);
        Contato contato = listaItens.get(position);


return null;
    }
}
