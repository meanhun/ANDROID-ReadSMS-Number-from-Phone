package com.share4happy.doctinnhantudienthoaidemo;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.share4happy.doctinnhantudienthoaidemo.model.Contact;

import java.util.ArrayList;



public class DanhBaActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS =1001 ;
    ListView lvDanhBa;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);

        addControls();
        showAllContactFromDevice();
    }
    private void addControls() {
        lvDanhBa = (ListView) findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<Contact>(DanhBaActivity.this,
                android.R.layout.simple_list_item_1, dsDanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);
    }
    private void showAllContactFromDevice() {
        //Thông qua ContactsContract để lấy contact từ đt
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        // Trả về 1 cursor - quản lý  dữ liệu  contact trong điện thoại
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        dsDanhBa.clear();
        while (cursor.moveToNext()) {
            // lấy thông tin tên trong danh bạ
            String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
            // lấy thông tin số đt trong danh bạ
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            // lấy vị trí tên cột trong dữ liệu
            int viTriTenCotName = cursor.getColumnIndex(tenCotName);
            int viTriTenCotPhone = cursor.getColumnIndex(tenCotPhone);
            // lấy dữ liệu trong các cột cần ra
            String name = cursor.getString(viTriTenCotName);
            String phone = cursor.getString(viTriTenCotPhone);
            //đưa vào mảng
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();
        }
    }
}