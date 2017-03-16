package alg.bxp.link;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Operation {
	public void print(Node head) {
		Node p;
		for (p = head; p != null; p = p.next) {
			System.out.print(p.date + "  ");
		}
	}

	@Test
	public void test() {
		// 创建
		Node head = create(read());
		System.out.println("创建成功");
		print(head);
		// 删除
		head = delete(head, 3);
		System.out.println();
		System.out.println("删除成功");
		print(head);
		
		System.out.println();
		System.out.println("插入第一个数据");
		head = insertFirst(head, 6);
		print(head);
		
		System.out.println();
		System.out.println("插最后数据");
		head = insertFinal(head, 6);
		print(head);
	}

	public Node insertFirst(Node head, int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		return node;
	}

	public Node insertFinal(Node head,int data) {
		for(Node pos = head; pos != null; pos = pos.next){
			if(pos.next == null){
				pos.next = new Node(data);
				break;
			}				
		}
		return head;
	}

	public Node delete(Node head, int date) {
		Node node = null;
		Node before = null;
		for (node = head; node != null; node = node.next) {
			if (node.date == date) {
				if (node.equals(head)) {
					// 删除的是第一个元素
					head = head.next;
				} else {
					before.next = node.next;
					node = before;
				}
			}
			before = node;
		}
		return head;
	}

	public Node create(int[] datas) {
		Node head = null;
		Node pos = null;
		for (int data : datas) {

			if (head == null) {
				head = new Node(data);
				pos = head;
			} else {
				Node node = new Node(data);
				pos.next = node;
				pos = node;
			}
		}
		return head;
	}

	public int[] read() {
		Scanner scanner = new Scanner(System.in);
		String info = scanner.nextLine();
		String[] dataStr = info.split(" ");
		int[] datas = new int[dataStr.length];
		for (int i = 0; i < dataStr.length; i++) {
			datas[i] = Integer.parseInt(dataStr[i]);
		}
		return datas;
	}
}
