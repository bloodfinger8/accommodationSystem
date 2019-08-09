package memberInfo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import login.Login;
import login.MemberDTO;
import reservation.ReservationDTO;

public class Information extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel topL, idL, passL, passL1, nameL, birthL, phoneL, emailL, addressL;
	private JLabel reservInfoL, reservInfoL2, check_in_dateL, check_out_dateL, yearL1, yearL2, monthL1, monthL2, dayL1,
			dayL2, room_NumL, room_Num_TagL, people_NumL, adultL, childrenL, personNum1L, personNum2L, payL, priceL;

	private JTextField idT, nameT, birthT, phoneT, emailT, addressT;
	private JPasswordField password1, password2;
	private JTextField check_in_dateT1, check_in_dateT2, check_in_dateT3, check_out_dateT1, check_out_dateT2,
			check_out_dateT3, room_NumT, people_NumT, adultT, childrenT, paywayT, priceT;

	private JButton accountCloseB, editB, confirmB, cancelB, toHomeB, reservChangeB;
	private JLabel wonL;

	private static String loginId = "irene";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Information(loginId).event();
	}// main

	/**
	 * Create the frame.
	 */
	public Information(String loginId) {
		this.loginId = loginId;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane pane = new JTabbedPane();

		ImageIcon tab1Icon = new ImageIcon("C:\\java_ee\\workspace\\InformationTabIcon\\tab1Icon.png");
		ImageIcon tab2Icon = new ImageIcon("C:\\java_ee\\workspace\\InformationTabIcon\\tab2Icon.png");
		ImageIcon tab3Icon = new ImageIcon("C:\\java_ee\\workspace\\InformationTabIcon\\tab3Icon.png");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 384, 561);
		contentPane.add(tabbedPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("예약정보", tab1Icon, tabbedPane_1, null);
		tabbedPane_1.setLayout(new BorderLayout());
		JPanel basePanel1 = new JPanel();
		basePanel1.setLayout(null);
//예약정보
		// 회원님의 예약 현황입니다.
		reservInfoL = new JLabel("회원님의 예약 현황입니다.");
		reservInfoL.setBounds(120, 12, 200, 25);
		reservChangeB = new JButton("예약 변경 및 취소");
		reservChangeB.setBounds(40, 450, 300, 25);
		check_in_dateL = new JLabel("체크 인 날짜 : ");
		check_in_dateL.setBounds(10, 50, 90, 25);

		check_in_dateT1 = new JTextField(5);
		check_in_dateT1.setBounds(110, 50, 40, 25);
		yearL1 = new JLabel("년");
		yearL1.setBounds(155, 50, 15, 25);

		check_in_dateT2 = new JTextField(5);
		check_in_dateT2.setBounds(175, 50, 25, 25);
		monthL1 = new JLabel("월");
		monthL1.setBounds(205, 50, 15, 25);

		check_in_dateT3 = new JTextField(5);
		check_in_dateT3.setBounds(225, 50, 25, 25);
		dayL1 = new JLabel("일");
		dayL1.setBounds(255, 50, 40, 25);

		check_out_dateL = new JLabel("체크 아웃 날짜 : ");
		check_out_dateL.setBounds(10, 100, 100, 25);

		check_out_dateT1 = new JTextField(10);
		check_out_dateT1.setBounds(110, 100, 40, 25);
		yearL2 = new JLabel("년");
		yearL2.setBounds(155, 100, 15, 25);

		check_out_dateT2 = new JTextField(10);
		check_out_dateT2.setBounds(175, 100, 25, 25);
		monthL2 = new JLabel("월");
		monthL2.setBounds(205, 100, 15, 25);

		check_out_dateT3 = new JTextField(10);
		check_out_dateT3.setBounds(225, 100, 25, 25);
		dayL2 = new JLabel("일");
		dayL2.setBounds(255, 100, 40, 25);

		room_NumL = new JLabel("객실 번호 : ");
		room_NumL.setBounds(10, 150, 85, 25);
		room_Num_TagL = new JLabel("호실");
		room_Num_TagL.setBounds(160, 150, 85, 25);
		room_NumT = new JTextField(3);
		room_NumT.setBounds(110, 150, 45, 25);

		people_NumL = new JLabel("예약 인원 : ");
		people_NumL.setBounds(10, 200, 85, 25);

		adultL = new JLabel("성    인 : ");
		adultL.setBounds(75, 225, 85, 25);
		childrenL = new JLabel("어린이 : ");
		childrenL.setBounds(75, 255, 85, 25);

		adultT = new JTextField(5);
		adultT.setBounds(140, 225, 45, 25);
		childrenT = new JTextField(5);
		childrenT.setBounds(140, 255, 45, 25);

		personNum1L = new JLabel(" 명");
		personNum1L.setBounds(190, 225, 85, 25);
		personNum2L = new JLabel(" 명");
		personNum2L.setBounds(190, 255, 85, 25);

		payL = new JLabel("결제 정보 : ");
		payL.setBounds(10, 310, 85, 25);
		paywayT = new JTextField(10);
		paywayT.setBounds(120, 310, 100, 25);

		priceL = new JLabel("가격 : ");
		priceL.setBounds(10, 360, 85, 25);
		priceT = new JTextField(10);
		priceT.setBounds(120, 360, 85, 25);
		wonL = new JLabel("원");
		wonL.setBounds(210, 360, 85, 25);
//		-------------------------------------

//
//		// component panel to base panel
		basePanel1.add(reservInfoL);
		basePanel1.add(check_in_dateL);
		basePanel1.add(check_in_dateT1);
		basePanel1.add(check_in_dateT2);
		basePanel1.add(check_in_dateT3);
		basePanel1.add(yearL1);
		basePanel1.add(monthL1);
		basePanel1.add(dayL1);

		basePanel1.add(check_out_dateL);
		basePanel1.add(check_out_dateT1);
		basePanel1.add(check_out_dateT2);
		basePanel1.add(check_out_dateT3);
		basePanel1.add(yearL2);
		basePanel1.add(monthL2);
		basePanel1.add(dayL2);

		basePanel1.add(room_NumL);
		basePanel1.add(room_NumT);
		basePanel1.add(room_Num_TagL);

		basePanel1.add(people_NumL);
		basePanel1.add(adultL);
		basePanel1.add(adultT);
		basePanel1.add(childrenL);
		basePanel1.add(childrenT);

		basePanel1.add(personNum1L);
		basePanel1.add(personNum2L);

		basePanel1.add(payL);
		basePanel1.add(paywayT);
		basePanel1.add(priceL);
		basePanel1.add(priceT);
		basePanel1.add(wonL);
		basePanel1.add(reservChangeB);

		// base panel 을 탭 패널에 붙이기
		tabbedPane_1.add(basePanel1);
//----------------------------------------------------------------------------------
//예약 변경 탭
//		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.addTab("예약변경", tab2Icon, tabbedPane_2, null);

//----------------------------------------------------------------------------------
//회원 정보 탭		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("회원정보", tab3Icon, tabbedPane_3, null);
		tabbedPane_3.setLayout(new BorderLayout());

//프로필 확인 및 수정 		
		topL = new JLabel("프 로 필   확 인   및   수 정");
		topL.setBounds(120, 12, 150, 25);
		idL = new JLabel("아     이     디 : ");
		idL.setBounds(10, 50, 85, 25);
		passL = new JLabel("비  밀  번  호 : ");
		passL.setBounds(10, 100, 85, 25);
		passL1 = new JLabel("비  번   확  인 : ");
		passL1.setBounds(10, 150, 85, 25);
		nameL = new JLabel("이             름 : ");
		nameL.setBounds(10, 200, 85, 25);
		birthL = new JLabel("생  년  월  일 : ");
		birthL.setBounds(10, 250, 85, 25);
		phoneL = new JLabel("전  화  번  호 : ");
		phoneL.setBounds(10, 300, 85, 25);

		emailL = new JLabel("이     메     일 : ");
		emailL.setBounds(10, 350, 85, 25);
		addressL = new JLabel("주             소 : ");
		addressL.setBounds(10, 400, 85, 25);
//결제방법 추가

		idT = new JTextField(15);
		idT.setBounds(100, 50, 150, 25);
		idT.setEditable(false);
		password1 = new JPasswordField(10);
		password1.setBounds(100, 100, 150, 25);
		password1.setEditable(false);
		password2 = new JPasswordField(10);
		password2.setBounds(100, 150, 150, 25);
		password2.setEditable(false);

		nameT = new JTextField(15);
		nameT.setBounds(100, 200, 150, 25);
		nameT.setEditable(false);
		birthT = new JTextField(15);
		birthT.setBounds(100, 250, 150, 25);
		birthT.setEditable(false);
		phoneT = new JTextField(15);
		phoneT.setBounds(100, 300, 150, 25);
		phoneT.setEditable(false);
		emailT = new JTextField(20);
		emailT.setBounds(100, 350, 200, 25);
		emailT.setEditable(false);
		addressT = new JTextField(15);
		addressT.setBounds(100, 400, 280, 25);
		addressT.setEditable(false);

		JPanel basePanel3 = new JPanel();
		basePanel3.setLayout(null);
		basePanel3.add(topL);

		basePanel3.add(idL);
		basePanel3.add(idT);
		basePanel3.add(passL);
		basePanel3.add(password1);
		basePanel3.add(passL1);
		basePanel3.add(password2);
		basePanel3.add(nameL);
		basePanel3.add(nameT);

		basePanel3.add(birthL);
		basePanel3.add(birthT);

		basePanel3.add(phoneL);
		basePanel3.add(phoneT);

		basePanel3.add(emailL);
		basePanel3.add(emailT);

		basePanel3.add(addressL);
		basePanel3.add(addressT);

		JPanel btmPanel = new JPanel(new GridLayout(2, 1));
		btmPanel.setBounds(15, 443, 350, 60);

		accountCloseB = new JButton("회원탈퇴");
		editB = new JButton("수정");
//		editB.setBounds(55, 450, 80, 30);
		confirmB = new JButton("확인");
//		confirmB.setBounds(150, 450, 80, 30);
		cancelB = new JButton("취소");
//		cancelB.setBounds(245, 450, 80, 30);
		toHomeB = new JButton("홈 화면");

		JPanel bp1 = new JPanel(new GridLayout(1, 4));
		bp1.add(accountCloseB);
		bp1.add(editB);
		bp1.add(confirmB);
		bp1.add(cancelB);
		JPanel bp2 = new JPanel(new GridLayout(1, 1));
		bp2.add(toHomeB);

		btmPanel.add(bp1);
		btmPanel.add(bp2);
//		basePanel3.add(editB);
//		basePanel3.add(confirmB);
//		basePanel3.add(cancelB);
		basePanel3.add(btmPanel);

		// base panel 을 탭 패널에 붙이기
		tabbedPane_3.add(basePanel3);

		// 실행하자마자 DB에서 로그인 한 사람의 레코드를 꺼내서 회원 정보 패널에 뿌리기
		InformationDAO dao = new InformationDAO();
		MemberDTO dto = dao.selectMemberData(loginId);
		getMemberData(dto);

		ReservationDTO rdto = dao.selectReservationData(loginId);
		getReservationData(rdto);

	}// Constructor

	public void event() {
		accountCloseB.addActionListener(this);
		editB.addActionListener(this);
		confirmB.addActionListener(this);
		cancelB.addActionListener(this);
		toHomeB.addActionListener(this);
		reservChangeB.addActionListener(this);

	}

	public void getReservationData(ReservationDTO dto) {// Information 1st tab
		// 로그인 한 사람의 예약데이터를 dto에서 textField로 뿌리기
		String startDay = dto.getStartday();
		String year1 = startDay.substring(0, 4);
		String month1 = startDay.substring(5, 7);
		String day1 = startDay.substring(8, 10);
		check_in_dateT1.setText(year1);
		check_in_dateT2.setText(month1);
		check_in_dateT3.setText(day1);
		System.out.println("startDay : " + startDay);
		System.out.println("year1 : " + year1);
		System.out.println("month1 : " + month1);
		System.out.println("day1 : " + day1);

		String endDay = dto.getEndday();
		String year2 = endDay.substring(0, 4);
		String month2 = endDay.substring(5, 7);
		String day2 = endDay.substring(8, 10);
		check_out_dateT1.setText(year2);
		check_out_dateT2.setText(month2);
		check_out_dateT3.setText(day2);
		System.out.println();
		System.out.println("endDay : " + endDay);
		System.out.println("year2 : " + year2);
		System.out.println("month2 : " + month2);
		System.out.println("day2 : " + day2);

		String roomNum = dto.getRoomNum();
		String temp_roomNum = roomNum.substring(1, 4);
		room_NumT.setText(temp_roomNum);
		adultT.setText(dto.getAdult());
		childrenT.setText(dto.getChild());
		paywayT.setText(dto.getPayway());
		int temp = dto.getTotalpay();
		String temp_String = Integer.toString(temp);
		priceT.setText(temp_String);

	}

	public void getMemberData(MemberDTO dto) {// Information 3rd tab
		// 로그인 한 사람의 데이터를 dto 에서 textField로 뿌리기
		idT.setText(dto.getId());
		password1.setText(dto.getPw());
		password2.setText(dto.getPwCheck());
		nameT.setText(dto.getName());
		birthT.setText(dto.getBirth());
		phoneT.setText(dto.getTel());
		emailT.setText(dto.getEmail());
		addressT.setText(dto.getAddress1());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == accountCloseB) {
			int reply = JOptionPane.showConfirmDialog(this, "정말로 탈퇴하시겠습니까?", "회원 탈퇴", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				new InformationDAO().deleteAccount(loginId);
				JOptionPane.showMessageDialog(this, "계정삭제되었습니다.");
				idT.setText("");
				password1.setText("");
				password2.setText("");
				nameT.setText("");
				birthT.setText("");
				phoneT.setText("");
				emailT.setText("");
				addressT.setText("");
				setVisible(false);
				// 로그인 화면으로
				new Login();

			}
		} else if (e.getSource() == editB) {// 수정 버튼
			password1.setEditable(true);
			password2.setEditable(true);
			nameT.setEditable(true);
			birthT.setEditable(true);
			phoneT.setEditable(true);
			emailT.setEditable(true);
			addressT.setEditable(true);

		} else if (e.getSource() == confirmB) {// 확인버튼
			String pw = new String(password1.getPassword());
			String pwCheck = new String(password2.getPassword());
			String name = nameT.getText();
			String birth = birthT.getText();
			String tel = phoneT.getText();
			String email = emailT.getText();
			String address = addressT.getText();

			if (name.length() == 0 || name == null) {
				JOptionPane.showMessageDialog(this, "이름을 입력해주세요");
				return;
			} else if (birth.length() == 0 || birth == null) {
				JOptionPane.showMessageDialog(this, "생년월일을 입력해주세요");
				return;
			} else if (!(validationDate(birth))) {
				JOptionPane.showMessageDialog(this, "유효한 날짜를 정확히 입력해주세요");
				return;
			} else if (tel.length() == 0 || tel == null) {
				JOptionPane.showMessageDialog(this, "전화번호를 입력해주세요");
				return;
			} else if (email.length() == 0 || email == null) {
				JOptionPane.showMessageDialog(this, "이메일 주소를 입력해주세요");
				return;
			} else if (address.length() == 0 || address == null) {
				JOptionPane.showMessageDialog(this, "주소를 입력해주세요");
				return;
			}

			MemberDTO dto = new MemberDTO();
			dto.setPw(pw);
			dto.setPwCheck(pwCheck);
			dto.setName(name);
			dto.setBirth(birth);
			dto.setTel(tel);
			dto.setEmail(email);
			dto.setAddress1(address);

			// DB에 update
			InformationDAO dao = InformationDAO.getInstance();
			int su = dao.updateMember(dto);

			// 회원정보 수정이 완료되었습니다.
			JOptionPane.showMessageDialog(this, "회원정보 수정이 완료되었습니다.");

			// TextField 비활성화
			password1.setEditable(false);
			password2.setEditable(false);
			nameT.setEditable(false);
			birthT.setEditable(false);
			phoneT.setEditable(false);
			emailT.setEditable(false);
			addressT.setEditable(false);

		} else if (e.getSource() == cancelB) {
			password1.setEditable(false);
			password2.setEditable(false);
			nameT.setEditable(false);
			birthT.setEditable(false);
			phoneT.setEditable(false);
			emailT.setEditable(false);
			addressT.setEditable(false);

		} else if (e.getSource() == toHomeB) {
			this.setVisible(false);
//			new xxxxx();
		} else if (e.getSource() == reservChangeB) {
			this.setVisible(false);
//			new xxxxx();
		}

	}// actionPerformed()

	public boolean validationDate(String checkDate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
			dateFormat.setLenient(false);
			dateFormat.parse(checkDate);
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

	}// validationDate()

}// class
