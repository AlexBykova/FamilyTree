package family_tree.tree;

import family_tree.human.Human;
import family_tree.human.HumanComparatorByAge;
import family_tree.human.HumanComparatorByGender;
import family_tree.human.HumanComparatorByName;
import study_group.StudentItterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tree implements Serializable, Iterable<Human>{
    private List<Human> peopleList;

    public Tree() {
        peopleList = new ArrayList<>();
    }

    public Human getPeopleBySnils (Float snils) {
        for (Human people: peopleList){
            if (people.getSnils() == snils){
                return people;
            }
        }
        return null;
    }

    public void addPeople(Human people) {
        peopleList.add(people);
    }

    public String getPeopleListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append ("Список членов семьи: \n");
        for (Human people: peopleList){
            stringBuilder.append(people);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void setNewChildren(Human children, Human parent1, Human parent2) {
        for (Human human: peopleList){
            if (human.getSnils() == parent1.getSnils()){
                List<Human> list = new ArrayList(parent1.getChildren());
                list.add(children);
                parent1.setChildren(list);
            }
            if (human.getSnils() == parent2.getSnils()){
                List<Human> list = new ArrayList(parent2.getChildren());
                list.add(children);
                parent2.setChildren(list);
            }
        }
        children.setParents(parent1,parent2);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanItterator(peopleList);
    }

    public void sortByName() {
        Collections.sort(peopleList, new HumanComparatorByName());
    }

    public void sortByAge() {
        Collections.sort(peopleList, new HumanComparatorByAge());
    }

    public void sortByGender() {
        Collections.sort(peopleList, new HumanComparatorByGender());
    }
}
