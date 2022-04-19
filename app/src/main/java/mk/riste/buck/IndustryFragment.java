package mk.riste.buck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class IndustryFragment extends Fragment {

    ArrayList<Business> businesses;

    IndustryFragment(ArrayList<Business> businesses) {
        this.businesses = businesses;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_industry, container, false);
        ListView lv = rootView.findViewById(R.id.industryList);
        CustomAdapter adapter = new CustomAdapter(this.getActivity(), getIndustryBusinesses(businesses));
        lv.setAdapter(adapter);
        return rootView;
    }

    private ArrayList<Business> getIndustryBusinesses(ArrayList<Business> allBusinesses) {
        // Get from Azure
        ArrayList<Business> businesses = new ArrayList<Business>();
        for(int i = 0; i < allBusinesses.size(); i++) {
            if(allBusinesses.get(i).getCategory().equals("Industry")) {
                businesses.add(allBusinesses.get(i));
            }
        }
        return businesses;
    }

    @NonNull
    @Override
    public String toString() {
        return "Industry";
    }
}
