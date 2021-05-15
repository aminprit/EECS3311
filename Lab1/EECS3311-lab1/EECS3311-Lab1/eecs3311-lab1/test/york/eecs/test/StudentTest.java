package york.eecs.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import york.eecs.source.BubbleSort;
import york.eecs.source.HeapSort;
import york.eecs.source.MapContainsNullValueException;

public class StudentTest {
 /**
  * TODO: Please write at least 5 test cases for testing @BubbleSort.
  * TODO: Please write at least 5 test cases for testing @HeapSort.
  * Author  - Prit Amin
  */
	BubbleSort bubble;
	HeapSort heapsort;

	 @Before
	    public void setUp() throws Exception {
		 bubble = new BubbleSort();
	    }
	 
	 @Test
	    public void test_bubble_no1() throws MapContainsNullValueException {
		 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
			map_to_be_sorted.put("tom", -9);
			map_to_be_sorted.put("james", 0);
			map_to_be_sorted.put("sam", 13); 
			map_to_be_sorted.put("allen", 1);
	     
	      bubble.setMap(map_to_be_sorted);
	        
	     /**
	      * @Expectedresult: the order of keys after ranking `map' by value with bubble algorithm.
	      */
	     ArrayList<String> expected_result = new ArrayList<String>();
	     expected_result.add("tom");
	     expected_result.add("james");
	     expected_result.add("allen");
	     expected_result.add("sam");
		 
	     /**
		  * map size should be the same;
		  */
		 Assert.assertEquals(map_to_be_sorted.size(), bubble.getMap().size());   
		 /**
		  * Expected result should have the same size of the ranked key list;
	      */		    
	     Assert.assertEquals(expected_result.size(), bubble.sortbyValue().size());
	     /**
		  * Elements in the same position from the expected result and the ranked key list should the same;
		  */ 
	     for(int i =0; i<expected_result.size(); i++) {
	    	 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
	     }
	 } 

	 @Test
	    public void test_buble_no2() throws MapContainsNullValueException {
	    	Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
			map_to_be_sorted.put("tom", -9);
			map_to_be_sorted.put("james", 12);
			map_to_be_sorted.put("sam", 13); 
			map_to_be_sorted.put("allen", 1);
	     
	      bubble.setMap(map_to_be_sorted);
	      
	      ArrayList<String> expected_result = new ArrayList<String>();
		     expected_result.add("tom");
		     expected_result.add("allen");
		     expected_result.add("james");
		     expected_result.add("sam");
			 
		     /**
			  * map size should be the same;
			  */
			 Assert.assertEquals(map_to_be_sorted.size(), bubble.getMap().size());   
			 /**
			  * Expected result should have the same size of the ranked key list;
		      */		    
		     Assert.assertEquals(expected_result.size(), bubble.sortbyValue().size());
		     /**
			  * Elements in the same position from the expected result and the ranked key list should the same;
			  */ 
		     for(int i =0; i<expected_result.size(); i++) {
		    	 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
		     }
	    }
	 
	 @Test
	 
	 public void test_bubble_no3() throws MapContainsNullValueException{
		 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
		 map_to_be_sorted.put("Asia", 100);
		 map_to_be_sorted.put("Africa", 1);
		 map_to_be_sorted.put("Antartica", 13);
		 map_to_be_sorted.put("North America", 2);
		 map_to_be_sorted.put("South America", 4);
		 map_to_be_sorted.put("Europe", 12);	
		 map_to_be_sorted.put("Australia", 101);
		 
		 bubble.setMap(map_to_be_sorted);
		 
		 ArrayList<String> expected_result = new ArrayList<String>();
		 expected_result.add("Africa");
		 expected_result.add("North America");
		 expected_result.add("South America");
		 expected_result.add("Europe");
		 expected_result.add("Antartica");
		 expected_result.add("Asia");
		 expected_result.add("Australia");
		 
		 Assert.assertEquals(map_to_be_sorted.size(), bubble.getMap().size());
		 Assert.assertEquals(expected_result.size(), bubble.sortbyValue().size());
		 
		 for(int i = 0; i < map_to_be_sorted.size(); i++) {
			 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
		}
	 }
	 
	 @Test
	    public void test_bubble_no4() throws MapContainsNullValueException{
		 
		 Map<String,Integer> map_to_be_sorted = new HashMap<String, Integer>();
		 map_to_be_sorted.put("Asia", 10);
		 map_to_be_sorted.put("Africa", 1);
		 map_to_be_sorted.put("Antartica", -13);
		 
		 bubble.setMap(map_to_be_sorted);
		 
		 ArrayList<String> expected_result = new ArrayList<String>();
		 expected_result.add("Asia");
		 expected_result.add("Antartica");
		 expected_result.add("Africa");
		 Assert.assertEquals(map_to_be_sorted.size(), bubble.getMap().size());
		 Assert.assertEquals(expected_result.size(), bubble.sortbyValue().size());
		 
		 for(int i = 0; i < map_to_be_sorted.size(); i++) {
			 Assert.assertNotEquals(expected_result.get(i), bubble.sortbyValue().get(i));
		}
	 }
	    
	    @Test(expected = MapContainsNullValueException.class)
	    public void test_bubble_no5(){
		 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
			
			map_to_be_sorted.put("james", 30);
			map_to_be_sorted.put("sam", null); 
	     
	       /**
	        * Initialize the `map' in class @BubbleSort with `map_to_be_sorted' by call method @setMap. 
	        * Method @setMap throws MapContainsNullValueException, when the values in the map contain @null.
	        */
	       bubble.setMap(map_to_be_sorted);
	    }
	    
	    @Before
	    public void setUp1() throws Exception {
		 heapsort = new HeapSort();
	    }
	 
	    @Test
	    public void test_heap_no1() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("A", -1.0);
		map_to_be_sorted.put("E", 2.0);
		map_to_be_sorted.put("C", 5.5);
		map_to_be_sorted.put("D", 1.0); 
		map_to_be_sorted.put("B", 8.5);
	    
	    /**
	     * Initialize the `map' in bubble with `map_to_be_sorted';
	     */
	    heapsort.setMap(map_to_be_sorted);    
	    
	    /**
	     * Expected results: the order of keys after ranking `map' by value with max heap algorithm;
	     */
		ArrayList<String> results = new ArrayList<String>();
		results.add("A");
		results.add("D");
		results.add("E");
		results.add("C");
		results.add("B");
		
		/**
		 * map size should be the same;
		 */
		Assert.assertEquals(map_to_be_sorted.size(), heapsort.getMap().size());
		/**
		 * Expected result should have the same size of the ranked key list;
		 */
	    Assert.assertEquals(results.size(), heapsort.sortbyValue().size());
	    
	    /**
	     * Elements in the same position from the expected result and the ranked key list should the same;
	     */
		for(int i =0; i<results.size(); i++) {
			 Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
		}
     }
	    @Test
	    public void test_heap_no2() {
			Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
			map_to_be_sorted.put("A", -1.0);
			map_to_be_sorted.put("B", -2.0);
			map_to_be_sorted.put("C", -1.9);
			map_to_be_sorted.put("D", 1.2);
			map_to_be_sorted.put("E", -0.01);
			map_to_be_sorted.put("F", 21.3);
			map_to_be_sorted.put("G", 1.10);
			map_to_be_sorted.put("H", 11.01);
			map_to_be_sorted.put("I", 1.02);
			map_to_be_sorted.put("J", 3.05);
			map_to_be_sorted.put("K", -11.0);
			map_to_be_sorted.put("L", 3.04);
			map_to_be_sorted.put("M", 244.4);
			map_to_be_sorted.put("N", 2.03);
			
			heapsort.setMap(map_to_be_sorted);
			
			ArrayList<String> results = new ArrayList<String>();
			results.add("K");
			results.add("B");
			results.add("C");
			results.add("A");
			results.add("E");
			results.add("I");
			results.add("G");
			results.add("D");
			results.add("N");
			results.add("L");
			results.add("J");
			results.add("H");
			results.add("F");
			results.add("M");
			
			Assert.assertEquals(map_to_be_sorted.size(), heapsort.getMap().size());
			/**
			 * Expected result should have the same size of the ranked key list;
			 */
		    Assert.assertEquals(results.size(), heapsort.sortbyValue().size());
		    
		    /**
		     * Elements in the same position from the expected result and the ranked key list should the same;
		     */
			for(int i =0; i<results.size(); i++) {
				 Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
			}
	    }
	    
	    @Test(expected = MapContainsNullValueException.class)
	    public void test_heap_no3() {
	    	Map<String, Double> map_to_be_sorted = new HashMap<String,Double>();
	    	
	    	map_to_be_sorted.put("A", -0.01);
	    	map_to_be_sorted.put("A", 1.0);
	    	map_to_be_sorted.put("A", 0.01);
	    	map_to_be_sorted.put("A", null);
	    	
	    	heapsort.setMap(map_to_be_sorted);
	    }
	    
	    @Test 
	    public void heap_sort_no5() {
	    	Map<String, Double> map_to_be_sorted = new HashMap<String,Double>();
	    	
	    	map_to_be_sorted.put("A", 100.01);
	    	map_to_be_sorted.put("B", 90.01);
	    	map_to_be_sorted.put("C", 80.01);
	    	map_to_be_sorted.put("D", 70.01);
	    	map_to_be_sorted.put("E", 60.01);
	    	map_to_be_sorted.put("F", 50.01);
	    	map_to_be_sorted.put("G", 40.01);
	    	map_to_be_sorted.put("H", 30.01);
	    	map_to_be_sorted.put("I", 20.01);
	    	map_to_be_sorted.put("J", 10.01);
	    	map_to_be_sorted.put("K", 0.01);
	    	map_to_be_sorted.put("L", -0.01);
	    	map_to_be_sorted.put("M", -1.01);
	    	map_to_be_sorted.put("N", -20.01);
	    	
	    	heapsort.setMap(map_to_be_sorted);
	    	
	    	ArrayList<String> expected_result = new ArrayList<String>();
	    	
	    	expected_result.add("N");
	    	expected_result.add("M");
	    	expected_result.add("L");
	    	expected_result.add("K");
	    	expected_result.add("J");
	    	expected_result.add("I");
	    	expected_result.add("H");
	    	expected_result.add("G");
	    	expected_result.add("F");
	    	expected_result.add("E");
	    	expected_result.add("D");
	    	expected_result.add("C");
	    	expected_result.add("B");
	    	expected_result.add("A");
	    	
	    	Assert.assertEquals(map_to_be_sorted.size(), heapsort.getMap().size());
			/**
			 * Expected result should have the same size of the ranked key list;
			 */
		    Assert.assertEquals(expected_result.size(), heapsort.sortbyValue().size());
		    
		    /**
		     * Elements in the same position from the expected result and the ranked key list should the same;
		     */
			for(int i =0; i<expected_result.size(); i++) {
				 Assert.assertEquals(expected_result.get(i), heapsort.sortbyValue().get(i));
			}
	    }

	    @Test(expected = MapContainsNullValueException.class)
	    public void test_heap_exception(){
		 Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
			map_to_be_sorted.put("A", 99.0);
			map_to_be_sorted.put("B", 30.1);
			map_to_be_sorted.put("E", null); 
			map_to_be_sorted.put("C", 107.3);
	     
	       /**
	        * Initialize the `map' in class @HeapSort with `map_to_be_sorted' by call method @setMap;
	        * Method @setMap throws MapContainsNullValueException, when the values in the map contain @null.
	        */
			heapsort.setMap(map_to_be_sorted);	    
	    }
}
