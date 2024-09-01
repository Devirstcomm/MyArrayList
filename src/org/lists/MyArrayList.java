package org.lists;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
    private int size; //Размер массива по умолчанию
    private E[] array;
    private int index = 0; //Количество вставленных элементов


    public MyArrayList(int size) throws IndexOutOfBoundsException {
        if (size > 0) {
            array = (E[]) new Object[size]; //Переопределяем размер массива по умолчанию переданной переменной из параметра
            this.size = size;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public MyArrayList() {
        this(10); //Если создаем объект с пустым конструктором значение по умолчанию равно 10;
    }

    public void add(E element) {
        if (index == size) { // Если индекс равен длине массива
            E[] copyArray = (E[]) new Object[index * 2]; // Увеличиваем массив вдвое
            System.arraycopy(array, 0, copyArray, 0, index); // Копируем элементы
            array = copyArray; // Обновляем ссылку на массив
            size = copyArray.length; // Обновляем размер
        }
        array[index++] = element; // Добавляем элемент и увеличиваем индекс
    }

    public void set(int index, E element) throws IndexOutOfBoundsException {
        /*
        1. Проверяем, не выходит ли индекс за пределы количества добавленных элементов
        2. Изменяем элемент
         */
        if (index >= this.index) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }
        array[index] = element;
    }


    public void remove(int index) throws IndexOutOfBoundsException {
        if (index >= this.index) { // Проверяем, не выходит ли индекс за пределы количества добавленных элементов
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }

        /*
        1. Создаем новый массив на один элемент меньше
        2. Копируем все элементы до удаляемого индекса
        3. Копируем все элементы после удаляемого индекса, сдвигая их на одну позицию влево
        4. Обновляем ссылку на массив и уменьшаем счетчик добавленных элементов
         */

        E[] copyArray = (E[]) new Object[this.size];

        for (int i = 0; i < index; i++) {
            copyArray[i] = array[i];
        }

        for (int i = index; i < this.index - 1; i++) {
            copyArray[i] = array[i + 1];
        }

        array = copyArray;
        this.index--;
    }

    public void sort() {
        // Проверяем, что массив не пустой
        if (index > 0 && array[0] instanceof Comparable) {
            Arrays.sort((E[]) array, 0, index); // Сортируем только заполненные элементы
        } else {
            throw new IllegalStateException("Элементы должны реализовывать интерфейс Comparable.");
        }
    }

    // Метод для сортировки с использованием компаратора
    public void sort(Comparator<? super E> comparator) {
        if (index > 0) {
            Arrays.sort(array, 0, index, comparator); // Сортируем с использованием переданного компаратора
        }
    }

    public void sortAsNumbers() {
        // Проверяем, что массив не пустой и его элементы можно преобразовать в числа
        if (index > 0 && array[0] instanceof String) {
            Arrays.sort((E[]) array, 0, index, new Comparator<E>() {
                @Override
                public int compare(E o1, E o2) {
                    Integer num1 = Integer.parseInt((String) o1);
                    Integer num2 = Integer.parseInt((String) o2);
                    return num1.compareTo(num2);
                }
            });
        } else {
            throw new IllegalStateException("Элементы должны быть строками, представляющими числа.");
        }
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public int getSize() {
        return this.index;
    }
}
