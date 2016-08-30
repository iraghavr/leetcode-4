package backtracking;

import java.util.LinkedList;
import java.util.List;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * */
// TO_TEST
public class Permutations 
{
    public List<List<Integer>> permute( int[] nums ) 
    {
    	List<List<Integer>> allPerms = new LinkedList<>();
    	List<Integer> onePerm = new LinkedList<>();
    	
    	generatePerms( allPerms, onePerm, nums, 0 );
    	
    	return allPerms;
    }
    
    private void generatePerms( List<List<Integer>> allPerms, List<Integer> onePerm, int[] nums, int startPos )
    {
    	if ( startPos == nums.length )
    	{
    		allPerms.add( new LinkedList<>( onePerm ) );
    		return;
    	}
    	
    	for ( int i = startPos; i < nums.length; i++ )
    	{
    		swap( nums, i, startPos );
    		onePerm.add( nums[i] );
    		generatePerms( allPerms, onePerm, nums, i + 1 );
    		onePerm.remove( onePerm.size( ) - 1 );
    		swap( nums, i, startPos );
    	}
    }
    
    private void swap( int[] nums, int pos1, int pos2 )
    {
    	int pos1NumBuffer = nums[pos1];
    	nums[pos1] = nums[pos2];
    	nums[pos2] = pos1NumBuffer;
    }
    
}
