package linkedlistviewer;


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class LinkedListComponent extends JComponent
{
   public LinkedListComponent()
   {
      list = new LinkedList();
      newIterator();
      next = 1;
   }

   public void newIterator()
   {
      iterator = (LinkedListIterator) list.listIterator();
      repaint();
      removeOk = false;
   }

   public void next()
   {
      if (iterator.hasNext())
      {
         iterator.next();
         repaint();
         removeOk = true;
      }
   }
   
   public void add()
   {
      iterator.add(new Integer(next));
      next++;
      repaint();
      removeOk = false;
   }

   public void remove()
   {
      if (removeOk)
      {
         iterator.remove();
         repaint();
         removeOk = false;
      }
   }
  
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      list.draw(g2);
      if (iterator != null)
         iterator.draw(g2);
   }
   private LinkedList list;
  private LinkedListIterator iterator;
   private int next = 1;
   private boolean removeOk = false;
}