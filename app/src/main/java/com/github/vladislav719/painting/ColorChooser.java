package com.github.vladislav719.painting;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ColorChooser extends ActionBarActivity implements View.OnClickListener{

    private Button redBtn, blueBtn, yellowBtn;
    private int colorID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_chooser);

        redBtn = (Button) findViewById(R.id.btnRed);
        redBtn.setOnClickListener(this);
        blueBtn = (Button) findViewById(R.id.btnBlue);
        blueBtn.setOnClickListener(this);
        yellowBtn = (Button) findViewById(R.id.btnYellow);
        yellowBtn.setOnClickListener(this);

        colorID = getIntent().getIntExtra("color", 345);

        Button tmp = (Button) findViewById(getIntent().getIntExtra("btn",1));
        if (tmp != null) {
            tmp.setText("PICKED");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.color_chooser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View v) {
        Button tmp =  (Button) v.findViewById(v.getId());
        tmp.setText("PICKED");

        colorID = ((ColorDrawable)tmp.getBackground()).getColor();

        Intent i = new Intent(this, MainActivity.class);
        System.out.println(colorID);
        i.putExtra("color", colorID);
        i.putExtra("btn", v.getId());
        startActivityForResult(i, 0);
    }
}
