package com.zipcode.services;

import com.zipcode.models.WorkOrder;
import com.zipcode.models.WorkOrderStatus.WorkOrderStatus;
import com.zipcode.repositories.WorkOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class WorkOrderService {

    @Autowired

    private WorkOrderRepo workOrderRepo;

    //----------------------------------new----------------------------------
    public WorkOrder createWorkOrder (WorkOrder workOrder) {
        workOrder.setFirstName(workOrder.getFirstName());
        workOrder.setLastName(workOrder.getLastName());
        workOrder.setDescription(workOrder.getDescription());
        workOrder.setLocation(workOrder.getLocation());
        workOrder.setDateCreated(workOrder.getDateCreated());
        return workOrderRepo.save(workOrder);
    }

    //----------------------------------update----------------------------------
    public void updateWorkOrderStatus(WorkOrder workOrder, WorkOrderStatus workOrderStatus) {
        workOrder.setWorkOrderStatus(workOrderStatus);

    }

    public void updateWorkOrderDescription(WorkOrder workOrder, String workOrderDescription)    {
        workOrder.setDescription(workOrderDescription);
    }

    public void updateWorkOrderCreatedDate(WorkOrder workOrder, LocalDate date)  {
        workOrder.setDateCreated(date);
    }

    public void updateWorkOrderCompletedDate(WorkOrder workOrder, LocalDate date)  {
        workOrder.setDateCompleted(date);
    }

    public void updateWorkOrderLocation(WorkOrder workOrder, String location)   {
        workOrder.setLocation(location);
    }

    //----------------------------------delete----------------------------------
    public Boolean deleteWorkOrder (Long workOrderId) {
        if(workOrderRepo.findById(workOrderId).isPresent()) {
            workOrderRepo.deleteById(workOrderId);
            return true;
        }
        else {
            return false;
        }
    }

    //----------------------------------get methods----------------------------------

    public Iterable<WorkOrder> displayAllWorkOrders (){
        return workOrderRepo.findAll();
    }

    public WorkOrder findWorkOrderById(Long workOrderId){
        WorkOrder workOrder = workOrderRepo.findById(workOrderId).get();
        if (workOrder == null) {
            return workOrder;
        }
        else{
            return null;
        }
    }

    public Iterable<WorkOrder> findWorkOrdersByStatus(WorkOrderStatus workOrderStatus)  {
        return workOrderRepo.findWorkOrdersByWorkOrderStatus(workOrderStatus);
    }

    public Iterable<WorkOrder> findWorkOrdersByDateCreated(LocalDate dateCreated)   {
        return workOrderRepo.findWorkOrdersByDateCreated(dateCreated);
    }

    public Iterable<WorkOrder> findWorkOrdersByDateCompleted(LocalDate dateCompleted)   {
        return workOrderRepo.findWorkOrdersByDateCompleted(dateCompleted);
    }

    public Iterable<WorkOrder> findWorkOrdersByName(String lastName, String firstName)  {
        return workOrderRepo.findWorkOrdersByLastNameAndFirstName(lastName, firstName);
    }




}