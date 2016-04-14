package com.rflpazini.fpsj;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private static int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startAlert(getApplicationContext(), getString(R.string.about_app), getString(R.string.action_about));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            ImageView imgView = (ImageView) rootView.findViewById(R.id.section_image);
            final Button btnView = (Button) rootView.findViewById(R.id.button);

            pos = getArguments().getInt(ARG_SECTION_NUMBER);

            switch (pos) {
                case 1:
                    imgView.setImageResource(R.drawable.brasil);
                    textView.setText(getString(R.string.brasil));
                    btnView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            startAlert(getContext(), getString(R.string.brasil_msg), getString(R.string.brasil));
                        }
                    });
                    break;
                case 2:
                    imgView.setImageResource(R.drawable.alemanha);
                    textView.setText(getString(R.string.alemanha));
                    btnView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            startAlert(getContext(), getString(R.string.alemanha_msg), getString(R.string.alemanha));
                        }
                    });
                    break;
                case 3:
                    imgView.setImageResource(R.drawable.italia);
                    textView.setText(getString(R.string.italia));
                    btnView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            startAlert(getContext(), getString(R.string.italia_msg), getString(R.string.italia));
                        }
                    });
                    break;
                case 4:
                    imgView.setImageResource(R.drawable.dinamarca);
                    textView.setText(getString(R.string.dinamarca));
                    btnView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            startAlert(getContext(), getString(R.string.dinamarca_msg), getString(R.string.dinamarca));
                        }
                    });
                    break;
                case 5:
                    imgView.setImageResource(R.drawable.usa);
                    textView.setText(getString(R.string.usa));
                    btnView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            startAlert(getContext(), getString(R.string.usa_msg), getString(R.string.usa));
                        }
                    });
                    break;
            }
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "BRASIL";
                case 1:
                    return "ALEMANHA";
                case 2:
                    return "ITALIA";
                case 3:
                    return "DINAMARCA";
                case 4:
                    return "ESTADOS UNIDOS";
            }
            return null;
        }
    }

    public static void startAlert(Context context, String msg, String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg)
                .setTitle(title);
        AlertDialog alert = builder.create();
        alert.show();
    }
}
