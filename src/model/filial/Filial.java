package model.filial;

import model.building.Buildings;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class Filial implements Filials,Serializable
{
    private String name;
    private HashSet<Buildings> buildings;

    public Filial(String name, Collection<Buildings> buildings)
    {
        this.name = name;
        this.buildings=new HashSet<>(buildings);
    }

    public Filial(String name)
    {
        this.name = name;
        this.buildings=new HashSet<>();
    }

    public Filial()
    {
        this.name = "";
        this.buildings=new HashSet<>();
    }
    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setBuildings(Collection<Buildings> buildings)
    {
        this.buildings = new HashSet<>(buildings);
    }

    @Override
    public Collection<Buildings> getBuildings()
    {
        return this.buildings;
    }

    @Override
    public void addBuilding(Buildings building)
    {
        this.buildings.add(building);
    }

    @Override
    public void removeBuilding(Buildings building)
    {
        this.buildings.remove(building);
    }

    @Override
    public Buildings getBuildingByAddress(String address)
    {
        for(Buildings building: buildings)
        {
            if (building.getAddress().equals(address))
            {
                return building;
            }
        }
        return null;
    }

    @Override
    public Buildings getBuildingByCoordinates(double x, double y)
    {
        for(Buildings building: buildings)
        {
            if (building.getCoordinatesX() == x && building.getCoordinatesY() == y)
            {
                return building;
            }
        }
        return null;
    }

//    @Override
//    public building.Buildings getBuildingByWorkings(employee.Employees[] workings)
//    {
//        for(building.Buildings buildings: this.buildings)
//        {
//            employee.Employees[] workings1 = buildings.getEmployees();
//            if (workings.length == workings1.length)
//            {
//                boolean flaf = true;
//                for (int i = 0, size = workings.length; i < size; ++i)
//                {
//                    if (!workings[i].equals(workings1[i]))
//                    {
//                        flaf = false;
//                        break;
//                    }
//                }
//                if(flaf)
//                {
//                    return buildings;
//                }
//            }
//        }
//        return null;
//    }

    @Override
    public boolean setBuildingByAddress(Buildings building, String address)
    {

        for(Buildings building1: buildings)
        {
            if (building1.getAddress().equals(address))
            {
                buildings.remove(building1);
                buildings.add(building);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setBuildingByCoordinates(double x, double y, Buildings building)
    {
        for(Buildings building1: buildings)
        {
            if (building1.getCoordinatesX() == x && building1.getCoordinatesY() == y)
            {
                buildings.remove(building1);
                buildings.add(building);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getCountBuildings()
    {
        return this.buildings.size();
    }

//    @Override
//    public boolean setBuildingByWorkings(employee.Employees[] workings, building.Buildings buildings)
//    {
//        return false;
//    }


    @Override
    public String toString()
    {
        return name;
    }
}
