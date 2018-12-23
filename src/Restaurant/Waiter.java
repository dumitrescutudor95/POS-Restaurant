
package Restaurant;

//Imports
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

//Class
public class Waiter implements Serializable {

    //Manager
    Manager m;

    //Staff data:First name,last name,salary,hiring date ,seniority
    private String firstName;
    private String lastName;
    private int salary;
    private LocalDate hiringDate;
    private long seniority;

    //Statistics: how many items each waiter served
    public int soldSchnitzel;
    public int soldMashedPotatoes;
    public int soldFrenchFries;
    public int soldChickenBreasts;
    public int soldSummerSalad;
    public int soldpickleSalad;
    public int soldBread;
    public int soldSparklingWater;
    public int soldStillWater;
    public int soldCocaCola;
    public int soldFanta;
    public int soldSprite;

    //Constructor
    public Waiter(Manager m, String nume, String prenume, int salariu) {
       this.m=m;
        this.firstName = nume;
        this.lastName = prenume;
        this.salary = salariu;
        LocalDate ld = LocalDate.now();
        hiringDate = ld;
    }

    //Returning first+last name
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    //Method:increasing salary
    public void increaseSalary(int x) {
        salary += x;
    }

    //Salary getter
    public int getSalary() {
        return salary;
    }

    //First name getter
    public String gerFirstName() {
        return firstName;
    }

    //Last name getter
    public String getLastName() {
        return lastName;
    }

    //Hiring date getter
    public LocalDate getHiringDate() {
        return hiringDate;
    }

    //Seniority getter : returns period of employment
    public String getSeniority(){
        Period p=Period.between(hiringDate, LocalDate.now());
        return p.toString();
    }

    //Serving methods:
   
    //serving Schnitzel
    public void serveSchnitzel(int n) {
        if (n < m.schnitzel) { //If the request is less than the cooked product,
            //The cook will cook the food
            Cook b = m.listCooks.get((int) Math.random() * m.listCooks.size());
            b.cookSchnitzel(n);
        }
    }

    //serving Chicken breast
    public void serveChickenBreast(int n) {
        if (n < m.chickenBreasts) {//If the request is less than the cooked product,
            //The cook will cook the food
            Cook b = m.listCooks.get((int) Math.random() * m.listCooks.size());
            b.cookChickenBreast(n);

        }
    }

    //serving Mashed potatoes
    public void serveMashedPotatoes(int n) {
        if (n < m.mashedPotatoes) {//If the request is less than the cooked product,
            //The cook will cook the food
            Cook b = m.listCooks.get((int) Math.random() * m.listCooks.size());
            b.cookMashedPotatoes(n);
        }
    }

    //serving French fries
    public void serveFrenchFries(int n) {
        if (n < m.frenchFries) {//If the request is less than the cooked product,
            //The cook will cook the food
            Cook b = m.listCooks.get((int) Math.random() * m.listCooks.size());
            b.cookFrenchFries(n);
        }
    }

    //serving Summer salad
    public void serveSummerSalad(int n) {
        if (n < m.summerSalad) {//If the request is less than the cooked product,
            //The cook will cook the food
            Cook b = m.listCooks.get((int) Math.random() * m.listCooks.size());
            b.prepareSummerSalad(n);

        }
    }

    //serving Pickle salad
    public void servePickleSalad(int n) {
        if (n < m.pickleSald) {//If the request is less than the cooked product,
            //The cook will cook the food
            Cook b = m.listCooks.get((int) Math.random() * m.listCooks.size());
            b.preparePickleSalad(n);
        } else {

        }
    }

    //serving Bread
    public void serveBread(int n) {
        if (n < m.bread) {//If the request is less than the product,
            //The manager will buy the product
            m.buyBread(n);

        }
    }

    //serving Sparkling water
    public void serveSparklingWater(int n) {
        if (n < m.sparklingWater) {//If the request is less than the product,
            //The manager will buy the product
            m.buySparklingWater(n);

        }
    }

    //serving Still water
    public void serveStillWater(int n) {
        if (n < m.stillWater) {//If the request is less than the product,
            //The manager will buy the product
            m.buyStillWater(n);

        }
    }

    //serving Coca cola
    public void serveCocaCola(int n) {
        if (n < m.cola) {//If the request is less than the product,
            //The manager will buy the product
            m.buyCocaCola(n);
        }
    }

    //serving Fanta
    public void serveFanta(int n) {
        if (n < m.fanta) {//If the request is less than the product,
            //The manager will buy the product
            m.buyFanta(n);
        }
    }

    //serving Sprite
    public void serveSprite(int n) {
        if (n < m.sprite) {//If the request is less than the product,
            //The manager will buy the product
            m.buySprite(salary);
        }
    }
}
