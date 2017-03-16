package tools;

import java.io.UnsupportedEncodingException;

public class Code {
//	java不同编码之间进行转换，都需要使用unicode作为中转。
//	以utf-8转gbk为例，示例代码如下：
	public static String change(String str){  
		String utf8 = null;
		String gbk = null;
		try {
			utf8 = new String(str.getBytes( "UTF-8"));
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
		String unicode = null;
		try {
			unicode = new String(utf8.getBytes(),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
		
		try {
			gbk = new String(unicode.getBytes("GBK"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return gbk;
	}

}
