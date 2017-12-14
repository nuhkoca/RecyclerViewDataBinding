package com.mobilemovement.recyclerviewdatabinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilemovement.recyclerviewdatabinding.R;
import com.mobilemovement.recyclerviewdatabinding.databinding.PeopleInfoBinding;
import com.mobilemovement.recyclerviewdatabinding.model.People;

import java.util.List;

/**
 * Created by nuhkoca on 14.12.2017.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<People> mPeople;

    public PeopleAdapter(List<People> mPeople) {
        this.mPeople = mPeople;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).
                inflate(R.layout.people_info, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        People people = mPeople.get(position);

        holder.bindView(people);
    }

    @Override
    public int getItemCount() {
        return mPeople.size();
    }

    public void updatePeople(List<People> people){
        mPeople = people;

        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private PeopleInfoBinding mPeopleInfoBinding;

        ViewHolder(View itemView) {
            super(itemView);

            mPeopleInfoBinding = DataBindingUtil.bind(itemView.getRootView());
        }

        void bindView(People people){
            mPeopleInfoBinding.setPeople(people);
            mPeopleInfoBinding.executePendingBindings();
        }
    }
}
