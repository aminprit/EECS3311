package analyzer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import graph.*;
/**
 * @desc build and analyze CFG of a given method.
 * @author you
 */
public class CFGAnalyzer {
	/**
	 * TODO: build and analyze CFG of a given method. 
	 * 		 You can create auxiliary classes/functions if needed. 
	 */
	
	ArrayList<String> code = new ArrayList<String>();
	DGraph<Integer> graph = new ListDGraph<Integer>();
	
	public void readMethod (String path) throws Exception {
		
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String code_line;
		String function_prefix = "def";
		String for_prefix = "	for";
		String if_prefix = "    if";
		String ret_prefix = "    return";
		
		int Vertex_counter = 1;
		boolean basic_block = false;
		
		while((code_line = br.readLine()) != null) {
			
			// Checks for a function
			if(code_line.startsWith(function_prefix)) {
				graph.addV(Vertex_counter);
				Vertex_counter++;
			}
			else if(code_line.startsWith(if_prefix)) {
				basic_block = false;
				int previous_vertex = Vertex_counter;
				int if_vertex = Vertex_counter+1;
				int else_vertex = Vertex_counter + 2;
				
				graph.addV(if_vertex);
				graph.addE(new Edge(previous_vertex, if_vertex));
				graph.addV(else_vertex);
				graph.addE(new Edge(previous_vertex, else_vertex));
				
				Vertex_counter = else_vertex + 1;
			}
			else if(code_line.startsWith(for_prefix)) {
				// for implementation here
			}
			else if(code_line.startsWith(ret_prefix)) {
				// return implementation here
			}
			
			//Check for a Basic_block
			else {
				int previous_vertex = Vertex_counter-1;
				int Basic_block_vertex = Vertex_counter;
				
				if(!basic_block) {
					basic_block = true;
					graph.addV(Basic_block_vertex);
					graph.addE(new Edge(previous_vertex, Basic_block_vertex));
					
					Vertex_counter = Basic_block_vertex + 1;
				}
				
			}
			
			// final return
			if(!code_line.startsWith(ret_prefix)) {
				graph.addV(Vertex_counter);
				graph.addE(new Edge(Vertex_counter-1, Vertex_counter));
			}
		}
		
		fstream.close();
	}
}
