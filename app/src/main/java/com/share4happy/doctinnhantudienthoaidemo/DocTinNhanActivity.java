package com.share4happy.doctinnhantudienthoaidemo;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.share4happy.doctinnhantudienthoaidemo.adapter.AdapterTinNhan;
import com.share4happy.doctinnhantudienthoaidemo.model.TinNhan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DocTinNhanActivity  extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001 ;
    ListView lvDocTinNhan;
    ArrayList<TinNhan> dsTinNhan;
    AdapterTinNhan adapterTinNhan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_tin_nhan);
        addControls();
        docToanBoTinNhan();
    }

    private void addControls() {
        lvDocTinNhan = (ListView) findViewById(R.id.lvDocTinNhan);
        dsTinNhan = new ArrayList<>();
        adapterTinNhan = new AdapterTinNhan(DocTinNhanActivity.this,
                R.layout.item_tinnhan,dsTinNhan);
        lvDocTinNhan.setAdapter(adapterTinNhan);
    }

    private void docToanBoTinNhan() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsTinNhan.clear();
        while (cursor.moveToNext()){
            // lấy vị trí tên cột trong dữ liệu
            int indexPhoneNumber = cursor.getColumnIndex("address");
            int indexTimeStamp = cursor.getColumnIndex("date");
            int indexBody = cursor.getColumnIndex("body");
            // lấy dữ liệu trong các cột cần ra
            String phoneNumber = cursor.getString(indexPhoneNumber);
            String timeSpamp = cursor.getString(indexTimeStamp);
            String body = cursor.getString(indexBody);
            //đưa vào mảng
            dsTinNhan.add(new TinNhan(phoneNumber,sdf.format(Long.parseLong(timeSpamp)),body));
            adapterTinNhan.notifyDataSetChanged();
        }
    }
}
