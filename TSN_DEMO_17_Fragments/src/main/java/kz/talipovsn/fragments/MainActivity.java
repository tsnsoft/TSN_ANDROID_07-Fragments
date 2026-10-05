package kz.talipovsn.fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
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

        // Перехват системного действия «Назад», чтобы сначала запросить подтверждение выхода.
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(getString(R.string.exit))
                        .setMessage(getString(R.string.exit_desc))
                        .setPositiveButton(getString(R.string.yes),
                                (dialog, which) -> finish())
                        .setNegativeButton(getString(R.string.no), null)
                        .show();
            }
        });
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

}
