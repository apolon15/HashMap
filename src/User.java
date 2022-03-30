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

    String city;

    public User(String city, int age) {
        this.city = city;
        this.age = age;
    }

    public static int age;

    // (Grodno, 10).compareTo((Minsk", 50)) == 0         < 0    >0
    @Override
    public int compareTo(Object o) { // 0
        User user1 = (User) o;
        if (this.getCity().equals("Minsk")) { //Grodno.equals(Minsk)
            return -100;
        }
        if (user1.getCity().equals("Minsk")) { // ("Minsk", 50)
            return 100;
        }
        if (this.getCity().equals("Brest")) {
            return -100;
        }
        if (user1.getCity().equals("Brest")) {
            return 100;
        }


        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}

