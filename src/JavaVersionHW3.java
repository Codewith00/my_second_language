public class JavaVersionHW3 {

    public static void main(String[] args) {

        String firstName = "Ksusha";
        String lastName = "Pe";
        Double height = 50000.0;
        Float weight = 35f;
        String child = "Личинка";
        Boolean isChild = height < 150 & weight < 40;
        if (isChild) {
            System.out.println("Это ребенок?" + isChild);
            child = "Личинка";
        } else {
            System.out.println("Это ребенок?" + isChild);
            child = "Взрослый лох";
        }

        String info = firstName + " " + lastName + " " + height + " " + weight + " " + child;
        System.out.println(info);
        height = 10d;
        isChild = height < 150 & weight < 40;
        if (isChild) {
            System.out.println("Это ребенок?" + isChild);
            child = "Личинка";
        } else {
            System.out.println("Это ребенок?" + isChild);
            child = "Взрослый лох";
        }

        info = firstName + " " + lastName + " " + height + " " + weight + " " + child;
        System.out.println(info);
    }
}
