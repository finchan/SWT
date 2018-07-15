package com.xavier.swt.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Created by Xavier on 2018-07-15.
 */
public class CompositeShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public CompositeShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Composite Example");
        s.setLayout(new FillLayout());
        final TextPaneComposite tpc = new TextPaneComposite(s, SWT.BORDER);
        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
