package mk.riste.buck;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar mainToolbar;
    ImageView addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.add_btn);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBusinessActivity.class);
                startActivity(intent);
            }
        });



        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Services");
        arrayList.add("Fun");
        arrayList.add("Industry");
        arrayList.add("Education");

        tabLayout.setupWithViewPager(viewPager);
        prepareViewPager(viewPager, arrayList);

//        this.addPages();
    }

    private void addPages(){
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        SQLDB sqldb = new SQLDB();
        ArrayList<Business> businesses = sqldb.getBusiness();
        pagerAdapter.addFragment(new FunFragment(businesses));
        pagerAdapter.addFragment(new FunFragment(businesses));
        pagerAdapter.addFragment(new FunFragment(businesses));
        pagerAdapter.addFragment(new FunFragment(businesses));
//        pagerAdapter.addFragment(new MainFragment());

        viewPager.setAdapter(pagerAdapter);
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        MainFragment mainFragment = new MainFragment();

        SQLDB sqldb = new SQLDB();
        ArrayList<Business> businesses = sqldb.getBusiness();

        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putString("title", arrayList.get(i));
            mainFragment.setArguments(bundle);
            switch (i) {
                case 0:
                    adapter.addFragment(new ServicesFragment(businesses), arrayList.get(i));
                    break;
                case 1:
                    adapter.addFragment(new FunFragment(businesses), arrayList.get(i));
                    break;
                case 2:
                    adapter.addFragment(new IndustryFragment(businesses), arrayList.get(i));
                    break;
                case 3:
                    adapter.addFragment(new EducationFragment(businesses), arrayList.get(i));
                    break;
            }

            mainFragment = new MainFragment();
        }

        viewPager.setAdapter(adapter);
    }

    private class MainAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        int[] imageList = { R.drawable.ic_services, R.drawable.ic_fun, R.drawable.ic_industry,  R.drawable.ic_education };

        public void addFragment(Fragment fragment, String s) {
            fragmentArrayList.add(fragment);
            stringArrayList.add(s);
        }

        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), imageList[position]);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            SpannableString spannableString = new SpannableString(" \n" + stringArrayList.get(position));
            ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_CENTER);
            spannableString.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            return spannableString;
        }
    }
}