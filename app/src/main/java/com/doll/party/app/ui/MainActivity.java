package com.doll.party.app.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.MenuItem;

import com.doll.party.app.R;
import com.doll.party.app.base.BaseAppActivity;

public class MainActivity extends BaseAppActivity {

    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;
    private SparseArray<Fragment> mFragments = new SparseArray<>();
    private int[] mNavigation = new int[]{
            R.id.navigation_home,
            R.id.navigation_discovery,
            R.id.navigation_my
    };
    private MenuItem mPrevMenuItem;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        mViewPager = (ViewPager) findViewById(R.id.vp_container);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragment();
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
    }

    private FragmentPagerAdapter mFragmentPagerAdapter
            = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(mNavigation[position]);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener
            = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            invalidateOptionsMenu();
            if (mPrevMenuItem == null) {
                mNavigationView.getMenu().getItem(0).setChecked(false);
            } else {
                mPrevMenuItem.setChecked(false);
            }
            mPrevMenuItem = mNavigationView.getMenu().getItem(position);
            mPrevMenuItem.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mViewPager.setCurrentItem(item.getOrder());
            return true;
        }
    };


    private void initFragment() {
        mFragments.put(R.id.navigation_home, HomeFragment.newInstance());
        mFragments.put(R.id.navigation_discovery, DiscoveryFragment.newInstance());
        mFragments.put(R.id.navigation_my, MyFragment.newInstance());
    }
}
