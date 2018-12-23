
package Restaurant;
//Imports

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

//Class
public class Cook implements Serializable {

    //Staff data:First name,last name,salary,hiring date ,seniority
    private String firstName;
    private String lastName;
    private int salary;
    private LocalDate hiringDate;
    private long seniority;

    //Manager
    Manager m;

    //Constructor
    public Cook(Manager m, String firstName, String lastName, int salary) {
        this.m = m;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        LocalDate ld = LocalDate.now();
        hiringDate = ld;
    }

    //Salary getter
    public int getSalary() {
        return salary;
    }

    //mothod : get seniority
    public String getSeniority() {
        Period p = Period.between(hiringDate, LocalDate.now());
        return p.toString();
    }

    //Cook method : schnitzel
    public void cookSchnitzel(int n) {
        if (n >= m.rawChicken) { //If there are materials
            //Prepare food
            m.schnitzel += n;
            m.rawChicken -= n;
        } else {
            //if not,the manager should first buy the materials,then the cook'll cook them
            m.buyChickem(n);
            m.schnitzel += n;
            m.rawChicken -= n;

        }
    }

    //Cook method :chicken breast
    public void cookChickenBreast(int n) {//If there are materials
        //Prepare food
        if (n >= m.rawChicken) {
            m.chickenBreasts += n;
            m.rawChicken -= n;
        } else {
            //if not,the manager should first buy the materials,then the cook'll cook them
            m.buyChickem(n);
            m.chickenBreasts += n;
            m.rawChicken -= n;
        }
    }

    //Cook method : mashed potatoes
    public void cookMashedPotatoes(int n) {
        if (n >= m.rawPotatoes) {//If there are materials
            //Prepare food
            m.rawPotatoes -= n;
            m.mashedPotatoes += n;

        } else {
            //if not,the manager should first buy the materials,then the cook'll cook them
            m.buyPotatoes(n);
            m.rawPotatoes -= n;
            m.mashedPotatoes += n;

        }
    }

    //Cook method : frenh fries
    public void cookFrenchFries(int n) {
        if (n >= m.rawPotatoes) {//If there are materials
            //Prepare food
            m.rawPotatoes -= n;
            m.frenchFries += n;
        } else {
            //if not,the manager should first buy the materials,then the cook'll cook them
            m.buyPotatoes(n);
            m.rawPotatoes -= n;
            m.frenchFries++;
        }
    }

    //Cook method : summer salad
    public void prepareSummerSalad(int n) {
        if (n >= m.summerSaladIngredients) {//If there are materials
            //Prepare food
            m.summerSaladIngredients -= n;
            m.summerSalad += n;
        } else {
            //if not,the manager should first buy the materials,then the cook'll cook them
            m.buySummerSaladIngredients(n);
            m.summerSaladIngredients -= n;
            m.summerSalad += n;
        }
    }

    //Cook method : pickles
    public void preparePickleSalad(int n) {
        if (n >= m.pickleSaladIngredients) {//If there are materials
            //Prepare food
            m.pickleSaladIngredients -= n;
            m.pickleSald += n;
        } else {
            //if not,the manager should first buy the materials,then the cook'll cook them
            m.buyPickleSaladIngredients(n);
            m.pickleSaladIngredients -= n;
            m.pickleSald += n;
        }
    }

    //Returning first+last name
    public String toString() {
        return firstName + " " + lastName;
    }
}
