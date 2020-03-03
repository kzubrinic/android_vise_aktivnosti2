package hr.kruno.viseaktivnosti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int OK_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pozoviAktivnost(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVraca
        Intent i = new Intent(this, NistaNeVracaActivity.class);
        // Šalje se 1 parametar - String s ključem "poruka" i vrijednošću "Dobar dan!"
        // Ako se drugoj aktivnosti ne šalju parametri, ovaj redak nije potreban
        i.putExtra("poruka","Dobar dan!");
        // Poziv aktivnosti koja ništa ne vraća pozivatelju
        startActivity(i);
    }
    public void pozoviAktivnostKojaVraca(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVraca
        Intent i = new Intent(this, VracaPozivateljuActivity.class);
        // Šalje se 1 parametar - String s ključem "poruka" i vrijednošću "Dobar dan!"
        // Ako se drugoj aktivnosti ne šalju parametri, ovaj redak nije potreban
        i.putExtra("poruka","Dobar dan!");
        // Poziv aktivnosti koja vraća rezultat pozivatelju
        startActivityForResult(i, OK_CODE);
    }

    // Ova metoda se automatski izvodi nakon što pozvana aktivnost završi izvođenje
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Provjerava je li druga aktivnost uspješno završila
        // Služi za identifikaciju određene aktivnosti
        if (requestCode == OK_CODE) {
            if (resultCode == RESULT_OK) {
                // dohvaća podatke kojeje u poslani objekt tipa Intent dodala pozvana aktivnost
                String povratna = data.getStringExtra("povratnaPoruka");
                TextView vracen = findViewById(R.id.vracen);
                vracen.setText(povratna);
            }
        }
    }


}
