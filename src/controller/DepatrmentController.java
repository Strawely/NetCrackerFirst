package controller;

import except.CantCreateEmployyException;
import model.department.Departments;
import model.employee.Employees;
import model.modl.ModelDepartment;
import view.department.DepartmentView;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;

/**
 * Created by Админ on 14.12.2017.
 */
public class DepatrmentController implements DepatrmentControllerInter
{
    private ModelDepartment model;
    private DepartmentView departmentView;

    public  DepatrmentController(ModelDepartment model)
    {
        this.model = model;
        departmentView = new DepartmentView(this.model.getDepartnents(), this);
        model.registerObserver(departmentView);
        departmentView.setVisible(true);
    }

    @Override
    public void addEmployee(int index, Employees employee)
    {
        model.addEmployee(index, employee);
    }

    @Override
    public void deleteEmployee(int index, ArrayList<Employees> employees)
    {
        model.deleteEmployee(index, employees);
    }
}
