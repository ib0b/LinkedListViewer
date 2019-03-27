package linkedlistviewer;

import javax.swing.JFrame;

/**
   Displays a linked list.
*/
public class LinkedListViewer
{
   public static void main(String args[])
   {
      JFrame frame = new LinkedListFrame();
      frame.setTitle("LinkedListViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}