package cn.rocker.juc.future.guavafuture;

import java.util.concurrent.Callable;

/**
 * @author: chengzc
 * @create: 2019-12-03 19:52
 * @since:
 **/
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            Thread.sleep(100);
            int i1 = 1 / 0;
        }
        return sb.toString();
    }
}
