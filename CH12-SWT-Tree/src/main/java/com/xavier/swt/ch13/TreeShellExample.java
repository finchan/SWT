package com.xavier.swt.ch13;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Created by Xavier on 2018-07-17.
 */
public class TreeShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public TreeShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Tree Shell Example");
        s.setLayout(new FillLayout());

        Tree t = new Tree(s, SWT.SINGLE|SWT.BORDER);
        TreeItem child1 = new TreeItem(t, SWT.NONE, 0);
        child1.setText("1");
        TreeItem child2 = new TreeItem(t, SWT.NONE, 1);
        child2.setText("2");
        TreeItem child2a = new TreeItem(child2, SWT.NONE, 0);
        child2a.setText("2A");
        TreeItem child2b = new TreeItem(child2, SWT.NONE, 1);
        child2b.setText("2B");
        TreeItem child3 = new TreeItem(t, SWT.NONE, 2);
        child3.setText("3");

        child1.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/folder.png"))));
        child2.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/folder.png"))));
        child3.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/folder.png"))));
        child2a.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/file.png"))));
        child2b.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/file.png"))));

        t.addTreeListener(new TreeListener() {
            public void treeCollapsed(TreeEvent treeEvent) {
                TreeItem ti = (TreeItem) treeEvent.item;
                ti.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/folder.png"))));
            }

            public void treeExpanded(TreeEvent treeEvent) {
                TreeItem ti = (TreeItem) treeEvent.item;
                ti.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/folderopen.png"))));
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
