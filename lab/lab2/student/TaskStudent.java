package student;/*Создать класс Student с полями:
1 Long id
2 String name
В методе main:
1 Создать ArrayList, который хранит объекты класса Student
(ArrayList<Student>).
2 Создать LinkedList, который хранит объекты класса Student
(LinkedList <Student>).
3 Создать Set, который хранит объекты класса Student (HashSet
<Student>).
4 Создать HashMap, который хранит объекты класса Student (HashMap
<Long, Student>).
В каждую структуру данных добавить 10 000 000 объектов.
После этого для каждой структуры данных измерить время в нс:
1 Добавление 1 несуществующего элемента в конец (id = 10 000 001).
2 Добавление 1 несуществующего элемента в начало.
3 Удаление последнего элемента
4 Удаление первого элемента
5 Взятие (Get) центрального элемента (id = 5 000 000)
6 Взятие (Get) последнего элемента (id = 9 999 999).
Помимо кода решение должно содержать цифры, полученные при
тестах. При невозможности работать с 10 000 000 записей позволительно
несколько сократить количество объектов.*/


import java.util.*;

public class TaskStudent {
    public static void main(String[] args) {
        int size =10_000_000;
        ArrayList<DataTypeStudent> arrayList = new ArrayList<>();
        List<DataTypeStudent> linkedList = new LinkedList<>();
        Set<DataTypeStudent> hashSet = new HashSet<>();
        Map<Long, DataTypeStudent> hashMap = new HashMap<>();
        for (long i = 0; i < size; i++) {
            DataTypeStudent s = new DataTypeStudent(i, "Student" + i);
            arrayList.add(s);
            linkedList.add(s);
            hashSet.add(s);
            hashMap.put(i, s);
        }
        DataTypeStudent newDataTypeStudent = new DataTypeStudent(10_000_001L, "NewStudent");
        System.out.println("Количество элементов: " + size);
        System.out.println("Измерение времени (мс):\n");
        System.out.println("==ArrayList==");
        DataTypeStudent.measureListPerformance(arrayList, newDataTypeStudent);
        System.out.println("==LinkedList++");
        DataTypeStudent.measureListPerformance(linkedList, newDataTypeStudent);
        System.out.println("==HashSet");
        DataTypeStudent.measureSetPerformance(hashSet, newDataTypeStudent);
        System.out.println("==HashMap==");
        DataTypeStudent.measureMapPerformance(hashMap, newDataTypeStudent);

    }
}

/*==ArrayList==
 Добавление в конец: 600
Добавление в начало: 3994400
Удаление последнего: 8400
Удаление первого: 3738700
Get центрального: 6700
Get последнего: 900
==LinkedList++
 Добавление в конец: 3200
Добавление в начало: 11200
Удаление последнего: 4300
Удаление первого: 1600
Get центрального: 26319700
Get последнего: 4700
==HashSet
Добавление (HashSet): 19500
Удаление (HashSet): 13100
==HashMap==
Добавление (HashMap): 5400
Удаление (HashMap): 9300
Get центрального (HashMap): 25800
Get последнего (HashMap): 2100 */