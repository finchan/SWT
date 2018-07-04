package com.xavier.swt.ch02;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018/7/4.
 */
public class ShellDialogExample {
    public ShellDialogExample() {
        Display d = new Display();
        Shell s = new Shell(d);
        s.setSize(300, 300);
        s.setImage(new Image(d, this.getClass().getResourceAsStream("/images/bean.ico")));
        s.setText("Shell Dialog Example");
        s.open();

        DialogExample de = new DialogExample(s);
        String result = de.open();
        System.out.println(result);
        while(!s.isDisposed()) {
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }

}
