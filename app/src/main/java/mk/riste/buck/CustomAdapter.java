package mk.riste.buck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Business> businesses;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Business> businesses) {
        this.c = c;
        this.businesses = businesses;
    }

    @Override
    public int getCount() {
        return businesses.size();
    }

    @Override
    public Object getItem(int position) {
        return businesses.get(position);
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

        String name = businesses.get(position).getName();
        int image = businesses.get(position).getImage();

        nameTxt.setText(name);
        img.setImageResource(image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c, name, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
