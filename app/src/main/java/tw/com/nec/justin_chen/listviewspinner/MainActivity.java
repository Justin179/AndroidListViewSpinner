package tw.com.nec.justin_chen.listviewspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 資料載具
    class Data {
        int photo;
        String name;
    }

    private Data[] makeSpinnerContent(){
        // 準備資料
        Data[] transData = new Data[4];
        for (int i = 0; i < transData.length; i++) {
            transData[i] = new Data();
        }
        transData[0].name = "腳踏車";
        transData[1].name = "機車";
        transData[2].name = "汽車";
        transData[3].name = "巴士";
        transData[0].photo = R.drawable.trans1;
        transData[1].photo = R.drawable.trans2;
        transData[2].photo = R.drawable.trans3;
        transData[3].photo = R.drawable.trans4;
        return transData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 做資料
        Data[] transData = makeSpinnerContent();

        // make Adapter (main)
        myAdapter transAdapter = new myAdapter(transData, R.layout.trans_list); // 左邊data 右邊template

        // make Container (Spinner)
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // put Adapter into Spinner
        spinner.setAdapter(transAdapter);


    }

    public class myAdapter extends BaseAdapter {
        private Data[] data;
        private int view;

        // 生成Adapter時資料進來, 左邊data 右邊template
        public myAdapter(Data[] data, int view) {
            this.data = data;
            this.view = view;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Data getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {

            // 取得view 物件
            rowView = getLayoutInflater().inflate(view, parent, false);

            // 取得view 上的圖物件、文物件
            TextView name = (TextView) rowView.findViewById(R.id.name);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

            // 塞值
            name.setText(data[position].name);
            imageView.setImageResource(data[position].photo);

            return rowView;
        }
    }

}
