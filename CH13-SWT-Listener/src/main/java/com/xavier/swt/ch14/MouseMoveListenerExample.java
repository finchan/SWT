package com.xavier.swt.ch14;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MouseMoveListenerExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public MouseMoveListenerExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Button Example");
        s.setLayout(new RowLayout(SWT.HORIZONTAL));
        final Text t = new Text(s, SWT.BORDER|SWT.SINGLE);
        t.setText("Left");
        final Text t2 = new Text(s, SWT.BORDER|SWT.SINGLE);
        t2.addMouseMoveListener(new MouseMoveListener() {
            public void mouseMove(MouseEvent mouseEvent) {
                t2.setText(t.getText());
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
