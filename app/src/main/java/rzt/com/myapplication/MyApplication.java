package rzt.com.myapplication;

import android.app.Application;
import android.util.Log;


public class MyApplication extends Application {
    private final static String TAG = "netease>>";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "MyApplication onCreate");
//        initApp();
    }

    private void initApp() {
//        TrackPoint.init(new TrackPointCallBack() {
//            @Override
//            public void onClick(String pageClassName, String viewIdName) {
//                Log.d(TAG, "onClick: " + pageClassName + "-" + viewIdName);
//                //添加你的操作
//            }
//
//            @Override
//            public void onPageOpen(String pageClassName) {
//                Log.d(TAG, "onPageOpen: " + pageClassName);
//                //添加你的操作
//            }
//
//            @Override
//            public void onPageClose(String pageClassName) {
//                Log.d(TAG, "onPageClose: " + pageClassName);
//                //添加你的操作
//            }
//        });
    }
}
