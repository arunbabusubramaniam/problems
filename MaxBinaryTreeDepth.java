package com.arun.tree.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MaxBinaryTreeDepth
{

  public TreeNode stringToTreeNode(String input)
  {
    input = input.trim();
    input = input.substring( 1, input.length() - 1 );
    if ( input.length() == 0 )
    {
      return null;
    }

    String[] parts = input.split( "," );
    String item = parts[0];
    TreeNode root = new TreeNode( Integer.parseInt( item ) );
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add( root );

    int index = 1;
    while ( !nodeQueue.isEmpty() )
    {
      TreeNode node = nodeQueue.remove();

      if ( index == parts.length )
      {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if ( !item.equals( "null") )
      {
        int leftNumber = Integer.parseInt( item );
        node.left = new TreeNode( leftNumber );
        nodeQueue.add( node.left );
      }

      if ( index == parts.length )
      {
        break;
      }

      item = parts[ index++ ];
      item = item.trim();
      if ( !item.equals( "null" ) )
      {
        int rightNumber = Integer.parseInt( item );
        node.right = new TreeNode( rightNumber );
        nodeQueue.add( node.right );
      }
    }
    return root;
  }

  public int maxDepth( TreeNode root )
  {
    if ( root == null )
      return 0;

    int numOfNodesInPath = 1;
    int numOfNodesInLeftPath = 0;
    int numOfNodesInRightPath = 0;

    if ( root.left == null && root.right == null )
      return numOfNodesInPath;
    if ( root.left != null )
    {
      numOfNodesInLeftPath = maxDepth( root.left, numOfNodesInPath );

    }
    if ( root.right != null )
    {
      numOfNodesInRightPath = maxDepth( root.right, numOfNodesInPath );

    }
    numOfNodesInPath = Math.max( numOfNodesInLeftPath, numOfNodesInRightPath );

    return numOfNodesInPath;
  }

  private int maxDepth( TreeNode root, int numOfNodesInPath ) {
    if ( root == null )
      return numOfNodesInPath;
    numOfNodesInPath++;
    int numOfNodesInLeftPath = 0;
    int numOfNodesInRightPath = 0;

    if ( root.left == null && root.right == null )
      return numOfNodesInPath;
    if ( root.left != null ) {
      numOfNodesInLeftPath = maxDepth( root.left, numOfNodesInPath );

    }
    if ( root.right != null ) {
      numOfNodesInRightPath = maxDepth( root.right, numOfNodesInPath );

    }
    numOfNodesInPath = Math.max( numOfNodesInLeftPath, numOfNodesInRightPath );

    return numOfNodesInPath;
  }

  /*
   * Inputs for testing
   * 
   * [2,null,3,null,4,null,5,null,6]
   * [2,4,3,59,4,34,5,49,6,83,78,1,23,13]
   */
  public static void main( String[] args ) throws IOException
  {
    BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
    MaxBinaryTreeDepth mainClass = new MaxBinaryTreeDepth();
    String line;
    while ( ( line = in.readLine() ) != null )
    {
      TreeNode root = mainClass.stringToTreeNode( line );

      int ret = mainClass.maxDepth( root );

      String out = String.valueOf( ret );

      System.out.print( out );
    }
  }

  class TreeNode
  {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode( int x )
    {
      val = x;
    }
  }
}