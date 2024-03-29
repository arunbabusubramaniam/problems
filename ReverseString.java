/**
 * @author ASubramaniam
 * 
 * Problem:
 * Write a function that reverses a string. 
 * The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 */
public class ReverseString {

	public static char[] reverseString(char[] s) 
	{
		int start = 0;
		int end = s.length - 1;
		
		while ( start < end )
		{
			char temp = s [start];
			s[start] = s[end];
			s[end] = temp;
			start ++;
			end --;
		}
		return s;
	}
	
	public static void main ( String[] args )
	{
		char[] input = "hello".toCharArray();
		char[] output = reverseString(input);
		System.out.println( output );
	}
}
