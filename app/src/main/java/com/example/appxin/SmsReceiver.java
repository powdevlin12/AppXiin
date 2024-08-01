package com.example.appxin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Kiểm tra hành động của Intent
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus != null) {
                    for (Object pdu : pdus) {
                        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                        String sender = smsMessage.getDisplayOriginatingAddress();
                        String messageBody = smsMessage.getMessageBody();

                        // Xử lý tin nhắn SMS ở đây
                        Toast.makeText(context, "SMS từ: " + sender + ", Nội dung: " + messageBody, Toast.LENGTH_LONG).show();

                        // Bạn có thể thêm logic khác để xử lý tin nhắn SMS ở đây
                    }
                }
            }
        }
    }
}
