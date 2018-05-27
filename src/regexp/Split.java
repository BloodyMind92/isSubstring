package regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Split {

	
	public List<String> split(String string) {
		List<String> result = new ArrayList<>();
		String substring = "";
		
		List<Character> charList = string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		
		for(int i=0; i< charList.size(); i++) {
			
			if(charList.get(i).equals('\\')) {
				if(charList.get(i+1).equals('*')) {
					substring = substring+"*";
					i++;
				}
				else {
					substring = substring+charList.get(i);
				}
			}
			
			if(!charList.get(i).equals('*')) {
				substring = substring+charList.get(i);
			}
			else {
				result.add(substring);
				substring = "";
			}
			
			
		}
		
		result.add(substring);
		
		return result;
	}
}
