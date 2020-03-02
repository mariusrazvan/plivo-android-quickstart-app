package com.plivo.plivosimplequickstart;

import android.content.Intent;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.HashMap;

public class PlivoFCMService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getData() != null) {
            String deviceToken = Utils.getDeviceToken();
            System.out.println("device token: "+ deviceToken);
            if(((App) getApplication()).backend().loginForIncoming(deviceToken)) {
                ((App) getApplication()).backend().relayIncomingPushData(new HashMap<>(remoteMessage.getData()));
            }
            startActivity(new Intent(this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            );
        }
    }
}
