package family_tree.writer;


import java.io.*;

public class FileHandler implements Writable {

    //Прошу прощения, что дублировала Ваш код! Со своим справиться не смогла... но на Вашем поняла механику работы! Спасибо!
    public void save (Serializable serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
           objectOutputStream.writeObject(serializable);
           System.out.println("\n Объект успешно сохранен");
       }
       catch (Exception e) {
           System.out.println("Ошибка сохранения: ");
           e.printStackTrace();
       }
   }


    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
