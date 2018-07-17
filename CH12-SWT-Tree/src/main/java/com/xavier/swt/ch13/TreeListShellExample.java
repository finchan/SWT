package com.xavier.swt.ch13;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by Xavier on 2018-07-17.
 */
public class TreeListShellExample {
    Display d = new Display();
    Shell s = new Shell(d);
    public TreeListShellExample(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Tree Shell Example");
        s.setLayout(new FillLayout(SWT.HORIZONTAL));

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

        final List l = new List(s, SWT.BORDER|SWT.SINGLE);

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

        t.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                TreeItem ti = (TreeItem) selectionEvent.item;
                populateList(ti.getText());
            }

            private void populateList(String type) {
                if(type.equals("1")){
                    l.removeAll();
                    l.add("File 1");
                    l.add("File 2");
                } else if("2".equals(type)){
                    l.removeAll();
                } else if("3".equals(type)){
                    l.removeAll();
                    l.add("File 7");
                    l.add("File 8");
                } else if("2A".equals(type)){
                    l.removeAll();
                    l.add("File 3");
                    l.add("File 4");
                } else if("2B".equals(type)){
                    l.removeAll();
                    l.add("File 5");
                    l.add("File 6");
                }
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
