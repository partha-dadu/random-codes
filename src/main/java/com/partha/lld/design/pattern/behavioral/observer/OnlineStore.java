package com.partha.lld.design.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    public List<INotifier> notifiers = new ArrayList<>();
    public int productStock = 0;
    public int getStock(){
        return productStock;
    }

    public void setStock(int stock){
        if(productStock == 0){
            notifyAllNotifiers();
        }
        productStock = stock;
    }

    public void notifyAllNotifiers(){
        for(INotifier notifier: notifiers){
            notifier.update(new NotificationIntent("Iphone", productStock > 0 ? StockType.IN_STOCK : StockType.OUT_OF_STOCK));
        }
    }

    public void addNotifier(INotifier notifier){
        notifiers.add(notifier);
    }
    public void removeNotifier(INotifier notifier){
        notifiers.remove(notifier);
    }


}
