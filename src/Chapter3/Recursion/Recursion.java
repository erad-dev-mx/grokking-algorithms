package Chapter3.Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        Item key = new Item(true);

        List<Item> innerBoxContent = new ArrayList<>();
        innerBoxContent.add(key);
        Item boxWithKey = new Item(innerBoxContent);

        List<Item> emptyBoxContent = new ArrayList<>();
        Item emptyBox = new Item(emptyBoxContent);

        List<Item> mainBoxContent = new ArrayList<>();
        mainBoxContent.add(emptyBox);
        mainBoxContent.add(boxWithKey);
        Item mainBox = new Item(mainBoxContent);

        System.out.println("Starting...");
        lookForKeyIterative(mainBox);
        lookForKeyRecursive(mainBox);

    }

    public static void lookForKeyIterative(Item mainBox) {
        LinkedList<Item> pile = new LinkedList<>();
        pile.add(mainBox);

        while (!pile.isEmpty()) {
            Item box = pile.removeFirst(); // Grab a box
            for (Item item : box.getContent()) {
                if (item.isBox()) {
                    pile.add(item); // Append to pile
                } else if (item.isKey()) {
                    System.out.println("Iterative: Found the key!");
                }
            }
        }
    }

    public static void lookForKeyRecursive(Item box) {
        for (Item item : box.getContent()) {
            if (item.isBox()) {
                lookForKeyRecursive(item);
            } else if (item.isKey()) {
                System.out.println("Recursive: Found the key!");
            }
        }
    }
}

class Item {
    private boolean isKey;
    private List<Item> content; // If is a box, has content

    // For key
    public Item(boolean isKey) {
        this.isKey = isKey;
        this.content = null;
    }

    // For box
    public Item(List<Item> content) {
        this.isKey = false;
        this.content = content;
    }

    public boolean isKey() {
        return isKey;
    }

    public boolean isBox() {
        return content != null;
    }

    public List<Item> getContent() { return content; }
}
