package com.example.exaula5;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;

public class ExAula5ListActivity extends ListActivity implements AdapterView.OnItemClickListener{

    String[] array = {"Lamb Ari", "Beto Neira", "Brita Deira", "Gil Ete", "Astolfo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_aula5_list_activity);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  Arrays.asList(array));
        //passa a escutar e as reacoes sao trazidas
        //para onItemClick
        ListView listView = getListView();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selecao = array[i];
                Intent intent = new Intent(getApplicationContext(), ExAula5ActivityFinal.class);
                intent.putExtra("nome", selecao);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView = (TextView) view;

        String conteudo = "Nome: " + textView.getText().toString();
        //this ou getApplicationContext()
        Toast.makeText(this, conteudo, Toast.LENGTH_SHORT).show();
    }
}
