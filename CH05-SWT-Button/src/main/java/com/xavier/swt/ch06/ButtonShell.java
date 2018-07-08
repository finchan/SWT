package com.xavier.swt.ch06;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-08.
 */
public class ButtonShell {
    Display d = new Display();
    Shell s = new Shell(d);
    public ButtonShell(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Button Example");

        final Button b1 = new Button(s, SWT.PUSH | SWT.CENTER);
        b1.setBounds(10, 10, 70, 30);
        b1.setText("Push Me");

        final Button b2 = new Button(s, SWT.CHECK);
        b2.setText("Check Me");
        b2.setBounds(10, 45, 70, 30);
        b2.setSelection(true);
        final Button b3 = new Button(s, SWT.CHECK );
        b3.setText("No, Check Me");
        b3.setBounds(85, 45, 95, 30);

        final Button b4 = new Button(s, SWT.RADIO);
        b4.setText("Pick Me");
        b4.setBounds(10, 80, 70, 30);
        final Button b5 = new Button(s, SWT.RADIO);
        b5.setText("No, Pick Me");
        b5.setBounds(10, 105, 95, 30);
        final Button fake = new Button(s, SWT.RADIO);
        fake.setSelection(true);

        final Button toggle = new Button(s, SWT.TOGGLE);
        toggle.setText("Toggle Me");
        toggle.setBounds(10,135, 70,30);

        final Button b6 = new Button(s, SWT.ARROW | SWT.UP);
        b6.setBounds(10, 180, 20, 15);
        final Button b7 = new Button(s, SWT.ARROW | SWT.DOWN);
        b7.setBounds(10, 195, 20, 15);
        final Text arrow = new Text(s, SWT.CENTER|SWT.BOLD);
        arrow.setText("1");
        arrow.setBounds(30, 185, 40, 20);
        arrow.setEditable(false);

        final Button imageButton = new Button(s, SWT.PUSH);
        imageButton.setImage(new Image(d, this.getClass().getResourceAsStream("/images/bean.ico")));
        imageButton.setBounds(10, 210, 36, 36);

        b1.addSelectionListener(new SelectionAdapter() {
                                    @Override
                                    public void widgetSelected(SelectionEvent selectionEvent) {
                                        System.out.println("Push Me is clicked!");
                                    }
                                }
        );

        b2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println(b2.getSelection());
            }
        });

        b3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println(b3.getSelection());
            }
        });

        b6.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                int n = Integer.parseInt(arrow.getText());
                n++;
                arrow.setText(new Integer(n).toString());
            }
        });

        b7.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                int n = Integer.parseInt(arrow.getText());
                n--;
                arrow.setText(new Integer(n).toString());
            }
        });

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
