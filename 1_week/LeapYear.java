class LeapYear {
    /** Creates a method to determine if given year is a leap year */
    public static boolean isLeapYear (int year) {
        if (year % 400 == 0) {
            return true;
        } else if  (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main (String args[]) {
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2004));
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(2003));
        System.out.println(isLeapYear(2100));
    }
}