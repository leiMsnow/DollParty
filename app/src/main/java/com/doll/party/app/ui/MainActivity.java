package com.doll.party.app.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.SparseArray;
import android.view.MenuItem;

import com.doll.party.app.R;
import com.doll.party.app.base.BaseAppActivity;

import butterknife.Bind;

public class MainActivity extends BaseAppActivity {

    @Bind(R.id.vp_container)
    ViewPager mViewPager;
    @Bind(R.id.navigation)
    BottomNavigationView mBottomNavigationView;
    @Bind(R.id.nv_view)
    NavigationView mNavigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private SparseArray<Fragment> mFragments = new SparseArray<>();
    private MenuItem mPrevMenuItem;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initFragment();
        initDrawerLayout();

        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnBottomNavigationItemSelectedListener);
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
    }

    private void initDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar
                , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private FragmentPagerAdapter mFragmentPagerAdapter
            = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return mFragments.valueAt(position);
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
                mBottomNavigationView.getMenu().getItem(0).setChecked(false);
            } else {
                mPrevMenuItem.setChecked(false);
            }
            mPrevMenuItem = mBottomNavigationView.getMenu().getItem(position);
            mPrevMenuItem.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnBottomNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mViewPager.setCurrentItem(item.getOrder());
            return true;
        }
    };

    private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initFragment() {
        mFragments.put(R.id.navigation_home, HomeFragment.newInstance());
        mFragments.put(R.id.navigation_discovery, DiscoveryFragment.newInstance());
        mFragments.put(R.id.navigation_my, MyFragment.newInstance());
    }

}
