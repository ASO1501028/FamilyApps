package jp.ac.asojuku.st.familyapps;

/**
 * Created by AHKNT on 2016/11/02.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.cardList2);
        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.cardList3);

        //画像描画の設定　上向き矢印に変更する
//        ImageView imageView;
//        imageView = (ImageView)findViewById(R.id.arrow);
//
//        Matrix mtrx = new Matrix();
//        imageView.setScaleType(ImageView.ScaleType.MATRIX);
//
//        mtrx.postRotate(90.0f, imageView.getWidth()/2, imageView.getHeight()/2);
//
//        imageView.setImageMatrix(mtrx);
//        imageView.invalidate(); //再描画


        // コンテンツの変化でRecyclerViewのサイズが変わらない場合は、
        // この設定でパフォーマンスを向上させることができる
        recyclerView.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);

        // RecyclerViewにはLayoutManagerが必要
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        // 横スクロールになる
        llManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 縦スクロール
        //llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);
        recyclerView2.setLayoutManager(llManager);
        recyclerView3.setLayoutManager(llManager);

        ArrayList<AnbayasiData> anbayasi = new ArrayList<AnbayasiData>();
        for (int i = 0; i < MyData.commentArray.length; i++) {
            anbayasi.add(new AnbayasiData(
                    MyData.numberArray[i],
                    MyData.additionArray[i],
                    MyData.commentArray[i]
            ));
        }
        ArrayList<LuckData> luck = new ArrayList<LuckData>();
        for (int i = 0; i < MyData2.commentArray.length; i++) {
            luck.add(new LuckData(
                    MyData2.numberArray[i],
                    MyData2.additionArray[i],
                    MyData2.commentArray[i]
            ));
        }
        ArrayList<TensionData> tension = new ArrayList<TensionData>();
        for (int i = 0; i < MyData3.commentArray.length; i++) {
            tension.add(new TensionData(
                    MyData3.numberArray[i],
                    MyData3.additionArray[i],
                    MyData3.commentArray[i]
            ));
        }



        RecyclerView.Adapter adapter = new AnbayasiAdapter(anbayasi);
        recyclerView.setAdapter(adapter);
        Random rnd = new Random();
        recyclerView.smoothScrollToPosition(rnd.nextInt(anbayasi.size()));    //最後までスクロール

        RecyclerView.Adapter adapter2 = new LuckAdapter(luck);
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(rnd.nextInt(luck.size()));    //最後までスクロール

        RecyclerView.Adapter adapter3 = new TensionAdapter(tension);
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(rnd.nextInt(tension.size()));    //最後までスクロール

    }
}