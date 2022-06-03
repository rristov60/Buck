package mk.riste.buck;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<Business> businesses;
    ArrayList<Business> filteredBusinesses;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Business> businesses) {
        this.c = c;
        this.businesses = businesses;
        this.filteredBusinesses = businesses;
    }

    @Override
    public int getCount() {
        return filteredBusinesses.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredBusinesses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(inflater == null)
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null)
            view = inflater.inflate(R.layout.model, parent, false);

        TextView nameTxt = (TextView) view.findViewById(R.id.business_name);
        TextView description = (TextView) view.findViewById(R.id.business_description);
        ImageView img = (ImageView) view.findViewById(R.id.business_image);

        String name = filteredBusinesses.get(position).getName();
        int image = filteredBusinesses.get(position).getImage();

        Business theBusiness = businesses.get(position);

        nameTxt.setText(name);
        img.setImageResource(image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch activity to see the business information
                Intent intent = new Intent(c, ViewBusiness.class);

                intent.putExtra("name", theBusiness.getName());
                intent.putExtra("address", theBusiness.getAddress());
                intent.putExtra("latitude", theBusiness.getLatitude());
                intent.putExtra("longitude", theBusiness.getLongitude());
                intent.putExtra("eMail", theBusiness.geteMail());
                intent.putExtra("telephone", theBusiness.getTelephone());
                intent.putExtra("webSite", theBusiness.getWebSite());
                intent.putExtra("image", theBusiness.getImage());
                intent.putExtra("description", theBusiness.getDescription());


                c.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if (constraint == null || constraint.length() == 0) {
                    //no constraint given, just return all the data. (no search)
                    results.count = businesses.size();
                    results.values = businesses;
                } else {//do the search
                    List<Business> resultsData = new ArrayList<>();
                    String searchStr = constraint.toString().toUpperCase();
                    for (Business b : businesses)
                        if (b.getName().toUpperCase().contains(searchStr)) resultsData.add(b);
                    results.count = resultsData.size();
                    results.values = resultsData;
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredBusinesses = (ArrayList<Business>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
