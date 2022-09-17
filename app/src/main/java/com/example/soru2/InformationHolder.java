package com.example.soru2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class InformationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtViewInformationWebSite;
    public TextView txtViewInformationUsername;
    public TextView txtViewInformationPassword;
    public InformationListAdapter adaptor;
    public InformationHolder(View itemView, InformationListAdapter adap){

        super(itemView);
        adaptor=adap;
        txtViewInformationWebSite = itemView.findViewById(R.id.txtViewInformationWebSite);
        txtViewInformationUsername = itemView.findViewById(R.id.txtViewInformationUsername);
        txtViewInformationPassword = itemView.findViewById(R.id.txtViewInformationPassword);

    }


    @Override
    public void onClick(View v) {

    }
}
