package hr.kruno.viseaktivnosti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VracaPozivateljuActivity extends AppCompatActivity {
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Druga aktivnost");
        setContentView(R.layout.activity_vraca_pozivatelju);
        i = getIntent();
        // Parametar je niz znakova
        String poruka = i.getStringExtra("poruka");
        TextView dobiven = (TextView)findViewById(R.id.dobiven);
        dobiven.setText(poruka);
    }

    public void vratiNatrag(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVraca
        EditText ed = findViewById(R.id.ed);
        // Pozivatelju se povratna vrijednost vraća unutar parametara onog intenta
        //   koji je pozivateljj poslao ovoj aktivnosti (nadopunjavaju se parametri).
        Intent i = new Intent();
        i.putExtra("povratnaPoruka", ed.getText().toString());
        // Sve je Ok
        setResult(Activity.RESULT_OK, i);
        // završetak - potvrda
        finish();
    }
}
