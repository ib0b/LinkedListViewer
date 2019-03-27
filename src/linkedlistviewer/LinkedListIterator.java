package linkedlistviewer;

import java.awt.Graphics2D;
import java.util.NoSuchElementException;

public class LinkedListIterator implements ListIterator
{
   /**
      Constructs an iterator that points to the front
      of the linked list.
   */
   public LinkedListIterator()
   {
      position = null;
      previous = null;
   }
   private class Node
   {  
      public Object data;
      public Node next;
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
      Moves the iterator past the next element.
      @return the traversed element
   */
   public Object next()
   {
      if (!hasNext())
         throw new NoSuchElementException();
      previous = position; // Remember for remove
   
      if (position == null)
         position = first;
      else
         position = position. next;
   
      return position.data;
   }

   /**
      Tests if there is an element after the iterator
      position.
      @return true if there is an element after the iterator
      position
   */
   public boolean hasNext()
   {
      if (position == null)
         return first != null;
      else
         return position.next != null;
   }

   /**
      Adds an element before the iterator position
      and moves the iterator past the inserted element.
      @param element the element to add
   */
   public void add(Object element)
   {
      if (position == null)
      {
         addfirst(element);
         position = first;
      }
      else
      {
         Node newNode = new Node();
         newNode.data = element;
         newNode.next = position.next;
         position.next = newNode;
         position = newNode;
      }
      previous = position;
   }
   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removefirst()
   {  
      if (first == null) 
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }
   /**
      Removes the last traversed element. This method may
      only be called after a call to the next() method.
   */
   public void remove()
   {
      if (previous == position)
         throw new IllegalStateException();
   
      if (position == first)
      {
         removefirst();
      }
      else
      {
         previous.next = position.next;
      }
         position = previous;
      }
          
      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position. data = element;
      }
   
      public void draw(Graphics2D g2)
      {
         // TODO: Draw iterator
         LinkedList.draw(g2);
      }
     
      private Node position;
      private Node previous;
      private Node first;
   }