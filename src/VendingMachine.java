import java.util.*;

public class VendingMachine {
    private int money;

    public VendingMachine(int money, List<Goods> goods) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static List<Goods> fillGoods() {
        List<Goods> goods = List.of(Goods.values());
        while (goods.size() != 5) {
            for (int i = 0; i < Goods.values().length; i++) {
                goods.add(i, Goods.values()[i]);
            }
        }
        return goods;
    }

    public void sellProduct(Goods g) {
        money -= g.getPrice();
        System.out.printf("%nYou bought %s%n%n", g.getName());
    }

    public void takeMoney() {
        System.out.print("\nPut a coin to the vending machine(1, 3, 5, 10, 20, 50): ");
        String str = new Scanner(System.in).nextLine();
        try {
            int coin = checkMoneyInput(str);
            money += coin;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int checkMoneyInput(String str) throws Exception {
        int input = Integer.parseInt(str);
        for (int i = 0; i < Coin.values().length; i++) {
            if (input == Coin.values()[i].getRate()) {
                return input;
            }
        }
        throw new Exception("No such coin rate");
    }

}


