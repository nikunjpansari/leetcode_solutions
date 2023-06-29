class Solution {
   public String reverseVowels(String s) 
{
	int i = 0 , j = s.length() - 1 ;
	char temp ;
	HashSet<Character> vowels=new HashSet<>();
	vowels.add('a'); vowels.add('A');
	vowels.add('e'); vowels.add('E');
	vowels.add('i'); vowels.add('I');
	vowels.add('o'); vowels.add('O');
	vowels.add('u'); vowels.add('U');
	char[] c = s.toCharArray() ;
	while( i < j )
	{        
		while( i < j && !vowels.contains(c[i]))
		{
			i++;
		}
		while( i < j && !vowels.contains(c[j]))
		{
			j--;
		}
		temp = c[i];
		c[i++] = c[j];
		c[j--] = temp;
	}        
	return new String(c) ;        
}

}