package york.eecs.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author song and you
 * @description: @HeapSort uses max heap algorithm to rank a map based on the values.
 */
public class HeapSort implements MapSort<String, Double>{
	/**
     * @map to be sorted;
     */	
	public Map<String, Double> map;
    
	/**
	 * TODO: There are missing methods, you can find clues of these methods from test cases.
     */
	public HeapSort() {
		map = new HashMap<String, Double>();
	}
	
	public void setMap(Map<String, Double> map1) {
		if (map1.containsValue(null)) {
			throw new MapContainsNullValueException("Key is Null");
		}
		map = new HashMap<String, Double>(map1);
	}
	
	public Map<String, Double> getMap(){
		return map;
	}
	
	/**
	 * @description: Sort a map by the values in ascending order max heap sorting algorithm.
	 * @return: Return the corresponding key list of the sorted map.
	 */
	@Override
	public ArrayList<String> sortbyValue() {
		/**
		 *  TODO: Implement sorting the maps by values with max heap sorting algorithm.
		 *  	  This method returns the corresponding key list.
		 *  	  You need to use the auxiliary method, i.e., @heapify.
		 */
		
		ArrayList<String> keyList = new ArrayList<String>(map.keySet());
	    ArrayList<Double> valueList = new ArrayList<Double>(map.values());
		
	    int n = valueList.size();
	    
	    for(int i = n/ 2 - 1; i >= 0; i--) {
	    	heapify(keyList, valueList, n, i);
	    }
	    for(int i = n - 1; i >=0; i --) {
	    	Collections.swap(valueList, i, 0);
	    	Collections.swap(keyList, i, 0);
	    	
	    	heapify(keyList, valueList, i, 0);
	    }
	    
		return keyList;

	}
	
	/**
	 * To heapify a subtree rooted with node `i' which is an index in both @keys and @values. 
	 * `n' is size of heap.
	 */
	public void heapify(ArrayList<String> strList, ArrayList<Double> arrList, int n, int i) {
		/**
		 *  TODO: Implement @heapify to build heap. 
		 */ 
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if (left < n && arrList.get(left) > arrList.get(max)) {
			max = left;
		}
		if (right < n && arrList.get(right) > arrList.get(max)) {
			max = right;
		}
		
		if(max != i) {
			Double temp = arrList.get(i);
			arrList.set(i, arrList.get(max));
			arrList.set(max, temp);
			
			String tempStr = strList.get(i);
			strList.set(i, strList.get(max));
			strList.set(max, tempStr); 
			
			//Collections.swap(arrList, i, max);
			//Collections.swap(strList, i, max);		
			
			heapify(strList, arrList, n, max);
		}

	}
}