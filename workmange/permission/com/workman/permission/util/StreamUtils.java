package com.workman.permission.util;

import java.io.Closeable;
import java.io.IOException;

public class StreamUtils {
	public static void closeStream(Closeable stream){
		if(stream != null){
			try {
				stream.close();
			} catch (IOException e) {
				SysLogUtils.error(StreamUtils.class, e,"关闭流失败");
			}
		}
	}
}
