class Solution {
    public int uniqueMorseRepresentations(String[] words) {
    	String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} ;
    	
    	Set<String> seen = new HashSet<String>() ;
    	
    	for(String word : words)
    	{
    		StringBuilder code = new StringBuilder() ;
    		for (char c : word.toCharArray())
    		{
    			code.append(MORSE[c - 'a']) ;
    		}
    		seen.add(code.toString()) ;
    	}
    	return seen.size() ;
    }
}
