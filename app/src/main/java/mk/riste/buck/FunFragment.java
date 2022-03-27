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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fun, container, false);
        ListView lv = rootView.findViewById(R.id.funList);
        CustomAdapter adapter = null;
        try {
            adapter = new CustomAdapter(this.getActivity(), getFunBusinesses());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        lv.setAdapter(adapter);
        return rootView;
    }

    private ArrayList<Business> getFunBusinesses() throws UnknownHostException {
//        // Get from mongo
        ArrayList<Business> businesses = new ArrayList<>();
        Business business1 = new Business("Riste Business", "Copernicus", "",
                29.22, 34.55,
                "ristov@riste.mk", "+389 70 000 000", "riste.mk", Category.Fun, R.drawable.ic_fun);
        Business business2 = new Business("Ivan Business", "Copernicus", "",
                43.12, 44.25,
                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Fun, R.drawable.ic_fun);
        businesses.add(business1);
        businesses.add(business2);
        return businesses;
    }

    @NonNull
    @Override
    public String toString() {
        return "Fun";
    }
}