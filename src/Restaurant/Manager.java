/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurant;
//Imports

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

//Class
public class Manager implements Serializable {

    //Staff data:First name,last name,salary,hiring date ,seniority
    private String firstName;
    private String lastName;
    private int salary;
    private LocalDate hiringDate;
    private long seniority;

    //Lists of staff : cooks and waiters
    public List<Cook> listCooks = new LinkedList<>();
    public List<Waiter> listWaiters = new LinkedList<>();

    //List of objects that contains the daily status: Day count,date & profit
    public List<DayStatus> listFinishedDays = new LinkedList<>();
    //Attribute holding the day cound,starting from 1.Each time an object will
    //be added to the list,this attribute will increase
    int ziLucrata = 1;

    //Constructor
    public Manager(String firstName, String lastName, int salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        LocalDate ld = LocalDate.now();
        hiringDate = ld;
    }

    //Dayly profit & the restaurant's budget
    private double dailyProfit;
    private double restaurantBudget;

    //Food materials
    public int rawChicken;
    public int rawPotatoes;
    public int summerSaladIngredients;
    public int pickleSaladIngredients;

    //Food(cooked,ready to ve served)
    public int schnitzel;
    public int mashedPotatoes;
    public int frenchFries;
    public int chickenBreasts;
    public int summerSalad;
    public int pickleSald;
    public int bread;

    //Drinks
    public int sparklingWater;
    public int stillWater;
    public int cola;
    public int fanta;
    public int sprite;

    //Market prices for the products
    public double chickenMarketPrice = 10;
    public double potatoesMarketPrice = 3;
    public double summerSaladIngredientsMarketPrice = 3;
    public double pickleSaladIngredientsMarketPrice = 3;
    public double breadMarketPrice = 0.5;
    public double drinkMarketPrice = 1.5;

    //Selling prices for the food & drinks
    public double priceSchnitzel = 24.99;
    public double priceMashedPotatoes = 9.99;
    public double priceFrenchFries = 9.99;
    public double priceChickenBreast = 27.99;
    public double priceSummerSalad = 10.99;
    public double pricePickleSalad = 10.99;
    public double priceBread = 1.99;
    public double priceWater = 3.99;
    public double priceJuice = 4.99;

    //Salary getter
    public int getSalary() {
        return salary;
    }

    //Daily profit getter
    public double getDailyProfit() {
        return dailyProfit;
    }
    
    //Restaurant's budget getter
    public double getRestaurantBuget() {
        return restaurantBudget;
    }
    
    //Seniority getter
    public String getSeniority() {
        Period p = Period.between(hiringDate, LocalDate.now());
        return p.toString();
    }
     
    //Method:buying market products
    public void buyProduct(double n) {
        restaurantBudget -= n;
    }

    //Method:Increasing daily profit
    public void increasingDailyProfit(double n) {
        dailyProfit += n;
    }

    //Method:Increasing the restaurant's budget
    public void increasingRestaurantBudget(double n) {
        restaurantBudget += n;
    }

    //Buying methods:
    //Raw chicken
    public void buyChickem(int n) {
        rawChicken += n;
        buyProduct(n * chickenMarketPrice);
    }

    //Potatoes
    public void buyPotatoes(int n) {
        rawPotatoes += n;
        buyProduct(n * potatoesMarketPrice);
    }

    //Summer salad ingredients
    public void buySummerSaladIngredients(int n) {
        summerSaladIngredients += n;
        buyProduct(n * summerSaladIngredientsMarketPrice);
    }
    
    //Pickle salad ingredients
    public void buyPickleSaladIngredients(int n) {
        pickleSaladIngredients += n;
        buyProduct(n * pickleSaladIngredientsMarketPrice);
    }

    //Bread
    public void buyBread(int n) {
        bread += n;
        buyProduct(n * breadMarketPrice);
    }

    //Sparkling water
    public void buySparklingWater(int n) {
        sparklingWater += n;
        buyProduct(n * priceWater);
    }

    //Still water
    public void buyStillWater(int n) {
        stillWater += n;
        buyProduct(n * priceWater);
    }

    //Coca cola
    public void buyCocaCola(int n) {
        cola += n;
        buyProduct(n * priceJuice);
    }

    //Fanta
    public void buyFanta(int n) {
        fanta += n;
        buyProduct(n * priceJuice);
    }

    //Sprite
    public void buySprite(int n) {
        sprite += n;
        buyProduct(n * priceJuice);
    }

    //Method:ending the day
    public void endDay() {
        //Adding the day's stats to the list
        listFinishedDays.add(new DayStatus(ziLucrata, LocalDate.now(), dailyProfit));
        //Increasing day count
        ziLucrata++;
        //reset profit
        dailyProfit = 0;
    }

    //Method:Paying the staff's salaries
    public void paySalaries() {
        for (Cook b : listCooks) {
            restaurantBudget -= b.getSalary();
        }
        for (Waiter o : listWaiters) {
            restaurantBudget -= o.getSalary();
        }
        restaurantBudget -= salary;
    }

    //Returning the first+last name
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
