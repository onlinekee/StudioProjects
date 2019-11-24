package com.example.hp.ktsmilkapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<CollectionItem> mData;

    public RecyclerViewAdapter(Context mContext, List<CollectionItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_session;
        private TextView txt_item;
        private TextView txt_supplier;
        private TextView txt_qty;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_session = (TextView) itemView.findViewById(R.id.session_collection);
            txt_item = (TextView) itemView.findViewById(R.id.item_collection);
            txt_supplier = (TextView) itemView.findViewById(R.id.supplier_collection);
            txt_qty = (TextView) itemView.findViewById(R.id.qty_collection);

        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.item_collection,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txt_session.setText(mData.get(position).getSession() );
        holder.txt_item.setText(mData.get(position).getItem());
        holder.txt_supplier.setText(mData.get(position).getSupplier());
        holder.txt_qty.setText(mData.get(position).getQty());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    }


