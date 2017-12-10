/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author floriandenise
 */
public class Revenue {

    public Revenue() {
    }

    //Date dateStart;
    //Date dateEnd;
    String product_code;
    float revenues;

    public float getRevenues() {
        return revenues;
    }

    /* public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }
     */
    public String getProduct_code() {
        return product_code;
    }

    public void setRevenues(float revenues) {
        this.revenues = revenues;
    }

    /*
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
     */
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public Revenue(String product_code, float revenues) {

        this.product_code = product_code;
        this.revenues = revenues;
    }

}
