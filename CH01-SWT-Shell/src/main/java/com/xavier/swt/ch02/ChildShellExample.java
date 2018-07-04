package com.xavier.swt.ch02;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018/7/4.
 */
public class ChildShellExample {
    Display d = new Display();
    ChildShellExample() {
        Shell s = new Shell(d);
        s.setMaximized(true);
        s.open();
        ChildShell cs1 = new ChildShell(s, SWT.MAX);
        ChildShell cs2 = new ChildShell(s, SWT.MIN|SWT.CLOSE|SWT.APPLICATION_MODAL);
        System.out.println("Print after confirm the Application Dialog");
        ChildShell cs3 = new ChildShell(s, SWT.CLOSE|SWT.SYSTEM_MODAL);
        System.out.println("Prevent all tasks in all tasks (including other applications");
        while(!s.isDisposed()) {
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
