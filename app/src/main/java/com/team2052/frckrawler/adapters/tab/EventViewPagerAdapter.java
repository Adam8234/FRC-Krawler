package com.team2052.frckrawler.adapters.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.team2052.frckrawler.adapters.ViewOnClickFragmentStatePagerAdapter;
import com.team2052.frckrawler.fragments.EventInfoFragment;
import com.team2052.frckrawler.fragments.SummaryFragment;
import com.team2052.frckrawler.fragments.robot.RobotsFragment;

/**
 * Created by Adam on 11/23/2015.
 */
public class EventViewPagerAdapter extends ViewOnClickFragmentStatePagerAdapter {
    public String[] headers = new String[]{"Info", "Metric Summary", "Teams Attending"};
    private long event_id;

    public EventViewPagerAdapter(FragmentManager fragmentManager, long event_id) {
        super(fragmentManager);
        this.event_id = event_id;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return EventInfoFragment.newInstance(event_id);
            case 1:
                return SummaryFragment.newInstance(event_id);
            case 2:
                return RobotsFragment.newEventInstance(event_id);
        }
        return null;
    }

    @Override
    public int getCount() {
        return headers.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return headers[position];
    }
}
