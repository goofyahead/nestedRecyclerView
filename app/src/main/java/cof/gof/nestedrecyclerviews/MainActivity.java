package cof.gof.nestedrecyclerviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import cof.gof.nestedrecyclerviews.adapter.MainListAdapter;
import cof.gof.nestedrecyclerviews.models.Card;
import cof.gof.nestedrecyclerviews.models.InnerCard;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private MainListAdapter adapter;
    private Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        List<Card> externalList = new ArrayList<>();

        for (int x = 0; x < 20 ; x++) {
            int randomSize = r.nextInt(30);
            Log.d(TAG, "created card with " + randomSize + " elements");
            List<InnerCard> innerCards = new ArrayList<>(randomSize);

            for (int y = 0; y < randomSize; y++){
                innerCards.add(new InnerCard());
            }

            externalList.add(new Card(innerCards));
        }

        adapter = new MainListAdapter(this);
        adapter.addAll(externalList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
