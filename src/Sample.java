import java.util.*;

public class Sample {
    public static void main(String[] args) {
        NodeImpl n1 = new NodeImpl();
        n1.key = 0;
        n1.mv = Arrays.asList(0, 0, 0);
        n1.maxLevel = 3;

        NodeImpl n2 = new NodeImpl();
        n2.key = 1;
        n2.mv = Arrays.asList(1, 0, 0);
        n2.maxLevel = 2;

        NodeImpl n3 = new NodeImpl();
        n3.key = 2;
        n3.mv = Arrays.asList(2, 0, 0);
        n3.maxLevel = 2;

        NodeImpl n4 = new NodeImpl();
        n4.key = 3;
        n4.mv = Arrays.asList(0, 1, 0);
        n4.maxLevel = 2;

        NodeImpl n5 = new NodeImpl();
        n5.key = 4;
        n5.mv = Arrays.asList(1, 1, 0);
        n5.maxLevel = 2;

        NodeImpl n6 = new NodeImpl();
        n6.key = 5;
        n6.mv = Arrays.asList(2, 1, 0);
        n6.maxLevel = 2;

        NodeImpl n7 = new NodeImpl();
        n7.key = 6;
        n7.mv = Arrays.asList(0, 2, 0);
        n7.maxLevel = 2;

        NodeImpl n8 = new NodeImpl();
        n8.key = 7;
        n8.mv = Arrays.asList(1, 2, 0);
        n8.maxLevel = 2;

        NodeImpl n9 = new NodeImpl();
        n9.key = 8;
        n9.mv = Arrays.asList(2, 2, 0);
        n9.maxLevel = 2;

        NodeImpl n10 = new NodeImpl();
        n10.key = 9;
        n10.mv = Arrays.asList(0, 0, 1);
        n10.maxLevel = 3;

        List<Node> nodeList = Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10);

        Printer.printSG(nodeList);
    }
}

class NodeImpl implements Node {
    int key;
    List<Integer> mv = new ArrayList<Integer>();
    int maxLevel;

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public List<Integer> getMV() {
        return mv;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
}