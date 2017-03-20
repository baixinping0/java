package alg.bxp.test;
public class Test {
	/**
	 * 有了 IP 地址，为什么还要用 MAC 地址？
估计很多人都有这个疑问，但没见哪本书上解释清楚，都只是描述IP是什么，
MAC是什么。当数据包到达局域网后，完全可以直接送到对应的IP地址主机，
为什么还要询问一下对应IP主机的MAC地址？

一个邮递员拿着地址详细到教室的一封信，
收件人是小明，教室里没有重名的，邮递员问
“小明的学号是多少？”，小明站起来回答“150807”
，然后小明坐下，然后邮递员说“学号150807的过来拿信”
，小明站起拿信。哎，好像重复了点什么。
	 */
	
	int aa = 0;
	@org.junit.Test
	public void test() {
		int bb = 0;
		new Thread(new Runnable() {
			int cc = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(aa);
				System.out.println(bb);
				System.out.println(cc);
			}
		});
	}
}
