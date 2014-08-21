package com.github.vladislav719.painting;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int colorID;
    private TextView textMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMain = (TextView) findViewById(R.id.textMain);
        colorID = getIntent().getIntExtra("color", 345);

        textMain.setBackgroundColor(colorID);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void textClick(View view){
        Intent i = new Intent(this, ColorChooser.class);
        i.putExtra("color", colorID);
        i.putExtra("btn", getIntent().getIntExtra("btn", 1));
        startActivityForResult(i, 0);
    }
}
