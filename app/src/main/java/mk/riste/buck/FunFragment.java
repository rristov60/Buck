package mk.riste.buck;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class FunFragment extends Fragment {

    ArrayList<Business> businesses;

    FunFragment(ArrayList<Business> businesses){
        this.businesses = businesses;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fun, container, false);
        ListView lv = rootView.findViewById(R.id.funList);
        CustomAdapter adapter = null;

        try {
            adapter = new CustomAdapter(this.getActivity(), getFunBusinesses(businesses));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        lv.setAdapter(adapter);
        return rootView;
    }

    private ArrayList<Business> getFunBusinesses(ArrayList<Business> allBusinesses) throws UnknownHostException {
        // Get from Azure
        ArrayList<Business> businesses = new ArrayList<Business>();
        for(int i = 0; i < allBusinesses.size(); i++) {
            if(allBusinesses.get(i).getCategory().equals("Fun")) {
                businesses.add(allBusinesses.get(i));
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