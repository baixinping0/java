package tools;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	//序列化
	public static void inputSerializable(String fileName, Object object){
		ObjectOutputStream os = null;
		try
        {
            os = 
            		new ObjectOutputStream(new FileOutputStream(fileName));//输出流保存的文件名为 my.out ；ObjectOutputStream能把Object输出成Byte流
            os.writeObject(object); 
            os.flush();  //缓冲流 
            os.close(); //关闭流
        } catch (FileNotFoundException e) 
        {        
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        } finally{
        	if(os != null)
	        	try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        }
	}
	//反系列化
	public static Object outputSerializable(String fileName)//反序列的过程
	{    
		File file = new File(fileName);
		if(!file.exists())
			try {
				file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
	     ObjectInputStream in = null;//局部变量必须要初始化
	     Object object = null;
	    
	    try{
	        in = new ObjectInputStream(new FileInputStream(fileName));
	        object =  in.readObject();//由Object对象向下转型为MyTest对象
	    } catch (FileNotFoundException e1){        
	        e1.printStackTrace();
//	    	return null;
	    } catch (EOFException e) {
			// TODO: handle exception
		}catch (IOException e1){
	        e1.printStackTrace();
//	    	return null;
	    }catch (ClassNotFoundException e) {
	        e.printStackTrace();
//	    	return null;
	    }finally{
	    	if(in != null)
	        	try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    }
	    return object;
	}
	
	public static void outputResult(String fileName, String info){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName, true);
			fileWriter.write(info.toCharArray());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fileWriter != null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
	
}
