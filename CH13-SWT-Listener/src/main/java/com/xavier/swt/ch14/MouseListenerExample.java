package com.xavier.swt.ch14;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class MouseListenerExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public MouseListenerExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A MouseListener Example");

        s.addMouseListener(new MouseAdapter() {
            boolean shiftPressed = false;
            @Override
            public void mouseDown(MouseEvent mouseEvent) {
                if(mouseEvent.button == 3 && mouseEvent.stateMask == SWT.SHIFT) {
                    Label l = new Label(s, SWT.FLAT);
                    l.setText("Mouse Button Down at:  " + mouseEvent.x + " " + mouseEvent.y);
                    l.setBounds(mouseEvent.x, mouseEvent.y, 200, 15);
                    shiftPressed = true;
                }
            }

            @Override
            public void mouseUp(MouseEvent mouseEvent) {
                //button = 1 left key, 2 roller, 3 right key.
                if(mouseEvent.button == 3 && shiftPressed ) {
                    Label l = new Label(s, SWT.FLAT);
                    l.setText("Mouse Button Up at:  " + mouseEvent.x + " " + mouseEvent.y);
                    l.setBounds(mouseEvent.x, mouseEvent.y, 200, 15);
                }
                shiftPressed = false;
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
