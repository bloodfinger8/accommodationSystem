package roomReservation;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class RoomReservation extends JFrame implements ActionListener{
	private JLabel startL, endL, hotelL, reserInfoL, nameL, phoneL,people_NumL,carfulL ,visitL ,payInfoL, reserpayL,
	salepayL,totalpayL,vatL,paywayL;
	private JTextField nameT, phoneT,reserpayT,salepayT,totalpayT;
	private JRadioButton runR, carR;
	private JComboBox<String> paywayCB;
	private JButton payB, cancelB;
	private JSpinner adultS, childS,timeSpinner,timeSpinner2;
	private SpinnerDateModel dateModel;
	
	
	public RoomReservation() {
		startL = new JLabel("예약날자");
		endL = new JLabel("퇴실날자");
		hotelL = new JLabel("비트 호텔");
		reserInfoL = new JLabel("예약자 정보");
		nameL = new JLabel("예약자 이름");
		phoneL = new JLabel("휴대폰 번호");
		people_NumL = new JLabel("숙박 인원");
		carfulL = new JLabel("*만8세 이하 어린이 ");
		visitL = new JLabel("방문 방법");
		payInfoL = new JLabel("결제 정보");
		reserpayL = new JLabel("예약금액");
		totalpayL = new JLabel("총 결제금액");
		vatL = new JLabel("(vat)포함");
		salepayL = new JLabel("할인금액");
		paywayL = new JLabel("결제수단");

		nameT = new JTextField();
		phoneT = new JTextField();
		reserpayT= new JTextField();
		salepayT= new JTextField();
		totalpayT= new JTextField();

		adultS = new JSpinner();
		childS = new JSpinner();
		runR = new JRadioButton("도보");
		carR = new JRadioButton("차량");
		ButtonGroup  group = new ButtonGroup();

		payB = new JButton("결제");
		cancelB = new JButton("취소");
		paywayCB = new JComboBox<String>();
		
		timeSpinner = new JSpinner( new SpinnerDateModel() );
		timeSpinner2 = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy년 MM월 dd일");
		JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(timeSpinner, "yyyy년 MM월 dd일");
		timeSpinner.setEditor(timeEditor);
		timeSpinner2.setEditor(timeEditor2);
		
		setTitle("숙박 예약");

	    JPanel panel = new JPanel();
	    panel.setPreferredSize(new Dimension(400,1000));
	    panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 385, 560);
        JPanel p1 = new JPanel(null);
        p1.setPreferredSize(new Dimension(500, 400));
        p1.add(scrollPane);
        
        
        startL.setBounds(26, 60, 73, 15);
		panel.add(startL);
        timeSpinner.setBounds(26,80,140,25);
        panel.add(timeSpinner);
        endL.setBounds(26, 110, 73, 15);
		panel.add(endL);
        timeSpinner2.setBounds(26,130,140,25);
        panel.add(timeSpinner2);
        
        hotelL.setFont(new Font("굴림", Font.BOLD, 23));
		hotelL.setBounds(145, 20, 112, 40);
		panel.add(hotelL);

		reserInfoL.setFont(new Font("굴림", Font.BOLD, 15));
		reserInfoL.setBounds(26, 170, 94, 21);
		panel.add(reserInfoL);
		
		
		
		nameL.setBounds(26, 206, 73, 15);
		panel.add(nameL);

		nameT.setBounds(26, 233, 116, 21);
		panel.add(nameT);
		nameT.setColumns(10);

		phoneL.setBounds(26, 264, 73, 15);
		panel.add(phoneL);

		phoneT.setBounds(26, 289, 116, 21);
		panel.add(phoneT);
		phoneT.setColumns(10);

		people_NumL.setBounds(26, 320, 116, 21);
		panel.add(people_NumL);

		JLabel lblNewLabel = new JLabel("성인");
		lblNewLabel.setBounds(26, 350, 42, 15);
		panel.add(lblNewLabel);
		
		adultS.setBounds(58, 347, 34, 22);
		panel.add(adultS);

		JLabel lblNewLabel_8 = new JLabel("어린이");
		lblNewLabel_8.setBounds(100, 350, 42, 15);
		panel.add(lblNewLabel_8);

		childS.setBounds(144, 347, 34, 22);
		panel.add(childS);

		carfulL.setFont(new Font("굴림", Font.ITALIC, 10));
		carfulL.setBounds(185, 350, 126, 15);
		panel.add(carfulL);

		visitL.setBounds(26, 389, 57, 15);
		panel.add(visitL);

		runR.setBounds(36, 410, 63, 23);
		panel.add(runR);
		
		carR.setBounds(110, 410, 63, 23);
		panel.add(carR);
		group.add(runR);
		group.add(carR);

		payInfoL.setFont(new Font("굴림", Font.BOLD, 15));
		payInfoL.setBounds(26, 450, 94, 21);
		panel.add(payInfoL);

		reserpayL.setBounds(26, 481, 57, 15);
		panel.add(reserpayL);

		reserpayT.setBounds(210, 475, 116, 21);
		panel.add(reserpayT);
		reserpayT.setColumns(10);

		salepayL.setBounds(26, 506, 57, 15);
		panel.add(salepayL);

		salepayT.setBounds(210, 503, 116, 21);
		panel.add(salepayT);
		salepayT.setColumns(10);

		totalpayL.setBounds(26, 534, 73, 15);
		panel.add(totalpayL);

		vatL.setFont(new Font("굴림", Font.ITALIC, 11));
		vatL.setBounds(100, 535, 57, 15);
		panel.add(vatL);

		totalpayT.setBounds(210, 531, 116, 21);
		panel.add(totalpayT);
		totalpayT.setColumns(10);

		paywayL.setFont(new Font("굴림", Font.BOLD, 15));
		paywayL.setBounds(26, 594, 73, 21);
		panel.add(paywayL);

		paywayCB.setModel(new DefaultComboBoxModel(new String[] {"현금결제", "간편 계좌 이체", "신용/체크카드", "토스", "네이버페이"}));
		paywayCB.setBounds(26, 625, 285, 21);
		panel.add(paywayCB);

		payB.setFont(new Font("굴림", Font.PLAIN, 14));
		payB.setBounds(26, 792, 155, 23);
		panel.add(payB);
		cancelB.setFont(new Font("굴림", Font.PLAIN, 14));
		cancelB.setBounds(170, 792, 155, 23);
		panel.add(cancelB);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 444, 384, 140);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 587, 372, 103);
		panel.add(separator_1);

        setContentPane(p1);

		setBounds(100,100,400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void event() {
		payB.addActionListener(this);
		cancelB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == payB) {
			Object a =timeSpinner.getValue();
			Object b =timeSpinner.getValue();
			String name = nameT.getText();
			String phone = phoneT.getText();
			Object adult = adultS.getValue();
			Object child = childS.getValue();
//			int visit = 
			JOptionPane.showMessageDialog(this, "예약이 완료 되었습니다.");
			
		}else if(e.getSource()==cancelB) {
			int result = JOptionPane.showConfirmDialog(RoomReservation.this,
					"예약을 취소하시겠습니까?"
					,"취소",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
	
	public void calc(int year,int month){ //입력받은 년도,달의 시작날,끝날을 계산
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1 , 1); //년,월,일 세팅
		//int startW = cal.get(Calendar.DAY_OF_WEEK); //입력한 달의 1일이 무슨요일로 시작하는지 출력 
		int lastD = cal.getActualMaximum(Calendar.DATE); //입력한 달의 마지막날 출력 
	}
	
	
	
	
	public static void main(String[] args) {
		new RoomReservation().event();
	}

 

}
