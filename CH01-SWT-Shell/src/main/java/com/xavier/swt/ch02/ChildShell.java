package com.xavier.swt.ch02;

import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018/7/4.
 */
public class ChildShell {
    public ChildShell(Shell parent, int style) {
        Shell child = new Shell(parent, style);
        child.setSize(200, 200);
        child.open();
    }
}
