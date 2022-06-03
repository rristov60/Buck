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

import java.net.UnknownHostException;
import java.util.ArrayList;

public class FunFragment extends Fragment {

    ArrayList<Business> businesses;
    SearchView sv;
    FunFragment(ArrayList<Business> businesses){
        this.businesses = businesses;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fun, container, false);
        ListView lv = rootView.findViewById(R.id.funList);
        CustomAdapter adapter =  new CustomAdapter(this.getActivity(), getFunBusinesses(businesses));
        sv = rootView.findViewById(R.id.search_fun);

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

    private ArrayList<Business> getFunBusinesses(ArrayList<Business> allBusinesses) {
        // Get from Azure
        ArrayList<Business> businesses = new ArrayList<Business>();
        if(businesses != null) {
            for(int i = 0; i < allBusinesses.size(); i++) {
                if(allBusinesses.get(i).getCategory().equals("Fun")) {
                    businesses.add(allBusinesses.get(i));
                }
            }
        }

        return businesses;
    }

    @NonNull
    @Override
    public String toString() {
        return "Fun";
    }
}