package me.libraryaddict.IRC;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class IrcNickChangeEvent extends Event {
  private static final HandlerList handlers = new HandlerList();
  private String nick;
  private String oldNick;
  private String botName;
  
  public IrcNickChangeEvent(String newName, String oldName, String bName) {
    nick = newName;
    oldNick = oldName;
    botName = bName;
  }
  
  public String getBot() {
    return botName;
  }
  
  public String getNewNick() {
    return nick;
  }
  
  public String getOldNick() {
    return oldNick;
  }

  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

}
