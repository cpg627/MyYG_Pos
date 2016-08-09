package com.ppro.p_choi.myyg_pos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btn_1_1, btn_1_2;
    ListView listView1;
    String[] selected_items = {"가", "나", "다", "라"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼에 리스너 달기
        btn_1_1=(Button)findViewById(R.id.btn_1_1);
        btn_1_2=(Button)findViewById(R.id.btn_1_2);
        //리스트뷰 생성
        listView1 = (ListView)findViewById(R.id.listview1);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);//선택이 가능하도록 설정
        //어댑터 생성
        final ArrayAdapter<String> selected_adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_multiple_choice,
                selected_items);
        //리스트에 어댑터 추가
        listView1.setAdapter(selected_adapter);

        Button.OnClickListener listener = new Button.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_1_1:
                        System.out.println("1_1 눌림");
                        selected_adapter.add("Americano");
                    case R.id.btn_1_2:
                        System.out.println("1_2 눌림");
                        selected_adapter.add("letter");
                        break;
                }
            }
        };//이부분에서 세미콜론;을 찍는것을잊어서는안된다
        btn_1_1.setOnClickListener(listener);
        btn_1_2.setOnClickListener(listener);

    }
    //이벤트 핸들러

}
