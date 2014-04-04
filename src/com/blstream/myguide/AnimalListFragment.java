package com.blstream.myguide;

import java.util.ArrayList;
import java.util.Locale;

import com.blstream.myguide.fragments.FragmentHelper;
import com.blstream.myguide.zoolocations.Animal;
import com.blstream.myguide.zoolocations.ZooLocationsData;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Fragment showing list of animals in the Zoo.
 * @author Agnieszka
 *
 */

public class AnimalListFragment extends Fragment {

	private ZooLocationsData mZooData;
	private ListView mAnimalList;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_animal_list, container,
				false);
		
		getActivity().getActionBar().setTitle(R.string.animal_list_title);
		
		mAnimalList = (ListView) view.findViewById(R.id.lvAnimalList);
		mZooData = ((MyGuideApp) this.getActivity().getApplication())
				.getZooData();
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				inflater.getContext(), R.layout.animal_list_item,getAnimalNames());
		
		mAnimalList.setAdapter(adapter);
		mAnimalList.setOnItemClickListener(new AnimalListOnClickListener());

		return view;
	}

	/**
	 * Reads names of animals from ZooLocationsData. 
	 * @return array of strings with animal names
	 */

	private String[] getAnimalNames() {
		ArrayList<Animal> animals = mZooData.getAnimals();
		String[] animalNames = new String[animals.size()];
		for (int i = 0; i < animalNames.length; i++) {
			animalNames[i] = animals.get(i).getName(
					Locale.getDefault().getDisplayLanguage());
		}
		return animalNames;
	}
	
	private class AnimalListOnClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			Animal animal = mZooData.getAnimals().get(position);
			Fragment newFragment = new AnimalDescriptionFragment(animal);
			FragmentHelper.swapFragment(R.id.flFragmentHolder, newFragment, getFragmentManager(), BundleConstants.FRAGMENT_ANIMAL_DETAIL);
		}
		
	}

}