/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demologin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author vanle_000
 */
public class Demologin extends JFrame {
    JLabel lbl_Title;
    JLabel lbl_TaiKhoan;
    JLabel lbl_MatKhau;
    JTextField txt_TaiKhoan;
    JPasswordField txt_MatKhau;
    JButton btn_DangNhap;
    JButton btn_Huy;
    public Demologin(JFrame JF){
        // tạo panel title
        lbl_Title = new JLabel("ĐĂNG NHẬP VÀO HỆ THỐNG");
        lbl_Title.setFont(new Font("Times New Roman", 0, 24));
        lbl_Title.setForeground(new Color(0, 0, 255));
        lbl_Title.setHorizontalAlignment(JLabel.CENTER);
        JPanel pn_Title = new JPanel();
        pn_Title.add(lbl_Title);
        
        // taoh panel tai khoan
        lbl_TaiKhoan = new JLabel("Tài khoản");
        lbl_TaiKhoan.setFont(new Font("Times New Roman",0,16));
        lbl_TaiKhoan.setForeground(new Color(0,0,255));
        txt_TaiKhoan = new JTextField();
        txt_TaiKhoan.setPreferredSize(new Dimension(220, 24));
        JPanel pn_Username = new JPanel();
        pn_Username.add(lbl_TaiKhoan);
        pn_Username.add(txt_TaiKhoan);
        
        // tạo panel mat khau
        lbl_MatKhau = new JLabel("Mật khẩu");
        lbl_MatKhau.setFont(new Font("Times New Roman",0,16));
        lbl_MatKhau.setForeground(new Color(0,0,255));
        txt_MatKhau = new JPasswordField();
        txt_MatKhau.setPreferredSize(new Dimension(222, 24));
        JPanel pn_Password = new JPanel();
        pn_Password.add(lbl_MatKhau);
        pn_Password.add(txt_MatKhau);
        
        // tạo panel button
        btn_DangNhap = new JButton("ĐĂNG NHẬP");
        btn_DangNhap.setFont(new Font("Times New Roman", 0, 16)); 
        btn_DangNhap.setForeground(new Color(0, 0, 255));
        btn_Huy = new JButton("HỦY");
        btn_Huy.setFont(new Font("Times New Roman", 0, 16)); 
        btn_Huy.setForeground(new Color(255, 0, 0));
        JPanel pn_Button = new JPanel();
        pn_Button.add(btn_DangNhap);
        pn_Button.add(btn_Huy);
        
        // panel chính
        JPanel pn_main = new JPanel();
        pn_main.setLayout(new GridLayout(4,1));
        pn_main.setSize(450, 200);
        pn_main.add(pn_Title);
        pn_main.add(pn_Username);
        pn_main.add(pn_Password);
        pn_main.add(pn_Button);
        
        // frame chính
        JF.setLayout(new GridLayout(1,1));
        JF.add(pn_main);
        //JF.setMaximumSize(pn_main.getSize());
        JF.setMinimumSize(pn_main.getSize());
        JF.setResizable(false);
        setListener();
        
        
    }
    private void setListener() {
        btn_DangNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txt_TaiKhoan.getText().equals("") || new String(txt_MatKhau.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(Demologin.this, "Tài khoản và Mật khẩu không được để trống.", "Lỗi !!!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txt_TaiKhoan.getText().equals("superadmin") && new String(txt_MatKhau.getPassword()).equals("123456")) {
                    JOptionPane.showMessageDialog(Demologin.this, "Đăng nhập thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(Demologin.this, "Tài khoản hoặc Mật khẩu không đúng.", "Lỗi!!!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });
        
        btn_Huy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf =new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocation(523, 270);
        jf.setVisible(true);
        jf.setTitle("THÔNG TIN ĐĂNG NHẬP");
        new Demologin(jf);
    }
    
}
