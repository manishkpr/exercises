package crackingcode.chapter4_TreesAndGraphs;

import org.junit.Test;

public class InOrderTraversal
{


  @Test
  public void test()
  {

  }

  public void inOrderTraversal(BNode n)
  {
    if(n!=null)
    {
      inOrderTraversal(n.left);
      System.out.println(n.value);
      inOrderTraversal(n.right);
    }
  }

  public void preOrderTraversal(BNode n)
  {
    if(n!=null)
    {
      System.out.println(n.value);
      inOrderTraversal(n.left);
      inOrderTraversal(n.right);
    }
  }

  public void postOrderTraversal(BNode n)
  {
    if(n!=null)
    {
      inOrderTraversal(n.left);
      inOrderTraversal(n.right);
      System.out.println(n.value);
    }
  }

}
