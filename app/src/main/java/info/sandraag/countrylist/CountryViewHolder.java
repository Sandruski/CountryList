package info.sandraag.countrylist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    private TextView countryView;

    public CountryViewHolder(View itemView, final CountryListAdapter.OnClickListener listener) {
        super(itemView);
        countryView = itemView.findViewById(R.id.countryView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();

                if (listener != null && position != RecyclerView.NO_POSITION)
                    listener.onClick(position);
            }
        });
    }

    public void bind(String country) {

        countryView.setText(country);
    }
}
