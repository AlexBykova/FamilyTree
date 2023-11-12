package family_tree;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.tree.Tree;
import family_tree.writer.FileHandler;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Tree familyTree = new Tree();
        Tree familyTree1 = new Tree();



        Human maxim = new Human(769375, "Максим Р", Gender.Male, getDate("04.11.1995"), null);
        Human maria = new Human(869476, "Мария Р", Gender.Female, getDate("16.12.1997"), null);
        Human vasilisa = new Human(316431, "Василиса Р.", Gender.Female, getDate("12.05.2017"), null);
        Human petr = new Human(455123, "Петр Р.", Gender.Male, getDate("11.09.2021"), null);

        Human mihail = new Human(531469, "Михаил Р.", Gender.Male, getDate("05.07.1975"), null);
        Human aleftina = new Human(562564, "Алефтина Р.", Gender.Female, getDate("06.01.1975"), null);

        Human evdakia = new Human(756478, "Евдакия М.", Gender.Female, getDate("03.03.1978"), null);
        Human artem = new Human(851346, "Артем М.", Gender.Male, getDate("29.04.1976"), null);

        familyTree.addPeople(maxim);
        familyTree.addPeople(maria);
        familyTree.addPeople(vasilisa);
        familyTree.addPeople(mihail);
        familyTree.addPeople(aleftina);
        familyTree.addPeople(evdakia);
        familyTree.addPeople(artem);
        familyTree.addPeople(petr);


        List items = Arrays.asList(vasilisa, petr);
        maxim.setChildren(items);
        maria.setChildren(items);

        List items1 = Arrays.asList(maxim);
        mihail.setChildren(items1);
        aleftina.setChildren(items1);

        List items2 = Arrays.asList(maria);
        evdakia.setChildren(items2);
        artem.setChildren(items2);


        vasilisa.setParents(maxim, maria);
        maxim.setParents(mihail, aleftina);
        maria.setParents(evdakia, artem);
        petr.setParents(maxim, maria);

        Human lilia = new Human (657485, "Лилия P.", Gender.Female, getDate("09.11.2023"), null);
        familyTree.addPeople(lilia);

        System.out.println(aleftina.getAge());

        System.out.println("Сортировка по возрасту: ");
        familyTree.sortByAge();
        System.out.println(familyTree.getPeopleListInfo());

        System.out.println("Сортировка по имени: ");
        familyTree.sortByName();
        System.out.println(familyTree.getPeopleListInfo());

        System.out.println("Сортировка по полу: ");
        familyTree.sortByGender();
        System.out.println(familyTree.getPeopleListInfo());

//        familyTree.setNewChildren(lilia, maxim, maria);
//        System.out.println(lilia.getInfo());
//        System.out.println(maxim.getInfo());
//        System.out.println(maria.getInfo());

//        System.out.println(human1);
//
//        System.out.println(evdakia.getInfo());
//        System.out.println("----------------");
//        System.out.println(human1.getSnils());
//        System.out.println("----------------");
//
//        System.out.println(familyTree.getPeopleListInfo());
//
//
//        System.out.println("============");
//        System.out.println(familyTree.getPeopleBySnils(769375F));
//        System.out.println("~~~~~~~~~~~~~~");
//        save(familyTree);
//        familyTree1 = load();
//        System.out.println(familyTree1.getPeopleListInfo());

    }

    private static void save(Tree familyTree) {
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_tree/writer/tree.txt";
        fileHandler.save(familyTree, filePath);
    }
    private static Tree load (){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/family_tree/writer/tree.txt";
        return (Tree) (fileHandler.read(filePath));
    }
    public static LocalDate getDate(String date) {
        LocalDate ld = LocalDate.parse(date, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy") );
        return ld;    }

}

