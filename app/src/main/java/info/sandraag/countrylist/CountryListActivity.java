package info.sandraag.countrylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryListActivity extends AppCompatActivity {

    private RecyclerView countryListView;
    private List<String> countries; // List és una Interface (classe abstracta que només conté mètodes virtuals purs).
    private CountryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        String[] arrayCountries = getResources().getStringArray(R.array.countries);
        countries = Arrays.asList(arrayCountries);

        /*
        countries = new ArrayList<>(); // ArrayList té tots els mètodes de List.
        countries.add("Portugal");
        countries.add("Spain");
        countries.add("France");
        for (int i = 0; i < 200; ++i)
        {
            countries.add("Country " + i);
        }
        */

        countryListView = findViewById(R.id.countryListView);
        countryListView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CountryListAdapter(this, countries);
        countryListView.setAdapter(adapter);

        countryListView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // Un RecyclerView no té listeners. Per això, hem de posar el listener al Adapter
        adapter.setOnClickListener(new CountryListAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                String country = countries.get(position);
                Intent data = new Intent(); // Informació
                data.putExtra("country", country);
                setResult(RESULT_OK, data);
                finish(); // L'activitat actual s'acaba
            }
        });
    }
}
