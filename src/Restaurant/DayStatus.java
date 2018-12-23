package Restaurant;

//Imports
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

//Class
public class DayStatus implements Serializable {
    //Day count
    int dayCount;
    //Date recorder
    public LocalDate date;
    //Daily profit
    public double profit;

    //Constructor
    public DayStatus(int dayCount, LocalDate date, double profit) {
        this.dayCount = dayCount;
        this.date = date;
        this.profit = profit;
    }

    //Returning the day's data
    @Override
    public String toString() {
        return "Day " + dayCount + " : " + date.format(DateTimeFormatter.ofPattern("dd MMMM YYYY", Locale.US)) + " - Profit " + profit + "$";
    }
}
