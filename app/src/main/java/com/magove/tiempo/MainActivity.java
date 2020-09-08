package com.magove.tiempo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_entrar = findViewById(R.id.id_btnIngresa);
    }

    public void ingresa(View v) {
        // REALIZAR LLAMADAS EN ANDROID

      /*  Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:5535504613"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)

            return;

        startActivity(intent);*/

      Intent intent = new Intent(this,Menu.class);
      startActivity(intent);
      finish();

}
}