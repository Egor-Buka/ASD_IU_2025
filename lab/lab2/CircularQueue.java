/* Реализовать «Циклическую очередь» (Circular Queue). Прокомментировать
логику. */

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public  CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue (int element) {
        if (isFull()) {
            System.out.println("Очередь заполнена!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        System.out.println("Добавлен элемент: " + element);

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return -1;
        }
        int removed = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Удалён элемпент: " + removed);
        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return -1;
        }
        return queue[front];
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return;
        }
        System.out.println("Содержимое очереди: ");
        for (int i = 0; i < size; i++) {
            System.out.println(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.printQueue();
        cq.dequeue();
        cq.dequeue();
        cq.printQueue();
        cq.enqueue(60);
        cq.enqueue(70);
        cq.printQueue();
        System.out.println("Первый элемент: " + cq.peek());
    }
}
/* Результат вывода:
Добавлен элемент: 10
Добавлен элемент: 20
Добавлен элемент: 30
Добавлен элемент: 40
Добавлен элемент: 50
Содержимое очереди:
10
20
30
40
50

Удалён элемпент: 10
Удалён элемпент: 20
Содержимое очереди:
30
40
50

Добавлен элемент: 60
Добавлен элемент: 70
Содержимое очереди:
30
40
50
60
70

Первый элемент: 30

 */