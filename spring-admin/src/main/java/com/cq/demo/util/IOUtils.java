package com.cq.demo.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName IOUtils
 * @Description IO流工具类
 * @Author chen
 * @Date 2020/1/1 19:59
 **/
public class IOUtils {

    /**
     * 关闭对象，连接
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
