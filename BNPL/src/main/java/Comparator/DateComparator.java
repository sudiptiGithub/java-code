package Comparator;

import Model.Order;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class DateComparator implements Comparator<Order> {

    public int getDateDiff(String dateString, String currentDateString) {
        String[] dateToken = dateString.split("-");
        String[] currentDateToken = currentDateString.split("-");
        LocalDate date = LocalDate.of(Integer.valueOf(dateToken[0]),Integer.valueOf(dateToken[1]),Integer.valueOf(dateToken[2]));
        LocalDate currentDate = LocalDate.of(Integer.valueOf(currentDateToken[0]),Integer.valueOf(currentDateToken[1]),Integer.valueOf(currentDateToken[2]));
        Period difference = Period.between(date,currentDate);
        int dayDiff = (difference.getYears()*12) +(difference.getMonths()*30)+difference.getDays();
        return dayDiff;
    }

    @Override
    public int compare(Order o1, Order o2) {
        return getDateDiff(o2.getOrderDate(),o1.getOrderDate());
    }
}
