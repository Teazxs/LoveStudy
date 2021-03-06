package com.example.wangzhibo.lovestudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * 最简单的Activity、Service使用、通信指南一(进程内通信)(附github源码)
 * https://blog.csdn.net/wangzhibo666/article/details/86606603
 */
public class MathService extends Service {
    SendThread thread;
    public MathService() {
    }

    @Override
    public void onCreate() {
        thread = new SendThread();
        thread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MathBinder();
    }

    public class MathBinder extends Binder{
        //返回service
        public MathService getService(){
            return MathService.this;
        }
    }

    //获取线程的num
    public int getNum(){
        return thread.getNum();
    }

    public void release() {
        thread.setEnd(true);
    }
}
