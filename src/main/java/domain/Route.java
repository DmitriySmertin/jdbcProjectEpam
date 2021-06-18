package domain;

public class Route {
    public  Route(){};
    private static String name;
    private static int numberRout;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNumberRout() {
        return numberRout;
    }

    public static void setNumberRout(int numberRout) {
        Route.numberRout = numberRout;
    }
}
