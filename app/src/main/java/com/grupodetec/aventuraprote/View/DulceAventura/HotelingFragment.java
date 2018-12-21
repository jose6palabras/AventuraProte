package com.grupodetec.aventuraprote.View.DulceAventura;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class HotelingFragment extends Fragment {


    public HotelingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hoteling, container, false);
        /*set recyclerviwe*/
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_hoteling);
        recyclerView.setHasFixedSize(true);

        /*set Managerlayout*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        DataSource dataSource = new DataSource();

        //Set adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataSource.hotelData(), R.layout.cardview_model_full);
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

}
