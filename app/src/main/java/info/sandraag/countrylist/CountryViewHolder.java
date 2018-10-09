package info.sandraag.countrylist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    private TextView countryView;

    public CountryViewHolder(View itemView) {
        super(itemView);

        countryView = itemView.findViewById(R.id.countryView);
    }

    public void bind(String country) {

        countryView.setText(country);
    }
}
