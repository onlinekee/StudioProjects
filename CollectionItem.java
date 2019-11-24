package com.example.hp.ktsmilkapp;
//create a model class for collection center
public class CollectionItem {

    private String Session;
    private String Item;
    private String Supplier;
    private String Qty;

    public CollectionItem() {

    }

    public CollectionItem(String session, String item, String supplier, String qty) {
        Session = session;
        Item = item;
        Supplier = supplier;
        Qty = qty;
    }

    public String getSession() {
        return Session;
    }

    public String getItem() {
        return Item;
    }

    public String getSupplier() {
        return Supplier;
    }

    public String getQty() {
        return Qty;
    }

    public void setSession(String session) {
        Session = session;
    }

    public void setItem(String item) {
        Item = item;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public void setQty(String qty) {
        Qty = qty;
    }
}
