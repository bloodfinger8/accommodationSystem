package kr.co.bit;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class RoomChoise extends JFrame
{
	public static final int NUMBER = 8;
	private JButton[] imgBtn;
	private JLabel[] room_NumL;
	private JLabel[] priceL;
	private JLabel[] reservationL;
	private ImageIcon[] image;
	private RoundedButton memberInfo;
	private RoundedButton chat;
	private JLabel main;
	private ImageIcon backImg;

	public RoomChoise()
	{
		imgBtn = new JButton[NUMBER];
		room_NumL = new JLabel[NUMBER];
		priceL = new JLabel[NUMBER];
		reservationL = new JLabel[NUMBER];
		image = new ImageIcon[NUMBER];
		
		Font font = new Font("Times", Font.BOLD, 12);
		
		JPanel[] pRoom = new JPanel[NUMBER];
		JPanel[] pPrice = new JPanel[NUMBER];
		JPanel[] pReser = new JPanel[NUMBER];
		
		AbstractBorder[] border = new AbstractBorder[NUMBER];
		
		JPanel[] pText = new JPanel[NUMBER];
		JPanel[] pLine = new JPanel[NUMBER];
		
		main = new JLabel("객실예약");
		Font fontText = new Font("Times", Font.BOLD, 25);
		main.setFont(fontText);
		memberInfo = new RoundedButton("회원정보");
		chat = new RoundedButton("관리자문의");
		
		memberInfo.setBackground(Color.DARK_GRAY);
		memberInfo.setForeground(Color.WHITE);
		chat.setBackground(Color.DARK_GRAY);
		chat.setForeground(Color.WHITE);
		
		JPanel pL = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pL.add(main);
		
		JPanel pBtn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBtn1.add(memberInfo);
		
		JPanel pBtn2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pBtn2.add(chat);
		
		JPanel pBtnTotal = new JPanel(new GridLayout(1, 2, 5, 5));
		pBtnTotal.add(pBtn1);
		pBtnTotal.add(pL);
		pBtnTotal.add(pBtn2);
		
		backImg = new ImageIcon("C:/java_ee/workspace/bitProject/img/images.jpg");
		
		JPanel pTotal = new JPanel(new GridLayout(9, 1, 5, 5));
		
		for(int i = 0; i < NUMBER; i++)
		{
			image[i] = new ImageIcon("C:/java_ee/workspace/bitProject/img/" + (i + 1) + ".jpg");
			
			imgBtn[i] = new JButton(image[i]);
			imgBtn[i].setBorderPainted(false); // 외곽선 없애기
			imgBtn[i].setContentAreaFilled(false); // 내용영역 채우기 안함
			imgBtn[i].setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
			imgBtn[i].setOpaque(false); // 투명하게
			//imgBtn[i].setBackground(getBackground().brighter());
			
			room_NumL[i] = new JLabel((i + 1) + "호실");
			room_NumL[i].setFont(font);
			//room_NumL[i].setOpaque(true);
			//room_NumL[i].setBackground(Color.);
			pRoom[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pRoom[i].add(room_NumL[i]);
			
			priceL[i] = new JLabel((i + 1) + "0000원");
			priceL[i].setFont(font);
			pPrice[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pPrice[i].add(priceL[i]);
			
			reservationL[i] = new JLabel("예약완료");
			reservationL[i].setFont(font);
			pReser[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pReser[i].add(reservationL[i]);
			
			pText[i] = new JPanel(new GridLayout(3, 1, 5, 5));
			pText[i].add(pRoom[i]);
			pText[i].add(pPrice[i]);
			pText[i].add(pReser[i]);
			
			border[i] = new SoftBevelBorder(SoftBevelBorder.RAISED);
			//border[i] = new MatteBorder(5, 10, 15, 20, backImg);
			pLine[i] = new JPanel(new GridLayout(1, 2, 5, 5));
			pLine[i].setBorder(border[i]);
			
			pLine[i].add(imgBtn[i]);
			pLine[i].add(pText[i]);
		}
		pTotal.add(pBtnTotal);
		
		for(int i = 0; i < NUMBER; i++)
		{
			pTotal.add(pLine[i]);		
		}
		JScrollPane scroll = new JScrollPane(pTotal);
		Container c = getContentPane();
		
		c.add(scroll);
		
		setBounds(100, 80, 400, 600);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new RoomChoise();
	}
}