package com.vaadin;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button;

import java.awt.*;

public class MyButton extends Button {
    public MyButton(){
        setIcon(FontAwesome.PLUS);
    }
}
