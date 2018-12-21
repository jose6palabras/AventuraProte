package com.grupodetec.aventuraprote.View.DulceAventura;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grupodetec.aventuraprote.Pojo.DataSource;
import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.RecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllViewFragment extends Fragment {


    public AllViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_all_view, container, false);
        /*set recyclerviwe*/
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_adventure_fragment);
        recyclerView.setHasFixedSize(true);

        /*set Managerlayout*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        DataSource dataSource = new DataSource();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataSource.adventureData(), R.layout.cardview_model_full);
        recyclerView.setAdapter(recyclerViewAdapter);

        //Floatin action button
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab_adventure1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new CheckFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
