package com.example.androiddome.mmap;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.androiddome.R;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/4/7 19:56
 * Description:
 */
public class MMAPActivity extends Activity {
    private Button btObserve;
    private Button btOpen;
    private Button btClose;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private boolean isObserve = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btObserve = (Button) findViewById(R.id.bt_observe);
//        btOpen = (Button) findViewById(R.id.bt_open);
//        btClose = (Button) findViewById(R.id.bt_close);
        btOpen.setOnClickListener(v->{
            mmapOpen(Environment.getExternalStorageDirectory().getAbsolutePath()+"/mmaptest.txt");
        });
        btClose.setOnClickListener(v->{
            isObserve = false;
            mmapClose();
            Toast.makeText(this, "关闭并停止监听", Toast.LENGTH_SHORT).show();
        });
        btObserve.setOnClickListener(v->{
            if(isObserve)
                return;
            isObserve = true;
            //开线程每隔500毫秒获取一下共享映射区的内容
            new Thread(()->{
                while (isObserve){
                    try {
                        String observe = observe("");
                        //当我们监听到共享区的内容不为空的时候就将内容以Toast的方式显示出来
                        if(!TextUtils.isEmpty(observe)){
                            runOnUiThread(()->{
                                Toast.makeText(this, observe, Toast.LENGTH_SHORT).show();
                            });
                            //获取完之后将共享区内容置空
                            mmapSetEmpty();
                        }
                        Thread.sleep(500);
                    }catch (Exception e){}
                }
            }).start();
            Toast.makeText(this, "开始监听", Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * 开启共享映射
     * @param absolutePath
     */
    public native void mmapOpen(String absolutePath);

    /**
     * 关闭共享映射
     */
    public native void mmapClose();

    /**
     * 将映射区置空
     */
    public native void mmapSetEmpty();

    /**
     * 监听映射区的内容
     * @param defaultVal 传入的默认值
     * @return
     */
    public native String observe(String defaultVal);

}
