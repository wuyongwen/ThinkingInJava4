//: containers/CollectionDataTest.java
package containers; /* Added by Eclipse.py */
import java.util.*;
import net.mindview.util.*;

class Government implements Generator<String> {
  String[] foundation = ("strange women lying in ponds " +
    "distributing swords is no basis for a system of " +
    "government").split(" ");
  private int index;
  public String next() { return foundation[index++]; }
}

public class CollectionDataTest {
  public static void main(String[] args) {
    Set<String> set = new LinkedHashSet<String>(
      new CollectionData<String>(new Government(), 15));
    // Using the convenience method:
    set.addAll(CollectionData.list(new Government(), 15));
    System.out.println(set);
    
    Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;  
  
    System.out.println(f1 == f2);  
    System.out.println(f3 == f4);  
    System.out.println(testSwitch("ab"));
  }
  static boolean testSwitch(String str){
	  switch(str){
	  case "a":return true;
	  case "b":return false;
	  default : return false;
	  }
  }
} /* Output:
[strange, women, lying, in, ponds, distributing, swords, is, no, basis, for, a, system, of, government]
*///:~
