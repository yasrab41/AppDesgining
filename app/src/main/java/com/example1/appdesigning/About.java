package com.example1.appdesigning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class About extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        bottomNavigation = findViewById(R.id.bottomNavigation);

        //Add menu item
        bottomNavigation.add(new MeowBottomNavigation.Model(R.id.nofication, R.drawable.notifications));
        bottomNavigation.add(new MeowBottomNavigation.Model(R.id.home, R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(R.id.about, R.drawable.about));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                // Initialize fragment
                //Fragment fragment = null;


                switch (item.getId()) {
                    case R.id.home:


                        // fragment = new NoficationFragment();

                        Intent intent = new Intent(About.this, MainActivity2.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.about:
                        // fragment = new AddRelativesFragment();

//                        Intent intent2 = new Intent(About.this, About.class);
//                        startActivity(intent2);
//                        overridePendingTransition(0,0);
//                        Intent intent2 = new Intent(MainActivity2.this, MainActivity2.class);
//                        startActivity(intent2);
                        break;
                    case R.id.nofication:

                        Intent intent3 = new Intent(About.this, Notification.class);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        break;
                }
                // loadFragment(fragment);
            }
        });

//        //Set nofication count
//        bottomNavigation.setCount(1, "10");
//
//        //Set home fragment initially selected
        bottomNavigation.show(R.id.about,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //display toast
                Toast.makeText(getApplicationContext(), "You clicked "+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //display toast
                Toast.makeText(getApplicationContext(), "You Reselected "+ item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}