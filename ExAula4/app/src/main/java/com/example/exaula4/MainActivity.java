package com.example.exaula4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import java.io.File;

public class MainActivity extends AppCompatActivity{

    private Uri uri;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirContatos(View view) {
        Button btnContatos = findViewById(R.id.btnContatos);

        uri = Uri.parse("content://com.android.contacts/contacts");
        intent = new Intent(Intent.ACTION_PICK, uri);
        startActivity(intent);
    }

    public void abrirWeb(View view) {
        Button btnWeb = findViewById(R.id.btnWeb);

        uri = Uri.parse("http://www.unisc.br");
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void abrirCall(View view) {
        Button btnCall = findViewById(R.id.btnCall);

        uri = Uri.parse("tel: 985875880");
        intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void abrirMaps1(View view) {
        Button btnMaps1 = findViewById(R.id.btnMaps1);

        uri = Uri.parse("geo:0,0?q=Sete+de+Setembro,Curitiba");
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void abrirMaps2(View view) {
        Button btnMaps2 = findViewById(R.id.btnMaps2);

        uri = Uri.parse("geo:-25.443195,-49.280977");
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void abrirMaps3(View view) {
        Button btnMaps3 = findViewById(R.id.btnMaps3);

        uri = Uri.parse("https://maps.google.com/maps?f=d&saddr=-25.443195,-49.280977&daddr=-25.442207,-49.278403&hl=pt");
        intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void abrirPicIt(View view) {
        Button btnPicIt = findViewById(R.id.btnPicIt);

        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File imagesFolder = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // Create the storage directory if it does not exist
        if (! imagesFolder.exists()){
            if (! imagesFolder.mkdirs()){
                System.out.println("Faiô");
            }
        }
        File image = new File(imagesFolder.getPath(), "image_001.jpg");
        uri = Uri.fromFile(image);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        startActivityForResult(intent, 0);
    }
}