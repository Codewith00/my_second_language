import java.util.ArrayList;
import java.util.Random;

public class JavaVersionHW7 {
    public static void main(String[] Args) {

        TV test = new TV("TEST", "test", 99.9);
        TV test1 = new TV("TEST", "test", 10.0);
        System.out.println(test1.getListChannels());
        System.out.println(test.getListChannels());
        test1.channelUP();
        test1.volumeDown(20);
        test1.channelDown();
        test1.channelDown();
        test1.channelDown();
        test.volumeUP(50);
        test.selectChannel(5);
    }
}


class TV {
    private String mark;
    private String model;
    private Double size;
    private Boolean power = false;
    private ArrayList<String> listChannels;
    private int currentVolume = 15;
    private int currentChannel = 0;
    private int amountChannelsInt;
    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;
    private static final int SMALL_SIZE = 32;
    private static final int MEDIUM_SIZE = 43;

    public TV(String mark, String model, Double size) {
        this.mark = mark;
        this.model = model;
        this.size = size;
        amountChannelsInt = getAmountChannelsInt();
        listChannels = Channels.shuffleAndSlice(Channels.listChannels(), amountChannelsInt);

    }

    private int getAmountChannelsInt() {
        if (size < SMALL_SIZE) {
            return 5;
        } else {
            if (size < MEDIUM_SIZE) {
                return 7;
            } else return 10;
        }
    }

    public void power() {
        power = !power;
        if (power) {
            System.out.println("Телевизор " + model + " включается");
        } else {
            System.out.println("Телевизор " + model + " выключается");
        }
    }

    public void volumeUP(int volume) {
        currentVolume += volume;
        if (currentVolume > MAX_VOLUME) currentVolume = 100;
        System.out.println("Текущая громкость: " + currentVolume);
    }

    public void volumeDown(int volume) {
        currentVolume -= volume;
        if (currentVolume < MIN_VOLUME) currentVolume = 0;
        System.out.println("Текущая громкость: " + currentVolume);
    }

    public void selectChannel(int channel) {
        currentChannel = channel;
        if (currentChannel < 0) currentChannel = 0;
        else if (currentChannel > amountChannelsInt - 1) currentChannel = amountChannelsInt - 1;
        System.out.println("Текущий канал - " + listChannels.get(currentChannel) + " НОМЕР: " + currentChannel);
    }

    public void channelUP() {
        if (!power) power();
        currentChannel++;
        if (currentChannel > amountChannelsInt - 1) currentChannel = 0;
        System.out.println("Текущий канал - " + listChannels.get(currentChannel) + " НОМЕР: " + currentChannel);
    }

    public void channelDown() {
        if (!power) power();
        currentChannel--;
        if (currentChannel < 0) currentChannel = amountChannelsInt - 1;
        System.out.println("Текущий канал - " + listChannels.get(currentChannel) + " НОМЕР: " + currentChannel);
    }

    public ArrayList<String> getListChannels() {
        return listChannels;
    }

    public static class Channels {
        public static ArrayList<String> listChannels() {
            ArrayList<String> list = new ArrayList<>();
            list.add("NEWS");
            list.add("2x2");
            list.add("porn");
            list.add("SolovevTV");
            list.add("PutinTV");
            list.add("NavalniiFreeDome");
            list.add("Spring");
            list.add("Sport");
            list.add("RUTV");
            list.add("Covid-19");
            list.add("Armagedon");
            list.add("SpasTV");
            list.add("TNT");
            list.add("STS");
            list.add("Ksuha_lohTV");
            return list;
        }

        public static ArrayList<String> shuffleAndSlice(ArrayList<String> list, int slice) {
            ArrayList<String> listReturn = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < slice; i++) {
                listReturn.add(i, list.get(rand.nextInt(0, slice)));
            }
            return listReturn;
        }
    }
}
