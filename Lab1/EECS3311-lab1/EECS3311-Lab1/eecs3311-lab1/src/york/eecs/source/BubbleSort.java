package york.eecs.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author song and you
 * @description: @BubbleSort uses bubble sorting algorithm to rank a map based on the values.
 */
public class BubbleSort implements MapSort<String, Integer>{
    /**
     * @map to be sorted;
     */
	public Map<String, Integer> map;
    
	/**
	 * TODO: There are missing methods, you can find clues from test cases.
     */
	public BubbleSort(){
		map = new HashMap<String, Integer>();
	}	
	
	public void setMap(Map<String, Integer> map1) {
		if (map1.containsValue(null)) {
			throw new MapContainsNullValueException("Key is Null");
		}
		map = new HashMap<String, Integer>(map1);
	}
	
	public Map<String, Integer> getMap(){
		return map;
	}

	/**
	 * @description: Sort a map by the values in ascending order with bubble sorting algorithm. 
	 * @return: Return the corresponding key list of the sorted map.
	 */
	@Override
	public ArrayList<String> sortbyValue(){
	/**
	 *  TODO: Implement sorting the maps by values with bubble sorting algorithm.
	 *  	  This method returns the corresponding key list.
	 */
		ArrayList<String> keyList = new ArrayList<String>(map.keySet());
	      ArrayList<Integer> valueList = new ArrayList<Integer>(map.values());
	      
	      boolean flag = false;
	      for(int i = 0; i < valueList.size(); i++) {
	    	  for(int j = 0; j < valueList.size() - 1 - i; j++) {
	    		  if(valueList.get(j) > valueList.get(j + 1)) {
	    			  Collections.swap(valueList, j, j + 1);
	    			  Collections.swap(keyList, j, j + 1);
	    			  flag = true;
	    		  }
	    	  }
	    	  if (flag == false)
	    		  break;
	      }
	
	   return keyList;
	}
}