package hr.kruno.viseaktivnosti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

public class VracaPozivateljuDrugaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vraca_pozivatelju_druga);
    }
    public void vratiNatrag(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVraca
        Switch s = findViewById(R.id.switch1);
        // Pozivatelju se povratna vrijednost vraća unutar parametara onog intenta
        //   koji je pozivateljj poslao ovoj aktivnosti (nadopunjavaju se parametri).
        Intent i = new Intent();
        i.putExtra("povratnaPoruka", s.isChecked());
        // Sve je Ok
        setResult(Activity.RESULT_OK, i);
        // završetak - potvrda
        finish();
    }
}