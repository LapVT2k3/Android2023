package com.lapvt.myapplication.buoi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.MergeAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lapvt.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMergeAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_merge_adapter);

        RecyclerView rcvData = findViewById(R.id.rcvData);
        rcvData.setLayoutManager(new GridLayoutManager(this, 2));

        ProductAdapter productAdapter = new ProductAdapter(createProducts());
        SupportAdapter supportAdapter = new SupportAdapter(createSupports());

        MergeAdapter adapter = new MergeAdapter(productAdapter, supportAdapter);
        rcvData.setAdapter(adapter);
    }

    private List<Product> createProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Hũ vàng", 5000000L));
        productList.add(new Product("Chứng khoán", 10000000L));
        productList.add(new Product("Đầu tư Quỹ", 10000000L));
        productList.add(new Product("Tích lũy", 10000000L));
        productList.add(new Product("Ngân hàng", 10000000L));
        return productList;
    }

    private  List<Support> createSupports() {
        List<Support> supportList = new ArrayList<>();
        supportList.add(new Support("Hướng dẫn người mới"));
        supportList.add(new Support("Hướng dẫn người mới2"));
        supportList.add(new Support("Hướng dẫn người mới3"));
        supportList.add(new Support("Hướng dẫn người mới4"));
        supportList.add(new Support("Hướng dẫn người mới5"));
        supportList.add(new Support("Hướng dẫn người mới6"));
        return supportList;
    }
}