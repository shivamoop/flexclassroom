package com.example.flexclassroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .setWelcomePageEnabled(false)
                    .setConfigOverride("requireDisplayName", true)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public void onButtonClick(View view) {
        EditText editText=findViewById(R.id.conferencename);
        String text= editText.getText().toString();
        if (text.length()>0){
            jitsiMeetConferenceOption options
                    =new JitsiMeetConferenceOptions.Builder()
                    .setRoom(text)
                    .build();
            JitsiMeetActivity.launch(this,option);
        }
    }
}

