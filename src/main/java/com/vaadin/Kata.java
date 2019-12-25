package com.vaadin;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import java.util.Random;

public class Kata extends VerticalLayout {

    public Kata() {
        buildButton();
    }

    int canlihucrecounter = 0;

    private void buildButton() {
        Button[][] dizi = new Button[5][5];

        for (int i = 0; i < 5; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            for (int j = 0; j < 5; j++) {
                int rnd = getRndSayi();

                MyButton button = new MyButton();
                button.setData(rnd);

                dizi[i][j] = button;

                int finalI = i;
                int finalJ = j;
                button.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        canlihucrecounter=0;
                        int sonuc = (Integer) button.getData();
                        if (sonuc == 1) {

                            int solindex=finalJ - 1;
                            if (solindex>=0){
                                Button buttonSolu = dizi[finalI][solindex];
                                if (buttonSolu.getData().equals(1)) canlihucrecounter++;
                            }

                            int sagindex=finalJ + 1;
                            if (sagindex<=4){
                                Button buttonSagi = dizi[finalI][sagindex];
                                if (buttonSagi.getData().equals(1)) canlihucrecounter++;
                            }

                            int ustindex=finalI - 1;
                            if (ustindex>=0){
                                Button buttonUstu = dizi[ustindex][finalJ];
                                if (buttonUstu.getData().equals(1)) canlihucrecounter++;
                            }

                            int altindex=finalI + 1;
                            if (altindex<=4){
                                Button buttonAlti = dizi[altindex][finalJ];
                                if (buttonAlti.getData().equals(1)) canlihucrecounter++;
                            }

                            if (ustindex>=0 && sagindex<=4)
                            {
                                Button buttonSagUstCarprazi = dizi[ustindex][sagindex];
                                if (buttonSagUstCarprazi.getData().equals(1)) canlihucrecounter++;
                            }

                            if (altindex<=4 && sagindex<=4)
                            {
                                Button buttonSagAltCarprazi = dizi[altindex][sagindex];
                                if (buttonSagAltCarprazi.getData().equals(1)) canlihucrecounter++;
                            }

                            if (ustindex>=0 && solindex>=0)
                            {
                                Button buttonSolUstCarprazi = dizi[ustindex][solindex];
                                if (buttonSolUstCarprazi.getData().equals(1)) canlihucrecounter++;
                            }

                            if (altindex<=4 && solindex>=0)
                            {
                                Button buttonSolAltCarprazi = dizi[altindex][solindex];
                                if (buttonSolAltCarprazi.getData().equals(1)) canlihucrecounter++;
                            }

                            Button secilibutton = dizi[finalI][finalJ];
                            if (canlihucrecounter >= 3){
                                Notification.show("Canlı kaldı");
                                secilibutton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
                            }
                            else {
                                Notification.show(" Sonradan Öldü");
                                secilibutton.setData(0);
                                secilibutton.addStyleName(ValoTheme.BUTTON_DANGER);
                            }
                        }
                        else {
                            Notification.show("Buton Zaten Ölü");
                            Button secilibutton = dizi[finalI][finalJ];
                            secilibutton.addStyleName(ValoTheme.BUTTON_DANGER);
                        }
                    }
                });
                horizontalLayout.addComponent(button);
                System.out.print(button.getData()); //buton datalarını görmek için
                horizontalLayout.setSpacing(true);
            }
            addComponent(horizontalLayout);
            setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);
            setSpacing(true);
            setMargin(true);
        }
    }

    private int getRndSayi() {
        Random random = new Random();
        return random.nextInt(2);
    }
}
