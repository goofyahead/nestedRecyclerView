package cof.gof.nestedrecyclerviews.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cof.gof.nestedrecyclerviews.R;
import cof.gof.nestedrecyclerviews.models.InnerCard;

public class InnerListAdapter extends RecyclerView.Adapter<InnerListAdapter.ViewHolder> {

    private static final String TAG = InnerListAdapter.class.getCanonicalName();

    private List<InnerCard> elements;

    public InnerListAdapter() {
        elements = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        final View view = LayoutInflater.from(context).inflate(R.layout.inner_item_card, parent, false);
        return new InnerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public void onViewRecycled(InnerListAdapter.ViewHolder holder) {
        super.onViewRecycled(holder);
        Log.d(TAG, "recycled INNER view parent");
    }


    @Override
    public int getItemCount() {
        return elements.size();
    }

    public void addAll(List<InnerCard> innerCards) {
        this.elements.addAll(innerCards);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
