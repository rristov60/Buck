package mk.riste.buck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ServicesFragment extends Fragment {

    ArrayList<Business> businesses;
    SearchView sv;
    ServicesFragment(ArrayList<Business> businesses) {
        this.businesses = businesses;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_services, container, false);
        ListView lv = rootView.findViewById(R.id.servicesList);
        sv = rootView.findViewById(R.id.search_services);
        CustomAdapter adapter = new CustomAdapter(this.getActivity(), getServicesBusinesses(businesses));
        lv.setAdapter(adapter);
        sv.setQueryHint("Search by business name");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return rootView;
    }

    private ArrayList<Business> getServicesBusinesses(ArrayList<Business> allBusinesses) {
        // Get from Azure
        ArrayList<Business> businesses = new ArrayList<Business>();
        if(allBusinesses != null) {
            for(int i = 0; i < allBusinesses.size(); i++) {
                if(allBusinesses.get(i).getCategory().equals("Services")) {
                    businesses.add(allBusinesses.get(i));
                }
            }
        }

        return businesses;
    }

    @NonNull
    @Override
    public String toString() {
        return "Services";
    }
}