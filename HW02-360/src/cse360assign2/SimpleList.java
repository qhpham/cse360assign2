/* Name: Quyen Pham
 * Class ID: 1214554523
 * Assignment: 02
 * Description: This program creates an integer array. 
 * The methods in this class allows the user to add 
 * and remove integers, search for an integer, and 
 * display the array.
 * Repository: https://github.com/qhpham/cse360assign2.git
 */

package cse360assign2;

/*
 * This class creates an integer array. 
 * It contains methods that manipulate the contents of the array. 
 * It also contains methods that can display the array, 
 * return the number of elements, and find the index of an element.
 */
public class SimpleList 
{
	private int[] list;
	private int count;
	private int full;
	
	/*
	 * This is the class constructor. It initializes the list array and count.
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
		full = 10;
	}
	
	/*
	 * This method adds an integer to the list array.
	 * @param newElement the integer to be added to the first index of the array
	 */
	public void add(int newElement)
	{
		//increase size of array if full by 50%
		if (count == full)
		{
			int[] temp = new int[count + count/2];
			
			//copy contents of the existing array into new one
			for (int index = 0; index < list.length; index++)
			{
				temp[index] = list[index];
			}
			
			list = temp;
			full = temp.length;
		}
		
		//moves each elements into the next index
		for (int index = count; index > 0; index--) 
		{
			list[index] = list[index - 1];
		}
		
		list[0] = newElement;
		count++;
	}
	
	/*
	 * This method removes an integer from the list array.
	 * @param removeNum the integer to be removed from the array
	 */
	public void remove(int removeNum)
	{
		boolean found = false;
		
		for (int index = 0; index < count; index++)
		{
			if (list[index] == removeNum)
			{
				//moves each element after the removed element to the left
				for (int listIndex = index; listIndex < count - 1; listIndex++) 
				{
					list[listIndex] = list[listIndex + 1];
				}
				
				count--;
				found = true;
			}
		}
		
		//reduces size of array if it is over 25% empty 
		if (count < (.75 * full) && found == true && full > 1)
		{
			int[] temp = new int[full - 1];
			
			//copy contents of the existing array into new one
			for (int index = 0; index < temp.length; index++)
			{
				temp[index] = list[index];
			}
			
			list = temp;
			full--;
		}
	}
	
	/*
	 * This method returns the number of elements in the array.
	 * @return count the number of elements in the array
	 */
	public int count()
	{
		return count;
	}
	
	/*
	 * This method returns the first element in the array
	 * @return first 	the first element in the array
	 */
	public int first()
	{
		int first;
		
		if (count > 0)
		{
			first = list[0];
		}
		else
		{
			first =  -1;
		}
		return first;
	}
	
	/*
	 * This method returns the last element in the array
	 * @return last 	the last element in the array
	 */
	public int last()
	{
		int last;
		if (count > 0)
		{
			last = list[count - 1];
		}
		else
		{
			last = -1;
		}
		return last;
	}
	
	/*
	 * This method returns the size of the array
	 * @return full 	the full size of the array
	 */
	public int size() 
	{
		return full;
	}
	
	/*
	 * This method displays all the elements in the array with spaces between each one
	 * @return result the elements of the array in a string
	 */
	public String toString()
	{
		String result = "";
		
		for (int index = 0; index < count; index++)
		{
			result += list[index];
			
			//adds a space after each element except the last one
			if (index < count - 1)
			{
				result += " ";
			}
		}
		
		return result;
	}
	
	/*
	 * This method searches for a specified integer and returns the index of the integer.
	 * The method returns -1 if the integer is not found.
	 * @param findNum the integer to be found
	 * @return foundIndex the index of the element that the method is searching for
	 */
	public int search(int findNum)
	{
		int foundIndex = -1;
		for (int index = 0; index < count; index++)
		{
			if (list[index] == findNum)
			{
				foundIndex = index;
			}
		}
		
		return foundIndex;
	}

}

