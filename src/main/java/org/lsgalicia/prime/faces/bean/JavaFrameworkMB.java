package org.lsgalicia.prime.faces.bean;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.lsgalicia.common.JavaFramework;
import org.lsgalicia.dao.JavaFrameworkDao;
import org.lsgalicia.dao.JavaFrameworkDao;
import org.lsgalicia.dao.service.JavaFrameworkService;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louis on 9/25/2015.
 */

@Component(value="javaFrameworkMB")
@ViewScoped
public class JavaFrameworkMB implements Serializable {


    private static final long serialVersionUID = 1L;



    @Autowired
    private JavaFrameworkDao javaFrameworkService;

    private JavaFramework bean;
    private JavaFramework beanSelected;
    private List<JavaFramework> list;
    private List<JavaFramework> listSelected;

    @PostConstruct
    public void init() {
        refreshList();
    }



    public void refreshList() {
        this.bean = new JavaFramework();
        this.beanSelected = new JavaFramework();
        this.list = new ArrayList<JavaFramework>();
        this.listSelected = new ArrayList<JavaFramework>();
        try {
            this.list.addAll(javaFrameworkService.findAll());
            this.listSelected.addAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void save() {
        try {

            javaFrameworkService.persist(this.bean);
            refreshList();
            notificationSuccess("persist framework");
        } catch (Exception e) {
            notificationError(e,"persist framework");
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            javaFrameworkService.merge(this.beanSelected);
            refreshList();
            notificationSuccess("update framework");
        } catch (Exception e) {
            notificationError(e,"update framework");
        }
    }

    public void delete() {
        try {
            javaFrameworkService.remove(this.beanSelected.getId());
            refreshList();
            notificationSuccess("delete framework");
        } catch (Exception e) {
            notificationError(e,"delete framework");
        }
    }

    public void onCancel(RowEditEvent event) {
        refreshList();
    }


    public void reset() {
        refreshList();
        RequestContext.getCurrentInstance().reset("form1:panel");
    }


    public void notificationSuccess(String operation) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation "+operation+" success");
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void notificationError(Exception e, String operation) {
        Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation "+operation+" Error ",e);
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public JavaFrameworkDao getJavaFrameworkService() {
        return javaFrameworkService;
    }

    public void setJavaFrameworkService(JavaFrameworkDao javaFrameworkService) {
        this.javaFrameworkService = javaFrameworkService;
    }

    public JavaFramework getBean() {
        return bean;
    }

    public void setBean(JavaFramework bean) {
        this.bean = bean;
    }

    public JavaFramework getBeanSelected() {
        return beanSelected;
    }

    public void setBeanSelected(JavaFramework beanSelected) {
        this.beanSelected = beanSelected;
    }

    public List<JavaFramework> getList() {
        if(list == null){
            list = new ArrayList<JavaFramework>();
        }
        return list;
    }

    public void setList(List<JavaFramework> list) {
        this.list = list;
    }

    public List<JavaFramework> getListSelected() {
        return listSelected;
    }

    public void setListSelected(List<JavaFramework> listSelected) {
        this.listSelected = listSelected;
    }



}
