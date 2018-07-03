package com.xavier.swt.ch02;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018-07-04.
 */
public class ShellStylesExample {
    public ShellStylesExample() {
        Display d = new Display();
        Shell s = new Shell(d, SWT.CLOSE | SWT.MAX | SWT.RESIZE);
        s.setSize(500, 500);
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
