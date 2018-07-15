package com.xavier.swt.group;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Created by Xavier on 2018-07-15.
 */
public class GroupComposite extends Composite{
    final Button b1;
    final Button b2;
    final Button b3;
    public GroupComposite(Composite parent, int style, String groupName) {
        super(parent, SWT.NO_BACKGROUND);
        this.setLayout(new FillLayout());
        this.setSize(110, 85);

        final Group g = new Group(this, style);
        g.setText(groupName);
        g.setSize(110, 85);
        b1 = new Button(g, SWT.RADIO);
        b1.setText("Option One");
        b1.setBounds(10, 20, 85, 15);
        b2 = new Button(g, SWT.RADIO);
        b2.setText("Option Two");
        b2.setBounds(10, 35, 85, 15);
        b3 = new Button(g, SWT.RADIO);
        b3.setText("Option Three");
        b3.setBounds(10, 50, 80, 15);
        b1.setSelection(true);

        b1.addFocusListener(new RadioFocusAdapter());
        b2.addFocusListener(new RadioFocusAdapter());
        b3.addFocusListener(new RadioFocusAdapter());
    }

    public class RadioFocusAdapter extends FocusAdapter{
        @Override
        public void focusGained(FocusEvent focusEvent) {
            Button target = (Button) focusEvent.widget;
            String groupName = target.getParent().toString();
            System.out.println(groupName + "\t" + target.getText());
        }
    }
}
