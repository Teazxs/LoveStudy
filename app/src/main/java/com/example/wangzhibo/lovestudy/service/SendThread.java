package com.example.wangzhibo.lovestudy.service;

/**
 * AIDL 跨进程Activity、Service的观察者模式实现与源码解读(附github源码)
 * https://blog.csdn.net/wangzhibo666/article/details/86667934
 * Created by samwangzhibo on 2019/1/23.
 */

class SendThread extends Thread {
    int num = 0;
    boolean isEnd = false;
    private final int DURATION_SLEEP = 1000;
    ITaskCallback iTaskCallback;

    /**
     * 关闭线程
     * @param end
     */
    void setEnd(boolean end) {
        isEnd = end;
    }

    public int getNum(){
        return num;
    }

    @Override
    public void run() {
        super.run();
        while (!isEnd) {
            num++;
            if (iTaskCallback != null){
                iTaskCallback.onTasking(num);
            }
            try {
                //不释放资源 休眠
                Thread.sleep(DURATION_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setITaskCallback(ITaskCallback iTaskCallback) {
        this.iTaskCallback = iTaskCallback;
    }

    interface ITaskCallback{
        void onTasking(int num);
    }
}