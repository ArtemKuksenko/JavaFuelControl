import java.io.*;

//https://metanit.com/java/tutorial/6.8.php
//https://metanit.com/java/tutorial/6.11.php

public class FileWork {
    public File dir = new File("~/IdeaProjects/FuelControl/src/main/java/files");
    public FileWork() {}

    public void writeFile(String name,String text) throws IOException {
        try(FileWriter writer = new FileWriter(name, false))
        {
            writer.write(text);
            writer.flush();
        }

    }

    public String readFile(String name){
        String result = "";
        try(FileInputStream fin=new FileInputStream(name)) {
            int i=-1;
            while((i=fin.read())!=-1){
                result +=(char)i;
//                System.out.print((char)i);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
