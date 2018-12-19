package com.grupodetec.aventuraprote.View.Adventure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.grupodetec.aventuraprote.R;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_adventure);
        getIncomingIntent();
    }
    private void getIncomingIntent() {
        if (getIntent().hasExtra("image") && getIntent().hasExtra("name") && getIntent().hasExtra("local")) {
            int cardview_photo_id = getIntent().getIntExtra("image", R.drawable.ic_launcher_background);
            String cardview_name = getIntent().getStringExtra("name");
            String cardview_local = getIntent().getStringExtra("local");
            setContent(cardview_photo_id, cardview_name, cardview_local);
        }
    }
    private void setContent(int photo_id, String name, String local){
        ImageView imageView = findViewById(R.id.container_image);
        imageView.setImageResource(photo_id);

        TextView textViewname = findViewById(R.id.container_title);
        textViewname.setText(name);

        TextView textViewlocal = findViewById(R.id.container_local);
        textViewlocal.setText(local);
    }
}
