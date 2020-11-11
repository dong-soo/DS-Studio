package com.example.horsemuscle;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragSales extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<SalesItem> arrayList;
    private RecyclerView.LayoutManager layoutManager;

    private Button btn_add; // 아이템 추가버튼

    public static FragSales newInstance() {
        FragSales fragSales = new FragSales();
        return fragSales;

    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { //프래그먼트 시작 시 수행하는 생명주기

        view = inflater.inflate(R.layout.frag_sales, container, false);


        btn_add = view.findViewById(R.id.btn_add); //추가버튼
        recyclerView = view.findViewById(R.id.rv_sales); // id 연동
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // 판매목록을 담아주려는 빈 배열 리스트 생성

        SalesItem salesItem = new SalesItem(); // 판매목록 데이터 클래스 생성
        salesItem.setTv_produtc("닭가슴살 흙마늘맛");
        salesItem.setTv_price("1900원");
        salesItem.setTv_date("2020-11-11");
        arrayList.add(salesItem); // 배열리스트에 추가

        SalesItem salesItem2 = new SalesItem(); // 판매목록 데이터 클래스 생성
        salesItem2.setTv_produtc("닭가슴살 불족발맛");
        salesItem2.setTv_price("1800원");
        salesItem2.setTv_date("2020-11-11");
        arrayList.add(salesItem2); // 배열리스트에 추가

        SalesItem salesItem3 = new SalesItem(); // 판매목록 데이터 클래스 생성
        salesItem3.setTv_produtc("닭가슴살 단호박치즈맛");
        salesItem3.setTv_price("1800원");
        salesItem3.setTv_date("2020-11-11");
        arrayList.add(salesItem3); // 배열리스트에 추가


        adapter = new SalesAdapter(arrayList, getContext()); // 어댑터를 생성하면서 리스트를 어댑터에 넘긴다
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 커스텀 어댑터를 연결(장착)

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialogAdd = new Dialog(getContext(), R.style.Theme_AppCompat_Light_Dialog_Alert);
                dialogAdd.setContentView(R.layout.dialog_add); // xml 레이아웃 연결

                final EditText et_product = dialogAdd.findViewById(R.id.et_product);  //상품명
                final  EditText et_price = dialogAdd.findViewById(R.id.et_price);      //가격
                final  EditText et_date = dialogAdd.findViewById(R.id.et_date);        //날짜

                Button btn_add = dialogAdd.findViewById(R.id.btn_add);  //추가버튼
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if(et_product.getText().length() == 0 || et_price.getText().length() == 0 || et_date.getText().length() == 0) {
                            // 현재 입력필드에 값을 안 적은 상황이라면..
                            Toast.makeText(getContext(), "비어있는 입력필드가 존재합니다.", Toast.LENGTH_SHORT).show();
                            return; // if문을 벗어나 온클릭수행 취소 (빠꾸)
                        }

                        SalesItem item = new SalesItem();
                        item.setTv_produtc(et_product.getText().toString());
                        item.setTv_price(et_price.getText().toString());
                        item.setTv_date(et_date.getText().toString());

                        arrayList.add(0, item);
                        adapter.notifyItemInserted( 0);

                        dialogAdd.dismiss();

                    }
                });
            }
        });

        return view;
    }
}
