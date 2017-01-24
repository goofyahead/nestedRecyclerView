package cof.gof.nestedrecyclerviews.adapter;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cof.gof.nestedrecyclerviews.R;
import cof.gof.nestedrecyclerviews.models.Card;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {
    private static final String TAG = MainListAdapter.class.getCanonicalName();
    private final LinkedList<Card> elements;
    private final Context context;

    public MainListAdapter(Context context){
        this.elements = new LinkedList<>();
        this.context = context;
    }

    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final View view = LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainListAdapter.ViewHolder holder, int position) {
        final Card card = elements.get(position);
        final InnerListAdapter innerAdapter = new InnerListAdapter();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setAutoMeasureEnabled(true);

        innerAdapter.addAll(card.getCards());
        holder.innerList.setLayoutManager(layoutManager);
        holder.innerList.setAdapter(innerAdapter);
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        Log.d(TAG, "recycled view parent");
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public void addAll(List<Card> externalList) {
        elements.addAll(externalList);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.innerRecyclerview) RecyclerView innerList;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
