package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {

    private PriorityQueue<Toy> priorityQueue = new PriorityQueue<>();

    public void put(int id, String name, int quantity, int frequency) {
        Toy toy = new Toy(id, name, quantity, frequency);
        priorityQueue.offer(toy);
    }

    public int get() {
        Random random = new Random();
        int randID = random.nextInt(100);
        if (randID < 20) {
            return 1;
        }
        else if (randID < 40) {
            return 2;
        }
        else {
            return 3;
        }
    }

    public void writeToFile(String name, int count) {
        try {
            FileWriter writer = new FileWriter(name);
            for (int i = 0; i < count; i++) {
                int choiceID = get();
                for (Toy toy: priorityQueue) {
                    if (toy.id == choiceID)
                        writer.write("id: " + toy.id +
                                "name: " + toy.name +
                                "quantity: " + toy.quantity +
                                "frequency: " + toy.frequency + "\n");

                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyStore toys = new ToyStore();
        toys.put(1, "cat", 2, 20);
        toys.put(2, "robot", 2, 20);
        toys.put(3, "baby", 6, 60);

        toys.writeToFile("AutomatToy", 10);
    }
}
