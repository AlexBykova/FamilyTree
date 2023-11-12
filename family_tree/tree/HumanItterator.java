package family_tree.tree;

import family_tree.human.Human;
import study_group.Student;

import java.util.Iterator;
import java.util.List;

public class HumanItterator implements Iterator<Human> {
    private  int index;
    private List<Human> peopleList;

    public HumanItterator(List<Human> peopleList) {
        this.peopleList = peopleList;
    }
    @Override
    public boolean hasNext() {return index < peopleList.size(); }

    @Override
    public Human next() {return peopleList.get(index++);}
}
