package cn.rocker.log4j;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Log4j 日志框架学习
 *
 * @author: chengzc
 * @create: 2019-11-29 14:23
 * @since:
 **/
@Slf4j
public class LogDemo {

    @Test
    public void testLogLevel(){
        log.trace("this is trace");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
    }

    @Test
    public void testFengling() {
        Logger fengling = LoggerFactory.getLogger("fengling");
        Map<String, Object> logmap = new HashMap();
        logmap.put("aaa","111");
        logmap.put("bbb","222");
        logmap.put("ccc","333");

        DemoObject demoObject = new DemoObject();
        demoObject.setAdd("aaa");
        demoObject.setAge(333);
        demoObject.setHome("ddd");
        demoObject.setName("rrrr");
        demoObject.setMap(logmap);

        fengling.info(JSON.toJSONString(logmap));
    }

}
