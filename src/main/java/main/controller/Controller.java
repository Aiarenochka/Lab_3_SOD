package main.controller;

import main.io.Printer;
import main.priorityQueue.*;
import main.timer.TimeMeasurement;

import java.util.Scanner;

public class Controller {
    private final Scanner sc = new Scanner(System.in);
    private final Printer printer = new Printer();
    private final PriorityQueue<Integer> q1 = new PriorityQueueOnArray(), q2 = new PriorityQueueOnDoublyLinkedList();
    private final TimeMeasurement tm = new TimeMeasurement();

    public void mainMenu(){
        exitLabel:
        while(true){
            printer.menu();
            int option = sc.nextInt();
            switch(option){
                case 1 -> doOperations(1);
                case 2 -> doOperations(2);
                case 3 ->{
                    var checkList1 = new PriorityQueueOnArray();
                    printer.timePrinter("Priority queue (Array) adding 10000 element time: ", tm.tmAdding(checkList1));
                    printer.timePrinter("Priority queue (Array) deleting 1000 element time: ", tm.tmDeleting(checkList1));

                    var checkList2 = new PriorityQueueOnDoublyLinkedList();
                    printer.timePrinter("Priority queue (DLL) adding 10000 element time: ", tm.tmAdding(checkList2));
                    printer.timePrinter("Priority queue (DLL) deleting 1000 element time: ", tm.tmDeleting(checkList2));
                }
                case 0 ->{
                    break exitLabel;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    public void doOperations(int op){
        exitLabel:
        while (true) {
            printer.menuOfOperations();
            int option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    printer.printer("Enter the value: ");
                    if(op == 1) q1.add(sc.nextInt());
                    else q2.add(sc.nextInt());
                }
                case 2 -> {
                    printer.printer("Deleted element: ");
                    if(op == 1) printer.printer(q1.delete().toString());
                    else printer.printer(q2.delete().toString());
                }
                case 3 -> {
                    printer.printer("First element of the queue: ");
                    if(op == 1) printer.printer(q1.peek().toString());
                    else printer.printer(q2.peek().toString());
                }
                case 4 -> {
                    if(op == 1) printer.printer("Array modeling: " + q1);
                    else if(op == 2) printer.printer("Doubly linked list modeling: " + q2);
                }
                case 0 -> {
                    break exitLabel;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }


    public void controller(){
        mainMenu();
    }
}
