package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class TruckService {
    public void addTruck(Truck truck){
        String query="insert into truck (name,model,capacity,driver_name) values(?,?,?,?)";

        try{
            Connection conn=ConnectionDetails.getConection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());

            int c=preparedStatement.executeUpdate();
            System.out.println("Row Inserted : "+c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Truck getTruckById(int id){
        String query="select from truck from id= ?";
        Truck truck=null;

        try{
            Connection conn=ConnectionDetails.getConection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                truck=new Truck();

                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));


            }
        }catch(Exception e){
             e.printStackTrace();
        }
        return truck;
    }

    public void updateTruck(Truck truck){
        String query="update truck set name=?, model=?, capacity=?, driver_name=? where id=?";

        try{
            Connection conn=ConnectionDetails.getConection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());
            preparedStatement.setInt(5,truck.getId());
            int i = preparedStatement.executeUpdate();

            System.out.println("Row updated : "+i);


        }catch(Exception e){

        }
    }

    public List<Truck> getAllTruck(){
        String query="select * from truck";

        List<Truck> trucks=new ArrayList();

        try{
            Connection conn=ConnectionDetails.getConection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                Truck truck=new Truck();

                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriver_name(resultSet.getString("driver_name"));

                trucks.add(truck);
            }

        }catch(Exception e){

        }
     return trucks;
    }
    
    public void deleteTruckById(int id)
    {
        String query="delete from truck where id= ?";
        
        try{
            Connection conn=ConnectionDetails.getConection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,id);

            int i = preparedStatement.executeUpdate();

            System.out.println("Row Deleted : "+i);

        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
}