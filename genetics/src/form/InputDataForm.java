package form;
import genetics1.Data;
import genetics1.Main;
import genetics1.Result;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import tools.MessageDialog;
import tools.PanelUtil;
import tools.Regular;
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
public class InputDataForm extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final String FILE_NAME = "data";
	public int flag = 0;
	Data newData = new Data();
	
	int equCount;
	double equRowWidth;
	double wsLength;
	double wsWidth;
	double firstEquWallWidth;
	
	int periodCount;
	int indiCount;
	int screenCount;
	double variationRate;
	double crossRate;
	
	double b1;
	double b2;
	double b3;
	double TR;
	double T;
	
	int resuleIteratorCount;
	double u;
	int m;
	
	double[] equLength = null;
	double[] equWidth = null;
	double[] equWallMargin = null;
	double[] equCarryCost = null;
	
	
	double[][] equMargin = null;
	double[][] P = null;
	double[][] Q1 = null;
	private JTextField crossText;
	private JLabel crossLable;
	private ButtonGroup buttonGroup1;
	private JRadioButton T_CGAButton;
	private JRadioButton L_CGAButton;
	private JRadioButton GAButton;
	double[][] Q2 = null;
	double[][] Q3 = null;
	String EQUMARGIN_STR = "equMargin";
	String P_STR = "P";
	String Q1_STR = "Q1";
	String Q2_STR = "Q2";
	String Q3_STR = "Q3";
	
	Map<String, String> map = new HashMap<String, String>();
	
	JFrame jFrame = this;
	
	//用于存放四个选择按钮
	List<JRadioButton> jRadioButtons = new ArrayList<JRadioButton>();
	
	//用于存放选择按钮改变之前的被选中的按钮。
	JRadioButton lastSelect = null;
	
	List<JTextField> equLengText = new ArrayList<JTextField>();
	List<JTextField> equWidthText = new ArrayList<JTextField>();
	List<JTextField> equWallMarginText = new ArrayList<JTextField>();
	List<JTextField> equCarryCostText = new ArrayList<JTextField>();
	List<List<JTextField>> equRelationText = new ArrayList<List<JTextField>>();
	List<JLabel> rowLables = new ArrayList<JLabel>();
	List<JLabel> colLables = new ArrayList<JLabel>();
	
	public static final int GA = 1;
	public static final int L_CGA = 2;
	public static final int T_CGA = 3;
	List<JRadioButton> calButtons = null;
	
	
	private JScrollPane jScrollPane1;
	private JButton calResultButton;
	private JLabel jLabel24;
	private JRadioButton Q3Button;
	private JRadioButton Q2Button;
	private JRadioButton Q1Button;
	private JRadioButton pButton;
	private ButtonGroup buttonGroup;
	private JRadioButton equMarginButton;
	private JLabel jLabel14;
	private JLabel jLabel8;
	private JLabel jLabel19;
	private JLabel jLabel17;
	private JLabel jLabel26;
	private JLabel jLabel25;
	private JTextField indiCountText;
	private JTextField variationRateText;
	private JLabel jLabel11;
	private JTextField screenCountText;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel equWidthLable;
	private JLabel equLengthLable;
	private JLabel jLabel5;
	private JTextField equCountText;
	private JLabel jLabel6;
	private JLabel jLabel1;
	private JTextField wsLengthText;
	private JLabel jLabel4;
	private JTextField equRowWidthText;
	private JTextField wsWidthText;
	private JTextField firstEquWallWidthText;
	private JLabel jLabel7;
	private JTextField periodCountText;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JTextField b1Text;
	private JLabel jLabel15;
	private JTextField b2Text;
	private JLabel jLabel16;
	private JTextField b3Text;
	private JTextField TText;
	private JLabel jLabel18;
	private JTextField TRText;
	private JTextField resuleIteratorCountText;
	private JLabel jLabel20;
	private JLabel jLabel22;
	private JTextField mText;
	private JLabel jLabel21;
	private JTextField uText;
	private JPanel jPanel1;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InputDataForm inst = new InputDataForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public InputDataForm() {
		super();
		initGUI();
		initData();
	}
	
	private void initData() {
		Data oldData = (Data) Serialize.outputSerializable(FILE_NAME);
		if(oldData != null){
			equCountText.setText(oldData.wsEquCount + "");
			equRowWidthText.setText(oldData.wsRowWidth + "");
			wsLengthText.setText(oldData.wsLength + "");
			wsWidthText.setText(oldData.wsWidth + "");
			firstEquWallWidthText.setText(oldData.wsRowWidth + "");
			
			periodCountText.setText(oldData.producePeriod + "");
			indiCountText.setText(oldData.indiCount + "");
			screenCountText.setText(oldData.screenCount + "");
			variationRateText.setText(oldData.variationRate + "");
			crossText.setText(oldData.crossRate + "");
			
			b1Text.setText(oldData.b1 + "");
			b2Text.setText(oldData.b2 + "");
			b3Text.setText(oldData.b3 + "");
			TRText.setText(oldData.TR + "");
			TText.setText(oldData.T + "");
			
			resuleIteratorCountText.setText(oldData.resuleIteratorCount + "");
			uText.setText(oldData.u + "");
			mText.setText(oldData.m + "");
			
			double[] equLengs = oldData.equLength;
			double[] equWidths = oldData.equWidth;
			double[] equWallMargins = oldData.equWallMargin;
			double[] equCarryCosts = oldData.cost;
			if(equLengs != null)
				for(int i = 0; i < equLengs.length; i++){
					equLengText.get(i).setText(equLengs[i] + "");
				}
			if(equWidths != null)
				for(int i = 0; i < equWidths.length; i++){
					equWidthText.get(i).setText(equWidths[i] + "");
				}
			
			if(equWallMargins != null)
				for(int i = 0; i < equWallMargins.length; i++){
					equWallMarginText.get(i).setText(equWallMargins[i] + "");
				}
			if(equCarryCosts != null)
				for(int i = 0; i < equCarryCosts.length; i++){
					equCarryCostText.get(i).setText(equCarryCosts[i] + "");
				}
			
			equMargin = oldData.equMargin;
			P = oldData.P;
			Q1 = oldData.Q1;
			Q2 = oldData.Q2;
			Q3 = oldData.Q3;
			intput(equMarginButton);  
		}
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setResizable(false);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				this.setTitle("计算机辅助动态布局设计");
	
				jScrollPane1.setBounds(0, 0, PanelUtil.windowLeng - 20, PanelUtil.windowWidth - 40);
//				jScrollPane1.setBounds(0, 0, this.getHeight() - 40 , this.getWidth() - 40);
				{
					
					jPanel1 = new JPanel();
					jScrollPane1.setViewportView(jPanel1);
					jPanel1.setLayout(null);
					jPanel1.setPreferredSize(new java.awt.Dimension(PanelUtil.windowLeng , PanelUtil.windowWidth));
					{
						uText = new JTextField();
						jPanel1.add(uText);
						uText.setBounds(384, 516, 75, 24);
					}
					{
						jLabel21 = new JLabel();
						jPanel1.add(jLabel21);
						jLabel21.setText("\u5438\u5f15\u5b50u");
						jLabel21.setBounds(309, 519, 57, 17);
						jLabel21.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						mText = new JTextField();
						jPanel1.add(mText);
						mText.setBounds(136, 566, 80, 24);
					}
					{
						jLabel22 = new JLabel();
						jPanel1.add(jLabel22);
						jLabel22.setText("m\u503c");
						jLabel22.setBounds(78, 569, 29, 17);
						jLabel22.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel20 = new JLabel();
						jPanel1.add(jLabel20);
						jLabel20.setText("\u8fed\u4ee3\u6b21\u6570");
						jLabel20.setBounds(58, 519, 66, 17);
						jLabel20.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						resuleIteratorCountText = new JTextField();
						jPanel1.add(resuleIteratorCountText);
						resuleIteratorCountText.setBounds(136, 516, 80, 24);
					}
					{
						jLabel19 = new JLabel();
						jPanel1.add(jLabel19);
						jLabel19.setText("-------------------------\u6df7\u6c8c\u8fed\u4ee3\u53c2\u6570\u8bbe\u7f6e--------------------");
						jLabel19.setBounds(12, 471, 459, 17);
						jLabel19.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel17 = new JLabel();
						jPanel1.add(jLabel17);
						jLabel17.setText("\u4ea7\u80fd\u635f\u5931\u6210\u672cTR");
						jLabel17.setBounds(22, 434, 102, 17);
						jLabel17.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						TRText = new JTextField();
						jPanel1.add(TRText);
						TRText.setBounds(136, 431, 80, 24);
					}
					{
						jLabel18 = new JLabel();
						jPanel1.add(jLabel18);
						jLabel18.setText("\u60e9\u7f5a\u503cT");
						jLabel18.setBounds(308, 438, 57, 17);
						jLabel18.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						TText = new JTextField();
						jPanel1.add(TText);
						TText.setBounds(383, 435, 75, 24);
					}
					{
						b3Text = new JTextField();
						jPanel1.add(b3Text);
						b3Text.setBounds(383, 380, 75, 24);
					}
					{
						jLabel16 = new JLabel();
						jPanel1.add(jLabel16);
						jLabel16.setText("b3");
						jLabel16.setBounds(360, 383, 15, 17);
						jLabel16.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						b2Text = new JTextField();
						jPanel1.add(b2Text);
						b2Text.setBounds(265, 380, 77, 24);
					}
					{
						jLabel15 = new JLabel();
						jPanel1.add(jLabel15);
						jLabel15.setText("b2");
						jLabel15.setBounds(238, 383, 15, 17);
						jLabel15.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						b1Text = new JTextField();
						jPanel1.add(b1Text);
						b1Text.setBounds(137, 380, 80, 24);
					}
					{
						jLabel13 = new JLabel();
						jPanel1.add(jLabel13);
						jLabel13.setText("\u52a0\u6743\u56e0\u5b50");
						jLabel13.setBounds(41, 383, 60, 17);
						jLabel13.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel12 = new JLabel();
						jPanel1.add(jLabel12);
						jLabel12.setText("-------------------------\u591a\u76ee\u6807\u53c2\u6570\u8bbe\u7f6e--------------------");
						jLabel12.setBounds(12, 342, 429, 17);
						jLabel12.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel10 = new JLabel();
						jPanel1.add(jLabel10);
						jLabel10.setText("\u4ee3\u6570");
						jLabel10.setBounds(304, 245, 61, 17);
						jLabel10.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						screenCountText = new JTextField();
						jPanel1.add(screenCountText);
						screenCountText.setBounds(383, 242, 80, 24);
					}
					{
						jLabel11 = new JLabel();
						jPanel1.add(jLabel11);
						jLabel11.setText("\u53d8\u5f02\u6982\u7387");
						jLabel11.setBounds(309, 298, 56, 17);
						jLabel11.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						variationRateText = new JTextField();
						jPanel1.add(variationRateText);
						variationRateText.setBounds(383, 295, 75, 24);
					}
					{
						indiCountText = new JTextField();
						jPanel1.add(indiCountText);
						indiCountText.setBounds(137, 242, 80, 24);
					}
					{
						jLabel9 = new JLabel();
						jPanel1.add(jLabel9);
						jLabel9.setText("\u79cd\u7fa4\u6570\u91cf");
						jLabel9.setBounds(53, 249, 66, 17);
						jLabel9.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						periodCountText = new JTextField();
						jPanel1.add(periodCountText);
						periodCountText.setBounds(383, 160, 80, 24);
					}
					{
						jLabel2 = new JLabel();
						jPanel1.add(jLabel2);
						jLabel2.setText("\u8ba1\u5212\u5468\u671f\u6570");
						jLabel2.setBounds(279, 163, 78, 17);
						jLabel2.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel7 = new JLabel();
						jPanel1.add(jLabel7);
						jLabel7.setText("\u7b2c\u4e00\u884c\u8bbe\u5907\u8ddd\u5899\u5bbd");
						jLabel7.setBounds(12, 163, 119, 17);
						jLabel7.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						firstEquWallWidthText = new JTextField();
						jPanel1.add(firstEquWallWidthText);
						firstEquWallWidthText.setBounds(137, 160, 80, 24);
					}
					{
						wsWidthText = new JTextField();
						jPanel1.add(wsWidthText);
						wsWidthText.setBounds(383, 117, 75, 24);
					}
					{
						equRowWidthText = new JTextField();
						jPanel1.add(equRowWidthText);
						equRowWidthText.setBounds(383, 66, 75, 24);
					}
					{
						jLabel4 = new JLabel();
						jPanel1.add(jLabel4);
						jLabel4.setText("\u8f66\u95f4\u5bbd");
						jLabel4.setBounds(317, 120, 48, 17);
						jLabel4.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						wsLengthText = new JTextField();
						jPanel1.add(wsLengthText);
						wsLengthText.setBounds(137, 117, 80, 24);
					}
					{
						jLabel3 = new JLabel();
						jPanel1.add(jLabel3);
						jLabel3.setText("\u8f66\u95f4\u957f");
						jLabel3.setBounds(66, 120, 53, 17);
						jLabel3.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel1 = new JLabel();
						jPanel1.add(jLabel1);
						jLabel1.setText("\u8bbe\u5907\u6570");
						jLabel1.setBounds(66, 69, 52, 17);
						jLabel1.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel6 = new JLabel();
						jPanel1.add(jLabel6);
						jLabel6.setText("\u8bbe\u5907\u6392\u5217\u884c\u5bbd");
						jLabel6.setBounds(273, 69, 84, 17);
						jLabel6.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						equCountText = new JTextField();
						jPanel1.add(equCountText);
						equCountText.setBounds(136, 66, 81, 24);
						equCountText.getDocument().addDocumentListener(new DocumentListener() {

							
//此处是对输入设备时台数改变的监听**************************************
							
							
		                public void removeUpdate(DocumentEvent e) {
		                	
		                	if(equCountText.getText().equals(""))
		                		change(0);
		                	else {
		                		String equCountString = equCountText.getText();
			            		if(!Regular.isNumber(equCountString)){
			            			MessageDialog.showMessage("请输入正确的设备台数", jFrame);
			            			return;
			            		}
		                		int equCount = Integer.parseInt(equCountText.getText());
		                		change(equCount);
							}
		                		
		                }
		                 
		                public void insertUpdate(DocumentEvent e) {
		                	String equCountString = equCountText.getText();
		            		if(!Regular.isNumber(equCountString)){
		            			MessageDialog.showMessage("请输入正确的设备台数", jFrame);
		            			return;
		            		}
		                	int equCount = Integer.parseInt(equCountString);
		                	change(equCount);
		                }
		                 
		                public void changedUpdate(DocumentEvent e) {
		                	String equCountString = equCountText.getText();
		            		if(!Regular.isNumber(equCountString)){
		            			MessageDialog.showMessage("请输入正确的设备台数", jFrame);
		            			return;
		            		}
		                	int equCount = Integer.parseInt(equCountString);
		                	change(equCount);
		                }
		                /**
		                 * 输入的台数改变的时候，需要发生的一些改变
		                 * @param equCount
		                 */
		                public void change(int equCount){
		                		
		                	int leng = 48;				//矩形框的长度
		                	int width = 24;				//矩形框的宽度
		                	int x = 680;				//第一个矩形框的横坐标
		                	int equLengY = 65;			//第一个矩形框的纵坐标
		                	int equWidthY = 65 + width +30;
		                	int equWallMarginY = equWidthY + width +30;
		                	int equCarryCostY = equWallMarginY + width + 30;
		                	int equRelationY = equCarryCostY + width + 30;
		                	
		                	productRowLable(equCount, x, equLengY, equLengY);		//产生横向标签
		                	
		                	productRow(equLengText, equCount, x, equLengY, leng, width);
		                	productRow(equWidthText, equCount, x, equWidthY, leng, width);
		                	productRow(equWallMarginText, equCount, x, equWallMarginY, leng, width);
		                	productRow(equCarryCostText, equCount, x, equCarryCostY, leng, width);
		                	
		                	productColLable(equCount, x, equRelationY, width);		//产生纵向标签
		                	
		                	productRowCol(equCount, x, equRelationY, leng, width);	//产生矩形框
	                		 
		                }
		            });
					}
					{
						jLabel5 = new JLabel();
						jPanel1.add(jLabel5);
						jLabel5.setText("------------------------------------------------\u8f66\u95f4\u521d\u59cb\u5e03\u5c40\u89c4\u5212------------------------------");
						jLabel5.setBounds(12, 12, 431, 17);
						jLabel5.setFont(new java.awt.Font("华文楷体",0,14));
					}
					{
						equLengthLable = new JLabel();
						jPanel1.add(equLengthLable);
						equLengthLable.setText("\u8bbe\u5907\u957f\u5ea6");
						equLengthLable.setBounds(544, 69, 56, 17);
						equLengthLable.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						equWidthLable = new JLabel();
						jPanel1.add(equWidthLable);
						equWidthLable.setText("\u8bbe\u5907\u5bbd\u5ea6");
						equWidthLable.setBounds(544, 120, 56, 17);
						equWidthLable.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel8 = new JLabel();
						jPanel1.add(jLabel8);
						jLabel8.setText("\u8bbe\u5907\u5899\u8ddd");
						jLabel8.setBounds(544, 174, 66, 17);
						jLabel8.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						jLabel14 = new JLabel();
						jPanel1.add(jLabel14);
						jLabel14.setText("\u8bbe\u5907\u642c\u8fd0\u8d39\u7528");
						jLabel14.setBounds(525, 228, 93, 17);
						jLabel14.setFont(new java.awt.Font("楷体",0,14));
					}
					{
//对按钮进行的定义*****************************************
						equMarginButton = new JRadioButton();
						jPanel1.add(equMarginButton);
						equMarginButton.setText("\u8bbe\u5907\u95f4\u8ddd");
						equMarginButton.setBounds(500, 285, 87, 21);
						equMarginButton.setSelected(true);
						
						pButton = new JRadioButton();
						jPanel1.add(pButton);
						pButton.setText("\u7269\u6599\u642c\u8fd0\u8d39\u7528P");
						pButton.setBounds(500, 315, 124, 21);
					
						Q1Button = new JRadioButton();
						jPanel1.add(Q1Button);
						Q1Button.setText("\u7269\u6599\u642c\u8fd0\u9891\u7387Q1");
						Q1Button.setBounds(500, 345, 124, 21);
					
						Q2Button = new JRadioButton();
						jPanel1.add(Q2Button);
						Q2Button.setText("\u7269\u6599\u642c\u8fd0\u9891\u7387Q2");
						Q2Button.setBounds(500, 375, 124, 21);
					
						Q3Button = new JRadioButton();
						jPanel1.add(Q3Button);
						Q3Button.setText("\u7269\u6599\u642c\u8fd0\u9891\u7387Q3");
						Q3Button.setBounds(500, 405, 124, 21);
//将按钮加入到buttonGroup中******************************
						buttonGroup = new ButtonGroup();
						buttonGroup.add(equMarginButton);
						
						
						buttonGroup.add(pButton);
						pButton.setFont(new java.awt.Font("楷体",0,14));
						
						buttonGroup.add(Q1Button);
						Q1Button.setFont(new java.awt.Font("楷体",0,14));
						
						buttonGroup.add(Q2Button);
						Q2Button.setFont(new java.awt.Font("楷体",0,14));
						
						buttonGroup.add(Q3Button);
						Q3Button.setFont(new java.awt.Font("楷体",0,14));

//按钮添加监听事件********************************
						equMarginButton.setFont(new java.awt.Font("楷体",0,14));
						equMarginButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								clickButton(equMarginButton);
							}
						});
						
						pButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								clickButton(pButton);
							}
						});
						
						Q1Button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								clickButton(Q1Button);
							}
						});
						
						Q2Button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								clickButton(Q2Button);
							}
						});
						
						Q3Button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								clickButton(Q3Button);
							}
						});
						//最开始给上次选择的按钮赋值第一个按钮
						lastSelect = equMarginButton;
						//将四个按钮加入集合中
						jRadioButtons.add(equMarginButton);
						jRadioButtons.add(pButton);
						jRadioButtons.add(Q1Button);
						jRadioButtons.add(Q2Button);
						jRadioButtons.add(Q3Button);	
						
						map.put(equMarginButton.getText(), EQUMARGIN_STR);
						map.put(pButton.getText(), P_STR);
						map.put(Q1Button.getText(), Q1_STR);
						map.put(Q2Button.getText(), Q2_STR);
						map.put(Q3Button.getText(), Q3_STR);
						
					}
					{
						jLabel24 = new JLabel();
						jPanel1.add(jLabel24);
						jLabel24.setText("----------------------------\u521d\u59cb\u5316\u53c2\u6570\u8bbe\u7f6e-------------");
						jLabel24.setBounds(12, 211, 565, 17);
						jLabel24.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						calResultButton = new JButton();
						jPanel1.add(calResultButton);
						calResultButton.setText("\u8ba1\u7b97\u7ed3\u679c");
						calResultButton.setBounds(505, 600, 113, 24);
						calResultButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
//计算结果的按钮*************************************
								JRadioButton jRadioButton = getSelectButton(calButtons);
								if(jRadioButton != null)
									if(jRadioButton == GAButton){
										flag = GA;
									}else if(jRadioButton == L_CGAButton){
										flag = L_CGA;
									}else if(jRadioButton == T_CGAButton){
										flag = T_CGA;
									}else {
										MessageDialog.showMessage("请先选择算法", jFrame);
										return;
									}
								if(getData() && getRowData() && getEquRelationData(getSelectButton(jRadioButtons))){
									evaluation();
									if(newData.equLength == null){
										MessageDialog.showMessage("请输入设备长度", jFrame);
										return;
									}
									if(newData.equWidth == null){
										MessageDialog.showMessage("请输入设备宽度", jFrame);
										return;
									}
									if(newData.equWallMargin == null){
										MessageDialog.showMessage("请输入设备距墙的宽度", jFrame);
										return;
									}
									if(newData.cost == null){
										MessageDialog.showMessage("请输入设备搬运费用", jFrame);
										return;
									}
									
									if(equMargin == null){
										MessageDialog.showMessage("请输入设备间距", jFrame);
										return;
									}
									if(newData.P == null){
										MessageDialog.showMessage("请输入物料搬运费用P", jFrame);
										return;
									}
									if(newData.Q1 == null){
										MessageDialog.showMessage("请输入物料搬运频率Q1", jFrame);
										return;
									}
									if(newData.Q2 == null){
										MessageDialog.showMessage("请输入物料搬运频率Q2", jFrame);
										return;
									}
									if(newData.Q3 == null){
										MessageDialog.showMessage("请输入物料搬运频率Q3", jFrame);
										return;
									}
									//将此次输入的数据序列化到文件中
									Serialize.inputSerializable(FILE_NAME, newData);
									
									Result result = new Main().main(newData, flag);
									ShowResultForm showResultForm = new ShowResultForm(jFrame, result);
									showResultForm.setVisible(true);
									jFrame.setVisible(false);
								}
							}
						});
					}
					{
						jLabel25 = new JLabel();
						jPanel1.add(jLabel25);
						jLabel25.setText("b1");
						jLabel25.setBounds(113, 383, 15, 17);
					}
					{
						jLabel26 = new JLabel();
						jPanel1.add(jLabel26);
						jLabel26.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						jLabel26.setBounds(500, 256, 864, 17);
					}
					{
						crossLable = new JLabel();
						jPanel1.add(crossLable);
						crossLable.setText("\u4ea4\u53c9\u6982\u7387");
						crossLable.setBounds(53, 298, 72, 17);
						crossLable.setFont(new java.awt.Font("楷体",0,14));
					}
					{
						crossText = new JTextField();
						jPanel1.add(crossText);
						crossText.setBounds(137, 295, 80, 24);
					}
					{
						GAButton = new JRadioButton();
						jPanel1.add(GAButton);
						GAButton.setText("GA");
						GAButton.setBounds(505, 489, 100, 21);
					}
					{
						L_CGAButton = new JRadioButton();
						jPanel1.add(L_CGAButton);
						L_CGAButton.setText("L_CGA");
						L_CGAButton.setBounds(505, 519, 95, 21);
					}
					{
						T_CGAButton = new JRadioButton();
						jPanel1.add(T_CGAButton);
						T_CGAButton.setText("T_CGA");
						T_CGAButton.setBounds(505, 553, 95, 21);
					}
					{
						buttonGroup1 = new ButtonGroup();
						GAButton.setSelected(true);
						buttonGroup1.add(GAButton);
						
						buttonGroup1.add(L_CGAButton);
						buttonGroup1.add(T_CGAButton);
						
						calButtons = new ArrayList<JRadioButton>();
						calButtons.add(GAButton);
						calButtons.add(L_CGAButton);
						calButtons.add(T_CGAButton);
					}
				}
			}
			pack();
			this.setSize(PanelUtil.windowLeng, PanelUtil.windowWidth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public void paint(Graphics graphics){
//		jScrollPane1.setBounds(0, 0, this.getHeight() - 40 , this.getWidth() - 40);
//	}
	/**
	 * 将界面中的数据赋值给Data
	 */
	public void evaluation(){
		//车间需要的数据
		newData.wsLength = wsLength;
		newData.wsWidth = wsWidth;
		newData. wsEquCount = equCount;			//设备的数量
		newData.wsRowWidth = equRowWidth; 		//车间中存放设备时每行设备的宽度
		newData.wsFirstMargin = firstEquWallWidth;	//第一行设备距离墙的宽度
//		newData.wsT = 500;				//500
		
		//设备需要的数据
		//***************************************************
		newData.equLength = equLength;
		newData.equWidth = equWidth;
		newData.equWallMargin = equWallMargin;
		newData.cost = equCarryCost;
		
		
		//设备间关系需要的数据
		//***************************************************
		newData.equMargin = equMargin;
		newData.P = P;
		newData.Q1 = Q1;
		newData.Q2 = Q2;
		newData.Q3 = Q3;
		
		
		//种群需要用到的数据
		//***************************************************
		newData. producePeriod = periodCount;		//周期
		newData. indiCount = indiCount;			//个体数量（每期初始产生多少个1-8的编码）
		newData. screenCount = screenCount;		//选择变异的次数
		newData.variationRate = variationRate;		//变异概率
		newData.crossRate = crossRate;
		
		//计算时需要用到的数据
		newData.b1 = b1;
		newData.b2 = b2;
		newData.b3 = b3;
		newData.TR = TR;				//设备重置时需要用到的TR
		newData.T = T;				//罚函数
		
		//混沌迭代时需要用到的数据
		newData. resuleIteratorCount = resuleIteratorCount;
		newData.u = u;
		newData.m = m;
	}
	
	
	/**
	 * 产生横向lable标识
	 * @param equCount
	 * @param x
	 * @param y
	 * @param leng
	 */
	public void productRowLable(int equCount, int x, int y, int leng){
		for(int i = 0; i < rowLables.size(); i++){
			jPanel1.remove(rowLables.get(i));
			jPanel1.repaint();
		}
		//清除集合中的控件
		rowLables.clear();
		
		for(int i = 0; i < equCount; i++){
			JLabel jLabel = new JLabel();
			jPanel1.add(jLabel);
			jLabel.setText((i + 1) + "");
			jLabel.setBounds(x, y - 20, 30, 10);
			rowLables.add(jLabel);
			x += (leng - 12);
		}
	}
	/**
	 * 纵向的lable
	 * @param equCount
	 * @param x
	 * @param y
	 * @param width
	 */
	public void productColLable(int equCount, int x, int y, int width){
		for(int i = 0; i < colLables.size(); i++){
			jPanel1.remove(colLables.get(i));
			jPanel1.repaint();
		}
		//清除集合中的控件
		colLables.clear();
		
		for(int i = 0; i < equCount; i++){
			JLabel jLabel = new JLabel();
			jPanel1.add(jLabel);
			jLabel.setText((i + 1) + "");
			jLabel.setBounds(x- 20, y , 30, 10);
			colLables.add(jLabel);
			y += (width + 5);
		}
	}
	
	/**
	 * 产生单行框
	 * @param list
	 * @param equCount
	 * @param x
	 * @param y
	 * @param leng
	 * @param width
	 */
	public void productRow(List<JTextField> list, int equCount, int x, int y, int leng, int width){
		//清除原有的
		for(int i = 0; i < list.size(); i++){
			jPanel1.remove(list.get(i));
			jPanel1.repaint();
		}
		//清除集合中的控件
		list.clear();
		
		for(int i = 0; i < equCount; i++){
			JTextField jTextField = new JTextField();
			jPanel1.add(jTextField);
			jTextField.setBounds(x, y, leng, width);
			list.add(jTextField);
			
			
			x += (leng + 5);
//			System.out.println("  " + x + "   " + y + "   " +  "   " + leng +  "   " + width);
		}
		
	}
	/**
	 * 产生矩形数组框
	 * @param lists
	 * @param equCount
	 * @param x
	 * @param y
	 * @param leng
	 * @param width
	 */
	public void productRowCol(int equCount, int x, int y, int leng, int width){
		int distance = 5;
		//清除所有
		for(int i = 0; i < equRelationText.size(); i++){
			for(int j = 0; j < equRelationText.get(i).size(); j++){
				jPanel1.remove(equRelationText.get(i).get(j));
				jPanel1.repaint();
			}
		}
		//将集合中的数据全部清空
		equRelationText.clear();
		for(int i = 0; i < equCount; i++){
			equRelationText.add(new ArrayList<JTextField>());
		}
		
		int backX = x;
		for(int i = 0; i < equCount; i++){
			x = backX;
			for(int j = 0; j < equRelationText.size(); j++){
				JTextField jTextField = new JTextField();
				jPanel1.add(jTextField);
				jTextField.setBounds(x, y, leng, width);
				equRelationText.get(i).add(jTextField);
				x += (leng + distance);	
			}
			y += (width + 5);
		}
		if(x > 1390 || y > 770)
			jPanel1.setPreferredSize(new Dimension(x, y));
	
	}
	/**
	 * 初始化保存数据所用的double数组
	 * @param equCount
	 */
	
	
	/**
	 * 获取被选择的button
	 * @return
	 */
	public JRadioButton getSelectButton(List<JRadioButton> jButtons){
		for(int i = 0; i < jButtons.size(); i++){
			if(jButtons.get(i).isSelected())
				return jButtons.get(i);
		}
		return null;
	}
	/**
	 * 
	 * @param jRadioButton 点击的按钮对象
	 */
//点击按钮监听的事件
	public void clickButton(JRadioButton jRadioButton){
		//1、将上次button中的数据进行保存
		if(lastSelect != jRadioButton){
			if(!getEquRelationData(lastSelect)){
				lastSelect.setSelected(true);
				return;
			}
			//将原有的数据导入矩形框
			clearEquRelation();
			intput(getSelectButton(jRadioButtons));
			lastSelect = jRadioButton;
		}
	}
	/**
	 * 将原有数据导入矩形框
	 * @param jRadioButton  当前选中的按钮
	 */
	private void intput(JRadioButton jRadioButton) {
		String value = jRadioButton.getText();
		double[][] info = null;
		if (EQUMARGIN_STR.equals(map.get(value))) {
			info = equMargin;
		}else if(P_STR.equals(map.get(value))){
			info = P;
		}else if(Q1_STR.equals(map.get(value))){
			info = Q1;
		}else if(Q2_STR.equals(map.get(value))){
			info = Q2;
		}else if(Q3_STR.equals(map.get(value))){
			info = Q3;
		}
		if(info != null)
			for(int i = 0; i < info.length; i++){
				for(int j = 0; j < info[i].length; j++){
					JTextField jTextField = equRelationText.get(i).get(j);
					jTextField.setText(info[i][j] + "");
				}
			}
	}

	/**
	 * 获取除矩形框和行框以外的数据
	 * @param info 数据要存的数组
	 */
	public boolean  getData(){
		//设备数量
		String equCountStr = equCountText.getText();
		if("".equals(equCountStr))
			equCount = 0;
		else {
			if(!Regular.isPositiveInteger(equCountStr)){
				MessageDialog.showMessage("请输入正确的设备台数", jFrame);
				return false;
			}
			equCount = Integer.parseInt(equCountStr);
		}
		//设备行宽
		String equRowWidthStr = equRowWidthText.getText();
		if("".equals(equRowWidthStr))
			equRowWidth = 0;
		else {
			if(!(Regular.isPositiveDecimal(equRowWidthStr) || Regular.isPositiveInteger(equRowWidthStr))){
				MessageDialog.showMessage("请输入正确的设备排列行宽", jFrame);
				return false;
			}
			equRowWidth = Double.parseDouble(equRowWidthStr);
		}
		//车间长度
		String wsLengthStr = wsLengthText.getText();
		if("".equals(wsLengthStr))
			wsLength = 0;
		else {
			if(!(Regular.isPositiveDecimal(wsLengthStr) || Regular.isPositiveInteger(wsLengthStr))){
				MessageDialog.showMessage("请输入正确的车间长度", jFrame);
				return false;
			}
			wsLength = Double.parseDouble(wsLengthStr);
		}
		//车间宽度
		String wsWidthStr = wsWidthText.getText();
		if("".equals(wsWidthStr))
			wsWidth = 0;
		else {
			if(!(Regular.isPositiveDecimal(wsWidthStr) || Regular.isPositiveInteger(wsWidthStr))){
				MessageDialog.showMessage("请输入正确的车间宽度", jFrame);
				return false;
			}
			wsWidth = Double.parseDouble(wsWidthStr);
		}
		//第一行距墙宽
		String firstEquWallWidthStr = firstEquWallWidthText.getText();
		if("".equals(firstEquWallWidthStr))
			firstEquWallWidth = 0;
		else {
			if(!(Regular.isPositiveDecimal(firstEquWallWidthStr) || Regular.isPositiveInteger(firstEquWallWidthStr))){
				MessageDialog.showMessage("请输入正确的第一行设备墙距", jFrame);
				return false;
			}
			firstEquWallWidth = Double.parseDouble(firstEquWallWidthStr);
		}
		
		//周期数
		String periodCountStr = periodCountText.getText();
		if("".equals(periodCountStr))
			periodCount = 0;
		else {
			if(!Regular.isPositiveInteger(periodCountStr)){
				MessageDialog.showMessage("请输入正确的周期数", jFrame);
				return false;
			}
			periodCount = Integer.parseInt(periodCountStr);
		}
		//个体数量
		String indiCountStr = indiCountText.getText();
		if("".equals(indiCountStr))
			indiCount = 0;
		else {
			if(!Regular.isPositiveInteger(indiCountStr)){
				MessageDialog.showMessage("请输入正确的种群数量", jFrame);
				return false;
			}
			indiCount = Integer.parseInt(indiCountStr);
		}
		//代数
		String screenCountStr = screenCountText.getText();
		if("".equals(screenCountStr))
			screenCount = 0;
		else{
			if(!Regular.isPositiveInteger(screenCountStr)){
				MessageDialog.showMessage("请输入正确的代数", jFrame);
				return false;
			}
			screenCount = Integer.parseInt(screenCountStr);
		}
		//变异概率
		String variationRateStr = variationRateText.getText();
		if("".equals(variationRateStr))
			variationRate = 0;
		else {
			if(!(Regular.isPositiveDecimal(variationRateStr) || Regular.isPositiveInteger(variationRateStr))){
				MessageDialog.showMessage("请输入正确的变异概率", jFrame);
				return false;
			}
			variationRate = Double.parseDouble(variationRateStr);
		}
		
		//交叉概率
				String crossRateStr = crossText.getText();
				if("".equals(crossRateStr))
					crossRate = 0;
				else {
					if(!(Regular.isPositiveDecimal(crossRateStr) || Regular.isPositiveInteger(crossRateStr))){
						MessageDialog.showMessage("请输入正确的交叉概率", jFrame);
						return false;
					}
					crossRate = Double.parseDouble(crossRateStr);
				}
		
		
		//加权子b1
		String b1Str = b1Text.getText();
		if("".equals(b1Str))
			b1 = 0;
		else {
			if(!(Regular.isPositiveDecimal(b1Str) || Regular.isPositiveInteger(b1Str))){
				MessageDialog.showMessage("请输入正确的加权因子b1", jFrame);
				return false;
			}
			b1 = Double.parseDouble(b1Str);
		}
		//加权子b2
		String b2Str = b2Text.getText();
		if("".equals(b2Str))
			b2 = 0;
		else {
			if(!(Regular.isPositiveDecimal(b2Str) || Regular.isPositiveInteger(b2Str))){
				MessageDialog.showMessage("请输入正确的加权因子b2", jFrame);
				return false;
			}
			b2 = Double.parseDouble(b2Str);
		}
		//加权子b3
		String b3Str = b3Text.getText();
		if("".equals(b3Str))
			b3 = 0;
		else {
			if(!(Regular.isPositiveDecimal(b3Str) || Regular.isPositiveInteger(b3Str))){
				MessageDialog.showMessage("请输入正确的加权因子b3", jFrame);
				return false;
			}
			b3 = Double.parseDouble(b3Str);
		}
		//产能损失成本TR
		String TRStr = TRText.getText();
		if("".equals(TRStr))
			TR = 0;
		else {
			if(!(Regular.isPositiveDecimal(TRStr) || Regular.isPositiveInteger(TRStr))){
				MessageDialog.showMessage("请输入正确的产能损失成本TR", jFrame);
				return false;
			}
			TR = Double.parseDouble(TRStr);
		}
		//惩罚值T
		String TStr = TText.getText();
		if("".equals(TStr))
			T = 0;
		else {
			if(!(Regular.isPositiveDecimal(TStr) || Regular.isPositiveInteger(TStr))){
				MessageDialog.showMessage("请输入正确的惩罚值T", jFrame);
				return false;
			}
			T = Double.parseDouble(TStr);
		}
		
		//结果迭代次数
		String resuleIteratorCountStr = resuleIteratorCountText.getText();
		if("".equals(resuleIteratorCountStr))
			resuleIteratorCount = 0;
		else{ 
			if(!Regular.isPositiveInteger(resuleIteratorCountStr)){
				MessageDialog.showMessage("请输入正确的迭代次数", jFrame);
				return false;
			}
			resuleIteratorCount = Integer.parseInt(resuleIteratorCountStr);
		}
		//吸引子
		String uStr = uText.getText();
		if("".equals(uStr))
			u = 0;
		else{
			if(!(Regular.isPositiveDecimal(uStr) || Regular.isPositiveInteger(uStr))){
				MessageDialog.showMessage("请输入正确的吸引子u", jFrame);
				return false;
			}
			u = Double.parseDouble(uStr);
		}
		//m值
		String mStr = mText.getText();
		if("".equals(mStr))
			m = 0;
		else {
			if(!(Regular.isPositiveInteger(mStr))){
				MessageDialog.showMessage("请输入正确的m值", jFrame);
				return false;
			}
			m = Integer.parseInt(mStr);
		}
		return true;
	}
	/**
	 * 获取设备间关系的数据（矩形框中的数据）
	 * @param info
	 */
	public  boolean getEquRelationData(JRadioButton button){
		String equCountString = equCountText.getText();
		double[][] info = null;
		if(!Regular.isNumber(equCountString)){
			MessageDialog.showMessage("请输入正确的设备台数", this);
			return false;
		}
		if(!"".equals(equCountString)){
			int equCount = Integer.parseInt(equCountString);
			if(equCount != 0){
				JRadioButton jRadioButton = button;
				String value = map.get(jRadioButton.getText());
				if(EQUMARGIN_STR.equals(value)){
					if(equMargin == null)
						equMargin = new double[equCount][equCount];
					info = equMargin;
				}
				else if(P_STR.equals(value)){
					if(P == null)
						P = new double[equCount][equCount];
					info = P;
				}
				else if(Q1_STR.equals(value)){
					if(Q1 == null)
						Q1 = new double[equCount][equCount];
					info = Q1;
				}
				else if(Q2_STR.equals(value)){
					if(Q2 == null)
						Q2 = new double[equCount][equCount];
					info = Q2;
				}
				else if(Q3_STR.equals(value)){
					if(Q3 == null)
						Q3 = new double[equCount][equCount];
					info = Q3;
				}
				
			}else {
				MessageDialog.showMessage("请输入设备的台数", this);
				return false;
			}
		}else {
			MessageDialog.showMessage("请输入设备的台数", this);
			return false;
		}	 
		//获取矩形框中的数据
		for(int i = 0; i < equRelationText.size(); i++){
			List<JTextField> list = equRelationText.get(i);
			for(int j = 0; j < list.size(); j++){
				JTextField jTextField = list.get(j);
				String text = jTextField.getText();
				if("".equals(text))
					info[i][j] = 0;
				else {
					JRadioButton jRadioButton = getSelectButton(jRadioButtons);
					if(!(Regular.isPositiveDecimal(text) || Regular.isPositiveInteger(text))){
						MessageDialog.showMessage(jRadioButton.getText() + "的第" + (i + 1) + "行" + (j + 1) + "列" + "个值输入错误", jFrame);
						return false;
					}
					info[i][j] = Double.parseDouble(text);
				}
			}		
		}
		return true;
	}
	/**
	 * 获取四个行中的数据
	 */
	public boolean getRowData(){
		String equCountString = equCountText.getText();
		if(!Regular.isNumber(equCountString)){
			MessageDialog.showMessage("请输入正确的设备台数", this);
			return false;
		}
		if(!"".equals(equCountString)){
			int equCount = Integer.parseInt(equCountString);
			if(equCount != 0){
				if(equLength  == null)
					equLength = new double[equCount];
				
				if(equWidth  == null)
					equWidth = new double[equCount];
				
				if(equWallMargin  == null)
					equWallMargin = new double[equCount];
				
				if(equCarryCost  == null)
					equCarryCost = new double[equCount];
				//获取四个行中的数据
				for(int i = 0; i < equLengText.size(); i++){
					
					String equLengStr = equLengText.get(i).getText();
					if("".equals(equLengStr))
						equLength[i] = 0;
					else {
						if(!(Regular.isPositiveDecimal(equLengStr) || Regular.isPositiveInteger(equLengStr))){
							MessageDialog.showMessage("第" + (i + 1) + "个设备的长度输入错误", jFrame);
							return false;
						}
						equLength[i] = Double.parseDouble(equLengStr);
					}
				
					String equWidthStr = equWidthText.get(i).getText();
					if("".equals(equWidthStr))
						equWidth[i] = 0;
					else {
						if(!(Regular.isPositiveDecimal(equWidthStr) || Regular.isPositiveInteger(equWidthStr))){
							MessageDialog.showMessage("第" + (i + 1) + "个设备的宽度输入错误", jFrame);
							return false;
						}
						equWidth[i] = Double.parseDouble(equWidthStr);
					}
					
					String equWallMarginStr = equWallMarginText.get(i).getText();
					if("".equals(equWallMarginStr))
						equWallMargin[i] = 0;
					else {
						if(!(Regular.isPositiveDecimal(equWallMarginStr) || Regular.isPositiveInteger(equWallMarginStr))){
							MessageDialog.showMessage("第" + (i + 1) + "个设备的墙距输入错误", jFrame);
							return false;
						}
						equWallMargin[i] = Double.parseDouble(equWallMarginStr);
					}
					
					String equCarryCostStr = equCarryCostText.get(i).getText();
					if("".equals(equCarryCostStr))
						equCarryCost[i] = 0;
					else {
						if(!(Regular.isPositiveDecimal(equCarryCostStr) || Regular.isPositiveInteger(equCarryCostStr))){
							MessageDialog.showMessage("第" + (i + 1) + "个设备的搬运费用输入错误", jFrame);
							return false;
						}
						equCarryCost[i] = Double.parseDouble(equCarryCostStr);
					}
				}
			}else {
				MessageDialog.showMessage("请输入设备的台数", this);
				return false;
			}
		}else {
			MessageDialog.showMessage("请输入设备的台数", this);
			return false;
		}	 
		return true;
//		System.out.println("设备数量 ： " + equCount);
//		System.out.println("吸引子 ： " + u);
//		System.out.println("设备长度");
//		PrintResult.printArray(equLength);
//		System.out.println("设备宽度");
//		PrintResult.printArray(equWidth);
//		System.out.println("设备墙距");
//		PrintResult.printArray(equWallMargin);
//		System.out.println("设备搬运费用");
//		PrintResult.printArray(equCarryCost);
//		
//		
//		System.out.println("设备间距");
//		PrintResult.printArray(equMargin);
//		System.out.println("P");
//		PrintResult.printArray(P);
//		System.out.println("Q1");
//		PrintResult.printArray(Q1);
//		System.out.println("Q2");
//		PrintResult.printArray(Q2);
//		System.out.println("Q3");
//		PrintResult.printArray(Q3);	
	}
	/**
	 * 清空矩形框中的数据
	 */
	public void clearEquRelation(){
		if(equRelationText != null)
			for(int i = 0; i < equRelationText.size(); i++){
				List<JTextField> list = equRelationText.get(i);
				for(int j = 0; j < list.size(); j++){
					JTextField jTextField = list.get(j);
					jTextField.setText("");
				}		
			}
		}
	
	

}
