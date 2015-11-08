package com.tsubu_nagoya.ilike;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import com.tsubu_nagoya.ilike.ilike.R;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Bitmap> pictureList = load();
        BitmapAdapter adapter = new BitmapAdapter(
                getApplicationContext(), R.layout.list_picture, pictureList);

        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(adapter);
    }

    private ArrayList<Bitmap> load() {
        ArrayList<Bitmap> list = new ArrayList<Bitmap>();
            ContentResolver cr = getContentResolver();
            Uri uri = Uri.parse("http://lp.spartacamp.jp/201510_java/img/Android-logo_t.png");
            try {
                InputStream in = cr.openInputStream(uri);
                Bitmap image = BitmapFactory.decodeStream(in);
                in.close();
                list.add(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return list;
    }
}
