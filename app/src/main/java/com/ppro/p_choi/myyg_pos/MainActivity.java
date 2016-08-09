package com.ppro.p_choi.myyg_pos;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_1_1, btn_1_2;
    ListView listView1;
    ArrayAdapter<String> m_adapter;
    String[] selected_items = {"가", "나", "다", "라"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼에 리스너 달기
        btn_1_1=(Button)findViewById(R.id.btn_1_1);
        btn_1_2=(Button)findViewById(R.id.btn_1_2);
       //어댑터 생성
        m_adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1);
        //리스트뷰 생성
        listView1 = (ListView)findViewById(R.id.listview1);
        listView1.setOnItemClickListener(onClickListItem);
        //리스트에 어댑터 추가** 에러가 발생하는 부분
        listView1.setAdapter(m_adapter);
        listView1.setBackgroundColor(Color.GRAY);//배경색 바꾸기

        Button.OnClickListener listener = new Button.OnClickListener(){
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_1_1:
                        System.out.println("1_1 눌림");
                        //ListView에 Item추가
                        m_adapter.add("Altic Armor");
                    case R.id.btn_1_2:
                        System.out.println("1_2 눌림");
                        //ListView에 Item추가
                        m_adapter.add("F-TR");
                        break;
                }
            }
        };//이부분에서 세미콜론;을 찍는것을잊어서는안된다
        btn_1_1.setOnClickListener(listener);
        btn_1_2.setOnClickListener(listener);

    }
    //listItem 터치 이벤트
    private OnItemClickListener onClickListItem = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //이벤트 클릭시 해당 아이템 위치의 텍스트를 출력
            Toast.makeText(getApplicationContext(), m_adapter.getItem(position), Toast.LENGTH_SHORT).show();
        }
    };

}
