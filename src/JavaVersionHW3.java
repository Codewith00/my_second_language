public class JavaVersionHW3 {

    public static void main(String[] args) {

        String firstName = "Ksusha";
        String lastName = "Pe";
        Double height = 50000.0;
        Float weight = 35f;
        String child = "�������";
        Boolean isChild = height < 150 & weight < 40;
        if (isChild) {
            System.out.println("��� �������?" + isChild);
            child = "�������";
        } else {
            System.out.println("��� �������?" + isChild);
            child = "�������� ���";
        }

        String info = firstName + " " + lastName + " " + height + " " + weight + " " + child;
        System.out.println(info);
        height = 10d;
        isChild = height < 150 & weight < 40;
        if (isChild) {
            System.out.println("��� �������?" + isChild);
            child = "�������";
        } else {
            System.out.println("��� �������?" + isChild);
            child = "�������� ���";
        }

        info = firstName + " " + lastName + " " + height + " " + weight + " " + child;
        System.out.println(info);
    }
}
