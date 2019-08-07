package kr.co.bit;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class RoomChoise extends JFrame
{
	public static final int NUMBER = 8;
	private RoundedButton[] imgBtn;
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
		imgBtn = new RoundedButton[NUMBER];
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
		
		backImg = new ImageIcon("C:\\java_ee\\workspace\\bitProject\\src\\img\\images.jpg");
		
		JPanel pTotal = new JPanel(new GridLayout(9, 1, 5, 5));
		
		/*pLine = new JPanel(new GridLayout(9, 1, 5, 5))
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				g.drawImage(backImg.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};*/
		
		for(int i = 0; i < NUMBER; i++)
		{
			image[i] = new ImageIcon("C:\\java_ee\\workspace\\bitProject\\src\\img\\" + (i + 1));
			
			imgBtn[i] = new RoundedButton(image[i]);
			imgBtn[i].setBackground(Color.DARK_GRAY);
			
			room_NumL[i] = new JLabel((i + 1) + "호실");
			room_NumL[i].setFont(font);
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