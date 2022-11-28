package com.github.sakakiaruka.serializeexample.serializeexapmle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SerializeMain implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        Player player = (Player) sender;

        /*
        *
        * args
        *  1:type (serialize or deSerialize)
        *  2:input (if in serialize mode -> items that you want to serialize. / if in deSerialize mode -> serialized string)
         */
        if(args.length != 2){
            player.sendMessage("invalid args. (not 2)");
            return false;
        }

        if(args[0].equalsIgnoreCase("serialize")){
            //serialize
            int slot;
            try{
                slot = Integer.valueOf(args[1]);
            }catch(NumberFormatException e){
                player.sendMessage("fail to get slot number.");
                return false;
            }
            if(player.getInventory().getItem(slot).equals(null)){
                player.sendMessage("fail to get item that you ordered.");
                return false;
            }
            ItemStack itemStack = player.getInventory().getItem(slot);
            Map<String,Object> serialized = itemStack.serialize();
            for(Map.Entry<String,Object> entry : serialized.entrySet()){
                player.sendMessage("Key : "+entry.getKey());
                player.sendMessage("Value : "+entry.getValue());
            }

        }else if(args[0].equalsIgnoreCase("deserialize")){
            //deserialize
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,Command command,String str,String[] args){
        if(args.length == 0){
            return new ArrayList<String>(Arrays.asList("serialize","deserialize"));
        }else{
            return null;
        }
    }
}
