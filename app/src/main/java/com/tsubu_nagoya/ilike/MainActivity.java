package com.tsubu_nagoya.ilike;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
        BitmapAdapter adapter = new BitmapAdapter(
                getApplicationContext(), R.layout.list_picture, pictureList);

        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(adapter);
    }

    private ArrayList<Bitmap> load() {
        ArrayList<Bitmap> list = new ArrayList<Bitmap>();
        ContentResolver cr = getContentResolver();
        Uri uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        ContentResolver resolver = new ContentResolver(getApplicationContext()) {

        };
        Cursor c = resolver.query(uri, null, null, null, null);
  //      Cursor c = managedQuery(uri, null, null, null, null);
        c.moveToFirst();
        for (int i = 0; i < c.getCount(); i++) {
            long id = c.getLong(c.getColumnIndexOrThrow("_id"));
            Bitmap bmp = MediaStore.Images.Thumbnails.getThumbnail(cr, id, MediaStore.Images.Thumbnails.MICRO_KIND, null);
            list.add(bmp);
            c.moveToNext();
        }
        return list;
    }
}
