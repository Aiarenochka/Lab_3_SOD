package main.io;

public class Printer {
    public void menu(){
        System.out.print("""
                Choose the type of priority queue modeling:
                1. Priority queue on array(heap);
                2. Priority queue on doubly linked list;
                3. Measure the time of adding 10000 elements and deleting the 1000.
                0. Exit.
                Your choice:\s""");
    }

    public void menuOfOperations(){
        System.out.print("""
                \n1. Add the element to the queue.
                2. Delete the element from the queue.
                3. Print the first element of the queue.
                4. Print the elements of the queue.
                0. Back <-
                Your choice:\s""");
    }

    public void printer(String description){
        System.out.print(description);
    }

    public void timePrinter(String description, long time){
        System.out.println(description + time + " ns");
    }
}
