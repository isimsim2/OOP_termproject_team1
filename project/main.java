package project;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

/**
 * Implement main class. (= Project Demo file)
 * @author Kim Min Jun.
 * last modified 2021-06-12.
 */

public class main {

	private JFrame frame;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		plan plan[] = new plan[8];
		lecture lecture[] = new lecture[20];	
		JTextField planTextField1[] = new JTextField[8];
		JTextField planTextField2[] = new JTextField[8];
		JTextField planTextField3[] = new JTextField[8];
		JButton timeTableBtn[] = new JButton[20];
		
		

		/*
		 * 프레임 생성
		 * */
	    frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setSize(600,680);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		/*
		 * 메인패널 생성
		 */
		ImagePanel mainPanel = new ImagePanel(new ImageIcon(main.class.getResource("/image/backgroundImage.png")).getImage());
		mainPanel.setBounds(0, 0, 584, 641);
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel);
		
	
		/*
		 * 메뉴패널 생성
		 */
		JPanel menu = new JPanel();
		menu.setBounds(24, 21, 537, 69);
		menu.setBackground(Color.WHITE);
		menu.setLayout(null);
		mainPanel.add(menu);
		
		JButton viewSchdeuleBtn = new JButton();
		viewSchdeuleBtn.setIcon(new ImageIcon(main.class.getResource("/image/timetable.PNG")));
		viewSchdeuleBtn.setBounds(330, 25, 114, 26);
		menu.add(viewSchdeuleBtn);
		
		JButton viewPlanBtn = new JButton();
		viewPlanBtn.setIcon(new ImageIcon(main.class.getResource("/image/planBtn.png")));
		viewPlanBtn.setBounds(49, 25, 80, 26);
		viewPlanBtn.setBackground(Color.WHITE);
		menu.add(viewPlanBtn);
		
		JButton addPlanBtn = new JButton();
		addPlanBtn.setBackground(Color.WHITE);
		addPlanBtn.setBorderPainted(false);
		addPlanBtn.setForeground(Color.WHITE);
		addPlanBtn.setBounds(129, 25, 58, 32);
		addPlanBtn.setIcon(new ImageIcon(main.class.getResource("/image/addBtn.png")));
		menu.add(addPlanBtn);
		
		JButton addTimetableBtn = new JButton();
		addTimetableBtn.setBackground(Color.WHITE);
		addTimetableBtn.setIcon(new ImageIcon(main.class.getResource("/image/addBtn.png")));
		addTimetableBtn.setBorderPainted(false);
		addTimetableBtn.setBounds(456, 25, 50, 32);
		menu.add(addTimetableBtn);
		
		
		/*
		 * contentPlan 패널 생성(등록한 plan을 보여주는 패널)
		 */
		JPanel contentPlan = new JPanel();
		contentPlan.setBackground(Color.WHITE);
		contentPlan.setBounds(24, 93, 537, 527);;
		contentPlan.setLayout(null);
		mainPanel.add(contentPlan);
		
		//이미지 삽입
		JLabel contentPlanLabel = new JLabel();
		contentPlanLabel.setIcon(new ImageIcon(main.class.getResource("/image/plan.PNG")));
		contentPlanLabel.setBounds(12, 10, 499, 53);
		contentPlan.add(contentPlanLabel);	
	
			
		/*
		 * contentTimetblae 패널 생성(등록한 lecture을 보여주는 패널)
		 */
		JPanel contentTimetable = new JPanel();
		contentTimetable.setBackground(Color.WHITE);
		contentTimetable.setBounds(24, 93, 537, 527);
		contentTimetable.setLayout(null);
		mainPanel.add(contentTimetable);
			
		ImagePanel timetableImage = new ImagePanel(new ImageIcon(main.class.getResource("/image/timetableMain.png")).getImage());
		timetableImage.setBounds(12, 10, 513, 492);
		timetableImage.setVisible(false);
		timetableImage.setLayout(null);
		contentTimetable.add(timetableImage);
		
		
		/*
		 * registerPlan 패널 생성(plan을 등록하는 패널)
		 * */
		JPanel registerPlan = new JPanel();
		registerPlan.setBackground(Color.WHITE);
		registerPlan.setBounds(24, 93, 537, 527);
		mainPanel.add(registerPlan);
		registerPlan.setLayout(null);
		
		
		
		/*
		 * selectPlan 패널 생성(과제,약속,목표 중 하나의 plan을 선택하는 패널)
		 * */
		JPanel selectPlan = new JPanel();
		selectPlan.setBackground(Color.WHITE);
		selectPlan.setBounds(12, 10, 513, 507);
		registerPlan.add(selectPlan);
		selectPlan.setLayout(null);
		selectPlan.setVisible(false);
		
		//이미지 삽입
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 501, 30);
		selectPlan.add(imageLabel);
		imageLabel.setIcon(new ImageIcon(main.class.getResource("/image/registerPlan.PNG")));
		
		
		/*
		 * selectPlan에서 선택한 plan에 맞게 해당되는 정보를 입력하는 패널
		 * */
		JPanel registerPlanInfo = new JPanel();
		registerPlanInfo.setBackground(Color.WHITE);
		registerPlanInfo.setBounds(12, 10, 513, 507);
		registerPlan.add(registerPlanInfo);
		registerPlanInfo.setLayout(null);
		registerPlanInfo.setVisible(false);
		
		//이미지 삽입
		JLabel registerLabel = new JLabel();
		registerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerLabel.setIcon(new ImageIcon(main.class.getResource("/image/registerPlan.PNG")));
		registerLabel.setBounds(0, 0, 513, 35);
		registerPlanInfo.add(registerLabel);
		
			
		
		
		JTextPane dateTextPanel = new JTextPane();
		dateTextPanel.setEditable(false);
		dateTextPanel.setText("날짜");
		dateTextPanel.setBounds(50, 105, 74, 21);
		registerPlanInfo.add(dateTextPanel);	
		
		JTextPane monthTextPanel = new JTextPane();
		monthTextPanel.setEditable(false);
		monthTextPanel.setText("월");
		monthTextPanel.setBounds(190, 105, 34, 21);
		registerPlanInfo.add(monthTextPanel);
			
		JTextPane dayTextPanel = new JTextPane();
		dayTextPanel.setEditable(false);
		dayTextPanel.setText("일");
		dayTextPanel.setBounds(281, 105, 34, 21);
		registerPlanInfo.add(dayTextPanel);
		
		JTextPane timeTextPanel2 = new JTextPane();
		timeTextPanel2.setEditable(false);
		timeTextPanel2.setText("시");
		timeTextPanel2.setBounds(365, 105, 74, 21);
		registerPlanInfo.add(timeTextPanel2);
		
		JTextPane contentTextPanel = new JTextPane();
		contentTextPanel.setEditable(false);
		contentTextPanel.setText("내용");
		contentTextPanel.setBounds(50, 168, 46, 21);
		registerPlanInfo.add(contentTextPanel);
		
		JTextPane remarksTextPanel = new JTextPane();
		remarksTextPanel.setEditable(false);
		remarksTextPanel.setBounds(51, 228, 81, 21);
		registerPlanInfo.add(remarksTextPanel);
		
		
		
		String monthComboArr[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		String dayComboArr[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String timeComboArr[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23",};
		
		//몇 월인지 선택하는 콤보박스
		JComboBox monthCombo = new JComboBox(monthComboArr);
		monthCombo.setBounds(146, 105, 46, 23);
		registerPlanInfo.add(monthCombo);
		
		//몇 일인지 선택하는 콤보박스
		JComboBox dayCombo = new JComboBox(dayComboArr);
		dayCombo.setBounds(236, 105, 46, 23);
		registerPlanInfo.add(dayCombo);
		
		//몇 시인지 선택하는 콤보박스
		JComboBox timeCombo = new JComboBox(timeComboArr);
		timeCombo.setBounds(318, 105, 43, 23);
		registerPlanInfo.add(timeCombo);
		
		
		/*
		 * 사용자로부터 값을 입력받는 TextField 생성
		 * */
	
		JTextField contentTextField = new JTextField();
		contentTextField.setBounds(146, 168, 116, 21);
		contentTextField.setColumns(10);
		registerPlanInfo.add(contentTextField);	
		
		JTextField reamarksTextField = new JTextField();
		reamarksTextField.setBounds(144, 228, 116, 21);
		reamarksTextField.setColumns(10);
		registerPlanInfo.add(reamarksTextField);
		
		
		
		/*
		 * registerButton 클릭 시, 사용자가 선택한 콤보박스와 TextFeild에 입력한 정보를 저장 및 출력한다
		 * */
		JButton registerButton = new JButton("Register");
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(264, 399, 97, 23);
		registerPlanInfo.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				for(int i=0; i<plan.length; i++)
				{
					//해당하는 인덱스에 등록된 plan이 없을 시
					if(plan[i] == null)
					{											
						
						//plan을 출력하는 TextField 생성
						
						//planTextField1 plan의 종류 출력				
						planTextField1[i] = new JTextField();					
						planTextField1[i].setEditable(false);
						planTextField1[i].setBackground(Color.WHITE);
						planTextField1[i].setBounds(35, 113+(i*40), 70, 21);
						planTextField1[i].setBorder(null);
						planTextField1[i].setFont(new Font("함초롬돋움", Font.BOLD, 13));
						contentPlan.add(planTextField1[i]);					
						
						//planTextField2 plan의 정보 출력
						planTextField2[i] = new JTextField();					
						planTextField2[i].setEditable(false);
						planTextField2[i].setBackground(Color.WHITE);
						planTextField2[i].setBounds(130, 113+(i*40), 300, 21);
						planTextField2[i].setBorder(null);
						planTextField2[i].setFont(new Font("함초롬돋움", Font.BOLD, 11));
						contentPlan.add(planTextField2[i]);
										
						//planTextField3 d-day 출력
						planTextField3[i] = new JTextField();					
						planTextField3[i].setEditable(false);
						planTextField3[i].setForeground(Color.red);
						planTextField3[i].setBackground(Color.WHITE);
						planTextField3[i].setBounds(450, 113+(i*40), 80, 21);
						planTextField3[i].setBorder(null);
						planTextField3[i].setFont(new Font("함초롬돋움", Font.BOLD, 11));
						contentPlan.add(planTextField3[i]);
											
						//selectPlan에서 appointmentBtn 클릭 시 remarksPanel에 "만나는 사람" 입력됨
						//remarksPanel에 값이 "만나는 사람" 이면 appointment 오브젝트 생성 후 plan배열에 저장						
						if(remarksTextPanel.getText().equals("만나는 사람"))
						{
							//정보 저장
							plan[i] = new appointment();			
							plan[i].setMonth(monthCombo.getSelectedItem().toString());
							plan[i].setDay(dayCombo.getSelectedItem().toString());					
							plan[i].setTime(timeCombo.getSelectedItem().toString());
							plan[i].setContent(contentTextField.getText());							
							((appointment)plan[i]).setFriendName(reamarksTextField.getText()); //자식클래스 변수를 사용하므로 강제적 형변환
							
							
							//정보 출력
							planTextField1[i].setText("약속");
							planTextField1[i].setForeground(Color.magenta);
							planTextField2[i].setText(((appointment)plan[i]).getInfo());
							planTextField3[i].setText("D-day " + plan[i].getRemaingTime());						
						}
						
						
						//selectPlan에서 assignment 클릭 시 remarksPanel에 "난이도" 입력됨
						//remarksPanel에 값이 "난이도" 이면 assignment 오브젝트 생성 후 plan배열에 저장
						else if(remarksTextPanel.getText().equals("난이도"))
						{
							plan[i] = new assignment();			
							plan[i].setMonth(monthCombo.getSelectedItem().toString());
							plan[i].setDay(dayCombo.getSelectedItem().toString());					
							plan[i].setTime(timeCombo.getSelectedItem().toString());
							plan[i].setContent(contentTextField.getText());
							((assignment)plan[i]).setDifficulty(reamarksTextField.getText());
							
							planTextField1[i].setText("과제");
							planTextField1[i].setForeground(Color.blue);
							planTextField2[i].setText(((assignment)plan[i]).getInfo());
							planTextField3[i].setText("D-day " + plan[i].getRemaingTime());					
							
							
						}
						
						//selectPlan에서 goal 클릭 시 remarksPanel에 "중요도" 입력됨
						//remarksPanel에 값이 "중요도" 이면 assignment 오브젝트 생성 후 plan배열에 저장
						else if(remarksTextPanel.getText().equals("중요도"))
						{					
							plan[i] = new goal();			
							plan[i].setMonth(monthCombo.getSelectedItem().toString());
							plan[i].setDay(dayCombo.getSelectedItem().toString());					
							plan[i].setTime(timeCombo.getSelectedItem().toString());
							plan[i].setContent(contentTextField.getText());
							((goal)plan[i]).setImportance(reamarksTextField.getText());
							
							planTextField1[i].setText("목표");	
							planTextField1[i].setForeground(Color.orange);
							planTextField2[i].setText(((goal)plan[i]).getInfo());					
							planTextField3[i].setText("D-day " + plan[i].getRemaingTime());											
						}	
												
						break;
					}							
				}
				
				//TextField 값 초기화
				contentTextField.setText("");
				reamarksTextField.setText("");
				
				
				registerPlanInfo.setVisible(false);
				selectPlan.setVisible(false);
				contentPlan.setVisible(true);
			}
		});
		
		
		//Cancel버튼 클릭 시 contentPlan을 보여준다
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBackground(Color.WHITE);
		cancelBtn.setBounds(390, 399, 97, 23);
		registerPlanInfo.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				registerPlanInfo.setVisible(false);
				selectPlan.setVisible(false);
				contentPlan.setVisible(true);
			}
		});
		

		//appointmentBtn 클릭 시 remarksTextPanel에 "만나는 사람" 입력 하고 registerPlanInfoPanel을 보여준다
		JButton appointmentBtn = new JButton("약속");
		appointmentBtn.setBackground(Color.WHITE);
		appointmentBtn.setBounds(41, 102, 97, 79);
		selectPlan.add(appointmentBtn);
		appointmentBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				remarksTextPanel.setText("만나는 사람");			
				selectPlan.setVisible(false);
				registerPlanInfo.setVisible(true);
			}
		});
		
				
		//assignmentBtn 클릭 시 remarksTextPanel에 "과제" 입력 하고 registerPlanInfoPanel을 보여준다
		JButton assignmentBtn = new JButton("과제");
		assignmentBtn.setBackground(Color.WHITE);
		assignmentBtn.setBounds(207, 102, 97, 79);
		selectPlan.add(assignmentBtn);
		assignmentBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				remarksTextPanel.setText("난이도");
				selectPlan.setVisible(false);
				registerPlanInfo.setVisible(true);
			}
		});
		
		
		
		//goalBtn 클릭 시 remarksTextPanel에 "목표" 입력 하고 registerPlanInfoPanel을 보여준다
		JButton goalBtn = new JButton("목표");
		goalBtn.setBackground(Color.WHITE);
		goalBtn.setBounds(367, 102, 97, 79);
		selectPlan.add(goalBtn);
		goalBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				remarksTextPanel.setText("중요도");
				selectPlan.setVisible(false);
				registerPlanInfo.setVisible(true);
			}
		});
		
		
		
		
		
		
		/*
		 * 시간표를 등록하는 패널 생성
		 * */
		JPanel registerTimetable = new JPanel();
		registerTimetable.setBorder(null);
		registerTimetable.setBackground(Color.WHITE);
		registerTimetable.setBounds(24, 93, 537, 527);
		registerTimetable.setLayout(null);
		registerTimetable.setVisible(false);
		mainPanel.add(registerTimetable);
		
		//이미지 삽입
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(main.class.getResource("/image/registerTimetable.PNG")));
		lblNewLabel.setBounds(12, 27, 493, 23);
		registerTimetable.add(lblNewLabel);
		
		
		
		JTextPane subjectTextPanel = new JTextPane();
		subjectTextPanel.setEditable(false);
		subjectTextPanel.setText("과목명");
		subjectTextPanel.setBounds(62, 77, 112, 21);
		registerTimetable.add(subjectTextPanel);
		
		JTextPane timeTextPanel = new JTextPane();
		timeTextPanel.setEditable(false);
		timeTextPanel.setText("시간");
		timeTextPanel.setBounds(62, 205, 112, 21);
		registerTimetable.add(timeTextPanel);
		
		JTextPane courseTextPanel = new JTextPane();
		courseTextPanel.setText("이수");
		courseTextPanel.setEditable(false);
		courseTextPanel.setBounds(62, 119, 112, 21);
		registerTimetable.add(courseTextPanel);
		
		JTextPane dayOfTheWeekTextPanel = new JTextPane();
		dayOfTheWeekTextPanel.setEditable(false);
		dayOfTheWeekTextPanel.setText("요일");
		dayOfTheWeekTextPanel.setBounds(62, 161, 112, 21);
		registerTimetable.add(dayOfTheWeekTextPanel);
		
		JTextPane lectureRoomTextPanel = new JTextPane();
		lectureRoomTextPanel.setEditable(false);
		lectureRoomTextPanel.setText("강의실");
		lectureRoomTextPanel.setBounds(62, 298, 112, 21);
		registerTimetable.add(lectureRoomTextPanel);
		
		JTextPane professorNameTextPanel = new JTextPane();
		professorNameTextPanel.setEditable(false);
		professorNameTextPanel.setText("교수님");
		professorNameTextPanel.setBounds(62, 253, 112, 21);
		registerTimetable.add(professorNameTextPanel);
			
		JTextPane emailTextPanel = new JTextPane();
		emailTextPanel.setEditable(false);
		emailTextPanel.setText("이메일");
		emailTextPanel.setBounds(62, 344, 112, 21);
		registerTimetable.add(emailTextPanel);
		
		JTextPane linkTextPanel = new JTextPane();
		linkTextPanel.setEditable(false);
		linkTextPanel.setText("웹엑스 링크");
		linkTextPanel.setBounds(62, 392, 112, 21);
		registerTimetable.add(linkTextPanel);
		
		
		
		
		/*
		 * 사용자로부터 값을 입력받는 TextField 생성
		 * */	
		JTextField subjectTextField = new JTextField();
		subjectTextField.setColumns(10);
		subjectTextField.setBounds(184, 77, 116, 21);
		registerTimetable.add(subjectTextField);
		
		JTextField professorNameTextField = new JTextField();
		professorNameTextField.setColumns(10);
		professorNameTextField.setBounds(184, 253, 116, 21);
		registerTimetable.add(professorNameTextField);
		
		JTextField lectureRoomTextField = new JTextField();
		lectureRoomTextField.setColumns(10);
		lectureRoomTextField.setBounds(184, 298, 116, 21);
		registerTimetable.add(lectureRoomTextField);
		
		JTextField emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(184, 344, 250, 21);
		registerTimetable.add(emailTextField);
		
		JTextField linkTextField = new JTextField();
		linkTextField.setColumns(10);
		linkTextField.setBounds(184, 392, 250, 21);
		registerTimetable.add(linkTextField);
		
		
		
		
			

		
		//요일 콤보박스 생성
		String dayOftheWeekComboArr[] = {"월","화","수","목","금"};
		JComboBox dayOftheWeekComboBox = new JComboBox(dayOftheWeekComboArr);
		dayOftheWeekComboBox.setBounds(186, 161, 71, 23);
		registerTimetable.add(dayOftheWeekComboBox);
		
		
		//시간 콤보박스 생성
		String timeArr[] = {"09 - 11","11 - 13","13 - 15","15 - 17"};
		JComboBox timeComboBox = new JComboBox(timeArr);
		timeComboBox.setBounds(186, 205, 71, 23);
		registerTimetable.add(timeComboBox);
		
		
		//전공 혹은 교양 선택하는 radiobutton 생성
		JRadioButton majorRadioBtn = new JRadioButton("전공");
		majorRadioBtn.setBackground(Color.WHITE);
		majorRadioBtn.setBounds(186, 119, 121, 23);
		registerTimetable.add(majorRadioBtn);
		
		JRadioButton electiveRadioBtn = new JRadioButton("교양");
		electiveRadioBtn.setBackground(Color.WHITE);
		electiveRadioBtn.setBounds(313, 119, 121, 23);
		registerTimetable.add(electiveRadioBtn);
		
		//majorRadioBtn,electiveRadioBtn 두개의 라디오 버튼을 그룹화하여 한개의 버튼만 선택되게 한다
		ButtonGroup group = new ButtonGroup();
		group.add(majorRadioBtn);
		group.add(electiveRadioBtn);
		majorRadioBtn.setActionCommand("전공");
		electiveRadioBtn.setActionCommand("교양");
		
		//register 버튼 생성
		JButton registerTimetableBtn = new JButton("Register");
		registerTimetableBtn.setBounds(267, 462, 97, 23);
		registerTimetableBtn.setBackground(Color.WHITE);
		registerTimetable.add(registerTimetableBtn);
		
		//register 버튼 클릭시
		registerTimetableBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
			{
				for(int i =0; i<lecture.length; i++)
				{
						
					//등록되어있는 lecture가 없을 경우 새로 생성
					if(lecture[i] == null)
					{					
						//콤보박스가 전공으로 선택되었을 경우 major 오브젝트 생성
						if(majorRadioBtn.isSelected())
						{
							lecture[i] = new major();
							lecture[i].setSubject(subjectTextField.getText());
							lecture[i].setCourse(majorRadioBtn.getActionCommand());		
							lecture[i].setDayOfTheWeek(dayOftheWeekComboBox.getSelectedItem().toString());
							lecture[i].setTime(timeComboBox.getSelectedItem().toString());
							lecture[i].setProfessorName(professorNameTextField.getText());
							lecture[i].setLectureRoom(lectureRoomTextField.getText());
							lecture[i].setEmail(emailTextField.getText());
							lecture[i].setLink(linkTextField.getText());
									
						
							//lecture 오브젝트 생성 시 동일한 요일과 시간을 가진 lecture가 있는지 중복 확인						
							for(int index = 0; index<i;index++)
							{
								if(lecture[index].equals(lecture[i]))
								{	
									//에러 메시지 창 띄우기
									JOptionPane errorMessage=new JOptionPane();
									errorMessage.showMessageDialog(null, "Error : 동일한 시간대에 과목이 존재합니다");
									lecture[i] = null;
								}
							}
							
							if(lecture[i] == null)
							{
								break;
							}
										
							//lecture의 정보를 확인 할 수 있는 버튼 생성								
							timeTableBtn[i] = new JButton();
							timeTableBtn[i].setForeground(Color.DARK_GRAY);
							timeTableBtn[i].setFont(new Font("함초롬돋움", Font.BOLD, 11));
							timeTableBtn[i].setBackground(Color.CYAN);
							timetableImage.add(timeTableBtn[i]);	
												
							//lecture의 요일과 시간에 따라 특정 위치에 버튼 생성
							for(int k=0;k<dayOftheWeekComboArr.length;k++)
							{
								for(int j=0;j<timeArr.length;j++)
								{
									if(dayOftheWeekComboArr[k].equals(lecture[i].getDayOfTheWeek()) && timeArr[j].equals(lecture[i].getTime()))
									{
										timeTableBtn[i].setBounds(48+(k*92), 47+(j*105), 93, 107);
										break;
									}
								}
							}
												
							//생성된 버튼안에 등록한 lecture 정보 출력
							timeTableBtn[i].setText("<html>"+lecture[i].getSubject() + "<br>" + lecture[i].getLectureRoom()+"</html>");							
							
							
							int index = i;
							
							//timeTableBtn 버튼 클릭 시 lectureInfo 창 생성(팝업창)
							timeTableBtn[i].addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e) 
								{
									lectureInfo newWindow = new lectureInfo(frame,lecture[index]);
									newWindow.setVisible(true);
								}
							});
							
							timeTableBtn[i].setVisible(true);
							
							break;												
						}
					
						
		
						//콤보박스가 교양으로 선택되었을 경우 elective 오브젝트 생성
						else if(electiveRadioBtn.isSelected())
						{
							lecture[i] = new elective();
							
							lecture[i].setSubject(subjectTextField.getText());
							lecture[i].setCourse(electiveRadioBtn.getActionCommand());		
							lecture[i].setDayOfTheWeek(dayOftheWeekComboBox.getSelectedItem().toString());
							lecture[i].setTime(timeComboBox.getSelectedItem().toString());
							lecture[i].setProfessorName(professorNameTextField.getText());
							lecture[i].setLectureRoom(lectureRoomTextField.getText());
							lecture[i].setEmail(emailTextField.getText());
							lecture[i].setLink(linkTextField.getText());
							
							
							for(int temp = 0; temp<i;temp++)
							{
								if(lecture[temp].equals(lecture[i]))
								{			
									JOptionPane errorMessage=new JOptionPane();
									errorMessage.showMessageDialog(null, "Error : 동일한 시간대에 과목이 존재합니다");
									lecture[i] = null;
								}
							}
							
							if(lecture[i] == null)
							{
								break;
							}
							
																										
							timeTableBtn[i] = new JButton();
							timeTableBtn[i].setForeground(Color.DARK_GRAY);
							timeTableBtn[i].setFont(new Font("함초롬돋움", Font.BOLD, 11));
							timeTableBtn[i].setBackground(Color.ORANGE);				
							timetableImage.add(timeTableBtn[i]);	
									
					
							for(int k=0;k<dayOftheWeekComboArr.length;k++)
							{
								for(int j=0;j<timeArr.length;j++)
								{
									if(dayOftheWeekComboArr[k].equals(lecture[i].getDayOfTheWeek()) && timeArr[j].equals(lecture[i].getTime()))
									{
										timeTableBtn[i].setBounds(48+(k*92), 47+(j*105), 93, 107);
										break;
									}
								}
							}
																				
							timeTableBtn[i].setText("<html>"+lecture[i].getSubject() + "<br>" + lecture[i].getLectureRoom()+"</html>");							
												
						    int index = i;																			
							timeTableBtn[i].addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e) 
								{								
									lectureInfo newWindow = new lectureInfo(frame, lecture[index]);
									newWindow.setVisible(true);
								
								}
							});
													
							timeTableBtn[i].setVisible(true);							
							break;
						}																		
					}		
				}
				
				//textField 값 초기화
				subjectTextField.setText(null);
				professorNameTextField.setText(null);
				lectureRoomTextField.setText(null);
				emailTextField.setText(null);
				linkTextField.setText(null);
				
				registerTimetable.setVisible(false);
				contentTimetable.setVisible(true);
				timetableImage.setVisible(true);			
			}
		});
		
		
		//cancel 버튼 생성
		JButton timeTableCancelBtn = new JButton("Cancel");
		timeTableCancelBtn.setBackground(Color.WHITE);
		timeTableCancelBtn.setBounds(409, 462, 97, 23);
		registerTimetable.add(timeTableCancelBtn);
		
		//cancel 버튼 클릭 시
		timeTableCancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//contentTimetable panel을 보여준다
				registerTimetable.setVisible(false);
				contentTimetable.setVisible(true);
				timetableImage.setVisible(true);
			}
		});	
		
		
		
		
		
		
		
		
		viewPlanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				contentPlan.setVisible(true);
				registerPlan.setVisible(false);
				contentTimetable.setVisible(false);
				registerTimetable.setVisible(false);
			}
		});
	
		
		viewSchdeuleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				contentPlan.setVisible(false);
				registerPlan.setVisible(false);
				contentTimetable.setVisible(true);
				registerTimetable.setVisible(false);
				timetableImage.setVisible(true);
			}
		});
		
		addPlanBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
					{
						contentPlan.setVisible(false);
						contentTimetable.setVisible(false);
						registerTimetable.setVisible(false);
						registerPlan.setVisible(true);
						registerPlanInfo.setVisible(false);
						selectPlan.setVisible(true);
					}
		});
		
		addTimetableBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
					{
						contentPlan.setVisible(false);
						registerPlan.setVisible(false);
						contentTimetable.setVisible(false);
						registerTimetable.setVisible(true);
					}
		});
		
		
	}
}

//background 이미지 삽입
class ImagePanel extends JPanel
{
	private Image img;
	
	public ImagePanel(Image img)
	{
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(img, 0,0,null);
	}
}
