package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemberJoin extends JFrame implements ActionListener{
	private JLabel idL,pwL,pwCheckL,nameL,birthL,emailL,emailCL,telL,addressL,telLineL,isSamePwL;
	private JTextField idT,nameT,birthT,emailT,emailCT,telT,address1T;
	private JPasswordField pwT,pwCheckT;
	private JButton isSameB,emailCB;
	private RoundedButton memberOK, memberNO;
	
	public MemberJoin() {
		
		idL = new JLabel("아이디");
		pwL = new JLabel("비밀번호");
		pwCheckL = new JLabel("비밀번호확인");
		nameL = new JLabel("이름");
		emailL = new JLabel("E-Mail");
		emailCL = new JLabel("인증 번호");
		telL = new JLabel("핸드폰");
		addressL = new JLabel("주소");
		telLineL = new JLabel("-없이 입력해주세요");
		birthL = new JLabel("생년월일");
		isSamePwL = new JLabel("패스워드가 일치하지 않습니다.");
		isSamePwL.setVisible(false);
		
		idT = new JTextField(15);
		pwT = new JPasswordField(15);
		pwCheckT = new JPasswordField(15);
		nameT = new JTextField(15);
		birthT = new JTextField(15);
		emailT = new JTextField(15);
		telT = new JTextField(15);
		address1T = new JTextField(20);
		emailCT = new JTextField(5);
		
		memberOK = new RoundedButton("가입하기");
		memberOK.setBackground(Color.PINK);
		memberNO = new RoundedButton("가입취소");
		memberNO.setBackground(Color.PINK);
		isSameB = new JButton("중복확인");
		emailCB = new JButton("이메일 인증");
		
		setLayout(null);
		idL.setBounds(150,55,70,10);
		idT.setBounds(250,50,150,20);
		isSameB.setBounds(410,50,90,20);
		
		pwL.setBounds(150,95,70,10);
		pwT.setBounds(250,90,150,20);
		
		pwCheckL.setBounds(150,135,90,10);
		pwCheckT.setBounds(250,130,150,20);
		
		isSamePwL.setBounds(250,155,200,10);
		
		nameL.setBounds(150,175,70,10);
		nameT.setBounds(250,170,150,20);
		
		birthL.setBounds(150,215,70,10);
		birthT.setBounds(250,210,150,20);
		
		emailL.setBounds(150,255,70,10);
		emailT.setBounds(250,250,190,20);
		emailCB.setBounds(450,250,110,20);
		
		emailCL.setBounds(150,295,100,10);
		emailCT.setBounds(250,290,150,20);
		
		telL.setBounds(150,335,70,10);
		telT.setBounds(250,330,150,20);
		telLineL.setBounds(420,335,150,10);
		
		addressL.setBounds(150,375,60,10);
		address1T.setBounds(250,370,300,20);
		
		memberOK.setBounds(200,410,100,30);
		memberNO.setBounds(320,410,100,30);
		
		Container con = getContentPane();
		con.add(idL);
		con.add(idT);
		con.add(isSameB);
		con.add(pwL);
		con.add(pwT);
		con.add(pwCheckL);
		con.add(pwCheckT);
		con.add(isSamePwL);
		con.add(nameL);
		con.add(nameT);
		con.add(birthL);
		con.add(birthT);
		con.add(emailL);
		con.add(emailT);
		con.add(telL);
		con.add(telT);
		con.add(telLineL);
		con.add(addressL);
		con.add(address1T);
		con.add(memberOK);
		con.add(memberNO);
		con.add(emailCB);
		con.add(emailCL);
		con.add(emailCT);
		
		setBounds(100, 100, 600, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		memberOK.addActionListener(this);
		memberNO.addActionListener(this);
		isSameB.addActionListener(this);
		emailCB.addActionListener(this);
		pwCheckT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String pw = new String(pwT.getPassword());
				String pwCheck = new String(pwCheckT.getPassword());
				System.out.println(pw);
				System.out.println(pwCheck);
				if(!(pwCheck.equals(pw))) {
					isSamePwL.setVisible(true);
					if(pwCheck.length()==0) {
						isSamePwL.setVisible(false);
					}
				}else if(pwCheck.equals(pw)){
					isSamePwL.setVisible(false);					
				}
				
				
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(true) {
			if(e.getSource() == memberNO) {
				setVisible(false);
				break;
			}else if(e.getSource() == memberOK) {
				String id = idT.getText();
				String pw = new String(pwT.getPassword());
				String pwCheck = new String(pwCheckT.getPassword());
				String name = nameT.getText();
				String birth = birthT.getText();
				String email = emailT.getText();
				String tel = telT.getText();
				String address1 = address1T.getText();
				
				if(id.length()==0||pw.length()==0||pwCheck.length()==0||name.length()==0||
					birth.length()==0||email.length()==0||tel.length()==0||address1.length()==0) {
					JOptionPane.showMessageDialog(this, "빈 칸을 채워주세요");
					break;
				}
				MemberDTO dto = new MemberDTO();
				dto.setId(id);
				dto.setPw(pwCheck);
				dto.setPwCheck(pwCheck);
				dto.setName(name);
				dto.setBirth(birth);
				dto.setEmail(email);
				dto.setTel(tel);
				dto.setAddress1(address1);
				
				MemberDAO dao = new MemberDAO();
				if(pw.equals(pwCheck)) {
					int su = 0;
					String searchID = dao.searchID(dto); 
					if(!(id.equals(searchID))) {
						su = dao.member(dto);
						idT.setText("");
						pwT.setText("");
						pwCheckT.setText("");
						nameT.setText("");
						birthT.setText("");
						emailT.setText("");
						telT.setText("");
						address1T.setText("");
					}else if(id.equals(searchID)) {
						JOptionPane.showMessageDialog(this,"중복된 아이디입니다. 다시 입력해주세요");
						break;
					}
					if(su != 0 ) {
						JOptionPane.showMessageDialog(this,"회원가입이 완료 되었습니다.");
						setVisible(false);
						break;
					}
				}else {
					JOptionPane.showMessageDialog(this,"패스워드가 틀렸습니다. 다시 입력해주세요");
					break;
				}
			}
			
			if(e.getSource()==isSameB) {
				String id = idT.getText();
				MemberDTO dto = new MemberDTO();
				dto.setId(id);
				MemberDAO dao = new MemberDAO();
				String searchID = dao.searchID(dto); 
				
				if(id.equals(searchID)) {
					JOptionPane.showMessageDialog(this, "중복된 아이디 입니다.");
				}else if(!(id.equals(searchID))){
					if(id != null && id.length()!=0){
						JOptionPane.showMessageDialog(this, "사용가능한 아이디 입니다.");
					}else {
						JOptionPane.showMessageDialog(this, "아이디를 입력해주세요");
					}
				}
				break;
			}
		}
	}
	public static void main(String[] args) {
		new MemberJoin();
	}
}