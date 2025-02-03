package kz.talipovsn.fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    // Глобальные переменные для всех фреймов
    public static String radioGroupValue1 = ""; // Переменная для хранения значения радио-группы 1
    public static String radioGroupValue2 = ""; // Переменная для хранения значения радио-группы 2

    // Создание окна
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Установка первого фрагмента в окно
        setFragment(this, new Fragment1());
    }

    // Установка в окне требуемого фрагмента
    public static void setFragment(FragmentActivity activity, Fragment fragment) {
        if (activity != null) {
            // Создание транзакции фрагмента
            FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            // Замена фрагмента
            fragmentTransaction.replace(R.id.frame, fragment);
            // Выполние транзакции
            fragmentTransaction.commit();
        }
    }

    // Создание диалогового окна при нажатии на кнопку "Назад"
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert) // Установка иконки
                .setTitle(getString(R.string.exit)) // Установка заголовка
                .setMessage(getString(R.string.exit_desc)) // Установка описания
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    // Обработка нажатия на кнопку "Да"
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();  // Закрытие приложения
                    }
                })
                .setNegativeButton(getString(R.string.no), null) // Отмена закрытия приложения
                .show(); // Показ диалогового окна
    }

}
