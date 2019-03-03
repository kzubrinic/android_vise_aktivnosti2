package hr.kruno.viseaktivnosti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NistaNeVracaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Aktivnost koja ništa ne vraća pozivatelju");
        setContentView(R.layout.activity_nista_ne_vraca);
        // Dohvat parametara od strane pozivatelja
        Intent intent = getIntent();
        // Parametar je niz znakova
        String poruka = intent.getStringExtra("poruka");
        TextView tv = findViewById(R.id.tv);
        tv.setText(poruka);
    }
}
