package day13;

import java.util.*;

public class Packet implements Comparable<Packet> {
    public ArrayList<Packet> children;
    public int val;
    public boolean integer = true;
    public String str;

    public Packet(String packet) {
        str = packet;
        children = new ArrayList<>();
        
        if (packet.equals("[]")) {
            val = -1;
        }

        if (!packet.startsWith("[")) {
            val = Integer.parseInt(packet);
        }
        else {
            packet = packet.substring(1, packet.length() - 1);
            int level = 0;
            String element = "";
            for (char c : packet.toCharArray()) {
                if (c == ',' && level == 0) {
                    children.add(new Packet(element));
                    element = "";
                }
                else {
                    level += (c == '[') ? 1 : (c == ']') ? -1 : 0;
                    element += c;
                }
            }
            if (!element.equals("")) {
                children.add(new Packet(element));
            }
            integer = false;
        }
    }

    public int compareTo(Packet other) {
        if (this.integer && other.integer) {
            return other.val - this.val;
        }
        if (!this.integer && !other.integer) {
            for (int i = 0; i < Math.min(children.size(), other.children.size()); i++) {
                int value = children.get(i).compareTo(other.children.get(i));
                if (value != 0) {
                    return value;
                }
            }
            return other.children.size() - children.size();
        }

        Packet pack1;
        Packet pack2;

        if (integer) {
            pack1 = new Packet("[" + this.val + "]");
        }
        else {
            pack1 = this;
        }

        if (other.integer) {
            pack2 = new Packet("[" + other.val + "]");
        }
        else {
            pack2 = other;
        }
        
        return pack1.compareTo(pack2);
    }
}
