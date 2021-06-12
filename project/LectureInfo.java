package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class LectureInfo extends JDialog {

	private JPanel mainPanel = new JPanel();
	

	public lectureInfo(Window parent, lecture lectureArr) {
		//팝업창 생성
		super(parent, "Modal", ModalityType.APPLICATION_MODAL);
		setSize(400, 260);
		setBounds(100, 100, 450, 332);
		getContentPane().setLayout(new BorderLayout());

		// 메인패널 생성
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		// 이미지 삽입
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(lectureInfo.class.getResource("/image/Info.PNG")));
		lblNewLabel.setBounds(50, 10, 327, 29);
		mainPanel.add(lblNewLabel);


		JTextPane subjectTextPanel = new JTextPane();
		subjectTextPanel.setBounds(56, 65, 43, 21);
		subjectTextPanel.setEditable(false);
		subjectTextPanel.setText("과목명");
		mainPanel.add(subjectTextPanel);

		JTextPane courseTextPanel = new JTextPane();
		courseTextPanel.setBounds(56, 96, 43, 21);
		courseTextPanel.setEditable(false);
		courseTextPanel.setText("이수");
		mainPanel.add(courseTextPanel);

		JTextPane professorNameTextPanel = new JTextPane();
		professorNameTextPanel.setBounds(56, 127, 43, 21);
		professorNameTextPanel.setEditable(false);
		professorNameTextPanel.setText("교수님");
		mainPanel.add(professorNameTextPanel);

		JTextPane lectureRoomTextPanel = new JTextPane();
		lectureRoomTextPanel.setBounds(56, 158, 43, 21);
		lectureRoomTextPanel.setEditable(false);
		lectureRoomTextPanel.setText("강의실");
		mainPanel.add(lectureRoomTextPanel);

		JTextPane emailTextPanel = new JTextPane();
		emailTextPanel.setBounds(56, 189, 43, 21);
		emailTextPanel.setEditable(false);
		emailTextPanel.setText("이메일");
		mainPanel.add(emailTextPanel);

		
		
		/*
		 * 매개변수로 받은 lectureArr의 정보를 textField에 출력
		 */
		
		JTextField subjectTextField = new JTextField();
		subjectTextField.setBounds(144, 65, 116, 21);
		subjectTextField.setEditable(false);
		subjectTextField.setText(lectureArr.getSubject());
		mainPanel.add(subjectTextField);
		subjectTextField.setColumns(10);

		JTextField courseTextField = new JTextField();
		courseTextField.setBounds(144, 96, 116, 21);
		courseTextField.setText(lectureArr.getcourse());
		courseTextField.setEditable(false);
		mainPanel.add(courseTextField);
		courseTextField.setColumns(10);

		JTextField professorTextField = new JTextField();
		professorTextField.setBounds(144, 127, 116, 21);
		professorTextField.setEditable(false);
		professorTextField.setText(lectureArr.getProfessorName());
		mainPanel.add(professorTextField);
		professorTextField.setColumns(10);

		JTextField lectureRoomTextField = new JTextField();
		lectureRoomTextField.setBounds(144, 158, 116, 21);
		lectureRoomTextField.setEditable(false);
		lectureRoomTextField.setText(lectureArr.getLectureRoom());
		mainPanel.add(lectureRoomTextField);
		lectureRoomTextField.setColumns(10);

		JTextField emailTextField = new JTextField();
		emailTextField.setBounds(144, 189, 157, 21);
		emailTextField.setEditable(false);
		emailTextField.setText(lectureArr.getEmail());
		mainPanel.add(emailTextField);
		
		

		/*
		 * button panel 생성
		 * */ 
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 233, 434, 60);
		mainPanel.add(buttonPane);
		buttonPane.setBackground(Color.WHITE);
		buttonPane.setLayout(null);

		
		// linkBtn 생성 (클릭 시 링크 주소 접속)
		JButton linkBtn = new JButton();
		linkBtn.setIcon(new ImageIcon(lectureInfo.class.getResource("/image/webexlogo.PNG")));
		linkBtn.setBounds(56, 10, 102, 35);
		buttonPane.add(linkBtn);
		linkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 웹브라우저로 링크 주소 접속
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();

					URI uri = null;
					try {
						uri = new URI(lectureArr.getLink());
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						desktop.browse(uri);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				dispose(); // 창 닫기
			}
		});

			
		// cancel button 생성(클릭시 창 닫기)
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 창 닫기
			}
		});

		cancelBtn.setBackground(Color.WHITE);
		cancelBtn.setBounds(325, 22, 97, 23);
		buttonPane.add(cancelBtn);

	}

}
