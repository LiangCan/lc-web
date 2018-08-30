package com.lc.web.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liang on 2017/1/3.
 */
public class ExecutorUtils {
    /** 可缓存线程池 */
   public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
}
