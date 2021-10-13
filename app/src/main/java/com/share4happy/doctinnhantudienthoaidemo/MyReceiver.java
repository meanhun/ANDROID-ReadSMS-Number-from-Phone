package com.share4happy.doctinnhantudienthoaidemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyReceiver extends BroadcastReceiver {
    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object arrPduss[] = (Object[]) bundle.get("pdus");
        for (int i=0;i<arrPduss.length;i++){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) arrPduss[i]);
            String noidung = smsMessage.getMessageBody();
            String phone = smsMessage.getOriginatingAddress();
            long time = smsMessage.getTimestampMillis();
            Date date = new Date(time);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String _time = sdf.format(date);
            Toast.makeText(context, "Số phone: "+phone+"\nNoi Dung: "+noidung+"\nVao Luc: "+_time
                    , Toast.LENGTH_LONG).show();
        }
    }
}