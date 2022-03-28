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

public class ServicesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_services, container, false);
        ListView lv = rootView.findViewById(R.id.servicesList);
        CustomAdapter adapter = new CustomAdapter(this.getActivity(), getFunBusinesses());
        lv.setAdapter(adapter);
        return rootView;
    }

    private ArrayList<Business> getFunBusinesses() {
        ArrayList<Business> businesses = new ArrayList<>();
//
//        Business business1 = new Business("Riste Business", "Copernicus",
//                29.22, 34.55,
//                "ristov@riste.mk", "+389 70 000 000", "riste.mk", Category.Services, R.drawable.ic_fun);
//        Business business2 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business3 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business4 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business5 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business6 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business7 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business8 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business9 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business10 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business11 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//        Business business12 = new Business("Ivan Business", "Copernicus",
//                43.12, 44.25,
//                "ivan@business.mk", "+389 71 111 111", "ivan.mk", Category.Services, R.drawable.ic_fun);
//
//
//        businesses.add(business1);
//        businesses.add(business2);
//        businesses.add(business3);
//        businesses.add(business4);
//        businesses.add(business5);
//        businesses.add(business6);
//        businesses.add(business7);
//        businesses.add(business8);
//        businesses.add(business9);
//        businesses.add(business10);
//        businesses.add(business11);
//        businesses.add(business12);


        return businesses;
    }

    @NonNull
    @Override
    public String toString() {
        return "Services";
    }
}