package ru.les8.calc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CalcForm extends JFrame {
    public CalcForm(){
        setTitle("Calculator");
        setBounds(100,100,300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CalcFormElements();

        setVisible(true);

    }

    private void CalcFormElements(){
        //c-удаление одного символа
        //dc-очистка поля
        String [] keys = {"+","0",".","-","*","/","C","DC","="};

        //эти панели та ещё заморочка
        //пока разобрался посидел
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Courier", Font.BOLD, 20));
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    textField.setText(keyboardEvents(e.getKeyChar(),e.getKeyCode(), textField.getText()));
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
            }
        });

        inputPanel.add(textField, BorderLayout.CENTER);

        JPanel keyPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(6,3));

        for (int i = 1; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        textField.setText(keyboardEvents(e.getActionCommand().charAt(0),0, textField.getText()));
                    } catch (ScriptException scriptException) {
                        scriptException.printStackTrace();
                    }

                }
            });
            keyPanel.add(button);
        }

        for (int i = 0; i < keys.length; i++) {
            JButton button =new JButton(keys[i]);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                    textField.setText(keyboardEvents(e.getActionCommand().charAt(0),0, textField.getText()));
                    } catch (ScriptException scriptException) {
                        scriptException.printStackTrace();
                    }

                }
            });
            keyPanel.add(button);
        }

        add(inputPanel, BorderLayout.NORTH);
        add(keyPanel, BorderLayout.CENTER);
    }

    private String keyboardEvents(char eChar, int eCode, String textField) throws ScriptException {
        StringBuilder text = new StringBuilder(textField);

        if (eChar == '0') text.append('0');
        if (eChar == '1') text.append('1');
        if (eChar == '2') text.append('2');
        if (eChar == '3') text.append('3');
        if (eChar == '4') text.append('4');
        if (eChar == '5') text.append('5');
        if (eChar == '6') text.append('6');
        if (eChar == '7') text.append('7');
        if (eChar == '8') text.append('8');
        if (eChar == '9') text.append('9');

        //защита от запроса символа не в массиве
        if (textField.length() > 0) {
            if (eChar == '+' & text.charAt(text.length() - 1) != '+') text.append('+');
            if (eChar == '-' & text.charAt(text.length() - 1) != '-') text.append('-');
            if (eChar == '*' & text.charAt(text.length() - 1) != '*') text.append('*');
            if (eChar == '/' & text.charAt(text.length() - 1) != '/') text.append('/');
            if (eChar == '.' & text.charAt(text.length() - 1) != '.') text.append('.');
            if (eCode == KeyEvent.VK_BACK_SPACE || eChar == 'C') text.deleteCharAt(text.length()-1);
        }
        //финт ушами c eChar == 'D'
        if (eCode == KeyEvent.VK_DELETE || eChar == 'D') text.setLength(0);

        if (eCode == KeyEvent.VK_EQUALS || eCode == 10 || eChar == '=') return ResultCalc(text.toString());

        return text.toString();

    }

    //помогли только форумы. в доках Оракла не разобрался от слова савсем
    //и кстати он материться на то что скоро этого не будет
    private String ResultCalc(String text) throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JS");
        Object result = engine.eval(text);
        return String.valueOf(result);
    }
}
