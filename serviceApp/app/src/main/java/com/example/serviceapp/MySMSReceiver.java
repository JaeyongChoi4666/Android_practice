package com.example.serviceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MySMSReceiver extends BroadcastReceiver {
    public static final String TAG="MySMSReceiver";
    public SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i(TAG,"onReceive 호출됨");
        Bundle bundle=intent.getExtras();
        SmsMessage[] messages=parseSmsMessage(bundle);
        if(messages!=null&&messages.length>0){
            String sender=messages[0].getOriginatingAddress();
            String contents=messages[0].getMessageBody();
            Date receiveDate=new Date(messages[0].getTimestampMillis());
            Log.i(TAG,"SMS sender: "+sender);
            Log.i(TAG,"received contents: "+contents);
            Log.i(TAG,"SMS received date: "+receiveDate);

            sendToActivity(context,sender,contents,receiveDate);
        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    public SmsMessage[] parseSmsMessage(Bundle bundle){
        Object[] objects= (Object[]) bundle.get("pdus");
        SmsMessage[] messages=new SmsMessage[objects.length];
        for(int i=0;i<messages.length;i++){
            if(Build.VERSION.SDK_INT>Build.VERSION_CODES.M){
                String format=bundle.getString("format");
                messages[i]=SmsMessage.createFromPdu((byte[])objects[i],format);
            }else{
                messages[i]=SmsMessage.createFromPdu((byte[])objects[i]);
            }
        }
        return messages;
    }

    private void sendToActivity(Context context,String sender, String contents, Date receivedDate){
        Intent intent=new Intent(context,SMSActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("sender",sender);
        intent.putExtra("contents",contents);
        intent.putExtra("receivedDate",format.format(receivedDate));
        context.startActivity(intent);
    }
}