package hr.kruno.viseaktivnosti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int ID_AKTIVNOSTI = 1;
    private final int ID_DRUGE_AKTIVNOSTI = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pozoviAktivnost(View v){
        // Pozvat će aktivnost koja je upravljana klasom NistaneVracaActivity
        Intent i = new Intent(this, NistaNeVracaActivity.class);
        // Šalje se 1 parametar - String s ključem "poruka" i vrijednošću "Dobar dan!"
        // Ako se drugoj aktivnosti ne šalju parametri, ovaj redak nije potreban
        i.putExtra("poruka","Dobra večer!");
        // Poziv aktivnosti koja ništa ne vraća pozivatelju
        startActivity(i);
    }
    public void pozoviAktivnostKojaVraca(View v){
        // Pozvat će aktivnost koja je upravljana klasom VracaPozivateljuActivity
        Intent i = new Intent(this, VracaPozivateljuActivity.class);
        // Šalje se 1 parametar - String s ključem "poruka" i vrijednošću "Dobar dan!"
        // Ako se drugoj aktivnosti ne šalju parametri, ovaj redak nije potreban
        i.putExtra("poruka","Dobar dan!");
        // Poziv aktivnosti koja vraća rezultat pozivatelju
        startActivityForResult(i, ID_AKTIVNOSTI);
    }
    public void pozoviAktivnostKojaVracaDruga(View v){
        // Pozvat će aktivnost koja je upravljana klasom VracaPozivateljuDrugaActivity
        Intent i = new Intent(this, VracaPozivateljuDrugaActivity.class);
        // Poziv aktivnosti koja vraća rezultat pozivatelju
        startActivityForResult(i, ID_DRUGE_AKTIVNOSTI);
    }

    // Ova metoda se automatski izvodi nakon što pozvana aktivnost završi izvođenje
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Provjerava je li druga aktivnost uspješno završila
        // Služi za identifikaciju određene aktivnosti
        if (requestCode == ID_AKTIVNOSTI) {
            if (resultCode == Activity.RESULT_OK) {
                // dohvaća podatke koje je u poslani objekt tipa Intent dodala pozvana aktivnost
                String povratna = data.getStringExtra("povratnaPoruka");
                TextView vracen = findViewById(R.id.vracen);
                vracen.setText(povratna);
            }
        } else if (requestCode == ID_DRUGE_AKTIVNOSTI) {
            if (resultCode == Activity.RESULT_OK) {
                // dohvaća podatke koje je u poslani objekt tipa Intent dodala pozvana aktivnost
                boolean povratna = data.getBooleanExtra("povratnaPoruka", false);
                TextView vracen = findViewById(R.id.vracenDrugi);
                String novi = (povratna) ? "ISTINA":"LAŽ";
                vracen.setText(novi);
            }
        }
    }


}
