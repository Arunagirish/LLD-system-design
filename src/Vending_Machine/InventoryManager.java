package Vending_Machine;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager
{
    //    slots,Items
    Map<String,Items> slots = new HashMap<>();
    public void add_slot(String slot_id, Items item)
    {
        slots.put(slot_id,item);
    }
    public void remove_slot(String slot_id)
    {
        slots.remove(slot_id);
    }
    public boolean item_available(String itemName)
    {
        for(String slot: slots.keySet() )
        {
            Items item = slots.get(slot);
            if(item.itemName.equals(itemName))return true;
        }
        return false;
    }

}
