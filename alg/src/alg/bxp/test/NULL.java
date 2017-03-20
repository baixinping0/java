package alg.bxp.test;

import org.junit.Test;

public class NULL {

	public static void print() {
		System.out.println("MTDP");
	}

	@Test
	public  void fun1() {
		System.out.println(((AA) null));
		System.out.println((int)((AA) null).fun());;
	}
//	@Test
//	public void fun2(){
//		boolean result=false?false:true==false?true:false;
//		System.out.println(""+result+"");
//	}
}
class AA{
	public static Integer fun(){
		
		System.out.println("asdfka");
		return (Integer)null;
	}
	
}