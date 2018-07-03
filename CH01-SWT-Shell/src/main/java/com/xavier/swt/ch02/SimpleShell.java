package com.xavier.swt.ch02;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018-07-03.
 */
public class SimpleShell {
    SimpleShell() {
        Display d = new Display();
        Shell s = new Shell(d);
        s.setSize(500, 500);
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
