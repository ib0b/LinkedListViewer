package linkedlistviewer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import  java.awt.Dimension;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import  javax.swing.JButton;
import  javax.swing.JFrame;
import  javax.swing.JPanel;

public class LinkedListFrame extends JFrame
{
   public LinkedListFrame()
   {
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      JPanel panel = new JPanel();
      panel.add(makeButtonPanel ());
      component = new LinkedListComponent();
      component.setPreferredSize(new Dimension(
            COMPONENT_WIDTH, COMPONENT_HEIGHT));
      panel.add(component);
      add(panel);
   }

   private JPanel makeButtonPanel()
   {
      JPanel panel = new JPanel();

      addButton = new JButton("Add");
      addButton.addActionListener(new AddButtonListener());
      panel.add(addButton);

      newButton = new JButton("New Iter");
      newButton.addActionListener(new NewButtonListener());
      panel.add(newButton);

      nextButton = new JButton("Next");
      nextButton.addActionListener(new NextButtonListener());
      panel.add(nextButton);

      removeButton = new JButton("Remove");
      removeButton.addActionListener(new RemoveButtonListener());
      panel.add(removeButton);

      return panel;
   }

   class AddButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         component.add();
      }
   }
   
   class NewButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         component.newIterator();
      }
   }

   class NextButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         component.next();
      }
   }

   class RemoveButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         component. remove();
      }
   }
   
  

   private JButton newButton;
   private JButton nextButton;
   private JButton addButton;
   private JButton removeButton;
   private LinkedListComponent component;

   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 400;
   private static final int COMPONENT_WIDTH = 500;
   private static final int COMPONENT_HEIGHT = 350;
}