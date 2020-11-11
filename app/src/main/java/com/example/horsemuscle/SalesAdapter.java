package com.example.horsemuscle;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   final int curPos = getAdapterPosition(); // 현재 클릭한 아이템의 포지션 (위치 0부터 시작)

                    final Dialog dialogMod = new Dialog(context, R.style.Theme_AppCompat_Light_Dialog_Alert);
                    dialogMod.setContentView(R.layout.dialog_modify); // xml 레이아웃 연결

                    final EditText et_product = dialogMod.findViewById(R.id.et_product);  //상품명
                    final  EditText et_price = dialogMod.findViewById(R.id.et_price);      //가격
                    final  EditText et_date = dialogMod.findViewById(R.id.et_date);        //날짜

                    EditText btn_modify = dialogMod.findViewById(R.id.btn_modify);  //수정완료 버튼
                    btn_modify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            if(et_product.getText().length() == 0 || et_price.getText().length() == 0 || et_date.getText().length() == 0) {
                                // 현재 입력필드에 값을 안 적은 상황이라면..
                                Toast.makeText(context, "비어있는 입력필드가 존재합니다.", Toast.LENGTH_SHORT).show();
                                return; // if문을 벗어나 온클릭수행 취소 (빠꾸)
                            }

                            SalesItem item = new SalesItem();
                            item.setTv_produtc(et_product.getText().toString());
                            item.setTv_price(et_price.getText().toString());
                            item.setTv_date(et_date.getText().toString());

                            arrayList.set(curPos, item); // 리스트에 있는 데이터를 수정
                            notifyItemChanged(curPos);   // 수정 완료 후 새로고침

                            dialogMod.dismiss(); // 다이얼로그 닫기
                        }
                    });


                    Button btn_delete = dialogMod.findViewById(R.id.btn_delete); // 삭제버튼
                    btn_delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            arrayList.remove(curPos);

                            notifyItemRemoved(curPos);
                            notifyItemChanged(curPos, arrayList.size());

                            dialogMod.dismiss();

                        }
                    });
                    dialogMod.show();

                }
            });
        }
    }
}
