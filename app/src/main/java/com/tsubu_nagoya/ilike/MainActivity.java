package com.tsubu_nagoya.ilike;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import com.tsubu_nagoya.ilike.ilike.R;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Bitmap> pictureList = load();
    }
    BitmapAdapter adapter = new BitmapAdapter(
            getApplicationContext(), R.layout.list_picture, pictureList);

    GridView gridView = (GridView)findViewById(R.id.gridView1);
    gridView.setAdapter(adapter);

    private ArrayList<Bitmap> load() {

    }
}
