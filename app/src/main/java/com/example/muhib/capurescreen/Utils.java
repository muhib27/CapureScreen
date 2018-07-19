package com.example.muhib.capurescreen;

/**
 * Created by Muhib on 7/19/2018.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {

    public static Bitmap takeScreenShot(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        //Find the screen dimensions to create bitmap in the same size.
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    public static void savePic(Bitmap b, String strFileName) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(strFileName);
            b.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static Bitmap takeS(Activity view) {


//        View v = view.getRootView();
//        v.setDrawingCacheEnabled(true);
//        Bitmap b = v.getDrawingCache();
//        String extr = Environment.getExternalStorageDirectory().toString();
//        File myPath = new File(extr, getString(R.string.free_tiket) + ".jpg");
//        FileOutputStream fos = null;
//        try
//
//        {
//            fos = new FileOutputStream(myPath);
//            b.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//            fos.flush();
//            fos.close();
//            MediaStore.Images.Media.insertImage(getContentResolver(), b,
//                    "Screen", "screen");
//        } catch (
//                FileNotFoundException e)
//
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (
//                Exception e)
//
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return b;
//
//    }
}
