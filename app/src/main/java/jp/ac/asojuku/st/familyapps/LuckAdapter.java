package jp.ac.asojuku.st.familyapps;

/**
 * Created by AHKNT on 2016/11/02.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class LuckAdapter extends RecyclerView.Adapter<LuckViewHolder> {
    private ArrayList<LuckData> rouletteDataSet;

    public LuckAdapter(ArrayList<LuckData> roulette) {

        this.rouletteDataSet = roulette;
    }

    // 新しいViewを作成する
    // レイアウトマネージャーにより起動される
    @Override
    public LuckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // parentはRecyclerView
        // public View inflate (int resource, ViewGroup root, boolean attachToRoot)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);
        // Log.d("Anbayasi", parent.toString());

        //AnbayasiViewHolder anbayasiViewHolder = new AnbayasiViewHolder(view);
        return new LuckViewHolder(view);
    }

    // Viewの内容を交換する（リサイクルだから）
    // レイアウトマネージャーにより起動される
    @Override
    public void onBindViewHolder(final LuckViewHolder holder, final int listPosition) {

        holder.textViewNumber.setText(rouletteDataSet.get(listPosition).getNumber() + "本");
        holder.textViewComment.setText(rouletteDataSet.get(listPosition).getComment());
        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // vはCardView
                Toast.makeText(v.getContext(), "おまけ" +
                        rouletteDataSet.get(listPosition).getAddition() + "本", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return rouletteDataSet.size();
    }
}

