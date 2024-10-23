package exercises;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

public class BankAccount {
    private String accountHolderName;
    private long currentBalance;
    private double monthlyInterestRate;
    private List<String> transactionList;
    private Integer withdrawalCount;

    private static final int MAX_WITHDRAWALS = 3;
    private int updateMonthlyInterest;
    private int INTEREST_UPDATE_DATE = 25;

    public BankAccount(){
        this.transactionList = new ArrayList<>();
        this.withdrawalCount = 0;
        this.updateMonthlyInterest = -1;
    }

    //tự động cập nhật tiền lãi
    private void calculateMonthlyInterest() {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH);

        //check đã tới ngày tính lãi : 25
        if(currentMonth != updateMonthlyInterest && calendar.get(Calendar.DAY_OF_MONTH) > INTEREST_UPDATE_DATE){
            double interest = currentBalance * (monthlyInterestRate / 100);
            currentBalance += interest;

            //reset
            withdrawalCount = 0;
            updateMonthlyInterest = currentMonth;
        }
    }

    //format date
    private String getDateTrans(){
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd");
        return simpleFormatter.format(new Date());
    }

    //thông tin số dư hiện tại
    public void printCurrentBalance(){
        System.out.println("Số dư hiện tại: " + this.currentBalance);
    }

    //gửi tiền
    public void deposit(double amount) {
        calculateMonthlyInterest();

        currentBalance += amount;
        transactionList.add("Deposit - " + amount + " VNĐ - " + getDateTrans());
    }

    //rút tiền
    public void withDrawal(double amount){
        calculateMonthlyInterest();
        if(withdrawalCount >= MAX_WITHDRAWALS){
            System.out.println("Đã  đạt tới giới hạn rút tiền tháng này");
        }
        else if(currentBalance >= amount){
            currentBalance -= amount;
            withdrawalCount++;
            transactionList.add("Withdraw - " + amount + " VNĐ - " + getDateTrans());
        }
        else {
            System.out.println("Không đủ số dư");
        }
    }

    //lịch sử giao dịch
    public void printTransHis(){
        for (String s : transactionList) {
            System.out.println(s);
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount bankAccount = new BankAccount();

        System.out.print("Tạo tài khoản mới: ");
        bankAccount.setAccountHolderName(sc.nextLine());
        System.out.print("Số dư ban đầu: ");
        bankAccount.setCurrentBalance(sc.nextLong());

        sc.nextLine();

        while(true){
            System.out.println("1.Gửi tiền");
            System.out.println("2.Rút tiền");
            System.out.println("3.Lịch sử giao dịch");
            System.out.println("4.Số dư hiện tại");
            System.out.println("Q.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    System.out.print("Nhập số tiền cần gửi: ");
                    long depositAmount = sc.nextLong();
                    bankAccount.deposit(depositAmount);
                    break;

                case "2":
                    System.out.println("Nhập số tiền cần rút: ");
                    long withdrawAmount = sc.nextLong();
                    bankAccount.withDrawal(withdrawAmount);
                    break;

                case "3":
                    bankAccount.printTransHis();
                    break;

                case "4":
                    bankAccount.printCurrentBalance();
                    break;

                case "Q":
                    System.out.println("\nKết thúc yêu cầu");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
