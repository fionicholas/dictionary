package com.unsera.myperloaddata.Fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.unsera.myperloaddata.Adapter.KamusAdapter;
import com.unsera.myperloaddata.Database.KamusHelper;

import com.unsera.myperloaddata.Model.KamusModel;
import com.unsera.myperloaddata.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishFragment extends Fragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {

    RecyclerView recyclerView;
    KamusAdapter kamusAdapter;
    KamusHelper kamusHelper;



    public EnglishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_english, container, false);

        setHasOptionsMenu(true);


            recyclerView = view.findViewById(R.id.recyclerview);

            kamusHelper = new KamusHelper(getActivity());
            kamusAdapter = new KamusAdapter(getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            recyclerView.setAdapter(kamusAdapter);

            kamusHelper.open();


            ArrayList<KamusModel> kamusModels1 = kamusHelper.getAllData1();

            kamusHelper.close();

            kamusAdapter.addItem(kamusModels1);


        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.navigation, menu);


        SearchView searchView = (SearchView) (menu.findItem(R.id.search)).getActionView();
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);



    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }



    @Override
    public boolean onQueryTextChange(String newText) {


        if(newText.equals("")){


            kamusHelper = new KamusHelper(getActivity());
            kamusAdapter = new KamusAdapter(getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            recyclerView.setAdapter(kamusAdapter);

            kamusHelper.open();


            ArrayList<KamusModel> kamusModels = kamusHelper.getAllData1();


            kamusHelper.close();

            kamusAdapter.addItem(kamusModels);


        } else {


            kamusHelper = new KamusHelper(getActivity());
            kamusAdapter = new KamusAdapter(getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(kamusAdapter);


            kamusHelper.open();



            ArrayList<KamusModel> kamusModels = kamusHelper.getDataByName1(newText);



            kamusHelper.close();


            kamusAdapter.clear();
            kamusAdapter.addItem(kamusModels);
            kamusAdapter.notifyDataSetChanged();


        }

        return true;
    }

}