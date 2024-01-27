import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame {

    String operand;            //피연산자
    String operator;        //연산자
    static JTextField inputText;

    public Main() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료

        Container c = getContentPane();
        c.setLayout(new BorderLayout(5, 5));
        North NP = new North();
        c.add(NP, BorderLayout.NORTH);  // 구열을 나누었을때 윗쪽에 위치

        Center CP = new Center();
        c.add(CP, BorderLayout.CENTER); // 구열을 나누었을때 센터에 위치


        c.add(CP, BorderLayout.SOUTH);  // 구열을 나누었을때 아랫쪽에 위치

        setSize(250, 300);                // 시작 사이즈
        setVisible(true);
    }

    class North extends JPanel {            // 텍스트 표시
        public North() {
            inputText = new JTextField(20);
            inputText.setHorizontalAlignment(JTextField.RIGHT);
            add(inputText);
        }
    }

    class Center extends JPanel {        // 센터에 버튼을 만듦
        public Center() {
            JButton[] bt = new JButton[16];
            setLayout(new GridLayout(4, 4));    // 칸
            bt[0] = new JButton("0");
            bt[1] = new JButton("1");
            bt[2] = new JButton("2");
            bt[3] = new JButton("3");

            bt[4] = new JButton("4");
            bt[5] = new JButton("5");
            bt[6] = new JButton("6");
            bt[7] = new JButton("7");

            bt[8] = new JButton("8");
            bt[9] = new JButton("9");
            bt[10] = new JButton(" ");
            bt[11] = new JButton(" ");

            bt[12] = new JButton("+");
            bt[13] = new JButton("-");
            bt[14] = new JButton("*");
            bt[15] = new JButton("/");

            for (int i = 0; i < 16; i++)        // 버튼에 입력된 칸 포문
            {
                bt[i].setBackground(new Color(80, 188, 223));

                add(bt[i]);

                bt[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {    // 키입력시 기존 텍스트에 입력값 새로 넣기
                        JButton b = (JButton) e.getSource();
                        String oldtext = inputText.getText();
                        String text = b.getText();
                        String newtext = oldtext + text;

                        int n = newtext.length();            // 길이가 25 이하일때 입력
                        if (n <= 25) {
                            inputText.setText(newtext);
                        }
                    }
                });
            }

            JButton[] sbt = new JButton[2];
            setLayout(new GridLayout(1, 2));
            sbt[0] = new JButton("clear");
            sbt[1] = new JButton("계산");

            for (int i = 0; i < 2; i++) // 버튼 값 포문
            {

                sbt[i].setBackground(new Color(80, 188, 223));
                add(sbt[i]);
            }

            for (JButton button : bt) {
                sbt[0].addActionListener(new ActionListener() { // clear 버튼 입력시 텍스트 초기화
                    public void actionPerformed(ActionEvent e) {
                        inputText.setText("");
                    }
                });
                sbt[1].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        long op1 = Long.valueOf(operand);
                        long op2 = Long.valueOf(inputText.getText());

                        if (operator.equals("+")) {                                //해당 operator로 연산
                            inputText.setText(String.valueOf(op1 + op2));        //op1 + op2
                        } else if (operator.equals("-")) {
                            inputText.setText(String.valueOf(op1 - op2));
                        } else if (operator.equals("*")) {
                            inputText.setText(String.valueOf(op1 * op2));
                        } else if (operator.equals("/")) {
                            inputText.setText(String.valueOf(op1 / op2));
                        }
                    }

                    //연산자 버튼을 눌렀을 경우
                    {
                        // 현재 입력된 피연산자 저장
                        operand = inputText.getText();
                        //지금 입력한 연산자를 operator에 저장
                        //operator =bt;
                        //새로운 피연산자를 입력받기 위해 textField 초기화
                        inputText.setText("");
                    }
                });


            }


        }

        public static void main(String[] args) { // 메인함수
            new Main();
        }
    }
}