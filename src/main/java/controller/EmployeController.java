package controller;


import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import Model.Employe;
import DAO.EmployeeDao;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class EmployeController implements Serializable {
    private static List<Employe> employes;
    private Employe employe = new Employe();

    public EmployeeDao = new EmployeeDao();


    public static List<Employe> getEmployes() {
        employes = EmployeeDao.findAll();
        return employes;
    }






    public void deleteStudent(long id) {
        EmployeeDao.delete(id);
        refreshStudents();
    }
    public void handleDelete(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String studentId = context.getExternalContext().getRequestParameterMap().get("id    ");
        if (studentId != null && !studentId.isEmpty()) {
            long id = Long.parseLong(studentId);
            deleteStudent(id);
        }
    }



    public void setStudents(List<Employe> employes) {
        this.employes = employes;
    }

    public Employe getStudent() {
        return employe;
    }

    public void setStudent(Employe student) {
        this.employe = employe;
    }

    public String addStudent() {
        EmployeeDao.save(employe);
        refreshStudents();
        employe = new Employe();
        return "employe added";
    }


    private void refreshStudents() {
        employes = EmployeeDao.findAll();
    }



}
