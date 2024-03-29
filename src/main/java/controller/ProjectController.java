package controller;

import DAO.ProjectDao;
import Model.Employe;
import Model.Project;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProjectController implements Serializable {





    private Long selectedProject;
    private Long selectedEmployee;

    // Getter and setter for selectedProject and selectedEmployee

    public List<Project> getAvailableProjects() {
        return ProjectDao.getAllProjects();
    }

    public List<Employe> getAvailableEmployees() {
        return EmployeController.getEmployes();
    }

    @Transactional
    public void assignEmployeeToProject() {
        Project project = ProjectDao.findById(selectedProject);
        Employe employee = EmployeController.findById(selectedEmployee);
        project.getEmployees().add(employee);
        projectController.updateProject(project);
    }
}