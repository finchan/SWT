package com.xavier.swt.ch15;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

public class CoolbarShellExample2 {
    Display d = new Display();
    Shell s = new Shell(d);
    public CoolbarShellExample2(){
        s.setSize(500,500);
        s.setImage(new Image(d, this.getClass().getResourceAsStream(("/images/bean.ico"))));
        s.setText("A Coolbar Shell Example");

        final CoolBar coolBar = new CoolBar(s, SWT.BORDER);
        coolBar.setSize(475, 30);
        coolBar.setLocation(0,0);
        coolBar.setLocked(true);


        final Image saveIcon = new Image(d, this.getClass().getResourceAsStream(("/images/save.png")));
        final Image openIcon = new Image(d, this.getClass().getResourceAsStream(("/images/open.png")));
        final Image cutIcon = new Image(d, this.getClass().getResourceAsStream(("/images/cut.png")));
        final Image copyIcon = new Image(d, this.getClass().getResourceAsStream(("/images/copy.png")));
        final Image pasteIcon = new Image(d, this.getClass().getResourceAsStream(("/images/paste.png")));

        // create and add the button for performing an open operation
        final CoolItem openCoolItem = new CoolItem(coolBar, SWT.NONE);

        final ToolBar fileToolBar = new ToolBar(coolBar,SWT.HORIZONTAL);
        final ToolItem openToolItem = new ToolItem(fileToolBar, SWT.PUSH);
        openToolItem.setImage(openIcon);
        openToolItem.setText("Open");
        openToolItem.setToolTipText("Open");

        final ToolItem saveToolItem = new ToolItem(fileToolBar, SWT.PUSH);
        saveToolItem.setImage(openIcon);
        saveToolItem.setText("Save");
        saveToolItem.setToolTipText("Save");

        fileToolBar.pack();
        Point size = fileToolBar.getSize();
        openCoolItem.setControl(fileToolBar);
        openCoolItem.setSize(openCoolItem.computeSize(size.x, size.y));

        final CoolItem editbarCoolItem = new CoolItem(coolBar, SWT.PUSH);
        final ToolBar editToolBar = new ToolBar(coolBar,SWT.HORIZONTAL);

//        create and add the button for performing a cut operation
        final ToolItem cutToolItem = new ToolItem(editToolBar, SWT.PUSH);
        cutToolItem.setImage(cutIcon);
        cutToolItem.setText("Cut");
        cutToolItem.setToolTipText("Cut");

        // create and add the button for performing a copy operation
        final ToolItem copyToolItem = new ToolItem(editToolBar, SWT.PUSH);
        copyToolItem.setImage(copyIcon);
        copyToolItem.setText("Copy");
        copyToolItem.setToolTipText("Copy");

        // create and add the button for performing a paste operation
        final ToolItem pasteToolItem = new ToolItem(editToolBar, SWT.PUSH);
        pasteToolItem.setImage(pasteIcon);
        pasteToolItem.setText("Paste");
        pasteToolItem.setToolTipText("Paste");
        editToolBar.pack();
        size = editToolBar.getSize();
        editbarCoolItem.setControl(editToolBar);
        editbarCoolItem.setSize(editbarCoolItem.computeSize(size.x, size.y));

        final CoolItem fontCoolItem = new CoolItem(coolBar, SWT.PUSH);
        final Combo fontCombo = new Combo(coolBar, SWT.READ_ONLY | SWT.BORDER);
        String[] items = {"Arial", "Courier", "Times New Roman"};
        fontCombo.setItems(items);
        fontCombo.pack();
        size = fontCombo.getSize();
        fontCoolItem.setControl(fontCombo);
        fontCoolItem.setSize(fontCoolItem.computeSize(size.x, size.y));
        fontCoolItem.setMinimumSize(size);

        openToolItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Open");
            }
        });

        copyToolItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Copy");
            }
        });

        cutToolItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Cut");
            }
        });

        pasteToolItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Paste");
            }
        });

        saveToolItem.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println("Save");
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
