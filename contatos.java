package com.example.gabi2.agendacontato;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class contatos extends ArrayAdapter<String>{

    private String[] ids;
    private String[] nomes;
    private Activity context;
    public static final String JSON_URL = "http://projetosfranca.com/mostrar.php";

    public contatos(Activity context, String[] ids, String[] nomes) {
        super(context, R.layout.contatos, ids);
        this.context = context;
        this.ids = ids;
        this.nomes = nomes;

    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.contatos, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);

        textViewId.setText(ids[position]);
        textViewName.setText(nomes[position]);

        return listViewItem;
    }
}
