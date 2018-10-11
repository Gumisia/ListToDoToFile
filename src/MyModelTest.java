import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyModelTest extends AbstractListModel<String> {


    private List<String> stringList;

    MyModelTest(){
        stringList = new ArrayList<>();
    }

    public void addElementList(String text){
        stringList.add(text);
        fireContentsChanged(this, 0, stringList.size());
    }

//    public void deleteElem(int index){
//        stringList.remove(index);
//        fireContentsChanged(this, 0, stringList.size());
//    }

    public void deleteList(){

        List<String> list = new ArrayList<>();

        stringList = list;

        fireContentsChanged(this, 0, stringList.size());
    }

    public void sortList(){

        Collections.sort(stringList);
    }

    @Override
    public int getSize() {

        return stringList.size();
    }

    @Override
    public String getElementAt(int index) {

        return stringList.get(index);
    }

    public void saveToFile() throws IOException {

        FileWriter writer = new FileWriter("/Users/admin/IdeaProjects/GUI-ĆWICZENIA/src/ZAD_23/out.txt");
        for(String str: stringList) {
            writer.write(str+"\n");
        }
        writer.close();

        System.out.println("Zapisano");
    }


}
