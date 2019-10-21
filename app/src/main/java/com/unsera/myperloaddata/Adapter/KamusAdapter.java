package com.unsera.myperloaddata.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.unsera.myperloaddata.Activity.DetailActivity;
import com.unsera.myperloaddata.Model.KamusModel;
import com.unsera.myperloaddata.R;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class KamusAdapter extends RecyclerView.Adapter<KamusAdapter.KamusHolder> {
    private ArrayList<KamusModel> mData = new ArrayList<>();
    private List<KamusModel> wordList;
    private Context context;
    private LayoutInflater mInflater;

    public KamusAdapter(Context context) {
        this.context = context;
        this.mData = mData;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public KamusHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kamus_row, parent, false);
        return new KamusHolder(view);
    }
    public void addItem(ArrayList<KamusModel> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void clear(){
        this.mData.clear();
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(KamusHolder holder, int position) {
        holder.textViewKata.setText(mData.get(position).getName());
        /*holder.textViewNama.setText(mData.get(position).getName());*/
    }
    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class KamusHolder extends RecyclerView.ViewHolder {
        private TextView textViewKata;
        private TextView textViewNama;


        public KamusHolder(View itemView) {
            super(itemView);
            textViewKata = itemView.findViewById(R.id.txt_kata);
           /* textViewNama =  itemView.findViewById(R.id.txt_nama);*/

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        KamusModel clickedDataItem = mData.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("word", mData.get(pos).getName());
                        intent.putExtra("translate", mData.get(pos).getKata());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "" + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }


}