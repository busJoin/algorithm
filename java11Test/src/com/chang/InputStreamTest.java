package com.chang;

import org.junit.Test;

import java.io.FileOutputStream;

/**
 * @User: chang
 */
public class InputStreamTest {
    @Test
    public void testName() throws Exception {
        var cl = this.getClass().getClassLoader();
        try (var is = cl.getResourceAsStream("file");
        var os = new FileOutputStream("flie1")){
            //把输入流中的所有数据直接自动地复制到输出流中
            is.transferTo(os);
        }
    }
}
