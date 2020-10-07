package com.example.exaula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class ExAula5ActivityFinal extends AppCompatActivity {
    private TextView txtNome;
    private Spinner spinnerUF;
    private ListView listaCidade;

    String[] uf = {"RS", "SC", "PA", "SP", "MG"};
    String [][] cidades = {
            new String[]{"Porto Alegre", "Rio Grande"},
            new String[]{"Florianopolis", "Joinville"},
            new String[]{"Curitiba", "Londrina"},
            new String[]{"Sao Paulo", "Campinas"},
            new String[]{"Belo Horizonte", "Iberaba"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_aula5_final);

        txtNome = findViewById(R.id.txtNome);
        spinnerUF = findViewById(R.id.spinnerUF);
        listaCidade = findViewById(R.id.listaCidade);

        Intent intent = getIntent();
        txtNome.setText(intent.getStringExtra("nome"));

        ArrayAdapter<CharSequence> adapterSpinner = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, uf);
        spinnerUF.setAdapter(adapterSpinner);
        spinnerUF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] selecao = getRow(i);
                ArrayAdapter<String> adapterListView = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(selecao));

                listaCidade.setAdapter(adapterListView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    public String[] getRow(int index){
        String[] row = new String[cidades[index].length];
        for (int i = 0; i < row.length; i++)
            row[i] = cidades[index][i];
        return row;
    }
}