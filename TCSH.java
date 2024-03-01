import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TCSH extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<?> comboBox; // Declare comboBox here

	public TCSH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 454);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("TRA cưu sỐ HỌc");
		lblNewLabel.setBounds(329, 85, 901, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nhập số cần tra cuu:");
		lblNewLabel_1.setForeground(new Color(0, 255, 128));
		lblNewLabel_1.setBounds(355, 230, 177, 32);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(574, 235, 96, 27);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(123, 356, 731, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		comboBox = new JComboBox(); // Initialize comboBox here
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Số nguyên tố", "Số hoàn hảo", "Số chính phương" }));
		comboBox.setBounds(265, 147, 177, 32);
		getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Check");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(331, 305, 96, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
				int num = Integer.parseInt(textField.getText());
				if (selectedItem == "Số nguyên tố") {
					if (sont(num)) {
						textField_1.setText(num + " là số nguyên tố.");
					} else {
						textField_1.setText(num + " không phải là số nguyên tố.");
					}
				} else if (selectedItem == "Số hoàn hảo") {
					if (sohh(num)) {
						textField_1.setText(num + " là số hoàn hảo.");
					} else {
						textField_1.setText(num + " không phải là số hoàn hảo.");
					}
				} else if (selectedItem == "Số chính phương"){
					if (socp(num)) {
						textField_1.setText(num + " là số chính phương.");
					} else {
						textField_1.setText(num + " không phải là số chính phương.");
					}
				}
			}
		});
		getRootPane().setDefaultButton(btnNewButton);
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Kết quả:");
		lblNewLabel_2.setBounds(14, 359, 99, 28);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Chọn Loại Số Tra Cứu:");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(26, 143, 238, 40);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Làm mới");
		btnNewButton_1.setForeground(new Color(0, 255, 0));
		btnNewButton_1.addActionListener((ActionEvent e) -> {
                    textField.setText("");
                    textField_1.setText("");
                });
		btnNewButton_1.setBounds(437, 305, 113, 27);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		getContentPane().add(btnNewButton_1);

		
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\unnamed.png"));
		lblNewLabel_4.setBounds(166, 0, 948, 417);
		getContentPane().add(lblNewLabel_4);

		// ... (remaining code)
	}

	private boolean sont(int n) {
		if(n<2) return false;
		for(int i=2;i<= Math.sqrt(n);i++) {
			if(n%i==0) return false;
		}
		return true;
	}

	private boolean sohh(int n) {
		int sum=0;
		for(int i=1; i<=n/2;i++) {
			if(n%i==0) sum += i;
		}
		return sum==n;
	}

	private boolean socp(int n) {
		int sqrt=(int) Math.sqrt(n);
		return sqrt*sqrt==n;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        TCSH frame = new TCSH();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
	}
}
