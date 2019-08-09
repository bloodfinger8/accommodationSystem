package reservation;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.SoftBevelBorder;

public class RoomChoise extends JFrame implements ActionListener, Runnable
{
	private static final long serialVersionUID = 1L;
	public static final int NUMBER = 8;
	private JButton[] imgBtn;
	private JLabel[] room_NumL;
	private JLabel[] priceL;
	private JLabel[] reservationL;
	private ImageIcon[] image;
	private RoundedButton memberInfo;
	private RoundedButton chat;
	private JLabel main;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private String loginId;

	public RoomChoise(String loginId)
	{
		this.loginId = loginId;
		
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
		
		JPanel pTotal = new JPanel(new GridLayout(9, 1, 5, 5));
		
		priceL[0] = new JLabel("40000원");
		priceL[1] = new JLabel("40000원");
		priceL[2] = new JLabel("50000원");
		priceL[3] = new JLabel("50000원");
		priceL[4] = new JLabel("60000원");
		priceL[5] = new JLabel("60000원");
		priceL[6] = new JLabel("70000원");
		priceL[7] = new JLabel("70000원");
		
		for(int i = 0; i < NUMBER; i++)
		{
			image[i] = new ImageIcon("C:/java_ee/workspace/bitProject/img/" + (i + 1) + ".png");
			
			imgBtn[i] = new JButton(image[i]);
			imgBtn[i].setBorderPainted(false); // 외곽선 없애기
			imgBtn[i].setContentAreaFilled(false); // 내용영역 채우기 안함
			imgBtn[i].setFocusPainted(false); // 버튼 눌렀을때 생기는 테두리 사용안함
			imgBtn[i].setOpaque(false); // 투명하게
			
			room_NumL[i] = new JLabel((i + 1) + "호실");
			room_NumL[i].setFont(font);
			pRoom[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pRoom[i].add(room_NumL[i]);
			
			priceL[i].setFont(font);
			pPrice[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
			pPrice[i].add(priceL[i]);
			
			reservationL[i] = new JLabel("예약가능");
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
		
		event();
		service();
		
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				pw.println("exit");
				pw.flush();
			}
		});
	}

	public void event()
	{
		chat.addActionListener(this);
		
		for(int i = 0; i < NUMBER; i++)
		{
			imgBtn[i].addActionListener(this);
		}
	}
	public void service()
	{
		String serverIP = "192.168.0.61";
		
		try
		{
			socket = new Socket(serverIP, 9100);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} 
		catch (UnknownHostException e) 
		{
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		} 
		catch (IOException e) 
		{
			System.out.println("서버를 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
		
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == chat)
		{
			new ChatClient(loginId).service();
		}
		
		String room = null;
		for(int i = 0; i < NUMBER; i++)
		{
			if(e.getSource() == imgBtn[i])
			{
				room = room_NumL[i].getText();
				System.out.println(room);
				
				pw.println(room);
				pw.flush();
			}
		}
	}
	@Override
	public void run()
	{
		String room = null;
		
		while(true)
		{
			try 
			{
				room = br.readLine();
				System.out.println(room);
				if(room == null || room.toLowerCase().equals("exit"))
				{
					br.close();
					pw.close();
					socket.close();
					
					System.exit(0);
				}
				
				for(int i = 0; i < NUMBER; i++)
				{
					if(room_NumL[i].getText().equals(room))
					{
						imgBtn[i].setEnabled(false);
						room_NumL[i].setEnabled(false);
						priceL[i].setEnabled(false);
						reservationL[i].setText("예약완료");
						reservationL[i].setEnabled(false);
					}
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}