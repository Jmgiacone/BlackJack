package BlackJack;

import java.util.ArrayList;

public class TestRemove {
   public static void main(String[] args) {
      ArrayList<String> originalList = new ArrayList<String>();
      originalList.add("foo");
      originalList.add("bar");
      originalList.add("bat");
      originalList.add("baz");
      originalList.add("bar");

      ArrayList<String> removeList = new ArrayList<String>();

      for(String currEntry : originalList) {
         if(currEntry.startsWith("ba")) {
            removeList.add(currEntry);
         }
      }

      for(String removeEntry : removeList) {
         originalList.remove(removeEntry);
      }

     for(String currEntry : originalList) {
        System.out.println(currEntry);
     }
   }
}
