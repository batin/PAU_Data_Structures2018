/*
 * 14253506
 * Şeref Batın Eryılmaz
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Odev3 {
		HashMap<String,Integer> hm;
		SimpleGraph graph;
		String s[],s2[];
		Map<String, String> bb;
	public Odev3(String girdi){
		hm = new HashMap();
		graph = new SimpleGraph(true);
		s = girdi.split("\\n");
		for (String string : s) {
			s2=string.split(" ");
			graph.addVertex(s2[0]);
			Vertex v = new Vertex(s2[0]);
			hm.put(v.value.toString(),(s2.length-1));
		}
		for (String string : s){
			s2=string.split(" ");
			for (int t = 1; t < s2.length; t++) {
				Vertex v1 = (Vertex) graph.verticesMap.get(s2[0]);
				Vertex v2 = (Vertex) graph.verticesMap.get(s2[t]);
				graph.addEdge(v1.value,v2.value);

			}
		}
	}

    public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
    	List<Map.Entry<String, Integer> > list = new LinkedList(hm.entrySet());
    	Collections.sort(list, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> {
    		int i = (o2.getValue()).compareTo(o1.getValue());
    		return i==0 ? o1.getKey().compareTo(o2.getKey()) : i;
    	});
    	HashMap<String, Integer> temp = new LinkedHashMap<>();
    	list.forEach((entry) -> {
    		temp.put(entry.getKey(), entry.getValue());
    			});
    	return temp;
    	}

    public Map<String, String> boya(String[] renkler) {
    	bb = new HashMap();
    	hm = sortByValue(hm);
    	bb = (Map<String, String>) hm.clone();
    	for (Entry<String, Integer> entry : hm.entrySet()) {
    		String key = entry.getKey();
    		bb.replace(key,"");
    	}
    	int i = 0;
    	boolean b = true;

    	while(!hm.isEmpty()){
    		String key = "";
    		for (Entry<String, String> entry : bb.entrySet()) {
    			key = entry.getKey();
    			Vertex vertex = (Vertex) graph.verticesMap.get(key);
    			if(bb.get(key).equals("")){
    				for ( Object v : vertex.edges ) {
    						if(bb.get( ((Edge) v).to.value ).equals(renkler[i])){
    							b = false;
    							break;
    						}

    				}
    				if(b){
    					bb.replace(key,renkler[i]);
    					hm.remove(key);
    				}
    			}
    					b = true;
    		}
    				i++;
    	}
    return bb;
    }
}

 
