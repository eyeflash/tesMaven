/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rz.vm;

import com.rz.db.service.CRUDServiceInv;
import com.rz.pojo.Lokasi;
import java.util.List;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Center;



/**
 *
 * @author Programer-2
 */
public class LokasiVm {
     
    @WireVariable
    private CRUDServiceInv CRUDService;
    private Lokasi selectedItem;
    private List<Lokasi> allRecordsInDB = null;
      @AfterCompose
    public void initSetup(@ContextParam(ContextType.VIEW) Component view, 
                            @ExecutionArgParam("centerArea") Center centerArea){
        Selectors.wireComponents(view, this, false);
        
        CRUDService = (CRUDServiceInv) SpringUtil.getBean("CRUDServiceInv");
        allRecordsInDB = CRUDService.getAll(Lokasi.class);
        //allRecordsInDB = CRUDService.GetListByNamedQuery("Lokasi.findAll");
        
        
        System.out.println("###size records :" + allRecordsInDB.size());
    }

    public List<Lokasi> getAllRecordsInDB() {
        return allRecordsInDB;
    }

    public Lokasi getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Lokasi selectedItem) {
        this.selectedItem = selectedItem;
    }
}
