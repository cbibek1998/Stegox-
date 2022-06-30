/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examplestego;

/**
 *
 * @author cbibe
 */
import java.io.File;
import javax.swing.filechooser.FileFilter;

class MyTextFileFilter
  extends FileFilter
{
  public boolean accept(File file)
  {
    return (file.isDirectory()) || (file.getAbsolutePath().endsWith(".txt"));
  }
  
  public String getDescription()
  {
    return "Text Documents (*.txt)";
  }
}
