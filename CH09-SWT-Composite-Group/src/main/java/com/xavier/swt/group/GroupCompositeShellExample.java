package com.xavier.swt.group;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by Xavier on 2018-07-15.
 */
public class GroupCompositeShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public GroupCompositeShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Group & Composite Example");

        final GroupComposite gc = new GroupComposite(s, SWT.SHADOW_ETCHED_IN, "Option Group One");
        gc.setLocation(10, 10);
        final GroupComposite gc2 = new GroupComposite(s, SWT.SHADOW_ETCHED_OUT, "Option Group Two");
        gc2.setLocation(100, 100);
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
