package form;
import genetics1.Ind;
import genetics1.Result;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import tools.Code;
import tools.PanelUtil;
import tools.Point;
import tools.Serialize;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ShowResultForm extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JPanel jPanel1;
	JFrame lastFrame = null;
	JFrame jFrame = this;
	Result result = null;
	int firstX = 100;
	int firstY = 100;
	int margin = 30;
	int rowHeight = 40;
	int colWidth = 40;
	public static final String FILE_NAME = "result.txt";
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	
	
	public ShowResultForm(final JFrame lastFrame, Result result) {
		super();
		this.lastFrame = lastFrame;
		this.result = result;
		this.setTitle("最优解显示界面");
		initGUI();
		initTable();
		if(firstX < PanelUtil.windowWidth){
			this.setSize(firstX + firstY, PanelUtil.windowWidth);
			jPanel1.setPreferredSize(new java.awt.Dimension(firstX + firstY, PanelUtil.windowWidth));
			jScrollPane1.setBounds(0, 0, firstX + firstY - 20, PanelUtil.windowWidth - 35);
		}
		this.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowClosing(WindowEvent e) {
				lastFrame.dispose();
				
			}
			
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
	}
	
	
	
	private int getMaxCount(List<Integer> list){
		int maxCount = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) > maxCount)
				maxCount = list.get(i);
		}
		return maxCount;
	}
	
	public void initTable(){
		List<Ind> inds = result.getInds();
		for(int i = 0; i < inds.size(); i++){
			int[] equRank = inds.get(i).getEquRank();
			List<Integer> integers = inds.get(i).getRowEquCounts();
			//行数
			int rowCount = integers.size();
			//列数
			int colCount = getMaxCount(integers);
			
			String[][] content = new String[rowCount][];
			int index = 0;
			int flag = 0;
			//循环加载行数据
			for(int j = integers.size() - 1; j >= 0; j--){
				if(j != integers.size() - 1)
					flag += integers.get(j + 1);
				//每行数据个数
				int count = integers.get(j);
				String[] str = new String[count];
				for(int t = equRank.length - flag - 1; (t >= 0 && count > 0); t--){
					str[count - 1] = equRank[t] + "";
					count --;
				}
				content[index] = str;
				index ++;
			}
			
			JLabel label = new JLabel();
			jPanel1.add(label);
			label.setBounds(firstX, firstY - 30, colWidth * colCount,20);
			label.setText("第" + (i + 1) + "期");
			
			int y = firstY;
			if(i == 0){
				for(int n = content.length; n > 0; n--){
					JLabel label1 = new JLabel();
					jPanel1.add(label1);
					label1.setBounds(firstX - 60, y, colWidth * colCount + 300,20);
					label1.setText("第" + n +"行");
					label1.setFont(new java.awt.Font("楷体",0,14));
					y += rowHeight;
				}
			}
			
			
			if(i == 1){
				JLabel label1 = new JLabel();
				jPanel1.add(label1);
				label1.setBounds(firstX, firstY + rowCount * rowHeight + 100, colWidth * colCount + 300,20);
				label1.setText("适应度结果:  " + result.getFitnessResult());
				label1.setFont(new java.awt.Font("楷体",0,14));
				
				JLabel label2 = new JLabel();
				jPanel1.add(label2);
				label2.setBounds(firstX, firstY + rowCount * rowHeight + 100 + 30, colWidth * colCount + 300,20);
				label2.setText("设备重置费用:  " + result.getEquResttingCost());
				label2.setFont(new java.awt.Font("楷体",0,14));
				
				JLabel label3 = new JLabel();
				jPanel1.add(label3);
				label3.setBounds(firstX, firstY + rowCount * rowHeight + 100 + 60, colWidth * colCount + 300,20);
				label3.setText("设备间物料搬运费用: " + result.getCarryCost());
				label3.setFont(new java.awt.Font("楷体",0,14));
				
				JLabel label4 = new JLabel();
				jPanel1.add(label4);
				label4.setBounds(firstX, firstY + rowCount * rowHeight + 100 + 90, colWidth * colCount + 300,20);
				label4.setText("面积使用率:  " + result.getAreaUse());
				label4.setFont(new java.awt.Font("楷体",0,14));
				
				JButton saveButton = new JButton("保存结果");
				jPanel1.add(saveButton);
				saveButton.setBounds(firstX - 20, firstY + rowCount * rowHeight + 100 + 90 + 40, 100, 24);
				saveButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
							File file = new File(FILE_NAME);
							if(file.exists()){
								file.delete();
							}
							Serialize.outputResult(FILE_NAME, "适应度结果：" + result.getFitnessResult() + "\r\n");
							List<Ind> inds = result.getInds();
							Serialize.outputResult(FILE_NAME, "设备间的搬运费用：" + result.getCarryCost()+"\r\n");
							Serialize.outputResult(FILE_NAME, "设备重置费用："+ result.getEquResttingCost() + "\r\n");
							Serialize.outputResult(FILE_NAME, "设备面积利用" + result.getAreaUse() + "\r\n");
							for(int j = 0; j < inds.size(); j++){
								Ind ind = inds.get(j);
								int[] equ = ind.getEquRank();
								Serialize.outputResult(FILE_NAME, "\r\n");
								for(int i = 0; i < equ.length; i++){
									System.out.print(equ[i]+ "  ");
									Serialize.outputResult(FILE_NAME, equ[i]+ "  ");
								}
								Serialize.outputResult(FILE_NAME, "\r\n");
								List<Integer> row = ind.getRowEquCounts();
								Serialize.outputResult(FILE_NAME, "行数：" + row.size() + "\r\n");
								for(int i = 0; i < row.size(); i++){
									Serialize.outputResult(FILE_NAME, "第"+ i +"行的设备数量： " + row.get(i) + "\r\n");
								}
								Point[] point = ind.getPoint();
								for(int i = 0; i < point.length; i++){
									Serialize.outputResult(FILE_NAME, "第" + (i + 1) +"个设备 的坐标：(" + point[i].X+ "," + point[i].Y+")   ");
								}
								Serialize.outputResult(FILE_NAME, "\r\n");
								Serialize.outputResult(FILE_NAME, "\r\n");
						}
					}
				});
				
				JButton retuButton = new JButton("返回");
				jPanel1.add(retuButton);
				retuButton.setBounds(firstX + 100 + 20, firstY + rowCount * rowHeight + 100 + 90 + 40, 100, 24);
				retuButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						jFrame.setVisible(false);
						lastFrame.setVisible(true);
					}
				});
			}
			
			TableModel jTable1Model = 
					new DefaultTableModel(content, new String[colCount]);
			JTable jTable1 = new JTable();
			jPanel1.add(jTable1);
			jTable1.setModel(jTable1Model);
			jTable1.setRowHeight(rowHeight);
			jTable1.setBounds(firstX, firstY,  colWidth * colCount, rowHeight * rowCount);
			firstX += margin + colWidth * colCount;
		}
		
//		int count = inds.size();
//		for(int i = 0; i < count; i++){
//			JList jList = new JList();
//			jList.setBounds(firstX, firstY, 100, 100);
//			jPanel1.add(jList);
//			firstX += 30 + 100;
//			System.out.println(firstX + "  **********");
//		}
	}
	
	private void initGUI(){
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();
				jScrollPane1.setBounds(0, 0, PanelUtil.windowLeng - 20, PanelUtil.windowWidth - 35);
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
//				jScrollPane1.setPreferredSize(new java.awt.Dimension(553, 672));
				{
					jPanel1 = new JPanel();
					jScrollPane1.setViewportView(jPanel1);
					jPanel1.setPreferredSize(new java.awt.Dimension(PanelUtil.windowLeng, PanelUtil.windowWidth));
					jPanel1. setLayout(null);
				}
			}
			pack();
			this.setSize(PanelUtil.windowLeng, PanelUtil.windowWidth);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
