import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        Document pageTag = Jsoup.connect("https://pogoda.mail.ru/prognoz/taganrog/24hours/").get();
        Elements resultTag = pageTag.getElementsByClass("p-forecast__temperature-value");
        String valueTag = resultTag.text();

        Document pageStav = Jsoup.connect("https://pogoda.mail.ru/prognoz/stavropol/").get();
        Elements resultStav = pageStav.getElementsByClass("e487206871 dedbbf63df bfbd3eb239");
        String valueStav = resultStav.text();

        Document pageRnd = Jsoup.connect("https://pogoda.mail.ru/prognoz/rostov-na-donu/").get();
        Elements resultRnd = pageRnd.getElementsByClass("e487206871 dedbbf63df bfbd3eb239");
        String valueRnd = resultRnd.text();

        String[] cities = {"Таганрог", "Ставрополь", "Ростов-на-дону"};
        String[] value = {valueRnd, valueStav, valueTag};
//        showMessageDialog(null, valueRnd + " " + valueStav + " " + valueTag);

        String input = (String)showInputDialog(
                null,
                "Выберите город ",
                "Города",
                JOptionPane.QUESTION_MESSAGE,
                null,
                cities,
                cities[0]
        );

        int index = 0;
        for (int x = 0; x < cities.length; x++) {
        if (input.equals(cities[x])){
            index = x;
            break;
        }
    }
        String itog = value[index];
        showMessageDialog(null, "Температура в городе " + cities[index] + ": " + itog);
}
}