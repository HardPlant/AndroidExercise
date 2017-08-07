package com.kiiren.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*매칭 요청을 보내고 결과를 받는다
*성공 시 : 협상 액티비티로 이동한다.
*실패 시 : 실패 메시지를 보여주고 이전 액티비티로 이동한다.
*/
public class MatchingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
    }
}
