package com.xavier.swt.ch14;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javax.sql.RowSetListener;

public class MouseTrackListenerExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public MouseTrackListenerExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Button Example");
        s.setLayout(new FillLayout());
        final Button b = new Button(s, SWT.PUSH);
        b.setBounds(50, 50, 100, 100);
        final Color oldColor = b.getBackground();
        b.addMouseTrackListener(new MouseTrackAdapter() {
            @Override
            public void mouseEnter(MouseEvent mouseEvent) {
                b.setBackground(new Color(d, 0, 153, 153));
            }

            @Override
            public void mouseExit(MouseEvent mouseEvent) {
                b.setBackground(oldColor);
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
