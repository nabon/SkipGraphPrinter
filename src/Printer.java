import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Printer {
    public static void printSG (List<Node> nodeList) {
        Map<Integer, Map<String, TreeMap<Integer, Node>>> levelToLists = new HashMap<Integer, Map<String, TreeMap<Integer, Node>>>();

        int maxLevel = 0;
        int minKey = Integer.MAX_VALUE;
        int maxKey = Integer.MIN_VALUE;
        for(Node node : nodeList){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<=node.getMaxLevel();i++){
                Map<String, TreeMap<Integer, Node>> lists;
                if(levelToLists.containsKey(i)) {
                    lists = levelToLists.get(i);
                } else {
                    lists = new HashMap<String, TreeMap<Integer, Node>>();
                }

                if(i==0) sb.append(0);
                else sb.append(node.getMV().get(i-1));
                String mvPrefix = new String(sb);

                TreeMap<Integer, Node> list;
                if(lists.containsKey(mvPrefix)) {
                    list = lists.get(mvPrefix);
                } else {
                    list = new TreeMap<Integer, Node>();
                }

                list.put(node.getKey(), node);
                lists.put(mvPrefix, list);
                levelToLists.put(i, lists);
            }

            if(node.getMaxLevel() > maxLevel) {
                maxLevel = node.getMaxLevel();
            }
            if(node.getKey() < minKey) {
                minKey = node.getKey();
            }
            if(node.getKey() > maxKey) {
                maxKey = node.getKey();
            }
        }

        for(int i=maxLevel;i>=0;i--) {
            Map<String, TreeMap<Integer, Node>> lists = levelToLists.get(i);
            for(String prefix : lists.keySet()) {
                TreeMap<Integer, Node> list = lists.get(prefix);
                StringBuilder sb = new StringBuilder();

                int predKey = minKey-1;
                for(int key : list.keySet()) {
                    if(predKey < minKey) {
                        for(int j=0;j<(key-minKey)*2+1;j++) {
                            sb.append("-");
                        }
                    } else {
                        for(int j=0;j<(key-predKey)*2-1;j++) {
                            sb.append("-");
                        }
                    }
                    sb.append("*");
                    predKey = key;
                }
                for(int j=0;j<(maxKey-predKey)*2+1;j++) {
                    sb.append("-");
                }

                System.out.println(new String(sb));
            }

            System.out.println("");
        }
    }
}
