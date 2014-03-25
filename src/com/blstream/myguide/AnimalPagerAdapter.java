
package com.blstream.myguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Piotrek on 23.03.14.
 */
public class AnimalPagerAdapter extends FragmentStatePagerAdapter {

	public AnimalPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
            //sample fragment
			case 0:
                //return new AnimalDesriptionFragment
				return new AnimalDescripitionFragment();
			case 1:
                //return new FOrChildrenDescriptionFragment
				return new AnimalDescripitionFragment();
			case 2:
				// TODO Map activity
				return new AnimalDescripitionFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return (position + 1) + "";
	}

}
