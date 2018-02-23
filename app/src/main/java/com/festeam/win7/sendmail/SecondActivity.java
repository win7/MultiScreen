package com.festeam.win7.sendmail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.festeam.win7.sendmail.Utils.CircleTransform;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView iw_logo = findViewById(R.id.imageView_logo);
        Picasso.with(this.getApplicationContext()).load(R.drawable.hackspace_logo).centerCrop()
                .resize(256, 256).transform(new CircleTransform()).into(iw_logo);
        TextView tw_names = findViewById(R.id.textView_names);

        tw_names.setText(getIntent().getExtras().getString("name") + " " +
                getIntent().getExtras().getString("surname"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.app_name)));
            }
        });
    }

}
