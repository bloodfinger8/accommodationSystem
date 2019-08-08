package hotel_Manager;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Manager extends JFrame {
	private JList list;
	private JLabel room1L, room2L, room3L, room4L, room5L, room6L, room7L, room8L;

	public static void main(String[] args) {
		new Manager();
	}// main

	public Manager() {// 생성자 시작
		setTitle("비트 호텔 매니저 v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 550);
//base panel as content pane
		JPanel basePanel = new JPanel();
		basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		basePanel.setLayout(null);

//JLabel
		room1L = new JLabel("1호실");
		room1L.setBounds(130, 65, 60, 15);
		room2L = new JLabel("2호실");
		room2L.setBounds(355, 65, 60, 15);
		room3L = new JLabel("3호실");
		room3L.setBounds(575, 65, 60, 15);
		room4L = new JLabel("4호실");
		room4L.setBounds(800, 65, 60, 15);
		room5L = new JLabel("5호실");
		room5L.setBounds(130, 272, 60, 15);
		room6L = new JLabel("6호실");
		room6L.setBounds(355, 272, 60, 15);
		room7L = new JLabel("7호실");
		room7L.setBounds(575, 272, 60, 15);
		room8L = new JLabel("8호실");
		room8L.setBounds(800, 272, 60, 15);

		basePanel.add(room1L);
		basePanel.add(room2L);
		basePanel.add(room3L);
		basePanel.add(room4L);
		basePanel.add(room5L);
		basePanel.add(room6L);
		basePanel.add(room7L);
		basePanel.add(room8L);
//ImageIcon
		ImageIcon room1Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\1_1.png");
		ImageIcon room2Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\2_1.png");
		ImageIcon room3Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\3_1.png");
		ImageIcon room4Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\4_1.png");
		ImageIcon room5Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\5_1.png");
		ImageIcon room6Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\6_1.png");
		ImageIcon room7Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\7_1.png");
		ImageIcon room8Icon = new ImageIcon("C:\\java_ee\\workspace\\HotelManagerIcon\\8_1.png");

//		imgBtn[i].setBorderPainted(false); // 외곽선 없애기
//        imgBtn[i].setContentAreaFilled(false); // 내용영역 채우기 안함
//        imgBtn[i].setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
//        imgBtn[i].setOpaque(false); // 투명하게
//RoundedButton
		JButton btnRoom_1 = new JButton("", room1Icon);
		btnRoom_1.setBounds(40, 90, 215, 125);
		btnRoom_1.setBorderPainted(false); // 외곽선 없애기
		btnRoom_1.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_1.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_1.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_1);

		JButton btnRoom_2 = new JButton("", room2Icon);
		btnRoom_2.setBounds(265, 90, 215, 125);
		btnRoom_2.setBorderPainted(false); // 외곽선 없애기
		btnRoom_2.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_2.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_2.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_2);

		JButton btnRoom_3 = new JButton("", room3Icon);
		btnRoom_3.setBounds(490, 90, 215, 125);
		btnRoom_3.setBorderPainted(false); // 외곽선 없애기
		btnRoom_3.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_3.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_3.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_3);

		JButton btnRoom_4 = new JButton("", room4Icon);
		btnRoom_4.setBounds(715, 90, 215, 125);
		btnRoom_4.setBorderPainted(false); // 외곽선 없애기
		btnRoom_4.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_4.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_4.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_4);

		JButton btnRoom_5 = new JButton("", room5Icon);
		btnRoom_5.setBounds(40, 296, 215, 125);
		btnRoom_5.setBorderPainted(false); // 외곽선 없애기
		btnRoom_5.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_5.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_5.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_5);

		JButton btnRoom_6 = new JButton("", room6Icon);
		btnRoom_6.setBounds(265, 296, 215, 125);
		btnRoom_6.setBorderPainted(false); // 외곽선 없애기
		btnRoom_6.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_6.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_6.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_6);

		JButton btnRoom_7 = new JButton("", room7Icon);
		btnRoom_7.setBounds(490, 296, 215, 125);
		btnRoom_7.setBorderPainted(false); // 외곽선 없애기
		btnRoom_7.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_7.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_7.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_7);

		JButton btnRoom_8 = new JButton("", room8Icon);
		btnRoom_8.setBounds(715, 296, 215, 125);
		btnRoom_8.setBorderPainted(false); // 외곽선 없애기
		btnRoom_8.setContentAreaFilled(false); // 내용영역 채우기 안함
		btnRoom_8.setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
		btnRoom_8.setOpaque(false); // 투명하게
		basePanel.add(btnRoom_8);

//----------------------------------------------------------------
		// JList
		list = new JList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(965, 42, 219, 440);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.add(list);
		basePanel.add(scrollPane);

		Container contentPane = this.getContentPane();
		contentPane.add(basePanel);

		setVisible(true);

	}// 생성자
}// class
