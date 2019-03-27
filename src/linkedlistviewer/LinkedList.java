package linkedlistviewer;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
      first = null;

   }

   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;

   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addfirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }

   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }   

   public static void draw(Graphics2D g2)
   {
             
      // TODO: Draw all nodes
     for (int i = 0; i < count; i++)
     {

         Rectangle node = new Rectangle((int)(points.get(i).getX()), (int)(points.get(i).getY()), 30, 30);
         g2.draw(node);
     }

   }

          
   public static int count = 0;  
   public static ArrayList<Point2D.Double> points;
   private Node first;

   private class Node
   {

      public Node()
      {
         // TODO: Determine coordinates for this node
         if (LinkedList.count == 0)
         {
             LinkedList.points.add(new Point2D.Double(20, 20));
             LinkedList.count++;
         }
         else
         {
             LinkedList.points.add(new Point2D.Double(30 + points.get(LinkedList.count).getX(), 30 + points.get(LinkedList.count).getY()));
             LinkedList.count++;
         }
         
      }
   

   public Object data;
   public Node next;
   // TODO: Instance fields for coordinates(Done)

    
  }
  
}