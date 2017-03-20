package alg.bxp.test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author bxp
 *
 */
public class Main {
	public static void main(String[] args) {
		fun();
	}
	public static void fun(){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		//L R
		String[] info = str.split(" ");
		//计算总度数
		double L = Integer.parseInt(info[0]);
		double R = Integer.parseInt(info[1]);
		
		double x = L * Math.sin((L/2)) * R;
		double y = L * Math.cos((L/2)) * R;
		DecimalFormat d = new DecimalFormat("0.000");
		System.out.println(d.format(x) + " " + d.format(y));
		System.out.println(d.format(x) + " " + (d.format(-y)));
	}
}





