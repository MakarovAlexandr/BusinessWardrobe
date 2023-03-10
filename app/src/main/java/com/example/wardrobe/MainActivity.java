package com.example.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float coat = 70; // Пальто
    byte coatDiscount = 77; // скидка (в процентах)
    float hat = 25; // Шляпа
    byte hatDiscount = 37;
    float businessSuit = 53; // Деловой костюм
    byte businessSuitDiscount = 44;
    float shirt = 19; // Сорочка
    float shoes = 41; // туфли
    byte shoesDiscount = 32;
    float account = 312; // Счет пользователя

    // метод подсчёта стоимости делового гардероба
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (coat * (100 - coatDiscount) + hat * (100 - hatDiscount)
                + businessSuit * (100 - businessSuitDiscount) + shirt
                + shoes * (100 - shoesDiscount)) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки делового гардероба
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить деловой гардероб
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки
    private TextView priceOut; // поле возможной стоимости покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки
        priceOut = findViewById(R.id.priceOut); // вывод информации о возможной стоимости покупки

        // заполнение экрана
        if (possibility()) { // если имеется возможность купить деловой гардероб
            possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
            priceOut.setText("Деловой гардероб стоит: " + calculation() + " серебряных монет");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки делового гардероба");
            priceOut.setText("Деловой гардероб стоит: " + calculation() + " серебряных монет");
            balanceOut.setText(" - ");
        }
    }
}

