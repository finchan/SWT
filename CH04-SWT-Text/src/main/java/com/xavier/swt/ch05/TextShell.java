package com.xavier.swt.ch05;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-07.
 */
public class TextShell {
    Display d = new Display ();
    Shell s = new Shell(d);
    TextShell(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Shell Text Example");

        final Text text1 = new Text(s, SWT.SINGLE | SWT.BORDER);
        text1.setBounds(30, 10, 100, 20);
        text1.setText("Enabled");
        text1.setEnabled(false);

        final Text text2 = new Text(s, SWT.SINGLE | SWT.BORDER);
        text2.setBounds(30, 35, 100, 20);
        text2.setText("Editable");
        text2.setEditable(false);

        final Text text3 = new Text(s, SWT.SINGLE | SWT.BORDER);
        text3.setBounds(30, 60, 100, 20);
        text3.setText("Hello World!");

        MouseListener mouseListener = new MouseListener() {
            public void mouseDoubleClick(MouseEvent mouseEvent) {

            }

            public void mouseDown(MouseEvent mouseEvent) {
                ((Text) mouseEvent.widget).selectAll();
            }

            public void mouseUp(MouseEvent mouseEvent) {

            }
        };

        FocusListener focusListener = new FocusListener() {
            public void focusGained(FocusEvent focusEvent) {
                Text t = (Text) focusEvent.widget;
                //Only support for Tab Key!!!
                t.selectAll();
            }

            public void focusLost(FocusEvent focusEvent) {
                Text t = (Text) focusEvent.widget;
                if(t == text3) {
                    if(t.getText().length() < 3) {
                        t.setBackground(new Color (d, 255, 0, 0));
                        t.setFocus();
                    } else {
                        t.setBackground(new Color(d, 255, 255, 255));
                    }
                }
            }
        };

        //2 Events - Tab - FocusEvent, MouseEvent
        text3.addFocusListener(focusListener);
        text3.addMouseListener(mouseListener);

        final Text text4 = new Text(s, SWT.SINGLE | SWT.BORDER);
        text4.setBounds(30, 85, 100, 20);
        text4.setTextLimit(5);
        //Text will be truncated as 5 chars
        text4.setText("Das ist ein Buch!");
        text4.setEchoChar('*');
        String text = text4.getText();
        System.out.println(text);

        Control[] c = {text4, text3, text2, text1};
        s.setTabList(c);
        final Text textarea = new Text(s, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
        textarea.setBounds(30, 110, 300, 100);

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
