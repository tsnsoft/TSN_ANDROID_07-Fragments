package kz.talipovsn.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {

    // Метод создания четвертого фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Установка разметки фрагмента и доступ к компонентам фрагмента
        final View rootView = inflater.inflate(R.layout.fragment4, container, false);

        // Поиск компонента TableLayout в разметке
        TableLayout tableLayout = rootView.findViewById(R.id.tableLayout);

        final int ROW_COUNT = 2; // Количество строк в таблице
        final int COL_COUNT = 2; // Количество столбцов в таблице
        String[][] results = new String[ROW_COUNT][COL_COUNT]; // Массив для хранения результатов

        results[0][0] = getResources().getString(R.string.question1); // Заголовок первого столбца
        results[1][0] = getResources().getString(R.string.question2); // Заголовок второго столбца
        results[0][1] = MainActivity.radioGroupValue1; // Результат первого столбца
        results[1][1] = MainActivity.radioGroupValue2; // Результат второго столбца

        // Формирование строк таблицы
        for (int row = 0; row < ROW_COUNT; row++) { // Перебор строк таблицы
            TableRow tableRow = new TableRow(rootView.getContext());  // Создание строки таблицы
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT); // Параметры строки таблицы
            tableRow.setLayoutParams(params); // Установка параметров строки таблицы
            tableRow.setGravity(Gravity.CENTER); // Установка выравнивания строки таблицы
            TableRow.LayoutParams param = new TableRow.LayoutParams(); // Параметры столбцов таблицы

            // Формирование столбцов таблицы
            for (int col = 0; col < COL_COUNT; col++) { // Перебор столбцов таблицы
                EditText editText = new EditText(rootView.getContext()); // Создание компонента EditText
                editText.setText(results[row][col]); // Установка значения компонента EditText
                editText.setLayoutParams(param); // Установка параметров компонента EditText
                editText.setTextSize(18); // Установка размера шрифта
                editText.setGravity(Gravity.CENTER); // Установка выравнивания компонента EditText
                editText.setBackgroundResource(R.drawable.back); // Установка фона компонента EditText
                editText.setPadding(5, 5, 5, 5); // Установка отступов компонента EditText
                tableRow.addView(editText, col); // Добавление компонента EditText в строку таблицы
            }
            tableLayout.addView(tableRow, row); // Добавление строки таблицы в TableLayout
        }

        // Поиск компонента кнопки Назад
        Button BackBtn = rootView.findViewById(R.id.backBtn);

        // Обработчик кнопки Назад
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) { // Проверка наличия активности
                    // Загрузка третьего фрагмента в окно
                    MainActivity.setFragment(getActivity(), new Fragment3());
                }
            }
        });

        // Поиск компонента кнопки Заново
        Button AgainBtn = rootView.findViewById(R.id.againBtn);

        // Обработчик кнопки Заново
        AgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment1 fragment1 = new Fragment1();
                if (getActivity() != null) { // Проверка наличия активности
                    // Загрузка первого фрагмента в окно
                    MainActivity.setFragment(getActivity(), new Fragment1());
                }
            }
        });

        return rootView; // Возвращение разметки фрагмента
    }

}
