package com.example.samsung.p0451_expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //коллекция для групп
    ArrayList<Map<String, String>> groupData,
    //коллекция для элементов одной группы
                                   childDataItem;
    //общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;
    //список атрибутов группы или элемента
    Map<String, String> map;

    ExpandableListView elvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //список атрибутов групп для чтения
        String[] groupFrom = new String[] {"groupName"};
        //список ID wiev-элементов, в которые будут помещены атриуты групп
        int[] groupTo = new int[] {android.R.id.text1};

        //создаём коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String,String>>>();

        //заполняем коллекцию групп из массива групп
        groupData = new ArrayList<Map<String, String>>();
        for (CharSequence group : getResources().getTextArray(R.array.groups)) {
            //заполняем список атрибутов для каждой группы
            map = new HashMap<String, String>();
            map.put("groupName", String.valueOf(group));
            groupData.add(map);
        }

        //список атрибутов элементов для чтения
        String[] childFrom = new String[] {"phoneName"};
        //список ID wiev-элементов, в которые будут помещены атриуты элементов
        int[] childTo = new int[] {android.R.id.text1};

        //создаём коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        //заполняем список атрибутов для каждого элемента
        for (CharSequence phone : getResources().getTextArray(R.array.phonesHTC)) {
            map = new HashMap<String, String>();
            map.put("phoneName", String.valueOf(phone)); //название телефона
            childDataItem.add(map);
        }
        //добавляем в коллекцию коллекций
        childData.add(childDataItem);

        //очищаем коллекцию элементов для второй группы
        childDataItem.clear();
        //заполняем список атрибутов для каждого элемента
        for (CharSequence phone : getResources().getTextArray(R.array.phonesSams)) {
            map = new HashMap<String, String>();
            map.put("phoneName", String.valueOf(phone)); //название телефона
            childDataItem.add(map);
        }
        //добавляем в коллекцию коллекций
        childData.add(childDataItem);

        //очищаем коллекцию элементов для третей группы
        childDataItem.clear();
        //заполняем список атрибутов для каждого элемента
        for (CharSequence phone : getResources().getTextArray(R.array.phonesLG)) {
            map = new HashMap<String, String>();
            map.put("phoneName", String.valueOf(phone)); //название телефона
            childDataItem.add(map);
        }
        //добавляем в коллекцию коллекций
        childData.add(childDataItem);

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, groupData, android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo,
                      childData, android.R.layout.simple_list_item_1, childFrom, childTo);

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);
    }
}
