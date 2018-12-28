/*
 * 14253506
 * Şeref Batın Eryılmaz
 */

import java.util.HashMap;
import java.util.Map;

public class Odev2 {

	/**
	 * huffmanKodla metodu verilen girdi metnini bir Huffman ağacı oluşturarak
	 * kodlar. Aynı zamanda parametre olarak gönderilen Huffman ağacını
	 * doldurur. Test işlemleri geri dönen kod ve ağaç üzerinden
	 * gerçekleştirilmektedir.
	 *
	 * @param girdi Girdi metni
	 * @param agac boş olarak verilen ağaç(HuffmanTree)
	 * @return kodlanmış metni döndürür
	 */
	public static String huffmanKodla(String girdi, HuffmanTree agac) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < girdi.length(); i++) {
				if (!hm.containsKey(girdi.charAt(i))) {
					hm.put(girdi.charAt(i), 1);
				} else {
					Integer frequency = hm.get(girdi.charAt(i));
					hm.replace(girdi.charAt(i),++frequency);
				}
		}

		int t = 0;
		HuffmanNode nodes[] = new HuffmanNode[hm.size()];
		for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			nodes[t] = new HuffmanNode(key, value, null, null);
			t++;
		}
		agac.addAll(nodes);
		HashMap<Character,String> hm2 = new HashMap<>();
		codeIt(agac.root,"",hm2);
		String ret = "";
		for (int i = 0; i < girdi.length(); i++) {
			ret += hm2.get(girdi.charAt(i));
		}
		return ret;
	}

	static void codeIt(HuffmanNode hn,String code,HashMap<Character,String> hm) {
		if (hn.left != null && hn.right != null) {
            codeIt(hn.left,(code+"0"),hm);
			codeIt(hn.right,(code+"1"),hm);
        }
        else {
            hm.put(hn.value,code);
        }

    }

}
