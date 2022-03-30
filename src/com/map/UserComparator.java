package com.map;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {






    @Override
    public int compare(User o1, User o2) {
        return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
    }
}
