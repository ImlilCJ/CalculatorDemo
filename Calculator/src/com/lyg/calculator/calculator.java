package com.lyg.calculator;

import com.lyg.utils.CalUtils;
import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author 林奕耿
 * @version 1.0
 */
public class calculator extends JFrame implements ActionListener {
    //北面的控件
    //初始化一个画板
    private JPanel northPanel = new JPanel();
    private JTextField northTextField = new JTextField();
    private JButton northButton = new JButton("C");

    //中间控件
    private JPanel centerPanel = new JPanel();

    public calculator() throws HeadlessException {
        this.init();
        this.setNorthPanel();
        this.setCenterPanel();
    }

    //初始化窗口
    public void init() {
        //设置标题
        this.setTitle(CalUtils.TITLE);
        //设置窗口尺寸
        this.setSize(CalUtils.FRAME_W, CalUtils.FRAME_H);
        //设置窗口位置
        this.setLocation(CalUtils.frame_x, CalUtils.frame_y);
        //设置layout
        this.setLayout(new BorderLayout());
        //设置退出窗口
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置不可拉扯窗口大小
        this.setResizable(false);
    }

    public void setNorthPanel() {
        //设置输入框大小
        this.northTextField.setPreferredSize(new Dimension(430, 30));
        //将输入框 和 按键 添加到Panel花瓣中
        northPanel.add(northTextField);
        northPanel.add(northButton);
        northButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 northTextField.setText("");
            }
        });
        this.add(northPanel, BorderLayout.NORTH);

    }

    public void setCenterPanel() {
        //设置一个4x4的布局
        this.centerPanel.setLayout(new GridLayout(4, 4));
        //设置按钮文字
        String btn_text = "123+456-789*0.=/";
        //正则表达式
        String regex = "[\\+\\-*/.=]";
        for (int i = 0; i < 16; i++) {
            String temp = btn_text.substring(i, i + 1);
            JButton btn = new JButton();
            btn.setText(temp);
            if (temp.matches(regex)) {
                btn.setFont(new Font("粗体", Font.BOLD, 37));
                btn.setForeground(Color.RED);
            }
            btn.addActionListener(this);
            centerPanel.add(btn);
        }
        this.add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        calculator calculator = new calculator();
        calculator.setVisible(true);
    }

    private String firstInput = null;
    private String operator = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnText = e.getActionCommand();
        if (".0123456789".indexOf(btnText) != -1) {
            this.northTextField.setText(northTextField.getText() + btnText);
            this.northTextField.setHorizontalAlignment(JTextField.RIGHT);
        } else if (btnText.matches("[\\+\\-*/]{1}")) {
            operator = btnText;
            firstInput = this.northTextField.getText();
            this.northTextField.setText("");
        } else if (btnText.equals("=")) {
            Double a = Double.valueOf(firstInput);
            Double b = Double.valueOf(this.northTextField.getText());
            Double res = null;
            switch (operator) {
                case "+":
                    res = a + b;
                    break;
                case "-":
                    res = a - b;
                    break;
                case "*":
                    res = a * b;
                    break;
                case "/":
                    if(b != 0){
                        res = a / b;
                    }
                    break;
            }
            this.northTextField.setText(res.toString());
        }
    }
}
