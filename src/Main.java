import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        var goodsList = VendingMachine.fillGoods();
        VendingMachine vm = new VendingMachine(0, goodsList);
        print(goodsList);
        while (true) {
            var productForSell = goodsList.stream()
                    .filter(e -> e.getPrice() <= vm.getMoney())
                    .toList();
            getAction(goodsList, vm, productForSell);
        }
    }

    public static void print(List<Goods> products) {
        System.out.println("\n+-----+----------------+-------+");
        System.out.println("|  #  |      Name      | Price |");
        System.out.println("+-----+----------------+-------+");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("|  %-2s | %-14s |  %-4s |%n",
                    i + 1, products.get(i).getName(), products.get(i).getPrice());
        }
        System.out.println("+-----+----------------+-------+");
    }

    public static void printMoney(VendingMachine vm) {
        System.out.println("+-----------------------+------+");
        System.out.printf("|          Money        |  %-3s |%n", vm.getMoney());
        System.out.println("+-----------------------+------+");
    }

    public static int chooseAction(List<Goods> productForSell) {
        String input;
        while (true) {
            printActions(productForSell);
            System.out.print("Enter number of action: ");
            try {
                input = new Scanner(System.in).nextLine();
                return checkAction(input, productForSell);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printActions(List<Goods> productForSell) {
        System.out.println("Choose Action:");
        System.out.println("1  - Put a coin to the vending machine");
        if (productForSell.size() > 0) {
            for (int i = 0; i < productForSell.size(); i++) {
                System.out.printf("%d  - Buy %s%n", i + 2, productForSell.get(i).getName());
            }
        }
    }

    public static int checkAction(String str, List<Goods> productForSell) throws Exception {
        int input = Integer.parseInt(str);
        if (input < 1 || input > productForSell.size() + 1)
            throw new Exception("Incorrect action");
        return input;
    }

    public static void getAction(List<Goods> goods, VendingMachine vm, List<Goods> productForSell) {
        switch (chooseAction(productForSell)) {
            case 1 -> {
                vm.takeMoney();
                print(goods);
                printMoney(vm);
            }
            case 2 -> {
                vm.sellProduct(productForSell.get(0));
                print(goods);
                printMoney(vm);
            }
            case 3 -> {
                vm.sellProduct(productForSell.get(1));
                print(goods);
                printMoney(vm);
            }
            case 4 -> {
                vm.sellProduct(productForSell.get(2));
                print(goods);
                printMoney(vm);
            }
            case 5 -> {
                vm.sellProduct(productForSell.get(3));
                print(goods);
                printMoney(vm);
            }
            case 6 -> {
                vm.sellProduct(productForSell.get(4));
                print(goods);
                printMoney(vm);
            }
        }
    }
}
