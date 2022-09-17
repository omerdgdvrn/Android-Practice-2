package com.example.soru2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InformationListAdapter extends RecyclerView.Adapter<InformationHolder> {
    public ArrayList<MyInformation> InformationList,backup;
    public Filter myfilter;
    public InformationListAdapter(ArrayList<MyInformation> data){
        InformationList=data;
        backup=null;
        myfilter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<MyInformation> resultList = new ArrayList<>();
                String pattern = constraint.toString().toLowerCase();
                if (pattern.length() == 1 && backup == null)
                    backup = new ArrayList<>(InformationList);
                if ((pattern == null || pattern.length() == 0 ) && backup != null) {
                    resultList.addAll(backup);
                    backup = null;

                } else {
                    for (int i = 0; i < InformationList.size(); i++)
                        if (InformationList.get(i).website.toLowerCase().contains(pattern))
                            resultList.add(InformationList.get(i));
                }
                FilterResults result = new FilterResults();
                result.values = resultList;
                return result;


            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                InformationList.clear();
                InformationList.addAll((List)results.values);
                notifyDataSetChanged();
            }
        };
    }

    @NonNull
    @Override
    public InformationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout,parent,false);
        return new InformationHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationHolder holder, int position) {
        holder.txtViewInformationWebSite.setText(InformationList.get(position).website);
        holder.txtViewInformationUsername.setText(InformationList.get(position).username);
        holder.txtViewInformationPassword.setText(InformationList.get(position).password);
    }

    @Override
    public int getItemCount() {
        return InformationList.size();
    }
}
