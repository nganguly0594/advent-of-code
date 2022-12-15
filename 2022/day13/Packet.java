package day13;

import java.util.*;

public class Packet {
  public List<Packet> children;
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
      String tmp = "";
      for (char c : packet.toCharArray()) {
        if (c == ',' && level == 0) {
          children.add(new Packet(tmp));
          tmp = "";
        } else {
          level += (c == '[') ? 1 : (c == ']') ? -1 : 0;
          tmp += c;
        }
      }
      if (!tmp.equals("")) {
        children.add(new Packet(tmp));
      }
      integer = false;
    }
  }

  public int compare(Packet other) {
    if (integer && other.integer) {
      return other.val - val;
    }
    if (!integer && !other.integer) {
      for (int i = 0; i < Math.min(children.size(), other.children.size()); i++) {
        int val = children.get(i).compare(other.children.get(i));
        if (val != 0) {
          return val;
        }
      }
      return other.children.size() - children.size();
    }
    Packet lst1 = integer ? new Packet("[" + val + "]") : this;
    Packet lst2 = other.integer ? new Packet("[" + other.val + "]") : other;
    return lst1.compare(lst2);
  }
}