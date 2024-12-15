package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsExample {
  //@Test
  public void f1() {
	  ArrayList<String> names = new ArrayList<String>();
		names.add("Abhi");
		names.add("Aditya");
		names.add("Zoya");
		names.add("anand");
		
		int count = 0;
		for(int i=0;i<names.size();i++) {
			if(names.get(i).startsWith("A"))
				count++;
		}
		System.out.println(count);
	  
  }
  
 // @Test
  public void f2() {
	  ArrayList<String> names = new ArrayList<String>();
		names.add("Abhi");
		names.add("Aditya");
		names.add("Zoya");
		names.add("Anand");
		
		long a = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(a);
		
		//Creating a stream
		Stream.of("Abhi","Aditya","Zoya","Anand").filter(
				s->s.startsWith("A")
				).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.startsWith("A")).limit(2).forEach(
				s->System.out.println(s)
				);
		
		
  }

  // @Test
  public void streamMap() {
	  
	  //print names in upper case which end with "a"
	  Stream.of("Yashna","Zoya","Abhimanyu","Arjun","Krishna").
	  filter(s->s.endsWith("a")).
	  map(s->s.toUpperCase()).
	  forEach(s->System.out.println(s));
	  
	  //print names in upper case in sorted way
	  Stream.of("Yashna","Zoya","Abhimanyu","Arjun","Krishna")
	  .map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
	  
	  List<String> names1 = Arrays.asList("Ram","Lakshman","Sita","Bharat","Urmila");
	  ArrayList<String> names = new ArrayList<String>();
		names.add("Krishna");
		names.add("Draupadi");
		names.add("Arjun");
		names.add("Nakul");
		names.add("Yudhishtar");
		names.add("Bheem");
		names.add("Sahadev");
	Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
	//newStream.sorted().forEach(s->System.out.println(s));
	
	Assert.assertEquals(newStream.anyMatch(s->s.equalsIgnoreCase("nakul")),true);  
  }
  
  @Test
  public void streamCollect() {
	  List<String> ls = Stream.of("Yashna","Zoya","Abhimanyu","Arjun","Krishna").sorted()
	  .collect(Collectors.toList());
	  System.out.println(ls.get(2));
	  
	  List<Integer> ls1 = Arrays.asList(2,9,3,9,1,2,4);
	  //unique and sorted
	  ls1.stream().distinct().forEach(a->System.out.print(a+"   "));
	  ls1.stream().distinct().sorted().forEach(a->System.out.print(a+"   "));
  }
}
