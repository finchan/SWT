package com.xaver.swt.ch11;

import com.xavier.swt.com.xavier.swt.complex.GridComposite;
import com.xavier.swt.group.GroupComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by Xavier on 2018/7/16.
 */
public class TabbedShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public TabbedShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Tab  Example");
        s.setLayout(new FillLayout());

        TabFolder tf = new TabFolder(s, SWT.BORDER);
        TabItem ti1 = new TabItem(tf, SWT.BORDER);
        ti1.setText("Option Group");
        ti1.setControl(new GroupComposite(tf, SWT.SHADOW_ETCHED_IN, "Option Group Composite"));
        TabItem ti2 = new TabItem(tf, SWT.BORDER);
        ti2.setText("Grid Composite");
        ti2.setControl(new GridComposite(tf, SWT.BORDER));
        TabItem ti3 = new TabItem(tf, SWT.BORDER);
        ti3.setText("Text");
        Composite c1 = new Composite(tf, SWT.BORDER);
        c1.setLayout(new FillLayout());
        Text t = new Text(c1, SWT.NONE|SWT.MULTI|SWT.WRAP|SWT.V_SCROLL);
        ti3.setControl(c1);
        TabItem ti4 = new TabItem(tf, SWT.BORDER);
        ti4.setText("Settings");
        Composite c2 = new Composite(tf, SWT.BORDER);
        RowLayout layout2 = new RowLayout();
        layout2.pack = false;
        layout2.wrap = false;
        c2.setLayout(layout2);
        Text t2 = new Text(c2, SWT.BORDER|SWT.SINGLE);
        t2.setSize(100, 30);
        Button btn = new Button(c2, SWT.BOLD);
        btn.setText("Save");
        btn.setSize(100, 30);
        ti4.setControl(c2);

        s.open();
        while(!s.isDisposed()){
            if(!d.readAndDispatch())
                d.sleep();
        }
        d.dispose();
    }
}
