package com.example.horsemuscle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.CustomViewHolder> {

    private ArrayList<SalesItem> arrayList; // 판매 목록 리스트를 담고있다.
    private Context context;


    public SalesAdapter(ArrayList<SalesItem> arrayList, Context context) { //생성자를 구성.
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SalesAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sales_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SalesAdapter.CustomViewHolder holder, int position) {
    holder.iv_profile.setImageResource(R.drawable.strength);
    holder.tv_product.setText(arrayList.get(position).getTv_produtc());
    holder.tv_price.setText(arrayList.get(position).getTv_price());
    holder.tv_date.setText(arrayList.get(position).getTv_date());
    }

    @Override
    public int getItemCount() { // 리스트 아이템의 전체갯수
        return arrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

         ImageView iv_profile;
         TextView tv_product;
         TextView tv_price;
         TextView tv_date;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_product = itemView.findViewById(R.id.tv_product);
            this.tv_price = itemView.findViewById(R.id.tv_price);
            this.tv_date = itemView.findViewById(R.id.tv_date);
        }
    }
}
