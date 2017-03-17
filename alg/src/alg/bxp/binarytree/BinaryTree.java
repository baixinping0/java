package alg.bxp.binarytree;
import java.util.Scanner;
import org.junit.Test;
public class BinaryTree {
	private Scanner scanner = new Scanner(System.in);
	public Node create() {
		String data = scanner.next();
		Node node = null;
		if ("#".equals(data)) {
			return null;
		} else {
			node = new Node(data);
			//创建左子数
			node.left = create();
			//创建右子数
			node.right = create();
		}
		return node;
	}
	
	/**
	 * 先根遍历
	 * @param root
	 */
	public void beforeRoot(Node root){
		if(root != null){
			System.out.println(root.data);
			beforeRoot(root.left);
			beforeRoot(root.right);
		}
		return;
	}
	/**
	 * 中根遍历
	 * @param root
	 */
	public void midRoot(Node root){
		if(root != null){
			midRoot(root.left);
			System.out.println(root.data);
			midRoot(root.right);
		}
		return;
	}
	/**
	 * 后根遍历
	 * @param root
	 */
	public void endRoot(Node root){
		if(root != null){
			endRoot(root.left);
			endRoot(root.right);
			System.out.println(root.data);
		}
		return;
	}
	/**
	 * 层序遍历
	 * @param root
	 */
	public void floor(Node root){
		if(root != null){
			System.out.println(root.data);
//			floor
		}
		return;
	}
	
	@Test
	public void test(){
		Node root = create();
		System.out.println("先根遍历");
		beforeRoot(root);
		System.out.println("中根遍历");
		midRoot(root);
		System.out.println("后根遍历");
		endRoot(root);
		System.out.println("层序遍历");
		floor(root);
	}
}
