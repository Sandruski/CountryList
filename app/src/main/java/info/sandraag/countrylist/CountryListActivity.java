package info.sandraag.countrylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CountryListActivity extends AppCompatActivity {

    private RecyclerView countryListView;
    private List<String> countries; // List és una Interface (classe abstracta que només conté mètodes virtuals purs).
    private CountryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        countries = new ArrayList<>(); // ArrayList té tots els mètodes de List.
        countries.add("Portugal");
        countries.add("Spain");
        countries.add("France");

        countryListView = findViewById(R.id.countryListView);
        countryListView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CountryListAdapter(this, countries);
        countryListView.setAdapter(adapter);
    }
}
