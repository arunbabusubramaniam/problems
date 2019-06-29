/**
 * @author ASubramaniam
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 */
public class ReverseVowelsInString {

	public static void main(String[] args) {
		String input = "leetcode";
		String outArr = reverse(input);
		System.out.println(outArr);
	}

	private static String reverse(String arr) {
		char[] inArr = arr.toCharArray();
		int start = 0;
		int end = inArr.length - 1;
		String vowel = "AEIOUaeiou";

		while ( start < end ) {
			boolean startFlag = false;
			boolean endFlag = false;
			if( vowel.indexOf( inArr[ start ] ) != -1 ) 
			{
				startFlag = true;
			} 
			else
			{
				start ++;
			}
			if( vowel.indexOf( inArr[ end ] ) != -1 )
			{
				endFlag = true;
			} 
			else
			{
				end --;
			}
			if ( startFlag && endFlag)
			{
				char temp = inArr[ start ];
				inArr[ start ] = inArr[ end ];
				inArr[ end ] =  temp;
				start ++;
				end --;
			}
		}
		return new String ( inArr );
	}
}
