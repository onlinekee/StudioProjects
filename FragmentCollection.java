package com.example.hp.ktsmilkapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentCollection extends Fragment {

    View view;
    private RecyclerView myrecyclerview;
    private List<CollectionItem> collectionItemList;

    DatabaseHelper db;

    public FragmentCollection() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collection_fragment,container,false);
        myrecyclerview =(RecyclerView)view.findViewById(R.id.collection_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),collectionItemList);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);



        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        db = new DatabaseHelper(this.getActivity());
         collectionItemList = new ArrayList<>();

        db = new DatabaseHelper(getActivity());

//
//        Cursor items = db.getAllCollections();
//
//        while (items.moveToNext()){
//            collectionItemList.add(new CollectionItem(items.getString(0), items.getString(1),items.getString(2),items.getString(7)));
//
//        }

          collectionItemList.add(new CollectionItem("sad", "ref","asda","2"));
    }
}
