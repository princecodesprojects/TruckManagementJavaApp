package org.example;


public class App 
{

    public static void main( String[] args )
    {
       TruckService ts=new TruckService();

       Truck tata=new Truck("TATA","2019",2000,"RAM");
       Truck eicher=new Truck("EICHER","2010",1000,"MOHAN");
       Truck volvo=new Truck("VOLVE","2015",4000,"SHYAM");
       Truck mahindra=new Truck("MAHINDRA","2016",8000,"RAJESH");

       //Adding data to db
       ts.addTruck(tata);
       ts.addTruck(eicher);
       ts.addTruck(volvo);
       ts.addTruck(mahindra);
    }
}
