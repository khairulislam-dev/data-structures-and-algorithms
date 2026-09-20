package Project;

class BkashCompany {
    private static int totalBalance = 2000;
    
    public static void bkashCompany(int securityKey) {
        if (securityKey == 159753) {
            System.out.println("---------Bkash Company----------");
            System.out.println("Total Balance: " + Bkash.totalBalance + "$");
        }
    }
}
