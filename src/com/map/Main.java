package com.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import jdk.nashorn.internal.ir.annotations.Immutable;

public class Main {
    public static HashMap<String, List<String>> translator = new HashMap<>();
    public static HashMap<String, Integer> statistic = new HashMap<>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("minsk", 4, 8));
        users.add(new User("grodno", 1, 5));
        users.add(new User("moskow", 5, 3));
        users.add(new User("vit", 3, 2));
        users.add(new User("brest", 2, 6));
        users.add(new User("minsk", 8, 7));
        System.out.println(users);
        new Integer(10).compareTo(new Integer(30));
        User user1 = new User("Minsk", 10, 1);
        User user2 = new User("Minsk", 20, 3);
        if (user1.compareTo(user2) > 0) {//user1<user2=-1
            System.out.println("Рейтинг больше у пользователя "+user1.toString() );
        }if(user1.rang>user2.rang){
            System.out.println("Рейтинг больше у пользователя "+user1.toString() );
        }
        Collections.sort(users);
        Collections.sort(users,new UserComparator());
//        init();
//        int choise = showMenu();
//        switch (choise) {
//            case 1:
//                rusToEngl();
//                break;
//            case 3:
//                remove();
//                break;
//        }
    }

    private static void remove() throws IOException {
        System.out.println("ВВедите слово (англ):");
        String userWord = reader.readLine();
        if (translator.containsKey(userWord.toLowerCase())) {
            System.out.println(userWord + " - " + translator.get(userWord.toLowerCase()));
            System.out.println("Нажмите 1 для удаления всей коллекции\n2 - введите порядковый номер элемента для удаления");
            int userChoise = Integer.parseInt(reader.readLine());
            switch (userChoise) {
                case 1:
                    translator.remove(userWord.toLowerCase());
                    break;
                case 2:
                    int deleteIndex = Integer.parseInt(reader.readLine());
                    List<String> list = translator.get(userWord.toLowerCase());
                    int index = 0;
                    Iterator<String> each = list.iterator();
                    boolean removed = false;
                    while (each.hasNext()) {
                        if (index == deleteIndex) {
                            each.remove();
                            removed = true;
                        }
                        index++;
                    }
                    if (removed) {
                        System.out.println("Удален!!!");
                    }
            }


        } else {
            System.out.println("Извините, слово не найдено...");
        }
    }

    private static void rusToEngl() throws IOException {
        System.out.println("ВВедите слово (англ):");
        String userWord = reader.readLine();
        if (translator.containsKey(userWord.toLowerCase())) {
            System.out.println(userWord + " - " + translator.get(userWord.toLowerCase()));
            int count = statistic.get(userWord.toLowerCase());
            statistic.put(userWord.toLowerCase(), ++count);


        } else {
            System.out.println("Извините, перевод не найден...");
        }
    }

    private static int showMenu() throws IOException {

        System.out.println("Выберети операцию: \n1 - перевод англ - русский" +
                "\n2 - изменить слово\n3 - удалить \n4 - заменить");
        return Integer.parseInt(reader.readLine());

    }

    private static void init() {
        ArrayList<String> hello = new ArrayList<>();
        hello.addAll(Arrays.asList("привет", "добрый день", "здравствуйте"));
        translator.put("hello", hello);
        statistic.put("hello", 0);
        ArrayList<String> bye = new ArrayList<>();
        bye.addAll(Arrays.asList("пока", "до встречи"));
        translator.put("bye", bye);
        statistic.put("bye", 0);
        ArrayList<String> ok = new ArrayList<>();
        ok.addAll(Arrays.asList("хорошо", "ладно", "ok"));
        translator.put("ok", ok);
        statistic.put("ok", 0);
    }

}

class User implements Comparable {


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int rang;
    String city;

    public User(String city, int age, int rang) {
        this.city = city;
        this.age = age;
        this.rang = rang;
    }

    int age;

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    // (Grodno, 10).compareTo((Minsk", 50)) == 0         < 0    >0
    @Override
    public int compareTo(Object o) { // 0
        User user1 = (User) o;
        User user0 = this;
        return new Integer(user1.rang).compareTo(user0.rang);
    }


    @Override
    public String toString() {
        return "User{" +
                "city='" + city + '\'' +
                ", age=" + age + ", rang=" + rang+
                '}';
    }
}




