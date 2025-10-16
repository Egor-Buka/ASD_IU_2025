//Реализовать «Стек с минимумом» (Min Stack). Прокомментировать логику.

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack; //основной стэк
    private Stack<Integer> minStack; //вспомогательный

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value){ //добавление минимума
        mainStack.push(value); //всегда новые элементы добавляются в основной стэк для хранения
        if (minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value); //обновляем минимум
        }
    }

    public void pop() { //удаление верхнего элемента
        if (mainStack.isEmpty()) {
            System.out.println("Стэк пуст!");
            return;
        }
        int removed = mainStack.pop(); //удаление из основного стэка
        if (removed == minStack.peek()) { //если удаленное значение совпадает с минимумом, удаляем и его
            minStack.pop();
        }
    }

    public int getMin() { //получение минимального элемента
        if (minStack.isEmpty()){
            throw new RuntimeException("Стэк пуст!");
        }
        return minStack.peek();
    }

    public int top() { //возврат верхнего элемента
        if (mainStack.isEmpty()){
            throw new RuntimeException("Стэк пуст!");
        }
        return mainStack.peek();
    }

    public boolean isEmpty() { //проверка стэка на пустоту
        return mainStack.isEmpty();
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(4);
        System.out.println(stack.getMin()); //2
        stack.pop(); //убрали 4
        System.out.println("Минимум после 1 удаления: " + stack.getMin()); //2
        stack.pop(); //убрали 2
        System.out.println("Минимум после 2 удалений: " + stack.getMin()); //3
    }

}
